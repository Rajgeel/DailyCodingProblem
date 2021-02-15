// Implement a URL shortener with the following methods:

// shorten(url), which shortens the url into a six-character alphanumeric string, such as zLg6wl.
// restore(short), which expands the shortened string into the original url. If no such shortened string exists, return null.
// Hint: What if we enter the same URL twice?


import java.util.HashMap;
import java.util.Map;
import java.util.Random;


// Time complexity is O(n) and space Compleity is O(n).
class URLShortener {

    Map<String, String> map = new HashMap<>();
    Random random = new Random();
    int length = 6;

    public String shorten(String url) {
        String shortUrl;

        do {
            shortUrl = getRandomString(length);
        } while (map.containsKey(shortUrl));

        map.put(shortUrl, url);
        return shortUrl;
    }

    public String restore(String shortUrl) {
        return map.get(shortUrl);
    }

    private String getRandomString(int length) {
        StringBuilder buf = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (random.nextBoolean())
                buf.append(random.nextInt(10));
            else {
                char ch = random.nextBoolean() ? 'A' : 'a';
                ch += random.nextInt(26);
                buf.append(ch);
            }
        }

        return buf.toString();
    }

	public static void main(String... args) {

        URLShortener urlShortener = new URLShortener();

        String url = "www.microsoft.com";
        String shortUrl;
        System.out.println(url + " - " + (shortUrl = urlShortener.shorten(url)) + " - " + urlShortener.restore(shortUrl));
        System.out.println(url + " - " + (shortUrl = urlShortener.shorten(url)) + " - " + urlShortener.restore(shortUrl));
    }
}