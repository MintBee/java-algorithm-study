import java.util.*;

public class Atm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] pArr = Arrays.stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();
        Arrays.sort(pArr);
        
        int[] prefixSum = new int[pArr.length];
        prefixSum[0] = pArr[0];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i-1] + pArr[i];
        }

        long minWaiting = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            minWaiting += prefixSum[i];
        }
        System.out.println(minWaiting);
    }
}
