/**
 * (1)first i need to find all the substrings of the string
 * substring method takes in two arguments starting index and last index
 * starting index goes from 0 to n-1
 * last index goes from (starting_index +1) to n
 * 
 * (2)a function which checks if the substring is a palindome
 * will run the loop for n/2 times
 * check ith index is equal to (n-i)th
 */

public class palindromic_substring {
    public static Boolean check_palindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1))
                return false;
        }
        return true;
    }

    public static void get_substring(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j <= str.length(); j++) {
                Boolean isPalindrome = check_palindrome(str.substring(i, j));
                if (isPalindrome) {
                    System.out.println(str.substring(i, j));
                }
            }
        }
    }

    public static void main(String[] args) {
        String str = "abcc";
        get_substring(str);
    }

}
