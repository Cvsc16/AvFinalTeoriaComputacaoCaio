package mygraph;

import java.util.List;
import java.util.LinkedList;
import java.util.stream.Collectors;

class Edge {
    private float weight = 1;
    private Vertex from;
    private Vertex to;

    public Edge(Vertex from, Vertex to) {
        setFrom(from);
        setTo(to);
    }

    public Edge(Vertex from, Vertex to, float weight) {
        setFrom(from);
        setTo(to);
        setWeight(weight);
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    private void setFrom(Vertex from) {
        this.from = from;
    }

    public Vertex getFrom() {
        return from;
    }

    private void setTo(Vertex to) {
        this.to = to;
    }

    public Vertex getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "[" +
                this.weight + ", " +
                this.from.getLabel() + ", " +
                this.to.getLabel() + "]";
    }
}

class Vertex {
    private String label;
    private List<Edge> edges = new LinkedList<>();

    public Vertex(String label) {
        setLabel(label);
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void addEdge(Edge edge) {
        this.edges.add(edge);
    }

    public void removeEdge(Edge edge) {
        edges.remove(edge);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public boolean hasEdgeTo(Vertex to) {
        for (Edge edge : edges) {
            if (edge.getTo() == to) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String ts = "[Label: " + label;
        for (Edge edge : this.edges)
            ts += edge;
        return ts + "]";
    }
}

public class Graph {

    private List<Vertex> vertexes = new LinkedList<>();

    public Graph() {  }

    protected Vertex findVertex(String value) {
        try {
            return vertexes
                    .stream()
                    .filter(v -> v.getLabel().equals(value))
                    .collect(Collectors.toList())
                    .get(0);
        } catch(Exception e){
            return null;
        }
    }

    public void addVertex(String value) {
        var vertex = findVertex(value);
        if (vertex == null)
            vertexes.add(new Vertex(value));
    }

    public void removeVertex(String value) {
        var vertex = findVertex(value);
        if (vertex != null)
            vertexes.remove(vertex);
    }

    public void addEdge(String valA, String valB) {
        var va = findVertex(valA);
        var vb = findVertex(valB);
        if (va != null && vb != null) {
            va.addEdge(new Edge(va, vb));
            vb.addEdge(new Edge(vb, va));
        }
    }

    public List<Vertex> neighbours(String value) {
        var v = findVertex(value);
        if (v == null)
            return null;
        List<Vertex> vs = new LinkedList<>();
        for(Edge e : v.getEdges())
            vs.add(e.getTo());

        return vs;
    }

    public boolean direct(String vA, String vB) {
        var v = findVertex(vA);
        if (v != null) {
            return v.getEdges()
                    .stream()
                    .filter(e -> e.getTo().getLabel().equals(vB))
                    .count() == 1;
        }
        return false;
    }

    @Override
    public String toString() {
        var s = "";
        for(Vertex v : vertexes)
            s += v;
        return s;
    }

    public List<Vertex> caminho(String valueA, String valueB) {
        Vertex start = findVertex(valueA);
        Vertex end = findVertex(valueB);
        if (start == null || end == null) {
            return null;
        }
        List<Vertex> visited = new LinkedList<>();
        visited.add(start);
        return caminhoHelper(start, end, visited);
    }

    private List<Vertex> caminhoHelper(Vertex current, Vertex end, List<Vertex> visited) {
        if (current == end) {
            return visited;
        }
        for (Edge edge : current.getEdges()) {
            Vertex neighbor = edge.getTo();
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                List<Vertex> path = caminhoHelper(neighbor, end, visited);
                if (path != null) {
                    return path;
                }
                visited.remove(visited.size() - 1);
            }
        }
        return null;
    }

    public Graph uniao(Graph other) {
        Graph union = new Graph();
        for (Vertex vertex : vertexes) {
            union.addVertex(vertex.getLabel());
            for (Edge edge : vertex.getEdges()) {
                Vertex to = edge.getTo();
                if (!union.direct(vertex.getLabel(), to.getLabel())) {
                    union.addEdge(vertex.getLabel(), to.getLabel());
                }
            }
        }
        for (Vertex vertex : other.vertexes) {
            Vertex existingVertex = union.findVertex(vertex.getLabel());
            if (existingVertex == null) {
                union.addVertex(vertex.getLabel());
                for (Edge edge : vertex.getEdges()) {
                    Vertex to = edge.getTo();
                    if (!union.direct(vertex.getLabel(), to.getLabel())) {
                        union.addEdge(vertex.getLabel(), to.getLabel());
                    }
                }
            } else {
                for (Edge edge : vertex.getEdges()) {
                    Vertex to = edge.getTo();
                    if (!existingVertex.hasEdgeTo(to)) {
                        union.addEdge(existingVertex.getLabel(), to.getLabel());
                    }
                }
            }
        }
        return union;
    }

    public Graph interseccao(Graph other) {
        Graph intersection = new Graph();
        for (Vertex vertex : vertexes) {
            if (other.findVertex(vertex.getLabel()) != null) {
                intersection.addVertex(vertex.getLabel());
                for (Edge edge : vertex.getEdges()) {
                    Vertex to = edge.getTo();
                    if (other.direct(vertex.getLabel(), to.getLabel())) {
                        intersection.addEdge(vertex.getLabel(), to.getLabel());
                    }
                }
            }
        }
        return intersection;
    }

}
