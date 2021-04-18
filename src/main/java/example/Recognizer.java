package example;

public class Recognizer {
    private Integer[] states = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    boolean nextState(int length, int numOfCurrState, String symbolsLane, int current) {
        Graph graph = new Graph();
        boolean answer=false;
        if (numOfCurrState == length) {
            return graph.getStates()[current - 1] == 1;
        } else {
            int i1 = Integer.parseInt(String.valueOf(symbolsLane.charAt(numOfCurrState)));
            for (int i = 0; i < graph.getSize(); i++) {
                for (int j = 0; j < graph.vertices.get(i).getSize(); j++) {
                    if (graph.vertices.get(i).edges.get(j).getBegin() == current) {
                        if (graph.vertices.get(i).edges.get(j).getState() == i1) {
                            answer = nextState(length, numOfCurrState + 1, symbolsLane, graph.vertices.get(i).edges.get(j).getEnd());
                        }
                    }
                }
            }
        }
        return answer;
    }

}
