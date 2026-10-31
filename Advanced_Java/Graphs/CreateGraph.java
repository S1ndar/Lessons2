package Advanced_Java.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class CreateGraph {

	public static void main(String[] args) {
		    Graph graph = Graph.createGraph();
			System.out.println(graph.getAdjVertices("Bob"));
			System.out.println(graph.getAdjVertices("Rob"));
			System.out.println(graph.getAdjVertices("Mark"));
			System.out.println(graph.getAdjVertices("Maria"));
		

	}

}

// Определение вершины графа
class Vertex {
    String label;
    Vertex(String label) {
        this.label = label;
    }
    
    public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Vertex d = (Vertex) obj;
		return Objects.equals(label, d.label);		
	}
	
	public int hashCode() { 
		return Objects.hash(label);
	}
	
	@Override
	public String toString() {
		return label;
	}
	
}

// Определение самого графа
class Graph {
	// Граф состоит из вершин - Vertex и её соседей List<Vertex>
    private Map<Vertex, List<Vertex>> adjVertices;
    
    // constructor
    public Graph() {
    	
    	adjVertices = new HashMap<>(); 
    }
    
    // setter
    public void setAdjVertices(Map<Vertex, List<Vertex>> adjVertices) {
		this.adjVertices = adjVertices;
	}
    
    // getter
    public Map<Vertex, List<Vertex>> getAdjVertices() {
		return adjVertices;
	}
    
    // Добавление вершин 
    void addVertex(String label) {
    	// putIfAbsent - добавление элемента, если такого нет 
    	// Элемент = вершина + список соседей
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }
    
    // Удаление вершин 
    void removeVertex(String label) {
        Vertex v = new Vertex(label);
        // Удаление из списка соседей
        adjVertices.values().stream().forEach(e -> e.remove(v));
        // Удаление самой вершины
        adjVertices.remove(new Vertex(label));
    }
    
    // Добавление ребер - связи между вершинами
    void addEdge(String label1, String label2) {
    	// Определение 2 вершин между которых ребро 
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        // Добавление вершин в друзья - вершина засовывется в список соседей другой вершины   
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }
    
    // Удаление ребер - связи между вершинами
    void removeEdge(String label1, String label2) {
    	// Определение 2 вершин между которых ребро 
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        // Удаление связи между соседями
        List<Vertex> eV1 = adjVertices.get(v1);
        List<Vertex> eV2 = adjVertices.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }
    
    // Получение соседей конкретной вершины 
    List<Vertex> getAdjVertices(String label) {
        return adjVertices.get(new Vertex(label));
    }
    
    // Создание самого графа через метод внутри класса
    public static Graph createGraph() {
    	Graph graph = new Graph();
    	graph.addVertex("Bob");
    	graph.addVertex("Alice");
    	graph.addVertex("Mark");
    	graph.addVertex("Rob");
    	graph.addVertex("Maria");
    	graph.addEdge("Bob", "Alice");
    	graph.addEdge("Bob", "Rob");
    	graph.addEdge("Alice", "Mark");
    	graph.addEdge("Rob", "Mark");
    	graph.addEdge("Alice", "Maria");
    	graph.addEdge("Rob", "Maria");
    	return graph;
    }
    
    // Обход в глубину 
    /*
      1. Создаем set visited - путь до нашей вершины
      2. Мы создаем стек stack, в который мы помещаем начальную вершину root. 
      3. Затем мы начинаем цикл while, который будет выполняться до тех пор, пока у нас есть вершины в стеке.
      4. На каждой итерации цикла мы извлекаем вершину из вершины stack.
      5. Мы проверяем, посещали ли мы уже эту вершину. Если нет, то мы добавляем ее в набор visited и исследуем ее смежные вершины.
      6. Для каждой смежной вершины мы добавляем ее в стек, чтобы в будущем исследовать ее.
      7. По завершении цикла возвращается набор посещенных вершин visited.
     */
    // В аргументы принимает сам граф - graph и вершину которую мы ищем - root
    Set<String> depthFirstTraversal(Graph graph, String root) {
    	// Путь до искомой вершины  
        Set<String> visited = new LinkedHashSet<String>();// Set - потому что он НЕ позволяет хранить одинаковые элементы 
        
        // Список всех вершин в графе
        Stack<String> stack = new Stack<String>();// Stack - потому что нам нужен принцип LIFO
        stack.push(root); // Искомая вершина 
        while (!stack.isEmpty()) {
        	// Извлекается первый элемент и удаляется из stack
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : graph.getAdjVertices(vertex)) {// Добавляем соседей искомой вершины в stack              
                    stack.push(v.label);
                }
            }
        }
        return visited; // Возвращает путь до искомой вершины
    }
    
    // Обход в ширину
    Set<String> breadthFirstTraversal(Graph graph, String root) {
    	// Путь до искомой вершины 
        Set<String> visited = new LinkedHashSet<String>();
        // Все вершины 
        Queue<String> queue = new LinkedList<String>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
        	// Вывод искомой вершины из очереди 
            String vertex = queue.poll();
            // Поиск по соседним вершинам искомой вершины
            for (Vertex v : graph.getAdjVertices(vertex)) {
                if (!visited.contains(v.label)) {
                    visited.add(v.label);
                    queue.add(v.label);
                }
            }
        }
        return visited;
    }

    
}


