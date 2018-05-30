package by.matrosov.graphs.task1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Graph {
    private int v;
    private ArrayList<Integer>[] adjList;

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

    private StringBuilder convertIntPathToStringPath(ArrayList<Integer> localPathList){
        char[] boogle = {'H','I','Z','U','A','R','Q','N','B'};
        StringBuilder sb = new StringBuilder();
        for (Integer a : localPathList) {
            sb.append(boogle[a]);
        }
        return sb;
    }

    private void checkWords(StringBuilder sb, Set<String> set){
        String[] dictionary = {"HABR", "FOR", "QUIZ", "GO"};
        for (String d : dictionary) {
            if (sb.toString().contains(d) || sb.reverse().toString().contains(d)){
                //System.out.println(d + "  " + sb.toString());
                set.add(d);
            }
        }
    }

    private void calculateAllPathsUtil(Integer u, Integer d, boolean[] isVisited, ArrayList<Integer> localPathList, Set<String> set){
        // Mark the current node
        isVisited[u] = true;

        if (u.equals(d))
        {
            //System.out.println(localPathList);
            //convertIntPathToStringPath(localPathList);
            checkWords(convertIntPathToStringPath(localPathList), set);
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
        graph.addEdge(0,4);

        graph.addEdge(1,0);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(1,5);

        graph.addEdge(2,1);
        graph.addEdge(2,4);
        graph.addEdge(2,5);

        graph.addEdge(3,0);
        graph.addEdge(3,1);
        graph.addEdge(3,4);
        graph.addEdge(3,6);
        graph.addEdge(3,7);

        graph.addEdge(4,0);
        graph.addEdge(4,1);
        graph.addEdge(4,2);
        graph.addEdge(4,3);
        graph.addEdge(4,4);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(4,7);
        graph.addEdge(4,8);

        graph.addEdge(5,1);
        graph.addEdge(5,2);
        graph.addEdge(5,4);
        graph.addEdge(5,7);
        graph.addEdge(5,8);

        graph.addEdge(6,3);
        graph.addEdge(6,4);
        graph.addEdge(6,7);

        graph.addEdge(7,3);
        graph.addEdge(7,4);
        graph.addEdge(7,5);
        graph.addEdge(7,6);
        graph.addEdge(7,8);

        graph.addEdge(8,4);
        graph.addEdge(8,5);
        graph.addEdge(8,7);
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        Graph graph = new Graph(9);
        initGraphPaths(graph);

        int s = 0; //from
        int[] d = {1,2,3,4,5,6,7,8}; //to
        for (int i : d) {
            graph.calculateAllPaths(s, i, set);
        }

        System.out.println(set);
        System.out.println(set.size()); //gg
    }
}
