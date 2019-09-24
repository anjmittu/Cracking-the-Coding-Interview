import unittest

"""
Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
cannot use additional data structures?
"""
def isUnique(string: str) -> bool:
    unique_chars = set()
    for s in string:
        unique_chars.add(s)

    return len(string) == len(unique_chars)

"""
Check Permutation: Given two strings, write a method to decide if one is a permutation of the
other.
"""
def checkPermutation(string1: str, string2: str) -> bool:
    return sorted(string1) == sorted(string2)

"""
URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: If implementing in Java, please use a character array so that you can
perform this operation in place.)
EXAMPLE
Input: "Mr 3ohn Smith"
Output: "Mr%203ohn%20Smith"
"""


class Test(unittest.TestCase):
    def test_unique(self):
        dataT = [('abcd'), ('s4fad'), ('')]
        dataF = [('23ds2'), ('hb 627jh=j ()')]
        # true check
        for test_string in dataT:
            actual = isUnique(test_string)
            self.assertTrue(actual)
        # false check
        for test_string in dataF:
            actual = isUnique(test_string)
            self.assertFalse(actual)

    def test_cp(self):
        dataT = (
            ('abcd', 'bacd'),
            ('3563476', '7334566'),
            ('wef34f', 'wffe34'),
        )
        dataF = (
            ('abcd', 'd2cba'),
            ('2354', '1234'),
            ('dcw4f', 'dcw5f'),
        )
        # true check
        for test_strings in dataT:
            result = checkPermutation(*test_strings)
            self.assertTrue(result)
        # false check
        for test_strings in dataF:
            result = checkPermutation(*test_strings)
            self.assertFalse(result)

if __name__ == "__main__":
    unittest.main()
