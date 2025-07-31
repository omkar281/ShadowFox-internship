import java.util.Scanner; // Import Scanner class to take user input

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read user input
        boolean isRunning = true; // Flag to control the loop

        while (isRunning) { // Start the main loop
            System.out.println("Choose operation:"); // Display menu options
            // Display different operation choices
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Square Root");
            System.out.println("6. Exponentiation");
            System.out.println("7. Temperature Conversion");
            System.out.println("8. Currency Conversion");
            System.out.println("9. Exit");
            int choice = scanner.nextInt(); // Read user's choice

            switch (choice) { // Switch case based on user's choice
                case 1:
                    addition(); // Call addition method
                    break;
                case 2:
                    subtraction(); // Call subtraction method
                    break;
                case 3:
                    multiplication(); // Call multiplication method
                    break;
                case 4:
                    division(); // Call division method
                    break;
                case 5:
                    squareRoot(); // Call square root method
                    break;
                case 6:
                    exponentiation(); // Call exponentiation method
                    break;
                case 7:
                    temperatureConversion(); // Call temperature conversion method
                    break;
                case 8:
                    currencyConversion(); // Call currency conversion method
                    break;
                case 9:
                    isRunning = false; // Set flag to exit the loop
                    System.out.println("Exiting..."); // Display exit message
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again."); // Display error message for invalid input
            }
        }
        scanner.close(); // Close Scanner object to release resources
    }

    // Define methods for each operation

    public static void addition() {
        Scanner scanner = new Scanner(System.in); // Create Scanner object to read user input
        System.out.println("Enter first number:"); // Prompt user to enter first number
        double num1 = scanner.nextDouble(); // Read first number
        System.out.println("Enter second number:"); // Prompt user to enter second number
        double num2 = scanner.nextDouble(); // Read second number
        double result = num1 + num2; // Perform addition
        System.out.println("Result: " + result); // Display result
    }

    public static void subtraction() {
        Scanner scanner = new Scanner(System.in); // Create Scanner object to read user input
        System.out.println("Enter minuend:"); // Prompt user to enter minuend
        double minuend = scanner.nextDouble(); // Read minuend
        System.out.println("Enter subtrahend:"); // Prompt user to enter subtrahend
        double subtrahend = scanner.nextDouble(); // Read subtrahend
        double result = minuend - subtrahend; // Perform subtraction
        System.out.println("Result: " + result); // Display result
    }

    public static void multiplication() {
        Scanner scanner = new Scanner(System.in); // Create Scanner object to read user input
        System.out.println("Enter first number:"); // Prompt user to enter first number
        double num1 = scanner.nextDouble(); // Read first number
        System.out.println("Enter second number:"); // Prompt user to enter second number
        double num2 = scanner.nextDouble(); // Read second number
        double result = num1 * num2; // Perform multiplication
        System.out.println("Result: " + result); // Display result
    }

    public static void division() {
        Scanner scanner = new Scanner(System.in); // Create Scanner object to read user input
        System.out.println("Enter dividend:"); // Prompt user to enter dividend
        double dividend = scanner.nextDouble(); // Read dividend
        System.out.println("Enter divisor:"); // Prompt user to enter divisor
        double divisor = scanner.nextDouble(); // Read divisor
        if (divisor != 0) {
            double result = dividend / divisor; // Perform division if divisor is not zero
            System.out.println("Result: " + result); // Display result
        } else {
            System.out.println("Error: Division by zero"); // Display error message for division by zero
        }
    }

    public static void squareRoot() {
        Scanner scanner = new Scanner(System.in); // Create Scanner object to read user input
        System.out.println("Enter number:"); // Prompt user to enter number
        double num = scanner.nextDouble(); // Read number
        if (num >= 0) {
            double result = Math.sqrt(num); // Calculate square root if number is non-negative
            System.out.println("Result: " + result); // Display result
        } else {
            System.out.println("Error: Cannot calculate square root of a negative number"); // Display error message for negative input
        }
    }

    public static void exponentiation() {
        Scanner scanner = new Scanner(System.in); // Create Scanner object to read user input
        System.out.println("Enter base:"); // Prompt user to enter base
        double base = scanner.nextDouble(); // Read base
        System.out.println("Enter exponent:"); // Prompt user to enter exponent
        double exponent = scanner.nextDouble(); // Read exponent
        double result = Math.pow(base, exponent); // Perform exponentiation
        System.out.println("Result: " + result); // Display result
    }

    public static void temperatureConversion() {
        Scanner scanner = new Scanner(System.in); // Create Scanner object to read user input
        System.out.println("Enter temperature:"); // Prompt user to enter temperature
        double temp = scanner.nextDouble(); // Read temperature
        System.out.println("Choose conversion:"); // Display conversion options
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        int choice = scanner.nextInt(); // Read user's choice
        double result;
        switch (choice) {
            case 1:
                result = (temp * 9/5) + 32; // Convert Celsius to Fahrenheit
                System.out.println("Result: " + result + " °F"); // Display result in Fahrenheit
                break;
            case 2:
                result = (temp - 32) * 5/9; // Convert Fahrenheit to Celsius
                System.out.println("Result: " + result + " °C"); // Display result in Celsius
                break;
            default:
                System.out.println("Invalid choice."); // Display error message for invalid input
        }
    }

    public static void currencyConversion() {
        Scanner scanner = new Scanner(System.in); // Create Scanner object to read user input
        System.out.println("Enter amount:"); // Prompt user to enter amount
        double amount = scanner.nextDouble(); // Read amount
        System.out.println("Choose conversion:"); // Display conversion options
        System.out.println("1. USD to EUR");
        System.out.println("2. EUR to USD");
        int choice = scanner.nextInt(); // Read user's choice
        double result;
        switch (choice) {
            case 1:
                result = amount * 0.84; // Convert USD to EUR (assuming 1 USD = 0.84 EUR)
                System.out.println("Result: " + result + " EUR"); // Display result in EUR
                break;
            case 2:
                result = amount / 0.84; // Convert EUR to USD (assuming 1 EUR = 0.84 USD)
                System.out.println("Result: " + result + " USD"); // Display result in USD
                break;
            default:
                System.out.println("Invalid choice."); // Display error message for invalid input
        }
    }
}
