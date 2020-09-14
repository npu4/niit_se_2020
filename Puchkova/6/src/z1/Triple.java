package z1;

public class Triple<T1, T2, T3> {
    private final T1 first;
    private final T2 second;
    private final T3 third;

    public Triple(T1 first, T2 second, T3 third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    public T3 getThird() {
        return third;
    }

    public boolean equals(Object obj){
        if (obj == this){
            return true;
        }
        else if(!(obj instanceof Triple)){
            return false;
        }
        else{
            Triple<?,?,?> objTriple = (Triple<?,?,?>) obj;
            return (first.equals(objTriple.first) && second.equals(objTriple.second) && third.equals(objTriple.third));
        }
    }

    public void println(){
        System.out.println("Triple: <" + getFirst() + ", " + getSecond() + ", " + getThird() + ">");
    }
}
