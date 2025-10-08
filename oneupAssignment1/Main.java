/**
 * @filename Main.java
 * This file serves as the main driver program to demonstrate various string operations
 * implemented in the MyString class. It allows users to interactively perform operations
 * like append, replace, count words, check palindrome, sort, reverse, etc.
 * 
 * @author Priyanshu Joshi
 * @class Main
 * @description The Main class is responsible for providing a menu-driven interface
 *              to test and execute all string manipulation methods defined in MyString.
 * @date 2025-10-08
 */

package oneupAssignment1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your string:");
        String str = sc.nextLine();

        MyString S = new MyString(str);
        S.Printstring();

        while (true) {
            // Choices of operation
            System.out.println("\n=== Choose an Operation ===");
            System.out.println("1. Append");
            System.out.println("2. CountWords");
            System.out.println("3. Replace");
            System.out.println("4. isPalindrome");
            System.out.println("5. Splice");
            System.out.println("6. Split");
            System.out.println("7. MaxRepeatingCharacter");
            System.out.println("8. Sort");
            System.out.println("9. Shift");
            System.out.println("10. Reverse");
            System.out.println("11. Print string");
            System.out.println("12. Exit");
            System.out.print("Enter choice (1-12): ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter text to append:");
                    String toappend = sc.nextLine();
                    S.append(toappend);
                    break;

                case 2:
                    int count = S.count();
                    System.out.println("Number of words in the string: " + count);
                    break;

                case 3:
                    System.out.println("Enter the word to replace:");
                    String oldword = sc.nextLine();
                    System.out.println("Enter the word to replace with:");
                    String newword = sc.nextLine();
                    S.replace(oldword, newword);
                    break;

                case 4:
                    if (S.isPalindrome()) {
                        System.out.println("The string is a palindrome.");
                    } else {
                        System.out.println("The string is not a palindrome.");
                    }
                    break;

                case 5:
                    System.out.print("Enter start index: ");
                    int start = sc.nextInt();
                    System.out.print("Enter length: ");
                    int length = sc.nextInt();
                    sc.nextLine();
                    S.splice(start, length);
                    break;

                case 6:
                    S.split();
                    break;

                case 7:
                    char maxfreq = S.MaxRepeatingCharacter();
                    System.out.println("Maximum repeated character is: " + maxfreq);
                    break;

                case 8:
                    S.sort();
                    break;

                case 9:
                    System.out.print("Enter shift value: ");
                    int sh = sc.nextInt();
                    sc.nextLine();
                    S.shift(sh);
                    break;

                case 10:
                    S.reverse();
                    break;

                case 11:
                    S.Printstring();
                    break;

                case 12:
                    System.out.println("Exiting program");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please enter 1–12.");
            }
        }
    }
}