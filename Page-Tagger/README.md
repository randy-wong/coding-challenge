Java Exercise ­ Part of Speech Tagging

The goal here is to tag the text present in web pages using the Stanford Part of Speech Tagger. Feel

free to use any 3rd party libraries for this task if it makes your job easier.

Part 1

1. Download the latest version of the English Stanford Tagger:

http://nlp.stanford.edu/software/tagger.shtml

2. Write a class called PageTagger​ that internally contains an instance of

edu.stanford.nlp.tagger.maxent.MaxentTagger​ initialized with a

english­left3words­distsim.tagger​ file that comes with the tagger library.

3. Create a method on this class called tagText​ that takes a String as input and returns the

tagged text, another String, as output. Internally the method should use the tagString

method of MaxentTagger to tag the String.

4. Create another method called getText​ that takes a java.net.URL as input and returns a

String containing all the text in the body of a web page excluding HTML tags and JavaScript.

For example, if the page has

5. <html><head><title>Simple Page</title></head><body><script>var a = 1;

var b=2;</script><p>hello</p><p>world</p></body></html>

6. the method should return hello world​. It is okay to use a 3rd party HTML parsing library if

you prefer.

5. Write a static main​ method that allows you to pass in an arbitrary web page URL, uses the

getText​ and tagText​ methods to return a tagged String.
