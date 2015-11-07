//package jp.mwsoft.sample.kuromoji;

import java.io.IOException;

import java.util.Arrays;
import java.util.List;

import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;

public class SimpleTokenizerSample {
    
    public static void main(String[] args) {
	
	/*
	Tokenizer tokenizer = Tokenizer.builder().build();
	List<Token> tokens = tokenizer.tokenize("僕の夢は、不労収入を得て一生遊んで暮らすことです。");
	for (Token token : tokens) {
	    System.out.println("==================================================");
	    System.out.println("allFeatures : " + token.getAllFeatures());
	    System.out.println("partOfSpeech : " + token.getPartOfSpeech());
	    System.out.println("position : " + token.getPosition());
	    System.out.println("reading : " + token.getReading());
	    System.out.println("surfaceFrom : " + token.getSurfaceForm());
	    System.out.println("allFeaturesArray : " + Arrays.asList(token.getAllFeaturesArray()));
	    System.out.println("辞書にある言葉? : " + token.isKnown());
	    System.out.println("未知語? : " + token.isUnknown());
	    System.out.println("ユーザ定義? : " + token.isUser());
	    System.out.println(token.getSurfaceForm() + "\t" + token.getAllFeatures());
	}
	*/

	Tokenizer tokenizer = Tokenizer.builder().build();
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
	    System.out.println("=======================");
	    System.out.println(stringArray[j]);
	    List<Token> tokens = tokenizer.tokenize(stringArray[j]);
	    for (Token token : tokens) {
		System.out.println(token.getSurfaceForm() + "\t" + token.getAllFeatures());
		/*
		String surface = token.getSurfaceForm();
		String[] fetures = token.getAllFeatures().split(",", 0);		
		String tmp_str = String.join("|", fetures);
		System.out.println(tmp_str);
		*/
	    }
	}
	
    }
    
}
