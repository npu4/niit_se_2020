package battle;

import java.io.*;

public class GameLog {
    private StringBuilder log = new StringBuilder();

    public void addAction(String action) {
        log.append(action).append("\n");
    }

    public void saveGame(String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.append(log);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLog() {
        return log.toString();
    }
}
