import java.util.*;

class reverseString {
    public static void main(String[] args) {
        char[] arr = { 'h', 'e', 'l', 'l', 'o' };

        for (int i = 0; i < arr.length / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        System.out.print(arr);

    }
}