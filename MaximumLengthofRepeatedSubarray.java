import java.math.BigInteger;
import java.util.*;

public class MaximumLengthofRepeatedSubarray {
    final int P = 113, MOD = 1_000_000_007;
    final int Pinv = BigInteger.valueOf(P).modInverse(BigInteger.valueOf(MOD)).intValue();

    public static void main(String[] args) {
        MaximumLengthofRepeatedSubarray lc = new MaximumLengthofRepeatedSubarray();

        System.out.println(lc.findLengthOptimised(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }

    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;

        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                    if (ans < dp[i][j])
                        ans = dp[i][j];
                }
            }
        }

        return ans;
    }

    public int findLengthOptimised(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int lo = 0, hi = Math.min(n, m) + 1;

        int ans = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (check(mid, nums1, nums2)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int guess, int[] a, int[] b) {
        Map<Integer, List<Integer>> hash = new HashMap<>();

        int k = 0;
        for (int x : rollingHash(a, guess)) {
            hash.computeIfAbsent(x, e -> new ArrayList<>()).add(k++);
        }

        int j = 0;
        for (int x : rollingHash(b, guess)) {
            for (int y : hash.getOrDefault(x, new ArrayList<>())) {
                if (Arrays.equals(Arrays.copyOfRange(a, y, y + guess), Arrays.copyOfRange(b, j, j + guess))) {
                    return true;
                }
            }
            j++;
        }

        return false;
    }

    private int[] rollingHash(int[] ar, int length) {
        int[] ans = new int[ar.length - length + 1];

        long h = 0, power = 1;
        if (length == 0)
            return ans;

        for (int i = 0; i < ar.length; i++) {
            h = (h + ar[i] * power) % MOD;

            if (i < length - 1) {
                power = (power * P) % MOD;
            } else {
                ans[i - (length - 1)] = (int) h;
                h = (h - ar[i - (length - 1)]) * Pinv % MOD;
                if (h < 0)
                    h += MOD;
            }
        }

        return ans;
    }
}
