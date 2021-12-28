import java.util.*;
// method 2 using queue
// (0)if length of string1 != string2 then obviously they cant be rotation of each other
// (1)push charactes of string1 and string2 in there respective queues
// (2)i will keep on poping the first character from the queue and pushing it back 
// (3) repeat step 2 for the length of string times
// (4)if at any point queue1 == queue2 then ill return true -->its a rotation

public class string_rotation_of_another_queue {
    public static boolean check_rotation(String str1, String str2) {

        if (str1.length() != str2.length())
            return false;

        // form a queue for str1
        Queue<Character> q1 = new LinkedList<>();
        for (int i = 0; i < str1.length(); i++) {
            q1.add(str1.charAt(i));
        }

        // form a queue for string str2
        Queue<Character> q2 = new LinkedList<>();
        for (int i = 0; i < str2.length(); i++) {
            q2.add(str2.charAt(i));
        }

        for (int i = 0; i < str1.length(); i++) {
            char temp = q1.peek();
            q1.remove();
            q1.add(temp);

            if (q2.equals(q1))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String str1 = "ABCD";
        String str2 = "CDAB";

        Boolean res = check_rotation(str1, str2);

        System.out.print(res);
    }
}
