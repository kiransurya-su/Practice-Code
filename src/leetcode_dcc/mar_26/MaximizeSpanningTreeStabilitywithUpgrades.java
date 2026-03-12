package leetcode_dcc.mar_26;
/*
3600. Maximize Spanning Tree Stability with Upgrades (Hard)
You are given an integer n, representing n nodes numbered from 0 to n - 1 and a list of edges, where edges[i] = [ui, vi, si, musti]:

ui and vi indicates an undirected edge between nodes ui and vi.
si is the strength of the edge.
musti is an integer (0 or 1). If musti == 1, the edge must be included in the spanning tree. These edges cannot be upgraded.
You are also given an integer k, the maximum number of upgrades you can perform. Each upgrade doubles the strength of an edge, and each eligible edge (with musti == 0) can be upgraded at most once.

The stability of a spanning tree is defined as the minimum strength score among all edges included in it.

Return the maximum possible stability of any valid spanning tree. If it is impossible to connect all nodes, return -1.

Note: A spanning tree of a graph with n nodes is a subset of the edges that connects all nodes together (i.e. the graph is connected) without forming any cycles, and uses exactly n - 1 edges.

Streak->218 (additional 1 because of solving the previous one problem - in aug)
* */
class DSU {
    int[] parent, rank;
    int components;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        components = n;
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }
    public boolean unite(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) return false;
        if (rank[pa] < rank[pb]) { int t = pa; pa = pb; pb = t; }
        parent[pb] = pa;
        if (rank[pa] == rank[pb]) rank[pa]++;
        components--;
        return true;
    }
}

public class MaximizeSpanningTreeStabilitywithUpgrades {
    public static void main(String[] args) {
        int n=3,k=1;
        int[][] arr ={{0,1,2,1},{1,2,3,0}};
        System.out.println(maxStability(n,arr,k));
    }
    public static boolean canAchieve(int n, int[][] edges, int k, int x) {
        DSU dsu = new DSU(n);
        for (int[] e : edges)
            if (e[3] == 1) {
                if (e[2] < x || !dsu.unite(e[0], e[1])) return false;
            }
        for (int[] e : edges)
            if (e[3] == 0 && e[2] >= x)
                dsu.unite(e[0], e[1]);
        int usedUpgrades = 0;
        for (int[] e : edges) {
            if (e[3] == 0 && e[2] < x && 2 * e[2] >= x) {
                if (dsu.unite(e[0], e[1])) {
                    usedUpgrades++;
                    if (usedUpgrades > k) return false;
                }
            }
        }
        return dsu.components == 1;
    }

    public static int maxStability(int n, int[][] edges, int k) {
        DSU dsu = new DSU(n);
        for (int[] e : edges) if (e[3] == 1) if (!dsu.unite(e[0], e[1])) return -1;

        int low = 1, high = 200000, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canAchieve(n, edges, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
