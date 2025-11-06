public class Link implements Comparable<Link> {
    private Node startNode;
    private Node endNode;

    public Link(Node startNode, Node endNode) {
        setStartNode(startNode);
        setEndNode(endNode);
    }

    private double getHalfHaversine(double startLongitude, double startLatitude, double endLongitude, double endLatitude) {
        double startRadianLatitude = startLatitude * Math.PI / 180;
        double endRadianLatitude = endLatitude * Math.PI / 180;

        double deltaRadianLatitude = (endLatitude - startLatitude) * Math.PI / 180;
        double deltaRadianLongitude = (endLongitude - startLongitude) * Math.PI / 180;

        return Math.pow(Math.sin(deltaRadianLatitude / 2), 2) + Math.cos(startRadianLatitude) * Math.cos(endRadianLatitude) * Math.pow(Math.sin(deltaRadianLongitude / 2), 2);
    }

    public double getWeight() {
        final double earthRadius = 6371.0;

        double startLongitude = getStartNode().getX();
        double startLatitude = getStartNode().getY();

        double endLongitude = getEndNode().getX();
        double endLatitude = getEndNode().getY();

        double halfHaversine = getHalfHaversine(startLongitude, startLatitude, endLongitude, endLatitude);
        double angularRadianDistance = 2 * Math.atan2(Math.sqrt(halfHaversine), Math.sqrt(1 - halfHaversine));

        return earthRadius * angularRadianDistance;
    }

    @Override
    public int compareTo(Link other) {
        return Double.compare(getWeight(), other.getWeight());
    }

    public Node getStartNode() {
        return startNode;
    }

    private void setStartNode(Node startNode) {
        this.startNode = startNode;
    }

    public Node getEndNode() {
        return endNode;
    }

    private void setEndNode(Node endNode) {
        this.endNode = endNode;
    }
}
