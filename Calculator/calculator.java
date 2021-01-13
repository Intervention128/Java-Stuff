import java.lang.Math;
import java.util.Scanner;
import java.util.ArrayList;

public class calculator {
    public static void calcBackend(String function, int p) {
        calculatorBackend backEnd = new calculatorBackend();
        switch(function) {
            case "getPrimes": backEnd.primeGenerator(p);
            break;
            case "getFaculty": backEnd.calculateFaculty(p);
            break;
        }
    }
    Scanner sc = new Scanner(System.in);
    public void plus() {
        System.out.println("Please enter two numbers you want to add to eachother! Space them out with a blank.");
        try {
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double result = a + b;
        System.out.println(a + " plus " + b + " equals " + result);
        listener.listen();
        } catch (Exception e) {
            if (sc.nextLine().equals("Stop")) {
                Main.stop();
            } else if (sc.nextLine().equals("Back")) {
                listener.listen();
            } else {
                System.out.println("Your input did not match the requirements!");
                plus();
            }
        }
    }
    public void minus() {
        System.out.println("Please enter two numbers you want to subtract from eachother! Space them out with a blank.");
        try {
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double result = b - a;
        System.out.println(b + " minus " + a + " equals to " + result);
        listener.listen();
        } catch (Exception e) {
            if (sc.nextLine() == "Stop") {
                Main.stop();
            } else if (sc.nextLine() == "Back") {
                listener.listen();
            } else {
                System.out.println("Your input did not match the requirements!");
                minus();
            }
        }
    }
    public void circumference() {
        System.out.println("Please enter the Radius of your circle!");
        try {
            double radius = sc.nextDouble();
            double result = Math.PI * Math.pow(radius, 2);
            System.out.println("The circumference of your Circle is " + result);
            listener.listen();
        } catch (Exception e) {
            if (sc.nextLine() == "Stop") {
                Main.stop();
            } else if (sc.nextLine() == "Back") {
                listener.listen();
            } else {
                System.out.println("Your input did not match the requirements!");
                circumference();
            }
        } 
    }
    public void faculty() {
        System.out.println("Please enter a Natural number you want the faculty of!");
        try {
            int n = sc.nextInt();
            calcBackend("getFaculty", n);
            System.out.println("The faculty of n is " + calculatorBackend.faculty);
            listener.listen();
        }
        catch (Exception e) {
            if (sc.nextLine() == "Stop") {
                Main.stop();
            } else if (sc.nextLine() == "Back") {
                listener.listen();
            } else {
                System.out.println("Your input did not match the requirements!");
                faculty();
            }
        } 
    }
    public void choose() {
        System.out.println("Please enter two natural numbers you want to use the choose function on! The first number must be bigger than the first one. Space them out with a blank.");
        try {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a < b) {
                System.out.println("The first number must be bigger than the second!");
                choose();
            } else {
                calcBackend("getFaculty", a);
                int facultyOfA = calculatorBackend.faculty;

                calcBackend("getFaculty", b);
                int facultyOfB = calculatorBackend.faculty;
                calcBackend("getFaculty", a-b);
                int facultyOfAMinusB = calculatorBackend.faculty;
                int result = facultyOfA / (facultyOfB * facultyOfAMinusB);
                System.out.println("C(" + a + ", " + b + ") equals to " + result);
                listener.listen();
            }
        } catch (Exception e) {
            if (sc.nextLine() == "Stop") {
                Main.stop();
            } else if (sc.nextLine() == "Back") {
                listener.listen();
            } else {
                System.out.println("Your input did not match the requirements!");
                choose();
            }
        }
    }
    public void printPrimes() {
        System.out.println("Please enter the greatest number you want");
        try {
            int biggest = sc.nextInt();
            calcBackend("getPrimes", biggest);
            ArrayList<Integer> allPrimes = calculatorBackend.primeGen;
            System.out.println("the Prime numbers up to your number are: " + allPrimes);
            listener.listen();
        } catch (Exception e) {
            if (sc.nextLine() == "Stop") {
                Main.stop();
            } else if (sc.nextLine() == "Back") {
                listener.listen();
            } else {
                System.out.println("Your input did not match the requirements!");
                printPrimes();
            }
        }
    }
    public void factorise() {
        System.out.println("Please enter the number you want to factorise!");
        try {
            boolean isPrime = false;
            int numberToFactorise = sc.nextInt();
            ArrayList<Integer> primeFactors = new ArrayList<Integer>();
            calcBackend("getPrimes", numberToFactorise);
            ArrayList<Integer> primesUpToNumber = calculatorBackend.primeGen;
            while (!isPrime) {
                for (int primeNumber : primesUpToNumber) {
                    if (primeNumber == numberToFactorise) {
                        isPrime = true;
                        primeFactors.add(numberToFactorise);
                    }
                    else if (numberToFactorise % primeNumber == 0) {
                        numberToFactorise = numberToFactorise / primeNumber;
                        primeFactors.add(primeNumber);
                    }
                }
            }
            System.out.println("The prime Factors are: " + primeFactors);
            listener.listen();
        } catch (Exception e) {
            if (sc.nextLine() == "Stop") {
                Main.stop();
            } else  if(sc.nextLine() == "Back") {
                listener.listen();
            } else {
                System.out.println("Your input did not match the requirements!");
                factorise();
            }
        }
    }
}