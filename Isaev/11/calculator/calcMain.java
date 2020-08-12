package calculator;

public class calcMain {
    public static void main(String[] args) {


        Calculator calculator = new Calculator();
        calculator.addOperation("sum",(a,b)->a+b);
        calculator.addOperation("sub",(a,b)->a-b);
        calculator.addOperation("multi",(a,b)->a*b);
        calculator.addOperation("div",(a,b)->a/b);
        calculator.addOperation("pow",(a,b)->Math.pow(a,b));
        calculator.addOperation("root",(a,b)->Math.pow(a,1.0/b));
        System.out.println(calculator.calculate("sum",10.,2.));
        System.out.println(calculator.calculate("sub",10.,2.));
        System.out.println(calculator.calculate("multi",10.,2.));
        System.out.println(calculator.calculate("div",10.,2.));
        System.out.println(calculator.calculate("pow",10.,2.));
        System.out.println(calculator.calculate("root",10.,2.));


    }
}
