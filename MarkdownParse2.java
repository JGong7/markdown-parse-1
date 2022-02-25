import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse2 {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            //System.out.println(currentIndex);
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            if(nextOpenBracket == -1 || 
                (nextOpenBracket - 1 >= 0 && markdown.charAt(nextOpenBracket - 1) == '!')) {
                break;
            }
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            if(markdown.charAt(nextCloseBracket + 1) != '(') {
                break;
            }
            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", openParen);
            if (nextOpenBracket == -1 || nextCloseBracket == -1 || openParen == -1 || closeParen == -1){ 
                break;
            }
            if(nextOpenBracket > 0 && markdown.charAt(nextOpenBracket - 1) != '!'){
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }
            currentIndex = closeParen + 1;
        }
        //System.out.println(currentIndex);
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}