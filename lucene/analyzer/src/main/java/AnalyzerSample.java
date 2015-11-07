//package jp.mwsoft.sample.kuromoji;

import java.io.IOException;
import java.io.StringReader;

import java.util.Arrays;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;

import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.apache.lucene.analysis.ja.JapaneseAnalyzer;
import org.apache.lucene.analysis.ja.JapaneseTokenizer;

import org.apache.lucene.analysis.ja.tokenattributes.BaseFormAttribute;
import org.apache.lucene.analysis.ja.tokenattributes.PartOfSpeechAttribute;
import org.apache.lucene.analysis.ja.tokenattributes.ReadingAttribute;
import org.apache.lucene.analysis.ja.tokenattributes.InflectionAttribute;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;

import org.apache.lucene.analysis.ja.dict.UserDictionary;
import org.apache.lucene.analysis.ja.util.ToStringUtil;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.util.Version;

public class AnalyzerSample {

    /* main */    
    public static void main(String[] args) {

	Analyzer analyzer = new JapaneseAnalyzer();//Version.LUCENE_4_10_3
	try {
	    String[] stringArray = new String[] {
		"メガネは顔の一部です。",
		"日本経済新聞でモバゲーの記事を読んだ。"
	    };
	    /*
	    String[] stringArray = new String[] {
		"すもももももももものうち。",
		"メガネは顔の一部です。",
		"日本経済新聞でモバゲーの記事を読んだ。",
		"Java, Scala, Groovy, Clojure",
		"ＬＵＣＥＮＥ、ＳＯＬＲ、Lucene, Solr",
		"ｱｲｳｴｵカキクケコさしすせそABCＸＹＺ123４５６",
		"Lucene is a full-featured text search engine library written in Java."
	    };
	    */
	    
	    for (int j = 0; j < stringArray.length; j++) {
		TokenStream tokenStream = analyzer.tokenStream("", new StringReader(stringArray[j]));

		System.out.println("[" 
				   + stringArray[j] 
				   + "]");
		try {
		    get_indexing_word(tokenStream);
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    // you must close tokenStream
		    tokenStream.close();
		}
		
	    }
	} catch (Exception e){
	    e.printStackTrace();
	} finally {
	    analyzer.close();
	}


    }

    /* function  */
    private static void get_indexing_word(TokenStream tokenStream) throws IOException {
	/*
	import org.apache.lucene.analysis.ja.tokenattributes.BaseFormAttribute;
	import org.apache.lucene.analysis.ja.tokenattributes.PartOfSpeechAttribute;
	import org.apache.lucene.analysis.ja.tokenattributes.ReadingAttribute;
	import org.apache.lucene.analysis.ja.tokenattributes.InflectionAttribute;
	import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
	import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
	import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
	import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
	*/

	CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
	PartOfSpeechAttribute partOfSpeechAttribute = tokenStream.addAttribute(PartOfSpeechAttribute.class);
	ReadingAttribute readingAttribute = tokenStream.addAttribute(ReadingAttribute.class);

	//文字列解析を始める前にストリームを必ずリセットする
	tokenStream.reset();
	while (tokenStream.incrementToken()) {
	    String token = charTermAttribute.toString();
	    String pos = partOfSpeechAttribute.getPartOfSpeech();
	    String reading = readingAttribute.getReading();
	    String readingRoma = null;

	    // reading
	    if (reading != null) {
		readingRoma = ToStringUtil.getRomanization(reading);
	    } else if(isHalfWidthAlphanumeric(token)) {
		readingRoma = token;
	    } else {
		readingRoma = ToStringUtil.getRomanization(token);
	    }

	    // result
	    /*
	    System.out.println("Token:" + token 
			       + " ,POS:" + pos 
			       + " ,Reading:" + reading);
	    */
	    System.out.println(token + "," 
			       + pos + ","
			       + reading);
	}
	System.out.println();
	// over romaize
    }

    private static boolean isHalfWidthAlphanumeric(String text) {
	if (text == null || text.length() == 0 || text.length() != text.getBytes().length) {
	    return false;
	}
	return true;
    }
}
