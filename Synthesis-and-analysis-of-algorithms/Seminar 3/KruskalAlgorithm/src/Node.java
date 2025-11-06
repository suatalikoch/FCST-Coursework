public class Node {
    private String id;
    private double x;
    private double y;

    public Node(String id, double x, double y) {
        setId(id);
        setX(x);
        setY(y);
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    private void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    private void setY(double y) {
        this.y = y;
    }
}
