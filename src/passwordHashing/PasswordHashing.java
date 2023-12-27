package passwordHashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHashing {
   public static String doHashing(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5"); //ເຂົ້າລະຫັດ MD5 ຫຼື SHA
            messageDigest.update(password.getBytes());
            byte[] resultByteArray = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : resultByteArray) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(doHashing("1234"));
        System.out.println("Len: "+ doHashing("1234").length());
    }
}