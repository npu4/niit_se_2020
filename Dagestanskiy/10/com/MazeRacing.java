import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MazeRacing {
    public static void main(String[] args) {
        boolean [][] maze = MazeRacing.getMaze();
        MazeStep f = finishRandomPosition(maze);
        List<Racer> racerList = new ArrayList<>();
        String [] racerName = new String[]{"Петя","Гриша","Саша","Коля"};
        for (String s : racerName) racerList.add(new Racer(s, maze, startRandomPosition(maze), f));
        racerList.forEach(racer -> {
            Thread thread =new Thread(() -> raceRun(racer));
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Racer bestRacer = Collections.min(racerList, (Comparator.comparingInt(o -> o.trackArray.size())));
        System.out.println("Победил гонщик "+bestRacer.name+" за "+bestRacer.trackArray.size()+" шагов.");
    }

    static void raceRun(Racer r){
        r.setNanoTimeStart(System.nanoTime());
        System.out.println("Гонщик "+r.name+" стартовал с позиции x = "+r.currentPosition.getX()+" y = "+r.currentPosition.getY());
        while (!r.step()) ;
        r.setNanoTimeFinish(System.nanoTime());
        System.out.println("Гонщик "+r.name+" финишировал на позиции x= "+r.currentPosition.getX()+" y = "+r.currentPosition.getY()+" за "+
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

    static MazeStep startRandomPosition(boolean[][] mazeLocal){
        MazeStep a = new MazeStep(1, 1, Direction.SOUTH);
        do {
            a.setX(rndI(1, mazeLocal[0].length - 2));//координата x
        } while (!mazeLocal[a.getX()][a.getY()]);
        return  a;
    }

    static MazeStep finishRandomPosition(boolean[][] mazeLocal){
        MazeStep a = new MazeStep(1,mazeLocal.length-1,Direction.SOUTH);
        do {
            a.setX(rndI(1, mazeLocal[0].length - 2));
        } while (!mazeLocal[a.getX()][a.getY()-1]);
        return  a;
    }
    public static int rndI(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

}
