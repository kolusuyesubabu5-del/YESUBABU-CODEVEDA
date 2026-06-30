import java.util.Scanner;

class Calculator {

    // Addition
    public double add(double a, double b) {
        return a + b;
    }

    // Subtraction
    public double subtract(double a, double b) {
        return a - b;
    }

    // Multiplication
    public double multiply(double a, double b) {
        return a * b;
    }

    // Division
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Error! Division by zero is not allowed.");
        }
        return a / b;
    }
}

public class basicCalucator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        int choice;
        double num1, num2;

        do {
            System.out.println("\n========== BASIC CALCULATOR ==========");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            if (choice >= 1 && choice <= 4) {

                System.out.print("Enter first number: ");
                num1 = sc.nextDouble();

                System.out.print("Enter second number: ");
                num2 = sc.nextDouble();

                switch (choice) {
                    case 1:
                        System.out.println("Result = " + calc.add(num1, num2));
                        break;

                    case 2:
                        System.out.println("Result = " + calc.subtract(num1, num2));
                        break;

                    case 3:
                        System.out.println("Result = " + calc.multiply(num1, num2));
                        break;

                    case 4:
                        try {
                            System.out.println("Result = " + calc.divide(num1, num2));
                        } catch (ArithmeticException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                }

            } else if (choice == 5) {
                System.out.println("Thank you for using the Basic Calculator!");
            } else {
                System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }

        } while (choice != 5);

        sc.close();
    }
}