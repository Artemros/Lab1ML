package example;

public class Edge {
    private int begin;
    private int end;
    private int state;

    public Edge(int begin, int end, int state) {
        this.begin = begin;
        this.end = end;
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }
}
