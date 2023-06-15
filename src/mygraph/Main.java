package mygraph;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        var graph = new Graph();

        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");
        graph.addVertex("e");

        graph.addEdge("a", "b");
        graph.addEdge("a", "c");
        graph.addEdge("b", "c");
        graph.addEdge("a", "d");
        graph.addEdge("c", "d");
        graph.addEdge("b", "e");



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

        System.out.println("");
        System.out.println("Avaliação Final");
        System.out.println("Parte com a implementação do arquivo BFS no grafo:");
        System.out.println("");
        List<Vertex> path = graph.buscaBfs("a", "e");
        if (path != null) {
            System.out.println("Caminho encontrado: " + path);
        } else {
            System.out.println("Não foi possível encontrar um caminho do vértice a ao vértice e.");
        }

        System.exit(0);
    }

}