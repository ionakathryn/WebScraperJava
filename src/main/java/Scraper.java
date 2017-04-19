import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created by iiiiiii on 19/04/17.
 */
public class Scraper {
        public static void main(String[] args) throws Exception{
            Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
            System.out.println(doc.outerHtml());


        }
    }
