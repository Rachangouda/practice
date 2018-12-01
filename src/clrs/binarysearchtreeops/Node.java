package clrs.binarysearchtreeops;

public class Node {
    public Node(Integer key) {
        this.key = key;
    }

    public Integer key;
    Node left;
    Node right;
    Node parent;
}
