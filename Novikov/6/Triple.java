public class Triple <T, S, U> {


    private T p1;
    private  S p2;
    private  U p3;

    Triple(T p1, S p2, U p3){
        this.p1=p1;
        this.p2=p2;
        this.p3=p3;
    }

    public void setP1(T p1) {
        this.p1 = p1;
    }

    public void setP2(S p2) {
        this.p2 = p2;
    }

    public void setP3(U p3) {
        this.p3 = p3;
    }

    T getFirst(){
        return this.p1;
    }

    S getSecond(){
        return this.p2;
    }

    U getFired(){
        return this.p3;
    }


}
