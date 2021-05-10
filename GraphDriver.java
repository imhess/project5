package matrix;

import java.util.ArrayList;

public class GraphDriver {

    public static void main(String[] args)
    {
    	Graph test = new Graph();
    	
    	test.addVertex("A");
    	test.addVertex("B");
    	test.addVertex("C");
    	test.addVertex("D");
    	test.addVertex("E");
    	test.addVertex("F");
    	test.addVertex("G");
    	test.addVertex("H");
    	test.addVertex("I");
    	
    	test.addEdge("A", "B");
    	test.addEdge("A", "E");
    	test.addEdge("A", "D");
    	test.addEdge("B", "E");
    	test.addEdge("C", "B");
    	test.addEdge("D", "G");
    	test.addEdge("E", "F");
    	test.addEdge("E", "H");
    	test.addEdge("F", "C");
    	test.addEdge("F", "H");
    	test.addEdge("G", "H");
    	test.addEdge("H", "I");
    	test.addEdge("I", "F");
    	
    	Set<String> depthFirstTraversal(test, "A");
    }
}
