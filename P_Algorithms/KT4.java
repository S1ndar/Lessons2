package P_Algorithms;

class Graf {
    class Edge {
        int to;
        int weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    private int n;                 // количество вершин
    private Edge[][] adj;          // список смежности
    private int[] deg;             // сколько рёбер у каждой вершины
    private static final int INF = 1000000000; // большое число

    public Graf(int n, int maxEdgesPerVertex) {
        this.n = n;
        this.adj = new Edge[n][maxEdgesPerVertex];
        this.deg = new int[n];
    }

    public void addEdge(int from, int to, int weight) {
        adj[from][deg[from]] = new Edge(to, weight);
        deg[from]++;
    }

    public int[] bellmanFord(int source) {
        int[] dist = new int[n];

        for (int i = 0; i < n; i++) {
            dist[i] = INF; // До других вершин расстояние многа, чтобы удобнее сравнивать
        }

        // До стартовой вершины расстояние равно 0
        dist[source] = 0;


        // n - 1 ребер до нашей вершины максимум
        for (int k = 0; k < n - 1; k++) {
            boolean flag = false; // флаг

            for (int v = 0; v < n; v++) {
                if (dist[v] == INF) continue; // Если мы еще не дошли до этой вершины

                for (int i = 0; i < deg[v]; i++) {
                    Edge e = adj[v][i];

                    // Если путь через v короче, обновляем расстояние
                    if (dist[v] + e.weight < dist[e.to]) {
                        dist[e.to] = dist[v] + e.weight;
                        flag = true;
                    }
                }
            }


            if (!flag) break;
        }

        // Поиск отрицательного цикла
        for (int v = 0; v < n; v++) {
            // Если до этой вершины не добраться то скип
            if (dist[v] == INF) continue;

            for (int i = 0; i < deg[v]; i++) {
                Edge e = adj[v][i];
                // Если путь через v короче, значит он меньше нуля
                if (dist[v] + e.weight < dist[e.to]) {
                    return null;
                }
            }
        }

        return dist; // массив кратчайших расстояний
    }
}

public class KT4 {
    public static void main(String[] args) {
        Graf g = new Graf(5, 4);

        g.addEdge(0, 1, -1);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 2);
        g.addEdge(1, 4, 2);
        g.addEdge(3, 2, 5);
        g.addEdge(3, 1, 1);
        g.addEdge(4, 3, -3);

        int[] dist = g.bellmanFord(0); // Стартовая вершина 0 и ищем кратчайший маршрут до всех вершин

        if (dist == null) {
            System.out.println("Есть отрицательный цикл");
        } else {
            for (int i = 0; i < dist.length; i++) {
                if (dist[i] >= 1000000000) {
                    // До вершины не добраться
                    System.out.println("0 -> " + i + " = INF");
                } else {
                    System.out.println("0 -> " + i + " = " + dist[i]);
                }
            }
        }
    }
}

