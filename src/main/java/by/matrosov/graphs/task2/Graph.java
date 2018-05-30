package by.matrosov.graphs.task2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Graph {
    private int v;
    private ArrayList<Integer>[] adjList;
    private int n = 1; //from 1 to n

    private Graph(int v) {
        this.v = v;
        initAdjList();
    }

    private void initAdjList() {
        adjList = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    private void addEdge(int u, int v){
        adjList[u].add(v);
    }

    private void calculateAllPaths(int s, int d, Set<String> set){
        boolean[] isVisited = new boolean[v];
        ArrayList<Integer> pathList = new ArrayList<>();
        pathList.add(s);
        calculateAllPathsUtil(s, d, isVisited, pathList, set);
    }

    private void calculateAllPathsUtil(Integer u, Integer d, boolean[] isVisited, ArrayList<Integer> localPathList, Set<String> set){
        // Mark the current node
        isVisited[u] = true;

        if (u.equals(d))
        {
            //System.out.println(localPathList);
            calculatePossibleNumbers(localPathList, n, set);
        }

        // Recur for all the vertices
        // adjacent to current vertex
        for (Integer i : adjList[u])
        {
            if (!isVisited[i])
            {
                // store current node
                // in path[]
                localPathList.add(i);
                calculateAllPathsUtil(i, d, isVisited, localPathList, set);

                // remove current node
                // in path[]
                localPathList.remove(i);
            }
        }

        // Mark the current node
        isVisited[u] = false;
    }

    private static void initGraphPaths(Graph graph){
        graph.addEdge(0,1);
        graph.addEdge(0,3);

        graph.addEdge(1,0);
        graph.addEdge(1,2);
        graph.addEdge(1,4);

        graph.addEdge(2,1);
        graph.addEdge(2,5);

        graph.addEdge(3,0);
        graph.addEdge(3,4);
        graph.addEdge(3,6);

        graph.addEdge(4,1);
        graph.addEdge(4,3);
        graph.addEdge(4,5);
        graph.addEdge(4,7);

        graph.addEdge(5,2);
        graph.addEdge(5,4);
        graph.addEdge(5,8);

        graph.addEdge(6,3);
        graph.addEdge(6,7);

        graph.addEdge(7,4);
        graph.addEdge(7,6);
        graph.addEdge(7,8);
        graph.addEdge(7,9);

        graph.addEdge(8,5);
        graph.addEdge(8,7);

    }

    private static void calculatePossibleNumbers(ArrayList<Integer> localPathList, int n, Set<String> set){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < localPathList.size(); i++) {
            sb.append(localPathList.get(i));
            if (sb.length() == n) {
                set.add(sb.toString());
                set.add(sb.reverse().toString());
                //System.out.println(sb.toString());
                sb.delete(0, sb.length());
                i = i - n + 1;
            }
        }

        addFreqNumbersToSet(set, n);
    }

    private static void addFreqNumbersToSet(Set<String> set, int n){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            while (sb.length() < n){
                sb.append(i);
            }
            set.add(sb.toString());
            sb.delete(0, sb.length());
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(10);
        initGraphPaths(graph);

        Set<String> set = new HashSet<>();
        int s = 0;
        int d = 9;

        graph.calculateAllPaths(s, d, set);

        System.out.println(set);

        //n=1 -> 10
        //n=2 -> 36
        //n=3 -> 52
        //...
        System.out.println(set.size());
    }
}
