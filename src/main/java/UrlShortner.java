import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class UrlShortner implements IURLShortner {

    Map<String, String> urlMap = new ConcurrentHashMap<>();
    Random ran = new Random();

    @Override
    public String encodeLongUrlToShort(String longUrl) throws InvalidURLException {

        if (!validURL(longUrl)) {
            throw new InvalidURLException("Invalid url");
        }
        char[] shortURL = new char[Constants.urlLength];
        for (int i = 0; i < Constants.urlLength; i++)
            shortURL[i] = Constants.randChars.charAt(ran.nextInt(Constants.randChars.length()));

        StringBuilder sb = new StringBuilder(Constants.DOMAIN_PREFIX);
        sb.append(new String(shortURL));
        urlMap.put(sb.toString(), longUrl);

        return sb.toString();

    }

    @Override
    public Optional<String> decodeShortUrlToLong(String shortUrl) {
        return urlMap.containsKey(shortUrl) ? Optional.of(urlMap.get(shortUrl)) : Optional.empty();
    }

}
