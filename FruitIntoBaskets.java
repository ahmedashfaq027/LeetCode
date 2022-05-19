/*

https://leetcode.com/problems/fruit-into-baskets/

You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
1. You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
2. Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
3. Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
4. Given the integer array fruits, return the maximum number of fruits you can pick.

Constraints:
1. 1 <= fruits.length <= 105
2. 0 <= fruits[i] < fruits.length

Input: fruits = [1,2,1]
Output: 3
    Explanation: We can pick from all 3 trees.

Input: fruits = [0,1,2,2]
Output: 3
    Explanation: We can pick from trees [1,2,2].
    If we had started at the first tree, we would only pick from trees [0,1].

Input: fruits = [1,2,3,2,2]
Output: 4
    Explanation: We can pick from trees [2,3,2,2].
    If we had started at the first tree, we would only pick from trees [1,2].

*/

import java.util.HashMap;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        FruitIntoBaskets lc = new FruitIntoBaskets();

        System.out.println(lc.totalFruit(new int[]{1, 2, 1}));
        System.out.println(lc.totalFruit(new int[]{0, 1, 2, 2}));
        System.out.println(lc.totalFruit(new int[]{1, 2, 3, 2, 2}));
    }

    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        HashMap<Integer, Integer> fruitMap = new HashMap<>();

        int ptr = 0, currBasket = 0;
        int result = 1;

        for (int fruit : fruits) {
            currBasket++;
            fruitMap.put(fruit, fruitMap.getOrDefault(fruit, 0) + 1);

            // If we have more than 2 distinct fruits, remove from basket (Slide the window)
            while (fruitMap.size() > 2) {
                currBasket--;

                int tmp = fruitMap.getOrDefault(fruits[ptr], 0) - 1;
                if (tmp <= 0) {
                    fruitMap.remove(fruits[ptr]);
                } else {
                    fruitMap.put(fruits[ptr], tmp);
                }

                ptr++;
            }

            result = Math.max(result, currBasket);
        }

        return result;
    }
}
