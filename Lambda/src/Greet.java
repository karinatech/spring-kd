public class Greet {
    public static void main(String[] args) {
        Greet g=new Greet();
        HelloWorldGreeting hg=new HelloWorldGreeting();
        g.greet(hg);
    }
    public static void greet(Greeting greeting){
    greeting.perform();
    }
    Greeting  greet=()-> System.out.println("Hello world");
    myAdd  doubleNumber = (int a ) -> a*2;
    add2 add = (int a, int b) -> a+b;

}

interface myAdd{
    int doubleIt(int a);
}
interface add2{
    int addtwo(int a, int b);
}
