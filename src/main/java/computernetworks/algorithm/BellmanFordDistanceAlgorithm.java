package computernetworks.algorithm;


import computernetworks.model.interfaces.Graph;
import computernetworks.model.records.Edge;
import computernetworks.model.records.Node;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/* ΕΞΑΓΩΓΗ ΠΙΝΑΚΩΝ ΔΡΟΜΟΛΟΓΗΣΗΣ - BELLMANFORD */
public class BellmanFordDistanceAlgorithm implements DistanceAlgorithm {
    private  Map<Node,Integer> currentDistance;
    private final Graph graph;
    private final Node sourceNode;

    public BellmanFordDistanceAlgorithm(final Graph graph, final Node sourceNode) {
        this.graph = graph;
        this.sourceNode = sourceNode;
    }

    @Override
    public Map<Node, Integer> runAlgorithm() {

        this.setCurrentDistance(this.graph.getNodes().stream()
                .collect(Collectors.toMap(node -> node, node -> (node.equals(this.sourceNode) ? 0 : Integer.MAX_VALUE))));


        this.graph.getEdges().stream()
                .limit((long) this.graph.getNodes().size() - 1)
                .filter(this::filterDistance)
                .forEach(this::addDistance);

        return this.currentDistance;
    }


    @Override
    public boolean filterDistance(final Edge edge){
        return currentDistance.get(edge.source()) != Integer.MAX_VALUE
                && currentDistance.get(edge.source()) + edge.weight() < currentDistance.get(edge.destination());
    }

    @Override
    public void addDistance(final Edge edge){
        currentDistance.put(edge.destination(), currentDistance.get(edge.source()) + edge.weight());
    }

    @Override
    public void setCurrentPriorityQueue(final PriorityQueue<Node> currentPriorityQueue) {
        throw new UnsupportedOperationException("Not supported in this implementation.");
    }

    @Override
    public void setCurrentDistance(final Map<Node, Integer> currentDistance) {
        this.currentDistance = currentDistance;
    }

    @Override
    public void clearCurrentDistance() {
        this.currentDistance.clear();
    }

    @Override
    public void clearPriorityQue() {
        throw new UnsupportedOperationException("Not supported in this implementation.");
    }


}