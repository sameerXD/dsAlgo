public class duplicate_char_array {
    public static void main(String[] args) {
        String str = "geeksofgeeks";

        int no_of_char = 256; // java jas 256 characters
        int[] total_characters_count = new int[no_of_char];

        for (int i = 0; i < str.length(); i++) {
            total_characters_count[str.charAt(i)]++;
        }

        for (int i = 0; i < no_of_char; i++) {
            if (total_characters_count[i] > 1) {
                System.out.println("character -> " + (char) (i) + " count " + total_characters_count[i]);
            }
        }

    }
}
