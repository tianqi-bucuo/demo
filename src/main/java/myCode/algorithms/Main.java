package myCode.algorithms;

import java.util.*;

public class Main {
    static int n, m, res, ans, tot;
    static int[] A = new int[20];
    static boolean[] discard = new boolean[20], f = new boolean[2001];
    private static void dfs(int cur, int discardNum) {
        if (discardNum > m)	return;
        if (cur == n) {
            if (discardNum == m) {
                dp();
            }
            return;
        }
        dfs(cur + 1, discardNum);
        discard[cur] = true;
        dfs(cur + 1, discardNum + 1);
        discard[cur] = false;
    }

    private static void dp() {
        Arrays.fill(f, false);
        f[0] = true;
        ans = 0;
        tot = 0;
        for (int i = 0; i < n; i++) {
            if (!discard[i]) {
                for (int j = tot; j >= 0; j--) {
                    if (f[j] && !f[j + A[i]]) {
                        f[j + A[i]] = true;
                        ans++;
                    }
                }
            }
            tot += A[i];
        }
        res = Math.max(res, ans);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }
        dfs(0, 0);
        System.out.println(res);
    }
}