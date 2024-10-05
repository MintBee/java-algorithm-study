import java.util.*;

public class Adding123 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] memo = new int[100];
        Arrays.fill(memo, -1);
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            System.out.println(calcWaysToSum(memo, num));
        }
    }

    static int calcWaysToSum(int[] memo, int num) {
        if (memo[num] != -1) {
            return memo[num];
        }
        int ans = calcWaysToSum(memo, num-1) + calcWaysToSum(memo, num-2) + calcWaysToSum(memo, num-3);
        memo[num] = ans;
        return ans;
    }
}