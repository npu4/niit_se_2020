import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public  class HelpUtil {
    public static int rndInt(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public static String arrayIntToString(int[] p, String separator) {
        StringBuilder sx = new StringBuilder();
        String[] aaa = new String[p.length];
        for (int i = 0; i < p.length; i++) {
            aaa[i] = String.valueOf(p[i]);
            sx.append(aaa[i]);
            if (i < p.length - 1) sx.append(separator);
        }
        return String.valueOf(sx);
    }

    public static void writeStringToFile(String replay, Scanner scanner) {
            System.out.print("Введите имя файла для сохранения реплея ( name.txt ): ");
            String nameFile = scanner.nextLine();

            try (FileWriter writer = new FileWriter("9\\com\\replays\\" + nameFile, false)) {
                writer.write(replay);
                writer.flush();
                writer.close();
                System.out.println("Реплей записан в файл : " + nameFile);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }



    }

    public static boolean qwestionAnswer(String qwestion, Scanner scan) {
        System.out.print(qwestion + " Да/нет? : ");
        String yesNo = scan.nextLine();
//        scan.close();
        return yesNo.contains("да".toLowerCase());
    }
}