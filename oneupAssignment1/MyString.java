package oneupAssignment1;

/**
 * Simple mutable wrapper around a String with utility string operations.
 * Methods operate on the internal `data` field.
 */
public class MyString {

    // The internal string storage for this MyString instance.
    private String data;

    // Default constructor — initializes data to an empty string.
    public MyString() {
        this.data = "";
    }

    // Parameterized constructor — initialize with provided string (may be null).
    public MyString(String string) {
        this.data = string;
    }

    // Convert object to string — returns the internal data.
    @Override
    public String toString() {
        return this.data;
    }

    // Print current string to standard output.
    public void Printstring() {
        System.out.println("The value stored in Mystring is: " + this.data);
    }

    // Append another string to data (adds a space between existing text and
    // appended text).
    public void append(String toAppend) {
        this.data = this.data + " " + toAppend;
    }

    // Count number of words in data using a simple space-separated definition.
    public int count() {
        int count = 0;
        boolean inWord = false;

        // If data is null or empty, there are no words.
        if (this.data == null || this.data.isEmpty()) {
            return 0;
        }

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            // When we encounter a non-space while not currently in a word, we've found a
            // new word.
            if (c != ' ' && !inWord) {
                inWord = true;
                count++;
            } else if (c == ' ') {
                // A space marks the end of the current word.
                inWord = false;
            }
        }
        return count;
    }

    // Replace occurrences of oldword with newword in the internal data.
    // Words are considered to be sequences separated by single spaces (no
    // punctuation handling).
    public void replace(String oldword, String newword) {
        String result = "";
        String temp = "";

        if (this.data == null || this.data.isEmpty()) {
            return; // nothing to replace
        }

        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);

            if (ch != ' ') {
                // build the current word
                temp = temp + ch;
            } else {
                // on space, check the completed word and append accordingly
                if (temp.equals(oldword)) {
                    result = result + newword + " ";
                } else {
                    result = result + temp + " ";
                }
                temp = ""; // reset for next word
            }
        }
        // Check for the last word (not followed by a space)
        if (temp.equals(oldword)) {
            result += newword + " ";
        } else if (!temp.isEmpty()) {
            result += temp + " ";
        }

        // Trim trailing/leading whitespace and update internal data
        this.data = result.trim();
    }

    // Check if data is a palindrome (ignores whitespace and is case-insensitive).
    public boolean isPalindrome() {
        if (this.data == null) {
            return false;
        }
        String text = data.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Splice (remove) substring from start index for given length.
    public void splice(int start, int length) {
        if (this.data == null) {
            System.out.println("Invalid start index!");
            return;
        }
        if (start < 0 || start >= data.length()) {
            System.out.println("Invalid start index!");
            return;
        }
        String result = "";
        for (int i = 0; i < data.length(); i++) {
            // keep characters that are outside the [start, start+length) range
            if (i < start || i >= start + length) {
                result += data.charAt(i);
            }
        }
        this.data = result;
    }

    // Split the data and print words (simple space-separated split).
    public void split() {
        if (this.data == null || this.data.isEmpty()) {
            System.out.println("Splitted string:");
            return;
        }

        String word = "";
        System.out.println("Splitted string:");
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            if (ch != ' ') {
                word = word + ch;
            } else {
                System.out.println(word);
                word = "";
            }
        }
        if (word.length() > 0) {
            System.out.println(word);
        }
    }

    // Find maximum repeating character in the string (counts all characters
    // including spaces).
    public char MaxRepeatingCharacter() {
        if (this.data == null || this.data.isEmpty()) {
            return '\0';
        }

        int maxCount = 0;
        char maxChar = ' ';
        for (int i = 0; i < data.length(); i++) {
            int count = 0;
            for (int j = 0; j < data.length(); j++) {
                if (data.charAt(i) == data.charAt(j))
                    count++;
            }
            if (count > maxCount) {
                maxCount = count;
                maxChar = data.charAt(i);
            }
        }
        return maxChar;
    }

    // Sort characters in the string alphabetically using bubble sort.
    public void sort() {
        if (this.data == null) {
            return;
        }
        char[] arr = data.toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        this.data = new String(arr);
    }

    // Shift the string left by n characters (rotates).
    public void shift(int n) {
        if (this.data == null) {
            return;
        }
        int len = data.length();
        if (len == 0)
            return;
        n = n % len; // normalize shift
        this.data = data.substring(n) + data.substring(0, n);
    }

    // Reverse the string character-wise.
    public void reverse() {
        if (this.data == null) {
            return;
        }
        String rev = "";
        for (int i = data.length() - 1; i >= 0; i--) {
            rev += data.charAt(i);
        }
        this.data = rev;
    }
}
