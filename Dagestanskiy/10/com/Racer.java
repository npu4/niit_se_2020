import java.util.ArrayList;

public class Racer {
    String name;
    boolean[][] maze;
    int[] currentPosition;
    int[] finishPosition;
    ArrayList<int[]> trackArray;
    Long nanoTimeStart;
    Long nanoTimeFinish;

    public Racer(String name, boolean[][] maze, int[] currentPosition,
                 int[] finishPosition) {
        this.name = name;
        this.maze = maze;
        this.currentPosition = currentPosition;
        this.finishPosition = finishPosition;
        this.trackArray = new ArrayList<>();
    }

    boolean step() {
            if (finishDown() || finishRight() || finishLeft() || finishUp() ) return true;
            int azimut = currentPosition[2];
            switch (azimut) {
                case 0:
                   if (!stepRight()) if (!stepDown()) if (!stepLeft()) stepUp();
                    break;
                case 1:
                    if (!stepUp()) if (!stepRight()) if (!stepDown()) stepLeft();
                    break;
                case 2:
                    if (!stepDown()) if (!stepLeft()) if (!stepUp()) stepRight();
                    break;
                default:
                    if (!stepLeft()) if (!stepUp()) if (!stepRight()) stepDown();
                    break;
            }
                return false;
    }
    boolean finishDown(){
        if ((currentPosition[0]==finishPosition[0] && currentPosition[1]+1==finishPosition[1])) {
            currentPosition[1] += 1;
            trackArray.add(currentPosition.clone());
            return true;
        }
        return false;
    }
    boolean finishRight(){
        if ((currentPosition[0]-1==finishPosition[0] && currentPosition[1]==finishPosition[1])) {
            currentPosition[0] -= 1;
            trackArray.add(currentPosition.clone());
            return true;
        }
        return false;
    }
    boolean finishLeft(){
        if ((currentPosition[0]+1==finishPosition[0] && currentPosition[1]==finishPosition[1])) {
            currentPosition[0] += 1;
            trackArray.add(currentPosition.clone());
            return true;
        }
        return false;
    }
    boolean finishUp(){
        if ((currentPosition[0]==finishPosition[0] && currentPosition[1]-1==finishPosition[1])) {
            currentPosition[1] -= 1;
            trackArray.add(currentPosition.clone());
            return true;
        }
        return false;
    }
    boolean stepDown(){
        if (maze[currentPosition[0] ][currentPosition[1]+1]) {
            currentPosition[1] += 1;
            currentPosition[2]=0;
            trackArray.add(currentPosition.clone());
            return true;
        }
        return false;
    }
    boolean stepRight() {
        if (maze[currentPosition[0]-1][currentPosition[1]]) {
            currentPosition[0] -= 1;
            currentPosition[2]=1;
            trackArray.add(currentPosition.clone());
            return true;
        }
        return false;
    }
    boolean stepLeft(){
        if (maze[currentPosition[0]+1][currentPosition[1]]) {
            currentPosition[0] += 1;
            currentPosition[2]=2;
            trackArray.add(currentPosition.clone());
            return true;
        }
        return false;
    }
    boolean stepUp(){
        if (maze[currentPosition[0]][currentPosition[1]-1]) {
            currentPosition[1] -= 1;
            currentPosition[2]=3;
            trackArray.add(currentPosition.clone());
            return true;
        }
        return false;
    }

    ArrayList<int[]> getTrack () {
        return trackArray;
    }

    public String getName() {
        return name;
    }

    public Long getNanoTimeStart() {
        return nanoTimeStart;
    }

    public Long getNanoTimeFinish() {
        return nanoTimeFinish;
    }

    public void setNanoTimeStart(Long nanoTimeStart) {
        this.nanoTimeStart = nanoTimeStart;
    }

    public void setNanoTimeFinish(Long nanoTimeFinish) {
        this.nanoTimeFinish = nanoTimeFinish;
    }

}
