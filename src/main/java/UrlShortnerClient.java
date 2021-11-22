import java.util.stream.IntStream;

public class UrlShortnerClient {

    public static void main(String[] args) throws InvalidURLException {

        UrlShortnerClient client = new UrlShortnerClient();

        UrlShortner url = new UrlShortner();
        String envodedurl = (url.encodeLongUrlToShort("https://www.google.co.in"));
        System.out.println(envodedurl);
        System.out.println(url.decodeShortUrlToLong(envodedurl).get());

       String envodedurl1 = (url.encodeLongUrlToShort("http://www.fb.co.in"));
        System.out.println(envodedurl1);
        System.out.println(url.decodeShortUrlToLong(envodedurl1).get());

        System.out.println("Main exits");

    }


}
