import java.util.Scanner;

/**
 * Simple Calculator Application
 * Performs basic arithmetic operations: addition, subtraction, multiplication, and division
 */
public class Calculator {
    
    /**
     * Main method to run the calculator
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;
        
        System.out.println("===== Simple Calculator =====");
        System.out.println("Operations: +, -, *, /");
        System.out.println("Type 'exit' to quit\n");
        
        while (continueCalculating) {
            try {
                // Get first number
                System.out.print("Enter first number: ");
                if (!scanner.hasNextDouble()) {
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("exit")) {
                        continueCalculating = false;
                        break;
                    }
                    System.out.println("Invalid input. Please enter a number.\n");
                    continue;
                }
                double firstNumber = scanner.nextDouble();
                
                // Get operator
                System.out.print("Enter operator (+, -, *, /): ");
                char operator = scanner.next().charAt(0);
                
                // Get second number
                System.out.print("Enter second number: ");
                double secondNumber = scanner.nextDouble();
                
                // Calculate result
                double result = calculate(firstNumber, secondNumber, operator);
                System.out.println("Result: " + firstNumber + " " + operator + " " + secondNumber + " = " + result + "\n");
                
            } catch (Exception e) {
                System.out.println("An error occurred. Please try again.\n");
                scanner.nextLine(); // Clear the buffer
            }
        }
        
        System.out.println("Thank you for using the calculator!");
        scanner.close();
    }
    
    /**
     * Performs the calculation based on the operator
     * 
     * @param num1 First number
     * @param num2 Second number
     * @param operator The operation to perform (+, -, *, /)
     * @return The result of the calculation
     * @throws IllegalArgumentException if operator is invalid or division by zero occurs
     */
    public static double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero!");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
