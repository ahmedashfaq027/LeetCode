public class BeautifulArrangement {
    public static void main(String[] args) {
        BeautifulArrangement lc = new BeautifulArrangement();

        System.out.println(lc.countArrangement(2));
        System.out.println(lc.countArrangement(1));
        System.out.println(lc.countArrangement(4));
    }

    public int countArrangement(int n) {
        int[] count = new int[1];
        dfs(n, 1, new boolean[n], count);
        return count[0];
    }

    private void dfs(int n, int currNum, boolean[] visited, int[] count) {
        if (currNum == n) {
            count[0]++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i - 1])
                continue;

            currNum += 1;
            if ((i % currNum == 0) || (currNum % i == 0)) {
                visited[i - 1] = true;
                dfs(n, currNum, visited, count);
                visited[i - 1] = false;
            }
            currNum -= 1;
        }
    }
}
