package lab2;
import java.util.*;
public class StringOperationsDemo {








    public static void main(String[] args) {

        // 1. String Creation and Basic Operations
        String str1 = "Hello";
        String str2 = new String("World");
        System.out.println("1. String Creation:");
        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);

        // 2. Length and Character Access
        System.out.println("\n2. Length and Character Access:");
        System.out.println("Length of str1: " + str1.length());
        System.out.println("Character at index 1: " + str1.charAt(1));

        // 3. String Comparison
        System.out.println("\n3. String Comparison:");
        System.out.println("Equals: " + str1.equals(str2));
        System.out.println("Equals Ignore Case: " + str1.equalsIgnoreCase("hello"));
        System.out.println("CompareTo: " + str1.compareTo(str2));

        // 4. String Searching
        System.out.println("\n4. String Searching:");
        String text = "Java Programming";
        System.out.println("Contains 'Java'? " + text.contains("Java"));
        System.out.println("Index of 'Pro': " + text.indexOf("Pro"));
        System.out.println("Last index of 'a': " + text.lastIndexOf('a'));

        // 5. Substring Operations
        System.out.println("\n5. Substring Operations:");
        System.out.println("Substring (0,4): " + text.substring(0, 4));
        System.out.println("Substring from index 5: " + text.substring(5));

        // 6. String Modification
        System.out.println("\n6. String Modification:");
        System.out.println("To Upper Case: " + text.toUpperCase());
        System.out.println("To Lower Case: " + text.toLowerCase());
        System.out.println("Replace 'Java' with 'Python': " + text.replace("Java", "Python"));

        // 7. Whitespace Handling
        System.out.println("\n7. Whitespace Handling:");
        String str3 = "   Java Programming   ";
        System.out.println("Before Trim: '" + str3 + "'");
        System.out.println("After Trim: '" + str3.trim() + "'");

        // 8. String Concatenation
        System.out.println("\n8. String Concatenation:");
        String result = str1 + " " + str2;
        System.out.println("Using + operator: " + result);
        System.out.println("Using concat(): " + str1.concat(" ").concat(str2));

        // 9. String Splitting
        System.out.println("\n9. String Splitting:");
        String sentence = "Java,Python,C++";
        String[] parts = sentence.split(",");
        for (String part : parts) {
            System.out.println(part);
        }

        // 10. StringBuilder Demo
        System.out.println("\n10. StringBuilder Demo:");
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        sb.insert(5, " Java");
        sb.replace(0, 5, "Hi");
        sb.delete(2, 7);
        System.out.println("StringBuilder result: " + sb);

        // 11. String Formatting
        System.out.println("\n11. String Formatting:");
        String formatted = String.format("Name: %s, Age: %d", "John", 22);
        System.out.println(formatted);

        // 12. Validate Email using contains(), startsWith(), endsWith()
        System.out.println("\n12. Email Validation:");
        String email = "example@gmail.com";

        boolean isValid = email.contains("@") &&
                          email.startsWith("example") &&
                          email.endsWith(".com");

        System.out.println("Email: " + email);
        System.out.println("Is valid? " + isValid);
    }
}