/*

https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/

Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.

Constraints:
1. 1 <= nums.length <= 2 * 105
2. 0 <= nums[i] <= 231 - 1

Input: nums = [3,10,5,25,2,8]
Output: 28
    Explanation: The maximum result is 5 XOR 25 = 28.

Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
Output: 127

*/

import java.util.Arrays;

class BitNode {
    BitNode[] links;
    boolean flag;

    BitNode() {
        links = new BitNode[2];
        Arrays.fill(links, null);
    }

    void putKey(int bit, BitNode node) {
        links[bit] = node;
    }

    boolean containsKey(int bit) {
        return links[bit] != null;
    }

    void setEnd() {
        flag = true;
    }

    BitNode nextNode(int bit) {
        return links[bit];
    }
}

class BitTrie {
    BitNode root;

    BitTrie() {
        root = new BitNode();
    }

    void insert(int n) {
        BitNode temp = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (n >> i) & 1;

            if (!temp.containsKey(bit)) {
                temp.putKey(bit, new BitNode());
            }

            temp = temp.nextNode(bit);
        }

        temp.setEnd();
    }

    int search(int n) {
        BitNode temp = root;
        int ans = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = (n >> i) & 1;

            if (temp.containsKey(1 - bit)) {
                ans = ans ^ (1 << i);
                temp = temp.nextNode(1 - bit);
            } else {
                temp = temp.nextNode(bit);
            }
        }

        return ans;
    }
}

public class MaximumXORofTwoNumbersinanArray {
    public static void main(String[] args) {
        MaximumXORofTwoNumbersinanArray lc = new MaximumXORofTwoNumbersinanArray();

        System.out.println(lc.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
        System.out.println(lc.findMaximumXOR(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70}));
    }

    /*
        Explanation:
            We know if a^b = c then a^c = b . We can use this approach to find efficient solution .

            Suppose we know 2 numbers A and B, so our question reduces to find max number C such that A ^ B = C
            Consider binary representation of both numbers ( suppose A = 0100111 and some B as 0100010 and we have to find C)
            let C = XXXXXXX and X can be 0/1
            and using the property a^c = b
                                                        A   0 1 0 0 1 1 1
                                                        C   X X X X X X X
            Now for maximising C let see each bit from MSB , since A's bit is 0, so max C can be 1XXXXXX , now this is possible only if B has 1 at that respective bit , since B has 0 at that bit so C cannot have 0 at that bit so C so far is 0XXXXXX
            Now see second MSB , A's bit is 1 and C was 0XXXXXX, so for max C we can have 01XXXXX, now this is possible only if B has 1 at that respective bit, and B has 1 at bit so C can have 1 at bit so C became 01XXXXX.
            We keep on repeating this and we can find max C .
    */
    public int findMaximumXOR(int[] nums) {
        BitTrie root = new BitTrie();

        for (int i : nums) {
            root.insert(i);
        }

        int ans = 0;
        for (int i : nums) {
            ans = Math.max(ans, root.search(i));
        }

        return ans;
    }
}
