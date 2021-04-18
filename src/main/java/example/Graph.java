package example;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    LinkedList<Vertex> vertices = new LinkedList<>();
    private Integer[] states = {1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0};

    public Graph() {
        vertices.add(new Vertex(1, List.of(new Edge(1, 3, 0), new Edge(1, 4, 1))));
        vertices.add(new Vertex(1, List.of(new Edge(2, 3, 0), new Edge(2, 4, 1))));
        vertices.add(new Vertex(1, List.of(new Edge(3, 5, 0), new Edge(3, 6, 1))));
        vertices.add(new Vertex(1, List.of(new Edge(4, 7, 0), new Edge(4, 8, 1))));
        vertices.add(new Vertex(1, List.of(new Edge(5, 11, 0), new Edge(5, 2, 1))));
        vertices.add(new Vertex(1, List.of(new Edge(6, 1, 0), new Edge(6, 2, 1))));
        vertices.add(new Vertex(1, List.of(new Edge(7, 5, 0), new Edge(7, 9, 1))));
        vertices.add(new Vertex(1, List.of(new Edge(8, 8, 0), new Edge(8, 10, 1))));
        vertices.add(new Vertex(1, List.of(new Edge(9, 10, 0), new Edge(9, 4, 1))));
        vertices.add(new Vertex(1, List.of(new Edge(10, 7, 0), new Edge(10, 8, 1))));
        vertices.add(new Vertex(1, List.of(new Edge(11, 11, 0), new Edge(11, 11, 1))));
    }

    public Integer[] getStates() {
        return states;
    }

    public Integer getSize() {
        return vertices.size();
    }
}
