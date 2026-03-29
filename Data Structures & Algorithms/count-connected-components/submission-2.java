// Revision Union Find solution
public class Solution {
    public int countComponents(int n, int[][] edges) {
        var unionFind = new UnionFind(n);
        int noOfComponents = n;
        for(int[] edge: edges) {
            if(unionFind.union(edge[0], edge[1])) {
                noOfComponents--;
            }
        }
        return noOfComponents;
    }
}

class UnionFind {
    int[] parent;
    int[] rank;

    UnionFind(int numberOfNodes){
        parent = new int[numberOfNodes];
        rank = new int[numberOfNodes];
        for(int i=0; i<numberOfNodes; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    int find(int node) {
        var current = node;
        while(current!=parent[current]) {
            parent[current] = parent[parent[current]];
            current = parent[current];
        }
        return current;
    }

    boolean union(int node1, int node2) {
        var parent1 = find(node1);
        var parent2 = find(node2);

        if(parent1 == parent2) 
            return false;
        if(rank[parent1]>rank[parent2]) {
            rank[parent1] += rank[parent2];
            parent[parent2] = parent1;
        } else {
            rank[parent2] += rank[parent1];
            parent[parent1] = parent2;
        }
        return true;
    }
}
