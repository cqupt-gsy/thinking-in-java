package programming.practise.katas.karate_transitive_dependencies;

import com.google.common.graph.GraphBuilder;
import com.google.common.graph.Graphs;
import com.google.common.graph.MutableGraph;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class CountDependencies {

    @Test
    public void shouldReturnName() {
        //Given
        List<String>  list = new ArrayList<String>() {{
            add("A B C");
            add("B C E");
            add("C G");
            add("D A F");
            add("E F");
            add("F H");
        }};
        MutableGraph<String> graph = GraphBuilder.directed().build();
        list.forEach(items -> Arrays.stream(items.split(" ")).forEach(graph::addNode));
        list.forEach(items -> {
            final String[] item = items.split(" ");
            String head = item[0];
            for (int i = 1; i < item.length; i++) {
                graph.putEdge(head, item[i]);
            }
        });
        graph.nodes().forEach(node -> {
            final Set<String> reachableNodes = Graphs.reachableNodes(graph, node);
            if (reachableNodes.size() > 1) {
                reachableNodes.forEach(System.out::print);
                System.out.println();
            }
        });
    }
}
