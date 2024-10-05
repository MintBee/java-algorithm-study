import java.util.*;

public class RgbDistance {
    static final int RED = 0;
    static final int GREEN = 1;
    static final int BLUE = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] minColorCost = new int[1000][3];

        int n = Integer.parseInt(sc.nextLine());

        int[] firstColorCosts = readInts(sc);
        minColorCost[0][RED] = firstColorCosts[RED];
        minColorCost[0][GREEN] = firstColorCosts[GREEN];
        minColorCost[0][BLUE] = firstColorCosts[BLUE];

        for (int i = 1; i < n; i++) {
            int[] colorCosts = readInts(sc);
            minColorCost[i][RED] = Math.min(minColorCost[i-1][BLUE] + colorCosts[RED], minColorCost[i-1][GREEN] + colorCosts[RED]);
            minColorCost[i][GREEN] = Math.min(minColorCost[i-1][BLUE] + colorCosts[GREEN], minColorCost[i-1][RED] + colorCosts[GREEN]);
            minColorCost[i][BLUE] = Math.min(minColorCost[i-1][RED] + colorCosts[BLUE], minColorCost[i-1][GREEN] + colorCosts[BLUE]);
        }

        int minCost = Arrays.stream(minColorCost[n-1]).min().getAsInt();
        System.out.println(minCost);
    }

    static int[] readInts(Scanner sc) {
        return Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}