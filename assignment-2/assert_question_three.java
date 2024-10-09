import java.util.Scanner;

public class assert_question_three{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number between 0 and 10: ");
        int userInput = scanner.nextInt();
        
        assert (userInput >= 0 && userInput <= 10) : "The entered number is out of range ";
        
        System.out.println("The number you've enter is: " + userInput);
        
        scanner.close();
    }
}