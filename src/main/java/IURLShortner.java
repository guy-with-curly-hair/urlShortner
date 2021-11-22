import org.apache.commons.validator.routines.UrlValidator;

import java.util.Optional;

public interface IURLShortner {

    String encodeLongUrlToShort(String longUrl) throws InvalidURLException;

    Optional<String> decodeShortUrlToLong(String shortUrl);

    default boolean validURL(String URL) {
        return UrlValidator.getInstance().isValid(URL);
    }
}
