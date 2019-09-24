package ch1;

public class ChapterOne {
	/*
	Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
	cannot use additional data structures?
	*/
	public static boolean isUniqueChars(String str) {

	}

	public static boolean testIsUniqueChars() {
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			System.out.println(word + ": " + isUniqueChars(word));
		}
	}

	public static void main(String[] args) {
		testIsUniqueChars()
	}

}
