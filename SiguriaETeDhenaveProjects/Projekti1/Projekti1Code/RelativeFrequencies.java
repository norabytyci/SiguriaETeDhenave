import java.io.IOException;

import java.util.*;

public class RelativeFrequencies {

    private String text = "";
    private String[] alphabet;
    private String[] frequencies;
    private String decrypted = "";

    private Map<String, Integer> map = new LinkedHashMap<>();
    private Map<Integer, String> map2 = new TreeMap<>(
            (Comparator<Integer>) (o1, o2) -> o2.compareTo(o1));
    Map<String, String> map3 = new LinkedHashMap<>();

    RelativeFrequencies(String text1) throws IOException {

        text = text1;
        alphabet = fill("ABCDEËFGHIJKLMNOPQRSTUVWXYZ");
        frequencies = fill("EËTIARNSHUKOMDJPLGVBQFZYCÇX");

        for (int i = 0; i < alphabet.length; i++) {
            map.put(alphabet[i], Integer.valueOf(0));
        }

        char z;
        for (int i = 0; i < text.length(); i++) {
            try {
                z = text.charAt(i);

                map.put(String.valueOf(z), map.get(String.valueOf(z)) + 1);
            }

            catch (java.lang.NullPointerException e) {

            }
        }

        map.forEach((a, b) -> {
            map2.put(b, a);
        });

        ArrayList<String> placeholder = new ArrayList<String>(map2.values());
        for (int i = 0; i < placeholder.size(); i++) {
            map3.put(placeholder.get(i), frequencies[i]);
        }

        // map3.forEach((a, b) -> System.out.println(a + " " + b));
        decrypted = textDecrypt(text, map3);

    }

    public String getDecrypted() {
        return decrypted;
    }

    public static String textDecrypt(String text, Map<String, String> map3) {
        String text2 = "";
        char z;
        for (int i = 0; i < text.length(); i++) {
            z = text.charAt(i);
            try {

                text2 += map3.get(String.valueOf(z)).charAt(0);

            }

            catch (java.lang.NullPointerException e) {
                text2 += String.valueOf(z);

            }
        }
        return text2;
    }

    public Map<String, Integer> getStatistics() {
        return map;
    }

    public Map<String, String> getSubsitutions() {
        return map3;
    }

    private static String[] fill(String word) {
        String[] a = new String[word.length()];
        char p;
        for (int i = 0; i < word.length(); i++) {
            p = word.charAt(i);
            a[i] = String.valueOf(p);
        }
        return a;
    }

}
