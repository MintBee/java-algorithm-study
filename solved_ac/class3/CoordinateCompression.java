import java.util.*;
import java.util.stream.*;

public class CoordinateCompression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] nums = Arrays.stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();
        Enumeration[] enums = new Enumeration[n];
        for (int i = 0; i < n; i++) {
            enums[i] = new Enumeration(nums[i], i);
        }
        Arrays.sort(enums);
        
        int[] ans = new int[n];

        int duplicateIdx = 0;
        int compressed = 0;
        int duplicateCompressed = 0;
        for (int i = 0; i < n; i++) {
            Enumeration enumeration = enums[i];
            if (enums[duplicateIdx].coordinate == enumeration.coordinate) {
                ans[enumeration.index] = duplicateCompressed;
            } else {
                compressed++;
                duplicateIdx = i;
                duplicateCompressed = compressed;
                ans[enumeration.index] = compressed;
            }
        }

        System.out.println(IntStream.of(ans).mapToObj(String::valueOf)
            .collect(Collectors.joining(" ")));
    }

    static class Enumeration implements Comparable<Enumeration> {
        int coordinate;
        int index;

        Enumeration(int coordinate, int index) {
            this.coordinate = coordinate;
            this.index = index;
        }

        public int compareTo(Enumeration o) {
            return this.coordinate - o.coordinate;
        }
    }
}