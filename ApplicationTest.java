import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ApplicationTest {

    @Test
    public void should_return_same_value_after_encoding_and_decoding() {
        Application application = new Application();

        String textToEncode = "test123";
        String encodedText = application.encodeText(textToEncode);
        String decodedText = application.decodeText(encodedText);

        Assertions.assertEquals(textToEncode, decodedText);
    }

    @Test
    public void should_generate_secure_password_which_fulfill_all_requirement() {
        for (int i = 0; i < 500; i++) {
            Application application = new Application();

            String strongPassword = application.generateStrongPassword();

            System.out.println(strongPassword);
            Assertions.assertTrue(strongPassword.length() > 8);
            Assertions.assertTrue(strongPassword.chars().mapToObj(c -> (char) c).toList().stream().anyMatch(Character::isLowerCase));
            Assertions.assertTrue(strongPassword.chars().mapToObj(c -> (char) c).toList().stream().anyMatch(Character::isUpperCase));
            Assertions.assertTrue(strongPassword.chars().mapToObj(c -> (char) c).toList().stream().anyMatch(Character::isDigit));
        }
    }
}
