import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;

import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;


public class TokenizerExample {

    public static void main(String[] args) {
	Tokenizer tokenizer = Tokenizer.builder().build();
	for (Token token: tokenizer.tokenize("本日は晴天なり。")) {
	    System.out.println(token.getSurfaceForm() + "\t" + token.getAllFeatures());
	}
    }

}