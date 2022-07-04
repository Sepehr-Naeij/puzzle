package string_encryption;

public class Encryption {
    public static String Encrypt(String str) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i < (str.length() - 1)) {
                stringBuilder.append((char) (str.charAt(i) + str.charAt(i + 1)));
            } else {
                stringBuilder.append((char) (str.charAt(0) + str.charAt(str.length() - 1)));
            }
        }

        if (str.length() % 2 == 0) {
            String first = String.valueOf(str.charAt(0));
            String last = String.valueOf(str.charAt(str.length() - 1));
            String string = stringBuilder.substring(0, str.length() - 1);
            stringBuilder = new StringBuilder(string + last + first);
        }
        return stringBuilder.toString();
    }

    public static String Decrypt(String string) {

        int length = string.length();
        if (string.charAt(length - 1) < 122) {
            string += "a";
        }
        int[] one = new int[length];
        int[] two = new int[length];

        for (int i = 0; i < length; i++) {
            one[i] = string.charAt(i);
        }

        StringBuilder stringBuilder = new StringBuilder();
        int input1 = 0;
        int input2 = 0;

        for (int j = 0; j < length; j++) {

            if (j % 2 == 0) {
                input1 += one[j];
            } else {
                input2 += one[j];
            }
        }
        int number = ((input1 - input2) / 2);
        two[0] = number;
        stringBuilder.append((char) number);
        int x = length;
        if (string.charAt(length - 1) < 122) {
            x = length - 1;
        }
        for (int k = 1; k < x; k++) {
            two[k] = one[k - 1] - two[k - 1];
            stringBuilder.append((char) two[k]);
        }
        return stringBuilder.toString();
    }
}
