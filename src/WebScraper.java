import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int allWordCount(final String url) {
        String allWord = urlToString(url);
        String[] wordCount = allWord.split(" ");
        return wordCount.length;
    }

    public static int singleWordCount(final String word, final String url) {
        String allWord = urlToString(url);
        String[] wordCount = allWord.split(" ");
        int count = 0;
        for (int i = 0; i < wordCount.length; i++) {
            if (word.equals(wordCount[i].replaceAll("[^(A-Za-z)]", ""))) {
                count++;
            }
        }
        return count;
//        String word = word.replaceAll("[^(A-Za-z)]", "");
    }

    public static void main(String[] unused) {
//        String webWord = urlToString("https://www.bls.gov/tus/charts/chart9.txt");
//        System.out.println(webWord);
        System.out.println(singleWordCount("leisure", "https://www.bls.gov/tus/charts/chart9.txt"));
//        String a = "%^$@!abcd";
//        String b = a.replaceAll("[^(A-Za-z)]", "");
//        System.out.println(b);
    }
}
