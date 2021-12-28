
/**
 * given--> 2 strings(str1, str2) and also an array of strings (result)
 * to do--> we have to check if each string from result is a valid shuffle of
 * strings
 * (ster1, str2)
 * 
 * algo
 * (1)sort str1, str2, and each strings of array result
 * (2)then we check that length of (str1+str2) equals length of result
 * (3)if not return false
 * (4)we loop through result string and check if that character is also there in
 * str1
 * or str2.
 * (5) if its there in any of the strings (str1, str2) increment (i, j)
 * respectively
 * (6)if that character is neither in str1 or str2 return false
 * (7)check if (i, j) equals to (str1.length, str2length) respectively if any of
 * the condition
 * fails then return false
 * 
 */

import java.util.*;

public class check_valid_shuffle {

    // sort the String alphabatecally
    public static String sort_string(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        // convert character array back to string

        return String.valueOf(arr);

    }

    // check if its a shuffle
    public static Boolean check_shuffle(String str1, String str2, String result) {

        int j = 0; // track characters found in str1
        int k = 0; // track characters found in str2

        // step 2
        if ((str1 + str2).length() != result.length())
            return false;

        // step 4
        for (int i = 0; i < result.length(); i++) {

            if (j < str1.length() && str1.charAt(j) == result.charAt(i)) {
                j++;
            } else if (k < str2.length() && str2.charAt(k) == result.charAt(i)) {
                k++;
            } else {
                return false;
            }

        }

        if (j < str1.length() || k < str2.length())
            return false;

        return true;
    }

    // driver
    public static void main(String[] args) {
        String str1 = "XY";
        String str2 = "12";

        String[] result = { "XY12", "12XY", "1X2Y", "XX12Y" };

        String sort_str1 = sort_string(str1);
        String sort_str2 = sort_string(str2);

        Boolean is_a_shuffle;
        for (String str : result) {
            String sort_result = sort_string(str);
            is_a_shuffle = check_shuffle(sort_str1, sort_str2, sort_result);
            if (is_a_shuffle) {
                System.out.println(str + " is a shuffle of " + str1 + " and " + str2);
            } else {
                System.out.println(str + " is not a shuffle of " + str1 + " and " + str2);

            }
        }

    }

}
