import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UrlShortnerTest {
UrlShortner u ;
private static String valid_url="http://www.google.com";
    private static String invalid_url="www.mcom.com";

    @BeforeEach
    void setUp() {
        u = new UrlShortner();
    }

    @Test
    void encodeLongUrlToShort() throws InvalidURLException {
        String encoedurl= u.encodeLongUrlToShort(valid_url);
        assertTrue(encoedurl.contains(Constants.DOMAIN_PREFIX));
    }

    @Test
    void decodeShortUrlToLong() throws InvalidURLException {
        String encoedurl= u.encodeLongUrlToShort(valid_url);
        Optional<String> decodedURL= u.decodeShortUrlToLong(encoedurl);
        assertTrue(valid_url.equals(decodedURL.get()));
    }

    @Test
    void testException()
    {
        InvalidURLException thrown = assertThrows(InvalidURLException.class, () -> u.encodeLongUrlToShort("www.google.com"));
        assertTrue(thrown.getMessage().contains("Invalid url"));
    }
}