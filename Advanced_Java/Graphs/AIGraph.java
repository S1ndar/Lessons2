package Graphs;
import java.util.*;

public class AIGraph {
    private int V; // Количество вершин
    private LinkedList<Integer> adj[]; // Список смежности

    public AIGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Добавление ребра в граф
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Обход в ширину
    void BFS(int s) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // Обход в глубину
    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int v) {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }

    // Вывод соседей вершины
    void printNeighbours(int v) {
        System.out.print("Соседи вершины " + v + " : ");
        for (Integer neighbour : adj[v]) {
            System.out.print(neighbour + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        AIGraph g = new AIGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Обход в ширину начиная с вершины 2:");
        g.BFS(2);
        System.out.println("\nОбход в глубину начиная с вершины 2:");
        g.DFS(2);
        System.out.println("\nСоседи вершины 2:");
        g.printNeighbours(2);
    }
}