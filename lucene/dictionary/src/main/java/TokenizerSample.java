//package jp.mwsoft.sample.kuromoji;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.TokenStream;;

import org.apache.lucene.analysis.ja.JapaneseTokenizer;
import org.apache.lucene.analysis.ja.JapaneseTokenizer.Mode;

import org.apache.lucene.analysis.ja.tokenattributes.BaseFormAttribute;
import org.apache.lucene.analysis.ja.tokenattributes.PartOfSpeechAttribute;
import org.apache.lucene.analysis.ja.tokenattributes.ReadingAttribute;
import org.apache.lucene.analysis.ja.tokenattributes.InflectionAttribute;

import org.apache.lucene.analysis.ja.JapaneseBaseFormFilter;
import org.apache.lucene.analysis.ja.JapaneseKatakanaStemFilter;
import org.apache.lucene.analysis.ja.JapanesePartOfSpeechStopFilter;

import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;

import org.apache.lucene.analysis.ja.dict.UserDictionary;
import org.apache.lucene.analysis.ja.util.ToStringUtil;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.util.Version;

public class TokenizerSample {

    /* main */    
    public static void main(String[] args) {


	String[] stringArray = new String[] {
	    "メガネは顔の一部です。",
	    "日本経済新聞でモバゲーの記事を読んだ。",
	    "このComputerは、10回に1回の割合で起動中に青い画面が表示されます。"
	};
	    
	for (int j = 0; j < stringArray.length; j++) {
	    
	    System.out.println("[" 
			       + stringArray[j] 
			       + "]");

	    // normal
	    TokenStream stream = new JapaneseTokenizer(new StringReader(stringArray[j]),
						       null,
						       false,
						       Mode.NORMAL);
	    try {
		CharTermAttribute charTermAttribute = stream.addAttribute(CharTermAttribute.class);
		PartOfSpeechAttribute partOfSpeechAttribute = stream.addAttribute(PartOfSpeechAttribute.class);
		ReadingAttribute readingAttribute = stream.addAttribute(ReadingAttribute.class);
		
		System.out.println("--------- Normal Node ---------");
		stream.reset();
		while (stream.incrementToken()) {
		    String term = charTermAttribute.toString();
		    String pos = partOfSpeechAttribute.getPartOfSpeech();
		    String reading = readingAttribute.getReading();
		    
		    System.out.println(term + "\t"
				       + pos + "\t"
				       + reading);
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }

	    // extended
	    TokenStream extended = new JapaneseTokenizer(new StringReader(stringArray[j]),
							 null,
							 false,
							 Mode.EXTENDED);
	    try {
		CharTermAttribute charTermAttribute = extended.addAttribute(CharTermAttribute.class);
		PartOfSpeechAttribute partOfSpeechAttribute = extended.addAttribute(PartOfSpeechAttribute.class);
		ReadingAttribute readingAttribute = extended.addAttribute(ReadingAttribute.class);
		
		System.out.println("--------- Extended Node ---------");
		extended.reset();
		while (extended.incrementToken()) {
		    String term = charTermAttribute.toString();
		    String pos = partOfSpeechAttribute.getPartOfSpeech();
		    String reading = readingAttribute.getReading();
		    
		    System.out.println(term + "\t"
				       + pos + "\t"
				       + reading);
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }

	    // search
	    
	    TokenStream search = new JapaneseTokenizer(new StringReader(stringArray[j]),
							 null,
							 false,
							 Mode.SEARCH);
	    try {
		CharTermAttribute charTermAttribute = search.addAttribute(CharTermAttribute.class);
		PartOfSpeechAttribute partOfSpeechAttribute = search.addAttribute(PartOfSpeechAttribute.class);
		ReadingAttribute readingAttribute = search.addAttribute(ReadingAttribute.class);
		
		System.out.println("--------- Search Node ---------");
		search.reset();
		while (search.incrementToken()) {
		    String term = charTermAttribute.toString();
		    String pos = partOfSpeechAttribute.getPartOfSpeech();
		    String reading = readingAttribute.getReading();
		    
		    System.out.println(term + "\t"
				       + pos + "\t"
				       + reading);
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	
    }


}
