package computernetworks.algorithm;

import computernetworks.model.interfaces.Graph;
import computernetworks.model.records.Edge;
import computernetworks.model.records.Node;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/* ΕΞΑΓΩΓΗ ΠΙΝΑΚΩΝ ΔΡΟΜΟΛΟΓΗΣΗΣ - DIJKSTRA */
public class DijkstraDistanceAlgorithm implements DistanceAlgorithm {
    private  Map<Node,Integer> currentDistance;
    private  PriorityQueue<Node> currentPriorityQueue;
    private final Graph graph;
    private final Node sourceNode;

    public DijkstraDistanceAlgorithm(final Graph graph, final Node sourceNode) {
        this.graph = graph;
        this.sourceNode = sourceNode;
    }

    @Override
    public  Map<Node, Integer> runAlgorithm() {

        this.setCurrentDistance(graph.getNodes().stream()
                .collect(Collectors.toMap(node -> node, node -> (node.equals(this.sourceNode) ? 0 : Integer.MAX_VALUE))));

        this.setCurrentPriorityQueue(new PriorityQueue<>(Comparator.comparingInt(currentDistance::get)));

        currentPriorityQueue.add(this.sourceNode);

        while (!currentPriorityQueue.isEmpty()) {
            Node current = currentPriorityQueue.poll();

            this.graph.getEdges().stream()
                    .filter(edge -> edge.source().equals(current))
                    .filter(this::filterDistance)
                    .forEach(this::addDistance);
        }

        return currentDistance;
    }
    @Override
    public boolean filterDistance(final Edge edge){
        return  currentDistance.get(edge.source()) + edge.weight() < currentDistance.get(edge.destination());
    }
    @Override
    public void addDistance(final Edge edge){
        currentDistance.put(edge.destination(), currentDistance.get(edge.source()) + edge.weight());
        currentPriorityQueue.add(edge.destination());
    }
    @Override
    public  void setCurrentPriorityQueue(final PriorityQueue<Node> currentPriorityQueue) {
        this.currentPriorityQueue = currentPriorityQueue;
    }

    @Override
    public  void setCurrentDistance(final Map<Node, Integer> currentDistance) {
        this.currentDistance = currentDistance;
    }

    @Override
    public  void clearCurrentDistance() {
        this.currentDistance.clear();
    }
    @Override
    public  void clearPriorityQue() {
        this.currentPriorityQueue.clear();
    }
}
