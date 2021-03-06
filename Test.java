import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// RUN THIS CLASS WITH:
// javac Test.java; java -ea Test
class Test {
    public static void main(String[] args) {
        List<Node> graph1 = new ArrayList<>();
        for (int i=0; i<4; i++) {
            graph1.add(new Node(i));
        }
        graph1.get(0).neighbours.addAll(Arrays.asList(graph1.get(1), graph1.get(3)));
        graph1.get(1).neighbours.addAll(Arrays.asList(graph1.get(0), graph1.get(3)));
        graph1.get(3).neighbours.addAll(Arrays.asList(graph1.get(0), graph1.get(1)));

        System.out.println("RUNNING TEST 1");
        dfs(graph1.get(0));
        boolean allCorrect = graph1.get(0).isVisited && graph1.get(1).isVisited && graph1.get(3).isVisited && !graph1.get(2).isVisited;
        try {
            System.out.println(allCorrect);
            assert (allCorrect);
        } catch (AssertionError error) {
            System.out.println("TEST 1 FAIL");
        }

        List<Node> graph2 = new ArrayList<>();
        for (int i=0; i<4; i++) {
            graph2.add(new Node(i));
        }
        graph2.get(0).neighbours.addAll(Arrays.asList(graph2.get(1), graph2.get(2)));
        graph2.get(1).neighbours.addAll(Arrays.asList(graph2.get(0), graph2.get(3)));
        graph2.get(2).neighbours.addAll(Collections.singletonList(graph2.get(0)));
        graph2.get(2).neighbours.addAll(Collections.singletonList(graph2.get(1)));

        System.out.println("RUNNING TEST 2");
        dfs(graph2.get(0));
        allCorrect = graph2.get(0).isVisited && graph2.get(1).isVisited && graph2.get(3).isVisited && graph2.get(2).isVisited;
        try {
            System.out.println(allCorrect);
            assert (allCorrect);
        } catch (AssertionError error) {
            System.out.println("TEST 2 FAIL");
        }
    }

    static void dfs(Node node) {
        // IMPLEMENT HERE
    }
}

class Node {
    List<Node> neighbours;
    int id;
    boolean isVisited = false;

    public Node(int id) {
        this.id = id;
        this.neighbours = new ArrayList<>();
    }

    public Node(int id, List<Node> neighbours) {
        this.id = id;
        this.neighbours = neighbours;
    }
}