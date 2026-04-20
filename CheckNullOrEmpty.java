package lab3;
import java.util.*;
public class CheckNullOrEmpty {







    public static boolean isNullOrEmpty(String str) {
        return (str == null || str.trim().isEmpty());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        if (isNullOrEmpty(input)) {
            System.out.println("String is null or empty/whitespace.");
        } else {
            System.out.println("String is not empty.");
        }
    }
}