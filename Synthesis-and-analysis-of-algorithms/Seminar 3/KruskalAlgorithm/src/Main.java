import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Node> nodes = List.of(
                new Node("Sofia", 42.6954026, 23.2415465),
                new Node("Plovdiv", 42.1441135, 24.6996748),
                new Node("Haskovo", 41.9327694, 25.507459),
                new Node("Burgas", 42.5264924, 27.3695656),
                new Node("Stara Zagora", 42.4192478, 25.5836623)
        );

        int size = nodes.size();

        List<Link> links = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                links.add(new Link(nodes.get(i), nodes.get(j)));
            }
        }

        Collections.sort(links);
        printLinks(links);
    }

    private static void printLinks(List<Link> links) {
        for (Link link : links) {
            String startNodeName = link.getStartNode().getId().toUpperCase().substring(0, 3);
            String endNodeName = link.getEndNode().getId().toUpperCase().substring(0, 3);

            System.out.printf("[%s <-> %s] -> Distance: %.2f%n", startNodeName, endNodeName, link.getWeight());
        }
    }
}