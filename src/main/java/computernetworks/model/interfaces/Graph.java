package computernetworks.model.interfaces;


import computernetworks.model.records.Edge;
import computernetworks.model.records.Node;

import java.util.List;
import java.util.Set;

public interface Graph {
    void addNode(final Node node);
    void addEdge(final Node source, final Node destination, final int weight);
    List<Edge> getEdges();
    Set<Node> getNodes();
    Node getNode(final String nodeName);
    void removeNode(final String nodeName);
    void removeEdge(final String sourceName, final String destinationName);
    void clearGraph();
}

