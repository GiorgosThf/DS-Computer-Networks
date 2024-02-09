package computernetworks.algorithm;




import computernetworks.model.records.Edge;
import computernetworks.model.records.Node;

import java.util.Map;
import java.util.PriorityQueue;

public interface DistanceAlgorithm {
    Map<Node, Integer> runAlgorithm();
    boolean filterDistance(final Edge edge);
     void addDistance(final Edge edge);
    void setCurrentPriorityQueue(final PriorityQueue<Node> currentPriorityQueue) ;
    void setCurrentDistance(final Map<Node, Integer> currentDistance) ;
    void clearCurrentDistance();
    void clearPriorityQue();
}
