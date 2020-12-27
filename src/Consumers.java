import java.util.function.Consumer;

public class Consumers {

    @FunctionalInterface
    public interface Retur{
        String retur(String source);
    }
    @FunctionalInterface
    public interface Printer{
        void print(String source);
    }
    // with arrow symbol
    Printer p = (String s) -> { System.out.println("* " + s + " *"); };
    // consumer with method references
    Printer pc =  System.out::println;

    // supplier arrow symbol
    Retur p2 = (String se) -> {return  se.substring(4,6);};









    public static void main(String[] args) {
        Consumers c = new Consumers();
       String ss = c.p2.retur("testrewrew");// Supplier return value

        Consumer<String> c2 = (String s) -> { System.out.println("* " + s + " *"); };
        c2.accept(ss);
        c.p.print(ss);//consumer consumed ss value
    }

}