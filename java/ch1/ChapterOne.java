package ch1;

import java.util.*;
import java.lang.Character;

public class ChapterOne {
	/*
	Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
	cannot use additional data structures?
	*/
	public static boolean isUniqueChars(String str) {
		HashMap<Character, Boolean> dict = new HashMap<Character, Boolean>();
		for (int i=0; i<str.length(); i++) {
			Character c = new Character(str.charAt(i));
			if (dict.get(c) != null) {
				return false;
			} else {
				dict.put(c, true);
			}
		}
		return true;
	}

	public static void testIsUniqueChars() {
		if (isUniqueChars("abcde") == true) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		if (isUniqueChars("hello") == false) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		if (isUniqueChars("apple") == false) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		if (isUniqueChars("kite") == true) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
	}

	/*
	Check Permutation: Given two strings, write a method to decide if one is a permutation of the
	other.
	*/
	public static boolean checkPermutation(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		int string_len = s1.length();
		ArrayList al = new ArrayList<Character>(string_len);
		for (int i=0; i<string_len;i++) {
			al.add(null);
		}
		boolean char_placed;
		Character current_char;
		Character looking_char;
		for (int i = 0; i<string_len; i++) {
			char_placed = false;
			current_char = new Character(s1.charAt(i));
			for (int j=0; j<string_len; j++) {
				looking_char = new Character(s2.charAt(j));
				if (current_char.equals(looking_char)) {
					if (al.get(i) == null && !char_placed) {
						al.add(i, current_char);
						char_placed = true;
					}
				}
			}
			if (!char_placed) {
				return false;
			}
		}
		return true;
	}

	public static void testCheckPermutation() {
		if (checkPermutation("apple", "papel") == true) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		if (checkPermutation("carrot", "tarroc") == true) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		if (checkPermutation("hello", "llloh") == false) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
	}

	/*
	URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
	has sufficient space at the end to hold the additional characters, and that you are given the "true"
	length of the string. (Note: If implementing in Java, please use a character array so that you can
	perform this operation in place.)
	EXAMPLE
	Input: "Mr 3ohn Smith"
	Output: "Mr%203ohn%20Smith"
	*/


	public static void main(String[] args) {
		testIsUniqueChars();
		testCheckPermutation();
	}

}
