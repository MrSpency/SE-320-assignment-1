import java.util.InputMismatchException;
import java.util.Scanner;

public class twointsum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;

        while(valid == false){
            try {
                System.out.print("Enter the first number: ");
                int num1 = scanner.nextInt();
            
                System.out.print("Enter the second number: ");
                int num2 = scanner.nextInt();
    
                int sum = num1 + num2;
                System.out.println("The sum of the two numbers is: " + sum);
                valid = true;
            } catch (InputMismatchException e) {
                System.out.print("Input is invalid, try again with integer values. ");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
