import java.util.*;
import java.util.stream.*;

public class NAndM2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] superSet = IntStream.range(1, n+1).toArray();
        List<Integer> selected = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        combination(superSet, -1, m, selected, ans);
        for (List<Integer> line : ans) {
            System.out.println(line.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }

    static void combination(int[] superSet, int lastIdx, int m, List<Integer> selected, List<List<Integer>> ans) { 
        if (selected.size() == m) {
            ans.add(List.copyOf(selected));
            return;
        }

        for (int i = lastIdx+1; i < superSet.length; i++) {
            selected.add(superSet[i]);
            combination(superSet, i, m, selected, ans);
            selected.remove(selected.size()-1);
        }
    }
}
