import java.util.*;

public class AreaSecuring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int groundCount = sc.nextInt();
        for (int i = 0; i < groundCount; i++) {
            Map<Long, Integer> soldiers = new HashMap<>();
            int soldierCount = sc.nextInt();
            for (int soldier = 0; soldier < soldierCount; soldier++) {
                soldiers.merge(sc.nextLong(), 1, Integer::sum);
            }
            Map.Entry<Long, Integer> dominant = Collections.max(soldiers.entrySet(), Map.Entry.comparingByValue());
            if (dominant.getValue() > soldierCount/2) {
                System.out.println(dominant.getKey());
            } else {
                System.out.println("SYJKGW");
            }
        }
        sc.close();
    }
}