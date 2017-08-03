package diploma.gyumri.theatre.conteins;

import java.util.regex.Pattern;

/**
 * Created by root on 7/30/17.
 */

public class Constants {
    public static final String BASE_URL = "http://212.34.246.6:8080/";
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALID_PASSWORD_REGEX =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,12}$", Pattern.CASE_INSENSITIVE);
}
