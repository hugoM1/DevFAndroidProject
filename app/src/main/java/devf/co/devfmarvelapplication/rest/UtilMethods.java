package devf.co.devfmarvelapplication.rest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.TimeZone;

public class UtilMethods {

    public static Long generateTimeStamp (){
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        return calendar.getTimeInMillis() / 1000L;
    }

    public static String generateHash (long timeStamp) {
        return md5(String.valueOf(timeStamp) + Constants.API_PRIVATE_KEY + Constants.API_PUBLIC_KEY);
    }

    /**
     * Created by Trey Robinson on 2/14/14.
     * Creates an md5 hash string from the string input
     *
     * @param s  String to be hashed
     */
    public static String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
