package com.wangqiuchen;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}


class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        //边的个数
        int nodesCount = edges.length;
        //0位不用
        UnionFind uf = new UnionFind(nodesCount + 1);
        //记录父节点
        int[] parent = new int[nodesCount + 1];
        //初始化父节点
        for (int i = 1; i <= nodesCount; ++i) {
            parent[i] = i;
        }
        int conflict = -1;
        int cycle = -1;
        for (int i = 0; i < nodesCount; ++i) {
            //对于这条边
            int[] edge = edges[i];
            //由2指向1
            int node1 = edge[0], node2 = edge[1];
            //如果2的父节点不是1，且2的父节点不是2（初始化后已经被遍历到）
            if (parent[node2] != node2) {
                conflict = i;
            } else {
                //2的父节点是1，且第一次被遍历到
                parent[node2] = node1;


                //如果他们的祖先相同（最后一次的祖先相同，因为其他时候的已经被遍历了，此时一定是已经被添加到集合中的）
                //那么记录下这个循环，这样可以找到最后一个循环中两个祖先相同的
                //否则就合并两个节点
                if (uf.find(node1) == uf.find(node2)) {
                    cycle = i;
                } else {
                    uf.union(node1, node2);
                }
            }
        }

        //出现冲突，度为2
        if (conflict < 0) {
            //度全部为1，多的一条边指向根结点
            //断掉最后一次成环的边
            int[] redundant = {edges[cycle][0], edges[cycle][1]};
            return redundant;
        } else {
            //有度为2的
            //最后一次循环就是多的一条边
            int[] conflictEdge = edges[conflict];

            if (cycle >= 0) {
                //此时的cycle是子节点号，找出子节点和子节点的父节点就行，它的父节点就是root
                int[] redundant = {parent[conflictEdge[1]], conflictEdge[1]};
                return redundant;
            } else {
                //最后一次遍历到的就是这条边
                int[] redundant = {conflictEdge[0], conflictEdge[1]};
                return redundant;
            }
        }
    }
}

class UnionFind {
    //并查集祖先
    int[] ancestor;

    //初始化并查集
    public UnionFind(int n) {
        ancestor = new int[n];
        for (int i = 0; i < n; ++i) {
            ancestor[i] = i;
        }
    }

    //合并
    //1指向2
    //2为父
    public void union(int index1, int index2) {
        ancestor[find(index1)] = find(index2);
    }

    //递归查找index的祖先
    public int find(int index) {
        if (ancestor[index] != index) {
            ancestor[index] = find(ancestor[index]);
        }
        return ancestor[index];
    }
}