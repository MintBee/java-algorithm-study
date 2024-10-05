import java.util.*;
import java.util.stream.*;

public class EasyShortestPath {
    static int[][] map;
    static int n,m;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        
        map = new int[n][m];
        visited = new boolean[n][m];
        int startX = -1, startY = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }

        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    ans[i][j] = 0;
                }
            }
        }

        Queue<Node> queue = new ArrayDeque<>(1_000_000);
        queue.offer(new Node(startX, startY, 0));
        visited[startX][startY] = true;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            ans[current.x][current.y] = current.depth;
            queue.addAll(current.produceNext());
        }

        for (int i = 0; i < n; i++) {
            System.out.println(IntStream.of(ans[i]).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
    

    static class Node {
        int x;
        int y;
        int depth;

        Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }

        static int[] dx = {1, -1, 0, 0};
        static int[] dy = {0, 0, 1, -1};

        List<Node> produceNext() {
            List<Node> nextNodes = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != 0 && !visited[nx][ny]) {
                    nextNodes.add(new Node(nx, ny, depth+1));
                    visited[nx][ny] = true;
                }
            }
            return nextNodes;
        }
    }
}