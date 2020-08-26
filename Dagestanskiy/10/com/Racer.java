import java.util.ArrayList;

public class Racer {
    String name;
    boolean[][] maze;
    MazeStep currentPosition;
    MazeStep finishPosition;
    ArrayList<MazeStep> trackArray;
    Long nanoTimeStart;
    Long nanoTimeFinish;

    public Racer(String name, boolean[][] maze, MazeStep currentPosition,
                 MazeStep finishPosition) {
        this.name = name;
        this.maze = maze;
        this.currentPosition = currentPosition;
        this.finishPosition = finishPosition;
        this.trackArray = new ArrayList<>();
    }

    boolean step() {
            if (finishDown() || finishRight() || finishLeft() || finishUp() ) return true;
            Direction azimut = currentPosition.direction;
            switch (azimut) {
                case SOUTH:
                   if (!stepRight()) if (!stepDown()) if (!stepLeft()) stepUp();
                    break;
                case EAST:
                    if (!stepUp()) if (!stepRight()) if (!stepDown()) stepLeft();
                    break;
                case WEST:
                    if (!stepDown()) if (!stepLeft()) if (!stepUp()) stepRight();
                    break;
                default:
                    if (!stepLeft()) if (!stepUp()) if (!stepRight()) stepDown();
                    break;
            }
                return false;
    }
    void tracArrayAddStep(){
        trackArray.add(new MazeStep(currentPosition.getX(), currentPosition.getY(), currentPosition.getDirection()));
    }
    boolean finishDown(){
        if ((currentPosition.getX()==finishPosition.getX() && currentPosition.getY()+1==finishPosition.getY())) {
            currentPosition.setY(currentPosition.getY()+1);
            currentPosition.setDirection(Direction.SOUTH);
            tracArrayAddStep();
            return true;
        }
        return false;
    }
    boolean finishRight(){
        if ((currentPosition.getX()-1==finishPosition.getX() && currentPosition.getY()==finishPosition.getY())) {
            currentPosition.setX(currentPosition.getX()-1);
            currentPosition.setDirection(Direction.EAST);
            tracArrayAddStep();
            return true;
        }
        return false;
    }
    boolean finishLeft(){
        if ((currentPosition.getX()+1==finishPosition.getX() && currentPosition.getY()==finishPosition.getY())) {
            currentPosition.setX(currentPosition.getX()+1);
            currentPosition.setDirection(Direction.WEST);
            tracArrayAddStep();
            return true;
        }
        return false;
    }
    boolean finishUp(){
        if ((currentPosition.getX()==finishPosition.getX() && currentPosition.getY()-1==finishPosition.getY())) {
            currentPosition.setY(currentPosition.getY()-1);
            currentPosition.setDirection(Direction.NORTH);
            tracArrayAddStep();
            return true;
        }
        return false;
    }
    boolean stepDown(){
        if (maze[currentPosition.getX() ][currentPosition.getY()+1]) {
            currentPosition.setY(currentPosition.getY()+1);
            currentPosition.setDirection(Direction.SOUTH);
            tracArrayAddStep();
            return true;
        }
        return false;
    }
    boolean stepRight() {
        if (maze[currentPosition.getX()-1][currentPosition.getY()]) {
            currentPosition.setX(currentPosition.getX()-1);
            currentPosition.setDirection(Direction.EAST);
            tracArrayAddStep();
            return true;
        }
        return false;
    }
    boolean stepLeft(){
        if (maze[currentPosition.getX()+1][currentPosition.getY()]) {
            currentPosition.setX(currentPosition.getX()+1);
            currentPosition.setDirection(Direction.WEST);
            tracArrayAddStep();
            return true;
        }
        return false;
    }
    boolean stepUp(){
        if (maze[currentPosition.getX()][currentPosition.getY()-1]) {
            currentPosition.setY(currentPosition.getY()-1);
            currentPosition.setDirection(Direction.NORTH);
            tracArrayAddStep();
            return true;
        }
        return false;
    }

    ArrayList<MazeStep> getTrack () {
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
