import java.util.*;
import java.util.stream.*;;

public class NAndM4 {
    static Set<List<Integer>> printedSequences = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        sc.nextLine();
        int[] superSet = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(superSet);
        List<Integer> selected = new ArrayList<>();
        combination(superSet, 0, m, selected);
    }

    static void combination(int[] superSet, int lastIdx, int m, List<Integer> selected) { 
        if (selected.size() == m) {
            if (printedSequences.contains(selected)) {
                return;
            }
            printedSequences.add(List.copyOf(selected));
            System.out.println(selected.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            return;
        }

        for (int i = lastIdx; i < superSet.length; i++) {
            selected.add(superSet[i]);
            combination(superSet, i, m, selected);
            selected.remove(selected.size()-1);
        }
    }
}
