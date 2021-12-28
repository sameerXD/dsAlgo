public class palindromeString {
    public static int isPalindrome(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            if (s[i] != s[s.length - 1 - i]) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        char[] arr = { 'a', 'b', 'a', 'a' };

        int res = isPalindrome(arr);
        System.out.print(res);

    }
}
