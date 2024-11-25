/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent", "listen")); // true
		System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie", "Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));

		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");

		// Performs a stress test of randomAnagram
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass)
				break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = removeSpace(preProcess(str1));
		str2 = removeSpace(preProcess(str2));
		int l1 = str1.length();
		int l2 = str2.length();

		for (int i = 0; i < l1; i++) {
			char ch1 = (char) str1.charAt(i);
			for (int j = 0; j < l2; j++) {
				char ch2 = (char) str2.charAt(j);
				if (ch1 == ch2) {

					str2 = str2.substring(0, j) + str2.substring(j + 1, l2);
					break;
				}
			}
			l2 = str2.length();
		}
		if (str2.length() == 0)
			return true;
		return false;
	}

	// Returns a preprocessed version of the given string: all the letter characters
	// are converted
	// to lower-case, and all the other characters are deleted, except for spaces,
	// which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String ans = "";
		int l = str.length();
		for (int i = 0; i < l; i++) {
			if ((char) str.charAt(i) > 64 && (char) str.charAt(i) < 91) {
				ans = ans + (char) (str.charAt(i) + 32);
			}
			if ((char) str.charAt(i) >= 97 && (char) str.charAt(i) <= 122) {
				ans = ans + (char) (str.charAt(i));
			}
			if ((char) str.charAt(i) == 32) {
				ans = ans + (char) (str.charAt(i));
			}
		}
		return ans;
	}

	public static String removeSpace(String str) {
		String ans = "";
		int l = str.length();
		for (int i = 0; i < l; i++) {

			if ((char) str.charAt(i) != 32) {
				ans = ans + (char) (str.charAt(i));
			}
		}
		return ans;
	}

	// Returns a random anagram of the given string. The random anagram consists of
	// the same
	// characters as the given string, re-arranged in a random order.
	public static String randomAnagram(String str) {
		String newStr = "";
		int l = str.length();
		for(int i = 0; i < l; i++ ){
			int newL = str.length();
			int addChar = 0;
			addChar = (int) (Math.random() * newL);
			newStr = newStr + str.charAt(addChar);
			str = str.substring(0, addChar) + str.substring(addChar + 1, newL);
		}
		return newStr;
	}
}
