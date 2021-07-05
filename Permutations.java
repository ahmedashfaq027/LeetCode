import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Permutations lc = new Permutations();

        List<List<Integer>> res = lc.permute(new int[]{1, 2, 3});
        for (List<Integer> i : res) {
            System.out.println(Arrays.toString(i.toArray()));
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }

    public void permute(int[] nums, boolean[] used, List<Integer> currPerm, List<List<Integer>> result) {
        int n = nums.length;
        if (currPerm.size() == n) {
            result.add(new ArrayList<>(currPerm));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i])
                continue;

            used[i] = true;
            currPerm.add(nums[i]);
            permute(nums, used, currPerm, result);
            used[i] = false;
            currPerm.remove(currPerm.size() - 1);
        }
    }
}
