import java.security.SecureRandom;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
    }

    public String encodeText(String textToEncode) {
        return Base64.getEncoder().encodeToString(textToEncode.getBytes());
    }

    public String decodeText(String textToDecode) {
        return new String(Base64.getDecoder().decode(textToDecode));
    }

    public String generateStrongPassword() {
        List<Character> password = String.valueOf(generateSecureRandomByRange(3, 33, 45))
                .concat(generateSecureRandomByRange(3, 65, 90))
                .concat(generateSecureRandomByRange(3, 48, 57))
                .concat(generateSecureRandomByRange(3, 97, 122))
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        Collections.shuffle(password);
        return password.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    public String generateSecureRandomByRange(int size, int origin, int bound) {
        return new SecureRandom()
                .ints(size, origin, bound)
                .mapToObj(specialCharacters -> String.valueOf((char) specialCharacters))
                .collect(Collectors.joining());
    }

}




