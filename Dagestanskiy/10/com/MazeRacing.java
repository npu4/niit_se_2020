import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MazeRacing {
    public static void main(String[] args) throws InterruptedException {
        boolean [][] maze;
        maze = MazeRacing.getMaze();
        int[] f = finishRandomPosition(maze);
        Racer r1 = new Racer("Петя",maze,startRandomPosition(maze),f);
        Racer r2 = new Racer("Гриша",maze,startRandomPosition(maze),f);
        Racer r3 = new Racer("Саша",maze,startRandomPosition(maze),f);
        Racer r4 = new Racer("Коля",maze,startRandomPosition(maze),f);

        Thread t1 = new Thread(() -> raceRun(r1));
        Thread t2 = new Thread(() -> raceRun(r2));
        Thread t3 = new Thread(() -> raceRun(r3));
        Thread t4 = new Thread(() -> raceRun(r4));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        Racer bestRacer = r1;
        if(r2.trackArray.size()<bestRacer.trackArray.size()) bestRacer= r2;
        if(r3.trackArray.size()<bestRacer.trackArray.size()) bestRacer= r3;
        if(r4.trackArray.size()<bestRacer.trackArray.size()) bestRacer= r4;
        System.out.println("Победил гонщик "+bestRacer.name+" за "+bestRacer.trackArray.size()+" шагов.");

    }

    static void raceRun(Racer r){
        r.setNanoTimeStart(System.nanoTime());
        System.out.println("Гонщик "+r.name+" стартовал с позиции x = "+r.currentPosition[0]+" y = "+r.currentPosition[1]);
        while (!r.step()) ;
        r.setNanoTimeFinish(System.nanoTime());
        System.out.println("Гонщик "+r.name+" финишировал на позиции x= "+r.currentPosition[0]+" y = "+r.currentPosition[1]+" за "+
                (r.getNanoTimeFinish()-r.getNanoTimeStart())+" наносекунд и "+r.getTrack().size()+" шагов.");

    }

    public static boolean[][] getMaze(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла - лабиринта: ");
        String nameFile = scanner.nextLine();
        ArrayList<String> arrayList = new ArrayList<>();
        try (FileReader reader = new FileReader(nameFile)) {
            Scanner scan = new Scanner(reader);
            while (scan.hasNextLine()) arrayList.add(scan.nextLine());
            scan.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        int rx = arrayList.get(0).length();
        int ry = arrayList.size();
        boolean[][] mazeLocal = new boolean[ry][rx];
        for (int i = 0; i < mazeLocal.length ; i++) {
            String str = arrayList.get(i);
            for (int j = 0; j < mazeLocal[0].length; j++) {
                mazeLocal[i][j] = (str.charAt(j) == ' ');
            }
        }
        for (int i = 0; i < ry; i++) {
            mazeLocal[0][i] =  false;
            mazeLocal[rx-1][i] = false;
        }
        boolean[][] mazeLocalReturn = new boolean[rx][ry];
        for (int i = 0; i <rx ; i++) {
            for (int j = 0; j <ry ; j++) {
                mazeLocalReturn[i][j]=mazeLocal[j][i];
            }
        }
        return mazeLocalReturn;
    }

    static int[] startRandomPosition(boolean[][] mazeLocal){
        int[] a = new int[3];
        a[1] = 1;//a[0] -координата x , a[1] -координата y
        // a[2] азимут - направление движения по лабиринту 0 - вниз, 1 - направо, 2 - налево ; 3 - вверх
        do {
            a[0] = rndI(1, mazeLocal[0].length - 2);//координата x
        } while (!mazeLocal[a[0]][a[1]]);
        return  a;
    }

    static int[] finishRandomPosition(boolean[][] mazeLocal){
        int[] a = new int[2];
        a[1] = mazeLocal.length-1;
        do {
            a[0] = rndI(1, mazeLocal[0].length - 2);
        } while (!mazeLocal[a[0]][a[1]-1]);

        return  a;
    }
    public static int rndI(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

}
