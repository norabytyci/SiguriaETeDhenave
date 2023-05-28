public class transformText {

    private String text = "";

    transformText(String text1) {
        text = text1;
        text = trasnform(text);
    }

    public String trasnform(String a) {
        String alphabet = "ABCÇDEËFGHIJKLMNOPQRSTUVWXYZ";
        char d;
        String text2 = "";
        for (int i = 0; i < a.length(); i++) {

            d = a.charAt(i);
            if (alphabet.contains(String.valueOf(d))) {
                text2 += d;

            }
        }
        return text2;
    }

    public String getText() {
        return text;
    }
}
