import java.util.*;

public class CountComponent {
    static int[] parents;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        parents = new int[n+1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {

        }
    }

    static void union(int a, int b) {
        parents[a] = b;
    }

    static int find(int a) {
        if (parents[a] == a) {
            return a;
        }

        
        return find(parents[a]);
    }

    
}
