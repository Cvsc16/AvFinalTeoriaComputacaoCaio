package mygraph;

public class Main {

    public static void main(String[] args) {
        var graph = new Graph();

        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");

        graph.addEdge("a", "b");
        graph.addEdge("a", "c");
        graph.addEdge("b", "c");
        graph.addEdge("a", "d");



        var graph2 = new Graph();

        graph2.addVertex("c");
        graph2.addVertex("d");
        graph2.addVertex("e");

        graph2.addEdge("c", "d");
        graph2.addEdge("d", "e");

        System.out.println("");
        System.out.println("Grafo G1: " +graph);
        System.out.println("");
        System.out.println("Grafo G2: " +graph2);
        System.out.println("");
        System.out.println("Vizinhos: " + graph.neighbours("a"));

        if (graph.direct("a", "c"))
            System.out.println("");
        System.out.println("A e C estao ligados!!");

        if (!graph.direct("b", "d"))
            System.out.println("");
        System.out.println("B e D NAO estao ligados!!");

        System.out.println("");
        System.out.println("Caminho entre A e B: " + graph.caminho("a", "b"));



        System.out.println("");
        System.out.println("União Grafo G1 e G2: " + graph.uniao(graph2));


        var graphIntersection = graph.interseccao(graph2);
        System.out.println("");
        System.out.println("Grafo resultante da intersecção entre G1 e G2: " + graphIntersection);

        System.exit(0);
    }

}