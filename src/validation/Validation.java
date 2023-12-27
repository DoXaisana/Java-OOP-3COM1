package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static boolean emailValidation(String email) {
        boolean status;

        String email_Pattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z0-9]{2,})$";

        Pattern pattern = Pattern.compile(email_Pattern);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            status = true;
        } else {
            status = false;
        }
        return status;
    }

    public static boolean TelephoneValidation(String tel) {
        boolean status;

        String tel_Pattern = "^((\\(\\d{3}\\))?|\\d{3})[- .]?\\d{4}[- .]?\\d{4}$";

        Pattern pattern = Pattern.compile(tel_Pattern);
        Matcher matcher = pattern.matcher(tel);

        if (matcher.matches()) {
            status = true;
        } else {
            status = false;
        }
        return status;
    }
}
