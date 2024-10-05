import java.util.*;

public class PartialSum4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] nums = Arrays.stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        int[] prefixSum = new int[nums.length+1];
        prefixSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }

        for (int run = 0; run < m; run++) {
            int i = sc.nextInt()-1, j = sc.nextInt();
            System.out.println(prefixSum[j]-prefixSum[i]);
        }
    }
}
