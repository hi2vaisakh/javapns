/**
 * 
 */
package my.exp.app;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vaisakh_Ps
 *
 */
public class Cat {

	private int catA = 0;
	private int catB = 0;
	private Integer finalCount = 0;

	public String calculateCombinations(String[] catAStrings,
			String[] catBStrings) {
		this.catA = catAStrings.length;
		this.catB = catBStrings.length;
		if (1 > catA || catA > 100000)
			return "Not a valid cat A String";
		if (1 > catB || catB > 100000)
			return "Not a valid cat B String";
		for (int i = 0; i < catA; i++) {
			String s = catAStrings[i];
			combinationOfLength(s, catBStrings);
		}
		return finalCount.toString();
	}

	private void combinationOfLength(String s, String[] catBStrings) {

		List<String> strToCompare1 = new ArrayList<String>();
		StringBuilder stBuildr = new StringBuilder();
		calculateCombination(s, strToCompare1, 0, stBuildr);
		String letter = "";
		if (strToCompare1.size() > 0) {
			for (int i = 0; i < strToCompare1.size(); i++) {
				letter = strToCompare1.get(i);
				for (int j = 0; j < catBStrings.length; j++) {
					if (letter.length() == 1) {
						for (int m = 0; m < catBStrings[j].length(); m++) {
							String ele = String.valueOf(catBStrings[j]
									.charAt(m));
							if (letter.equals(ele)) {
								finalCount++;
							}
						}
					} else {
						if (catBStrings[j].contains(letter)) {
							finalCount++;
						}
					}
				}
			}
		}
	}

	private void calculateCombination(String s, List<String> strToCompare1,
			int start, StringBuilder stBuildr) {
		for (int i = start; i < s.length(); ++i) {
			stBuildr.append(s.charAt(i));
			strToCompare1.add(stBuildr.toString());
			if (i < s.length())
				calculateCombination(s, strToCompare1, i + 1, stBuildr);
			stBuildr.setLength(stBuildr.length() - 1);
		}
	}
}
