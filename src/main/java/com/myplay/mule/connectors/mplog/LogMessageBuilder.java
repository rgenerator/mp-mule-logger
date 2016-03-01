package com.myplay.mule.connectors.mplog;

import java.util.ArrayList;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.StringEscapeUtils;

public class LogMessageBuilder {
	
	ArrayList<String> entries = new ArrayList<String>();
	
	public void addPair(String key, String value) {
		entries.add(joinPair(key, value));
	}
	
	public void addText(String text) {
		entries.add(text);
	}
	
	public String build() {
		return StringUtils.join(entries, " ");
	}

	private String joinPair(String key, String value) {
		return key + "=\"" + escape(value) + "\"";
	}

	private String escape(String str) {
		return StringEscapeUtils.escapeJava(str == null ? null : str);
	}
}
