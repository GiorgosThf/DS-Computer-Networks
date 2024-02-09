package computernetworks.model.records;

public record Node(String name) {

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                '}';
    }
}