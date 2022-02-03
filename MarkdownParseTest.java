import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;

import org.junit.*;

public class MarkdownParseTest {
    @Test //indicating the following method is a tester
    public void addition() {
        assertEquals(2, 1 + 1);
    } //test

    @Test //call getLink() on test-file.md
    public void test1() throws IOException{
        Path fileName = Path.of("/test-file.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("https://something.com", "some-page.html"),
             links);
    }

    @Test //call getLink() on test2.md
    public void test2() throws IOException{
        Path fileName = Path.of("/test2.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("link.com"),
             links);
    }

    @Test //call getLink() on test3.md
    public void test3() throws IOException{
        Path fileName = Path.of("/test3.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of(),
             links);
    }

    @Test //call getLink() on test4.md
    public void test4() throws IOException{
        Path fileName = Path.of("/test4.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of(),
             links);
    }
}