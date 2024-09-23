import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class randarray {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean valid = false;
        int[] randnums = new int[100];
        int indexnum;

        while(valid == false){
            try {
                for (int i = 0; i < randnums.length; i++) {
                    randnums[i] = random.nextInt(100);
                }
                System.out.print("Enter an index number between 0 and 99: ");
                indexnum = scanner.nextInt();
                System.out.println("The number at index " + indexnum + " is " + randnums[indexnum]);
                valid = true;
            } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                System.out.print("Input is invalid, try again with integer values. ");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
