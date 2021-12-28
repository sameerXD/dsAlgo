/**
 * (1)find all the substrings of string
 * (2)find if the substring is a palindrome or not
 * (3)if its a palindrome ill check its length if its greater then the length of
 * previous
 * palindrome ill replace the old one
 */
public class longest_palindromic_substring {

    public static Boolean check_palindrome(String str, int n) {
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1))
                return false;
        }
        return true;
    }

    public static String longest_palindrom_substring(String str, int n) {
        String lps = "";
        for (int i = 0; i < n; i++) {
            for (int j = i; j <= n; j++) {
                Boolean isPalindrome = check_palindrome(str.substring(i, j), str.substring(i, j).length());

                if (isPalindrome && str.substring(i, j).length() > lps.length()) {
                    lps = str.substring(i, j);
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        String res = longest_palindrom_substring(str, str.length());
        System.out.print(res);
    }

}
