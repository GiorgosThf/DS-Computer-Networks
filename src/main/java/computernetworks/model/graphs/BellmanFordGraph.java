package computernetworks.model.graphs;

import computernetworks.model.interfaces.Graph;
import computernetworks.model.records.Edge;
import computernetworks.model.records.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BellmanFordGraph implements Graph {
    private final List<Edge> edges = new ArrayList<>();
    private final Set<Node> nodes = new HashSet<>();
    private final int graphSize;

    public BellmanFordGraph(final int graphSize) {
        this.graphSize = graphSize;
    }

    @Override
    public void addNode(final Node node) {
        if (this.nodes.size() <= graphSize){
            this.nodes.add(node);
        } else throw new RuntimeException("Graph reached max capacity");

    }

    @Override
    public void addEdge(final Node source, final Node destination, int weight) {
        this.edges.add(new Edge(source, destination, weight));
    }

    @Override
    public void removeNode(final String nodeName) {
        this.nodes.removeIf(node -> node.name().equals(nodeName));
    }

    @Override
    public void removeEdge(final String sourceName, final String destinationName) {
        this.edges.removeIf(edge ->
                edge.source().name().equals(sourceName) && edge.destination().name().equals(destinationName));
    }

    @Override
    public Set<Node> getNodes() {
        return this.nodes;
    }

    @Override
    public List<Edge> getEdges() {
        return this.edges;
    }


    @Override
    public Node getNode(final String destinationName) {
        return this.nodes.stream().filter(node -> node.name().equals(destinationName)).findFirst()
                .orElseThrow(()-> new RuntimeException("No such node: " + destinationName));
    }

    @Override
    public void clearGraph() {
        this.edges.clear();
        this.nodes.clear();
    }

    @Override
    public String toString() {
        return " BellmanFord Graph{" +
                "edges=" + edges +
                ", nodes=" + nodes +
                '}';
    }
}
