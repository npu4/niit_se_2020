public class Pair<T, S> {

    private T p1;
    private  S p2;


    Pair(T p1, S p2){
        this.p1=p1;
        this.p2=p2;
    }

    T getFirst(){
        return this.p1;
    }

    S getSecond(){
        return this.p2;
    }


}
