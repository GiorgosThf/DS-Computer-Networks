package computernetworks.model.records;

public record Edge(Node source, Node destination, int weight) {

    @Override
    public String toString() {
        return "Edge{" +
                "source=" + source +
                ", destination=" + destination +
                ", weight=" + weight +
                '}';
    }
}