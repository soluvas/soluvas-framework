package org.soluvas.social.nlp;

import java.io.IOException;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

import org.soluvas.social.SocialException;

/**
 * @author ceefour
 *
 */
public class NlpUtils {
	
	private static SentenceDetectorME SENTENCE_DETECTOR;
	
	public static synchronized SentenceDetectorME getSentenceDetectorME() {
		if (SENTENCE_DETECTOR == null) {
			SentenceModel sentenceModel;
			try {
				sentenceModel = new SentenceModel(NlpUtils.class.getResource("en-sent.bin"));
			} catch (IOException e) {
				throw new SocialException("Cannot load OpenNLP SentenceModel: " + e, e);
			}
			SENTENCE_DETECTOR = new SentenceDetectorME(sentenceModel);
		}
		return SENTENCE_DETECTOR;
	}
	
}
