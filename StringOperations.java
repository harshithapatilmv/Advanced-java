package lab3;
import java.util.*;
public class StringOperations {







    public static void main(String[] args) {

        // 1. String Creation and Basic Operations
        String s1 = "Hello";
        String s2 = new String("World");
        System.out.println("1. Strings: " + s1 + " " + s2);

        // 2. Length and Character Access
        System.out.println("\n2. Length: " + s1.length());
        System.out.println("Character at index 1: " + s1.charAt(1));

        // 3. String Comparison
        System.out.println("\n3. Equals: " + s1.equals(s2));
        System.out.println("Equals Ignore Case: " + s1.equalsIgnoreCase("hello"));
        System.out.println("CompareTo: " + s1.compareTo(s2));

        // 4. String Searching
        String text = "Java Programming";
        System.out.println("\n4. Contains 'Java'? " + text.contains("Java"));
        System.out.println("Index of 'Pro': " + text.indexOf("Pro"));

        // 5. Substring Operations
        System.out.println("\n5. Substring (0,4): " + text.substring(0, 4));
        System.out.println("Substring from 5: " + text.substring(5));

        // 6. String Modification
        System.out.println("\n6. Uppercase: " + text.toUpperCase());
        System.out.println("Lowercase: " + text.toLowerCase());
        System.out.println("Replace: " + text.replace("Java", "Python"));

        // 7. Whitespace Handling
        String s3 = "   Java   ";
        System.out.println("\n7. Before trim: '" + s3 + "'");
        System.out.println("After trim: '" + s3.trim() + "'");

        // 8. String Concatenation
        System.out.println("\n8. Concatenation (+): " + s1 + " " + s2);
        System.out.println("Concatenation (concat): " + s1.concat(" ").concat(s2));

        // 9. String Splitting
        String str = "Java,Python,C++";
        String[] arr = str.split(",");
        System.out.println("\n9. Splitting:");
        for (String i : arr) {
            System.out.println(i);
        }

        // 10. StringBuilder Demo
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        sb.insert(5, " Java");
        sb.replace(0, 5, "Hi");
        sb.delete(2, 7);
        System.out.println("\n10. StringBuilder: " + sb);

        // 11. String Formatting
        String formatted = String.format("Name: %s, Age: %d", "John", 20);
        System.out.println("\n11. Formatted String: " + formatted);

        // 12. Email Validation
        String email = "example@gmail.com";
        boolean valid = email.contains("@") &&
                        email.startsWith("example") &&
                        email.endsWith(".com");

        System.out.println("\n12. Email: " + email);
        System.out.println("Is Valid? " + valid);
    }
}