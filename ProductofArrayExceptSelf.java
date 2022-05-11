import java.util.Arrays;

public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
        ProductofArrayExceptSelf lc = new ProductofArrayExceptSelf();

        System.out.println(Arrays.toString(lc.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(lc.productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        res[0] = 1;
        res[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int rightPro = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            res[i] = res[i] * rightPro;
            rightPro *= nums[i];
        }

        return res;
    }

    public int[] productExceptSelfDiv(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        int product = 1, zeros = 0;
        for (int num : nums) {
            if (num == 0) {
                zeros++;
                continue;
            }

            product *= num;
        }

        if (zeros > 1)
            return res;

        for (int i = 0; i < n; i++) {
            if (zeros == 0)
                res[i] = (int) (product / nums[i]);
            else if (nums[i] == 0) {
                res[i] = product;
                break;
            }
        }

        return res;
    }
}
