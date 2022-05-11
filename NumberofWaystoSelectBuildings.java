/*

https://leetcode.com/problems/number-of-ways-to-select-buildings/

You are given a 0-indexed binary string s which represents the types of buildings along a street where:
1. s[i] = '0' denotes that the ith building is an office and
2. s[i] = '1' denotes that the ith building is a restaurant.

As a city official, you would like to select 3 buildings for random inspection. However, to ensure variety, no two consecutive buildings out of the selected buildings can be of the same type.
For example, given s = "001101", we cannot select the 1st, 3rd, and 5th buildings as that would form "011" which is not allowed due to having two consecutive buildings of the same type.
Return the number of valid ways to select 3 buildings.

Constraints:
1. 3 <= s.length <= 105
2. s[i] is either '0' or '1'.

Input: s = "001101"
Output: 6
    Explanation:
    The following sets of indices selected are valid:
    - [0,2,4] from "001101" forms "010"
    - [0,3,4] from "001101" forms "010"
    - [1,2,4] from "001101" forms "010"
    - [1,3,4] from "001101" forms "010"
    - [2,4,5] from "001101" forms "101"
    - [3,4,5] from "001101" forms "101"
    No other selection is valid. Thus, there are 6 total ways.

Input: s = "11100"
Output: 0
    Explanation: It can be shown that there are no valid selections.

*/

public class NumberofWaystoSelectBuildings {
    public static void main(String[] args) {
        NumberofWaystoSelectBuildings lc = new NumberofWaystoSelectBuildings();

        System.out.println(lc.numberOfWays("001101"));
        System.out.println(lc.numberOfWays("11100"));
    }

    /*
        Explanation:
            For an index i, If the character at the ith index is 1 then we will try to find number of '01' on the right side of that index,
            and If the character at the inde i is '0', then we will find number of '10' on the right side of that index.
            In order to find '10' we can find number of zeroes on the right of that index,
            similarly it can be done to find '01' as well.
     */
    public long numberOfWays(String s) {
        int n = s.length();

        long ways = 0;
        int one = 0, zero = 0;
        long onesAfterZero = 0, zerosAfterOne = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zero++;
                zerosAfterOne += one;
                ways += onesAfterZero;
            } else {
                one++;
                onesAfterZero += zero;
                ways += zerosAfterOne;
            }
        }

        return ways;
    }
}
