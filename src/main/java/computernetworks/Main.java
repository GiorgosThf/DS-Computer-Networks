package computernetworks;


import computernetworks.algorithm.*;
import computernetworks.model.AccessPoint;
import computernetworks.model.PacketTransmission;
import computernetworks.model.Service;
import computernetworks.model.Signal;
import computernetworks.model.graphs.BellmanFordGraph;
import computernetworks.model.graphs.DijkstraGraph;
import computernetworks.model.interfaces.Graph;
import computernetworks.model.records.Node;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose a showcase to start:");
            System.out.println("1. Bellman-Ford Algorithm");
            System.out.println("2. Dijkstra's Algorithm");
            System.out.println("3. Delay in Networks");
            System.out.println("4. Packets and Information Flows");
            System.out.println("5. Transmission Rates in Networks");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> showCaseBellmanFord(scanner);
                case 2 -> showCaseDijkstra(scanner);
                case 3 -> showCaseDelayInNetworks(scanner);
                case 4 -> showCasePacketsAndInformationFlows(scanner);
                case 5 -> showCaseTransmissionRatesInNetworks(scanner);
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private static void showCaseBellmanFord(Scanner scanner) {
        System.out.print("Enter the number of nodes: ");
        int numNodes = scanner.nextInt();
        scanner.nextLine();

        Graph graph = new BellmanFordGraph(numNodes);
        List<Node> nodeList = new ArrayList<>();

        for (int i = 0; i < numNodes; i++) {
            System.out.print("Enter the name of node " + i + ": ");
            String nodeName = scanner.nextLine();
            Node node = new Node(nodeName);
            graph.addNode(node);
            nodeList.add(node);
        }

        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numEdges; i++) {
            System.out.print("Enter start node for edge " + (i) + ": ");
            String startNodeName = scanner.next();
            System.out.print("Enter end node for edge " + (i) + ": ");
            String endNodeName = scanner.next();
            System.out.print("Enter cost for edge " + (i) + ": ");
            int cost = scanner.nextInt();

            try {
                graph.addEdge(graph.getNode(startNodeName), graph.getNode(endNodeName), cost);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                i--;
            }
        }

        System.out.print("Enter the starting node name: ");
        String startingNodeName = scanner.next();

        final String shortestPaths;
        try {
            shortestPaths = new BellmanFordDistanceAlgorithm(graph, graph.getNode(startingNodeName)).runAlgorithm().toString();
            System.out.println("BellmanFord -> Shortest paths from " + startingNodeName + ": " + shortestPaths);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showCaseDijkstra(Scanner scanner) {
        System.out.print("Enter the number of nodes: ");
        int numNodes = scanner.nextInt();
        scanner.nextLine();

        Graph graph = new DijkstraGraph(numNodes);
        List<Node> nodeList = new ArrayList<>();

        for (int i = 0; i < numNodes; i++) {
            System.out.print("Enter the name of node " + i + ": ");
            String nodeName = scanner.nextLine();
            Node node = new Node(nodeName);
            graph.addNode(node);
            nodeList.add(node);
        }

        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numEdges; i++) {
                System.out.print("Enter start node for edge " + (i) + ": ");
                String startNodeName = scanner.next();
                System.out.print("Enter end node for edge " + (i) + ": ");
                String endNodeName = scanner.next();
                System.out.print("Enter cost for edge " + (i) + ": ");
                int cost = scanner.nextInt();

                try {
                    graph.addEdge(graph.getNode(startNodeName), graph.getNode(endNodeName), cost);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    i--;
                }
            }

        System.out.print("Enter the starting node name: ");
        String startingNodeName = scanner.next();

        final String shortestPaths;
        try {
            shortestPaths = new DijkstraDistanceAlgorithm(graph, graph.getNode(startingNodeName)).runAlgorithm().toString();
            System.out.println("Dijkstra -> Shortest paths from " + startingNodeName + ": " + shortestPaths);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showCaseDelayInNetworks(Scanner scanner){
        System.out.println("Enter the Bit Rate:");
        double bitRate = scanner.nextDouble();

        System.out.println("Enter the Packet Size:");
        int packetSize = scanner.nextInt();

        System.out.println("Enter the Propagation Delay:");
        double propDelay = scanner.nextDouble();

        System.out.println("Select a bit to calculate delivery time:");
        int selectedBit = scanner.nextInt();

       System.out.println("Computing....");

       final PacketTransmission packetTransmission =
                PacketTransmission.PacketTransmissionBuilder.aPacketTransmission()
                        .withBitRate(bitRate)
                        .withPacketSize(packetSize)
                        .withPropagationDelay(propDelay)
                        .build();

        final DelayInNetworks delayInNetworks = new DelayInNetworks(packetTransmission);

        System.out.println("Total delivery time of package: "+ delayInNetworks.getTotalDeliveryTime());
        System.out.println("Delivery time of bit 2 : " + delayInNetworks.getBitDeliveryTime(selectedBit));
    }

    private static void showCasePacketsAndInformationFlows(Scanner scanner){
        System.out.println("Enter the minimum Signal Value:");
        int minSignalValue = scanner.nextInt();

        System.out.println("Enter the maximum Signal Value:");
        int maxSignalValue = scanner.nextInt();

        System.out.println("Enter the quantization level:");
        int quantizationLevel = scanner.nextInt();

        System.out.println("Enter the number of signal Values: ");
        int signalValues = scanner.nextInt();
        List<Double> values = new ArrayList<>();

        for ( int i=0; i<signalValues; i++){
            System.out.println("Enter" + i + "signal value: ");
            double value = scanner.nextInt();
            values.add(value);

        }
        System.out.println("Computing....");
        final Signal signal = Signal.SignalBuilder.aSignal()
                .withMinimumSignalValue(minSignalValue)
                .withMaximumSignalValue(maxSignalValue)
                .withQuantizationLevel(quantizationLevel)
                .withSignalValues(values)
                .build();

        final PacketsAndInformationFlows packetsAndInformationFlows = new PacketsAndInformationFlows(signal);

        System.out.println("Quantization of signal: " + packetsAndInformationFlows.quantizeSignal());
    }

    private static void showCaseTransmissionRatesInNetworks(Scanner scanner){
        System.out.println("Enter number of services: " );
        int numServices = scanner.nextInt();
        System.out.println("Enter the access point capacity (CapX): ");
        int capacity = scanner.nextInt();

        List<Service> services = new ArrayList<>();

        for (int i=0; i< numServices; i++){
            System.out.println("Enter service name:");
            String serviceName = scanner.next();

            System.out.println("Enter sample size (Ns):");
            int sampleSize = scanner.nextInt();

            System.out.println("Enter sampling rate  (FSs):");
            int samplingRate = scanner.nextInt();

            services.add(
                    Service.ServiceBuilder.aService()
                            .withName(serviceName)
                            .withSampleSize(sampleSize)
                            .withSamplingRate(samplingRate)
                            .build()
            );
        }

        System.out.println("Computing....");
        final AccessPoint accessPoint =
                AccessPoint.AccessPointBuilder.anAccessPoint()
                        .withNumberOfServices(numServices)
                        .withServicesList(services)
                        .withAccessPointCapacity(capacity)
                        .build();

        TransmissionRatesInNetworks ratesInNetworks = new TransmissionRatesInNetworks(accessPoint);

        System.out.println("Minimum Access point for services: "+ ratesInNetworks.calculateMinimumAccessPoints());
    }
}
