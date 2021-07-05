/*

https://leetcode.com/problems/implement-strstr/

Implement strStr().
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:
What should we return when needle is an empty string? This is a great question to ask during an interview.
For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

Constraints:
1. 0 <= haystack.length, needle.length <= 5 * 104
2. haystack and needle consist of only lower-case English characters.

Input: haystack = "hello", needle = "ll"
Output: 2

Input: haystack = "aaaaa", needle = "bba"
Output: -1

Input: haystack = "", needle = ""
Output: 0

*/

public class ImplementStrStr {
    public static void main(String[] args) {
        ImplementStrStr lc = new ImplementStrStr();

        System.out.println(lc.strStr("hello", "ll"));
        System.out.println(lc.strStr("aaaaa", "bba"));
        System.out.println(lc.strStr("a", "a"));
    }

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty())
            return 0;
        int n = haystack.length(), m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            String tmp = haystack.substring(i, i + m);
            if (needle.equals(tmp))
                return i;
        }

        return -1;
    }
}
