public class string_rotation_of_another {
    public static int check_rotation(String str1, String str2) {
        if (str1.length() != str2.length())
            return 0;

        if ((str1 + str1).indexOf(str2) == -1)
            return 0;
        return 1;
    }

    public static void main(String[] args) {
        String str1 = "aacd";
        String str2 = "acda";

        int res = check_rotation(str1, str2);

        System.out.print(res);
    }

}
