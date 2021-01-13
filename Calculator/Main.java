import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("What would you like me to calculate? Type \"Help\" for a list of available options!");
        System.out.println("You can always go back one Menu by typing \"Back\" or Stop the program with \"Stop\"");
        listener.listen();
    }
    public static void calculate(String x) {
        calculator calc = new calculator();
        switch (x) {
            case "a": calc.circumference();
            break;
            case "b": calc.minus();
            break;
            case "c": calc.plus();
            break;
            case "d": calc.faculty();
            break;
            case "e": calc.choose();
            break;
            case "f": calc.printPrimes();
            break;
            case "g": calc.factorise();
            break;
        }
    }
    public static void getList() {
        String list = "Here are all currently implemented functions: \n";
        try {
            Class readClass = calculator.class;
            Method[] methods = readClass.getDeclaredMethods();
            for (int i = 0; i <= methods.length; i++) {
                if (!methods[i].toString().equals("public static void calculator.calcBackend(java.lang.String,int)")) {
                    String functions = methods[i].toString();
                    int startIndex = functions.indexOf(".");
                    int endIndex = functions.indexOf("(");
                    String noBrackets = functions.substring(startIndex + 1, endIndex);
                    list += noBrackets + "\n";
                }
            }
        } catch (Exception e) {
            // System.err.println(e);
        }
        list += "type the name of the function to enter its interface.";
        System.out.println(list);
        listener.listen();
    }
    public static void stop() {
        System.out.println("Goodbye!");
    }
}