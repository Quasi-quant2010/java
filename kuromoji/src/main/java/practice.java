//package jp.mwsoft.sample.kuromoji;

import java.io.IOException;

import java.util.Arrays;
import java.util.List;

import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;
import org.atilika.kuromoji.Tokenizer.Builder;
import org.atilika.kuromoji.Tokenizer.Mode;
import 

public class practice {

    /* main */    
    public static void main(String[] args) {

	String[] stringArray = new String[] {
	    "すもももももももものうち。",
	    "メガネは顔の一部です。",
	    "日本経済新聞でモバゲーの記事を読んだ。",
	    "Java, Scala, Groovy, Clojure",
	    "ＬＵＣＥＮＥ、ＳＯＬＲ、Lucene, Solr",
	    "ｱｲｳｴｵカキクケコさしすせそABCＸＹＺ123４５６",
	    "Lucene is a full-featured text search engine library written in Java."
	};
	
	for (int j = 0; j < stringArray.length; j++) {

	    System.out.println("====================");

	    // init instance
	    Builder builder = Tokenizer.builder();	    

	    Tokenizer normal = builder.build();// ノーマルモード
	    List<Token> tokenNormal = normal.tokenize(stringArray[j]);
	    disp(tokenNormal);

	    builder.mode(Mode.SEARCH);
	    Tokenizer search = builder.build();//サーチーモード
	    List<Token> tokenSearch = search.tokenize(stringArray[j]);
	    disp(tokenSearch);

	    builder.mode(Mode.EXTENDED);
	    Tokenizer extended = builder.build();// extendsモード
	    List<Token> tokenExtended = extended.tokenize(stringArray[j]);
	    disp(tokenExtended);
	}

    }

    /* function */
    private static void disp(List<Token> tokens) {
	for (Token token : tokens) {
	    System.out.println(token.getSurfaceForm() + "\t" + token.getAllFeatures());
	}
	System.out.println();
    }
    
}
