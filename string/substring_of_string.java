/**
 * we have a starting index and lastIndex they are passed into String substing
 * method
 * the last index is not printed eg:-[1,2) for "ab" will return a.
 * 
 * substrings of "ab"=>
 * 
 * [0,1)
 * [1,2) [2,3)
 * 
 * so the starting index starts from 0 to (n-1)
 * and last index goes all the way from (i+1) to n (obviously index n will be
 * ignored by
 * subString method)
 */

public class substring_of_string {

    public static void print_substring(String str) {
        // i is the starting index
        for (int i = 0; i < str.length(); i++) {
            // j is the last index
            for (int j = i + 1; j <= str.length(); j++) {
                System.out.println(str.substring(i, j));
            }
        }

    }

    public static void main(String[] args) {
        String str = "abccb";
        print_substring(str);
    }
}
