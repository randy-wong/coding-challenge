import java.io.File;
import java.io.IOException;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Randy Wong
 */
public class PageTagger {

    public static void main(String[] args) throws IOException {
        PageTagger pageTagger = new PageTagger();
        
        // Command line input
        if(args.length > 0) {
            for(String arg : args) {
            	// Create URL object
                URL url = new URL(arg);
                // Apply getText method to URL object
                String pageText = pageTagger.getText(url);
                // Apply tagText to getText modified object
                String taggedText = pageTagger.tagText(pageText);
                // Print out POS of URL
                System.out.println(url + ": " + taggedText);
            }
        }
        else {
        	// Created URL objects for URL Strings
            URL a = new URL("http://gumgum.com");
            URL b = new URL("http://www.popcrunch.com/jimmy-kimmel-engaged/");
            URL c = new URL("http://gumgum-public.s3.amazonaws.com/numbers.html");
            URL d = new URL("http://www.windingroad.com/articles/reviews/quick-drive-2012-bmw-z4-sdrive28i/");

            System.out.println("Gum Gum Website: " + pageTagger.tagText(pageTagger.getText(a)));
            System.out.println("Popcrunch Website: " + pageTagger.tagText(pageTagger.getText(b)));
            System.out.println("Test Page Website: " + pageTagger.tagText(pageTagger.getText(c)));
            System.out.println("Windingroad Website: " + pageTagger.tagText(pageTagger.getText(d)));
        }
    }
    
    private MaxentTagger tagger;
    // Needed to get proper class pathing in order to run code correctly
    public PageTagger() {
        String modelPath = "edu"+File.separator+"stanford"+File.separator+"nlp"+File.separator+"models"+File.separator+
                "pos-tagger"+File.separator+"english-left3words"+File.separator;
        // Instance of MaxentTagger
        tagger = new MaxentTagger(modelPath + "english-left3words-distsim.tagger");
    }

    // Returns POS of String passed in
    public String tagText(String text) {
        return tagger.tagString(text);
    }

    // Exception checks URL
    public String getText(URL url) throws IOException {
    	// Used Jsoup to parse, objected used is Document
        Document doc = Jsoup.connect(url.toString()).get();
        // Grabbed text body
        Element body = doc.body();
        return getTextString(body, "");
    }
    
    // Method used to further parse the body of text
    private String getTextString(Element element, String currentText) {
    	// Flag to ignore script
        boolean isScriptTag = element.tagName().equalsIgnoreCase("script");
        // Used to check nested Elements
        Elements children = element.children();
        // If there are no more children or is a script
        if(children.isEmpty() || isScriptTag) {
            return currentText;
        }
        else {
        	//Check all nested Elements
            for(Element child : children) {
                if(child.hasText()) {
                	// Add text to be returned
                    currentText += child.text();
                    // Uses recursion to check further nested Elements
                    return getTextString(child, currentText);
                }
            }
        }
        return currentText;
    }

}