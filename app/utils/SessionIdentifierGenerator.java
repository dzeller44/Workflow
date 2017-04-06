package utils;

import java.math.BigInteger;
import java.security.SecureRandom;

public class SessionIdentifierGenerator {
    /**
     * Generate random unique alpha numeric string
     * reference http://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string
     * @return
     */
    public static String nextSessionId() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }
}