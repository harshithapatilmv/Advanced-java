package lab3;
import java.util.*;
public class CapitalizeWords {






    public static String capitalizeWords(String str) {
        String[] words = str.split("\\s+");
        String result = "";

        for (String word : words) {
            if (word.length() > 0) {
                result += Character.toUpperCase(word.charAt(0)) +
                          word.substring(1).toLowerCase() + " ";
            }
        }
        return result.trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Capitalized: " + capitalizeWords(input));
    }
}