import java.util.Scanner;

public class listener {
    public static void listen() {
        Scanner listener = new Scanner(System.in);
            switch(listener.nextLine().toLowerCase()) {
                case "help": Main.getList();
                break;
                case "circumference": Main.calculate("a");
                break;
                case "minus": Main.calculate("b");
                break;
                case "plus": Main.calculate("c");
                break;
                case "faculty": Main.calculate("d");
                break;
                case "choose": Main.calculate("e");
                break;
                case "printprimes": Main.calculate("f");
                break;
                case "factorise": Main.calculate("g");
                break;
                case "stop": Main.stop();
                break;
                default: 
                    System.out.println("That operation has not yet been implemented!");
                    listen();
        }
        listener.close();
    }   
}