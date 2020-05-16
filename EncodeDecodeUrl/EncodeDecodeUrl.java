import java.util.*;

public class EncodeDecodeUrl {
    private HashMap<Integer, String> hmap = new HashMap<Integer, String>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        // Long randLong = (long) (Math.random() * 6000000);
        hmap.put(longUrl.hashCode(), longUrl);
        return ("http://tinyurl.com/" + longUrl.hashCode());
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        System.out.println(shortUrl);
        Integer key = Integer.parseInt(shortUrl.substring(19));
        return hmap.get(key);
    }

    public static void main(String[] args) {
        EncodeDecodeUrl ed = new EncodeDecodeUrl();
        System.out.println(ed.decode(ed.encode("https://leetcode.com/problems/design-tinyurl")));
    }
}