package org.jack.anime.utils.tool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class StringTool {
	public static String getRandStr(int length) {
		String strRanDomNum = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			strRanDomNum = strRanDomNum + String.valueOf(random.nextInt(10));
		}
		return strRanDomNum;
	}

	public static String getRandStr(int length, char[] codeSequence) {
		String strRanDomNum = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			strRanDomNum = strRanDomNum
					+ String.valueOf(codeSequence[random
							.nextInt(codeSequence.length)]);
		}
		return strRanDomNum;
	}

	public static String fromatNum(int num, int length) {
		String numStr = String.valueOf(num);
		int numLength = numStr.length();
		if (numStr.length() >= length) {
			return numStr;
		}
		for (int i = 0; i < length - numLength; i++) {
			numStr = "0" + numStr;
		}
		return numStr;
	}

	public static String fromatNum(String num, int length) {
		int numLength = num.length();
		if (num.length() >= length) {
			return num;
		}
		for (int i = 0; i < length - numLength; i++) {
			num = "0" + num;
		}
		return num;
	}

	public static String mergeList(Collection list, String tag) {
		if ((list == null) || (list.size() < 1)) {
			return null;
		}
		String str = "";
		for (Object obj : list) {
			str = str + tag + obj + tag;
		}
		return str;
	}

	public static List<String> split(String str, String tag) {
		if ((str == null) || (tag == null)) {
			return null;
		}
		String[] array = str.split("[" + tag + "]{1,2}");
		List<String> list = new ArrayList<String>();
		String[] arrayOfString1;
		int j = (arrayOfString1 = array).length;
		for (int i = 0; i < j; i++) {
			String item = arrayOfString1[i];
			if (!StringUtils.isEmpty(item)) {
				list.add(item);
			}
		}
		return list;
	}

	public static String addLine(String str, String newLine) {
		if (newLine == null) {
			return str;
		}
		if (str == null) {
			return newLine;
		}
		if (!str.endsWith("\r\n")) {
			str = str + "\r\n";
		}
		str = str + newLine;
		return str;
	}

	public static String clearHtml(String strHtmlStream,
			boolean translatingCharacters) {
		String str = strHtmlStream;
		String regExHtml = "<[^>]+>";

		Pattern phtml = Pattern.compile(regExHtml, 2);
		Matcher mhtml = phtml.matcher(strHtmlStream);
		str = mhtml.replaceAll("");
		if (translatingCharacters) {
			str = str.replace("&acute;", "?");
			str = str.replace("&copy;", "?");
			str = str.replace("&gt;", ">");
			str = str.replace("&micro;", "?");
			str = str.replace("&reg;", "?");
			str = str.replace("&amp;", "&");
			str = str.replace("&deg;", "��");
			str = str.replace("&iexcl;", "?");
			str = str.replace("&nbsp;", "��");
			str = str.replace("&raquo;", "?");
			str = str.replace("&brvbar;", "?");
			str = str.replace("&divide;", "��");
			str = str.replace("&iquest;", "?");
			str = str.replace("&not;", "?");
			str = str.replace("&sect;", "��");
			str = str.replace("&bull;", "?");
			str = str.replace("&frac12;", "?");
			str = str.replace("&laquo;", "?");
			str = str.replace("&para;", "?");
			str = str.replace("&uml;", "��");
			str = str.replace("&cedil;", "?");
			str = str.replace("&frac14;", "?");
			str = str.replace("&lt;", "<");
			str = str.replace("&plusmn;", "��");
			str = str.replace("&times;", "��");
			str = str.replace("&cent;", "?");
			str = str.replace("&frac34;", "?");
			str = str.replace("&macr;", "?");
			str = str.replace("&quot;", "\"");
			str = str.replace("&trade;", "?");
			str = str.replace("&euro;", "��");
			str = str.replace("&pound;", "?");
			str = str.replace("&yen;", "?");
			str = str.replace("&bdquo;", "?");
			str = str.replace("&hellip;", "��");
			str = str.replace("&middot;", "��");
			str = str.replace("&rsaquo;", "?");
			str = str.replace("&ordf;", "?");
			str = str.replace("&circ;", "?");
			str = str.replace("&ldquo;", "��");
			str = str.replace("&mdash;", "��");
			str = str.replace("&rsquo;", "��");
			str = str.replace("&ordm;", "?");
			str = str.replace("&dagger;", "?");
			str = str.replace("&lsaquo;", "?");
			str = str.replace("&ndash;", "�C");
			str = str.replace("&sbquo;", "?");
			str = str.replace("&rdquo;", "��");
			str = str.replace("&Dagger;", "?");
			str = str.replace("&lsquo;", "��");
			str = str.replace("&permil;", "��");
			str = str.replace("&shy;", "?");
			str = str.replace("&tilde;", "?");
			str = str.replace("&asymp;", "��");
			str = str.replace("&frasl;", "?");
			str = str.replace("&larr;", "��");
			str = str.replace("&part;", "?");
			str = str.replace("&spades;", "?");
			str = str.replace("&cap;", "��");
			str = str.replace("&ge;", "��");
			str = str.replace("&le;", "��");
			str = str.replace("&Prime;", "��");
			str = str.replace("&sum;", "��");
			str = str.replace("&clubs;", "?");
			str = str.replace("&harr;", "?");
			str = str.replace("&loz;", "?");
			str = str.replace("&prime;", "��");
			str = str.replace("&uarr;", "��");
			str = str.replace("&darr;", "��");
			str = str.replace("&hearts;", "?");
			str = str.replace("&minus;", "?");
			str = str.replace("&prod;", "��");
			str = str.replace("&diams;", "?");
			str = str.replace("&infin;", "��");
			str = str.replace("&ne;", "��");
			str = str.replace("&radic;", "��");
			str = str.replace("&equiv;", "��");
			str = str.replace("&int;", "��");
			str = str.replace("&oline;", "?");
			str = str.replace("&rarr;", "��");
			str = str.replace("&alpha;", "��");
			str = str.replace("&eta;", "��");
			str = str.replace("&mu;", "��");
			str = str.replace("&pi;", "��");
			str = str.replace("&theta;", "��");
			str = str.replace("&beta;", "��");
			str = str.replace("&gamma;", "��");
			str = str.replace("&nu;", "��");
			str = str.replace("&psi;", "��");
			str = str.replace("&upsilon;", "��");
			str = str.replace("&chi;", "��");
			str = str.replace("&iota;", "��");
			str = str.replace("&omega;", "��");
			str = str.replace("&rho;", "��");
			str = str.replace("&xi;", "��");
			str = str.replace("&delta;", "��");
			str = str.replace("&kappa;", "��");
			str = str.replace("&omicron;", "��");
			str = str.replace("&sigma;", "��");
			str = str.replace("&zeta;", "��");
			str = str.replace("&epsilon;", "��");
			str = str.replace("&lambda;", "��");
			str = str.replace("&phi;", "��");
			str = str.replace("&tau;", "��");
		}
		return str;
	}

	public static String cleanXss(String value) {
		if (StringUtils.isEmpty(value)) {
			return value;
		}
		value = value.toLowerCase().replaceAll("[<]", "").replaceAll("[>]", "");
		value = value.toLowerCase().replaceAll("[(]", "").replaceAll("[)]", "");
		value = value.toLowerCase().replaceAll("'", "");
		value = value.toLowerCase().replaceAll(";", "");
		value = value.toLowerCase().replaceAll("/", "");
		value = value.toLowerCase().replaceAll("-", "");
		value = value.toLowerCase().replaceAll("script", "");
		value = value.toLowerCase().replaceAll("frame", "");
		return value;
	}

	public static void main(String[] args) {
		System.out.println(cleanXss("sold';alert(42873);'"));

		List<Long> list = new ArrayList<Long>();
		list.add(Long.valueOf("111"));
		list.add(Long.valueOf("222"));
		list.add(Long.valueOf("333"));
		list.add(Long.valueOf("444"));

		System.out.println(mergeList(list, "|"));
		System.out.println(split(mergeList(list, "|"), "|").size());
		System.out.println(addLine("", "hello"));
	}
}
