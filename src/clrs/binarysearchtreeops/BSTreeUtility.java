package clrs.binarysearchtreeops;

import java.util.Stack;

public class BSTreeUtility {

    /**
     * Inorder tree traversal using the Stack
     *
     * @param node
     */

    public void inorderTraversalUsingStack(Node node) {
        Stack<Node> stack = new Stack<Node>();
        while (true) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()) {
                Node temp = stack.pop();
                System.out.print(temp.key + " ");
                node = temp.right;
            }
            else
                break;
        }
    }

    /**
     * Algorithm
     * Step-1: For the current node check whether it has a left child which is not there in the visited list. If it has then go to step-2 or else step-3.
     * Step-2: Put that left child in the list of visited nodes and make it your current node in consideration. Go to step-6
     * Step-3: Print the node and If node has right child then go to step 4 else go to step 5
     * Step-4: Make right child as current node.
     * Step-5:if there is a thread node then make it the current node.
     * Step-6: if all nodes have been printed then END else go to step 1
     */

    public void inorderTraversalWithouStackWitoutRecursion(Node node) {
//TODO  Threaded binary Tree understanding is required

    }


    public void preorderRecursive(Node root) {
        if (root ==null)
            return;
        System.out.print(root.key + " ");
        preorderRecursive(root.left);
        preorderRecursive(root.right);
    }

    public void postorderRecursive(Node root) {
        if (root ==null)
            return;
        postorderRecursive(root.left);
        postorderRecursive(root.right);
        System.out.print(root.key + " ");
    }

    public void inorderRecursive(Node root) {
        if (root == null)
            return;
        postorderRecursive(root.left);
        System.out.print(root.key + " ");
        postorderRecursive(root.right);
    }

    public Node search(Node node, Integer key){

        while (node != null) {
            if (key == node.key) {
                System.out.println("Key found in tree..");
                return node;
            }
            if (key > node.key)
                node = node.right;
            else
                node = node.left;
        }

        System.out.println("Key not found in tree..");
        return node;
    }

    public Node minimum(Node root){
        //int min=0;
        while (root.left != null)
        {
            //min = root.key;
            root = root.left;
        }
        System.out.println("Minimum is :"+ root.key);
        return root;
    }


    public Node maximum(Node root){

        while (root.right != null){
            root = root.right;
        }
        System.out.println("Maximum is :" + root.key);
        return root;
    }


    public Node successorOf(Integer item, Node root){
        Node node = search(root,item);

        if(node.right != null) {
            Node successor = minimum(node.right);
            System.out.println("Successor of "+ item + " is "+ successor.key);
            return successor;
        }
        Node ancestorSuccessorNode = node.parent;
        while(ancestorSuccessorNode != null && node == ancestorSuccessorNode.right){
            node = ancestorSuccessorNode;
            ancestorSuccessorNode = ancestorSuccessorNode.parent;
        }
        System.out.println("Successor of "+ item + " is "+ ancestorSuccessorNode.key);
        return ancestorSuccessorNode;
    }


    public Node predessorOf(Integer item, Node root){
        Node node = search(root,item);

        if(node.left != null) {
            Node predessor = minimum(node.left);
            System.out.println("Predessor of "+ item + " is "+ predessor.key);
            return predessor;
        }
        Node ancestorPredessorNode = node.parent;
        while(ancestorPredessorNode != null && node == ancestorPredessorNode.left){
            node = ancestorPredessorNode;
            ancestorPredessorNode = ancestorPredessorNode.parent;
        }
        System.out.println("Predessor of "+ item + " is "+ ancestorPredessorNode.key);
        return ancestorPredessorNode;
    }


    public void inorderBySucessorLogic(Node root){

        Node node = minimum(root);
        System.out.print("Inorder by minimum and n-1 successor:" + node.key + " ");

        Node currentSuccessor = node;
        while (currentSuccessor != null){
            currentSuccessor = successorOf(currentSuccessor.key, root);
            System.out.print( currentSuccessor.key + " ");
        }
    }

    public void insertNode(Node newNode, Node root){

        Node node = root;
        Node nodeToAddNewNode=null;
        while(node != null){

            nodeToAddNewNode = node;
            if (node.key > newNode.key){
                node = node.left;
            }
            else{
                node = node.right;
            }
        }

        if (nodeToAddNewNode == null){
            root = newNode;
            return;
        }
        newNode.parent = nodeToAddNewNode;

        if (newNode.key > nodeToAddNewNode.key)
            nodeToAddNewNode.right = newNode;
        else
            nodeToAddNewNode.left = newNode;
    }


    public void delete(Node root, int item){

        Node node= search(root,item);

        //node dont have any child
        if(isLeafNode(node)) {
            removeLeaf(node);
            return;
        }

        //node dont have right child
        if (ifThereIsNoRightSubTree(node)){
            if (isThisNodeRightSubTreeNode(node)){
                replaceRootRightWithLeftSubTree(node);
            }
            else {
                replaceRootLeftWithLeftSubTree(node);
            }
            return;
        }
        //node dont have left child
        if (ifThereIsNoLeftSubTree(node)){

            if (isThisNodeLeftSubTreeNode(node))
                replaceRootLeftWithRightSubTree(node);
            else
                replaceRootRightWithRightSubTree(node);

            return;
        }

        //node have left and right child
        Node successorNode = minimum(node.right);

        //successor node dont have childrens
        if (isLeafNode(successorNode)) {
            node.key = successorNode.key;
            removeLeaf(successorNode);
            return;
        }

        if (successorNode.right != null) {
            //successor have right child
            successorNode.parent.left = successorNode.right;

            if (isThisNodeLeftSubTreeNode(node)) {
                node.parent.left = successorNode;
            } else {
                node.parent.right = successorNode;
            }
            successorNode.left = node.left;
            successorNode.right = node.right;
        }
    }

    private void replaceRootLeftWithLeftSubTree(Node node) {
        node.parent.left = node.left;
    }

    private void replaceRootRightWithLeftSubTree(Node node) {
        node.parent.right = node.left;
    }

    private void replaceRootRightWithRightSubTree(Node node) {
        node.parent.right = node.right;
    }

    private void replaceRootLeftWithRightSubTree(Node node) {
        node.parent.left = node.right;
    }

    private boolean isThisNodeLeftSubTreeNode(Node node) {
        return node.parent.left==node;
    }

    private boolean ifThereIsNoLeftSubTree(Node node) {
        return node.left ==null;
    }

    private boolean ifThereIsNoRightSubTree(Node node) {
        return node.right == null;
    }

    private boolean isThisNodeRightSubTreeNode(Node node) {
        return node.parent.right == node;
    }

    private void removeLeaf(Node node) {
        if (isLeftSubTreeRootNode(node)) {
            removeLeftSubTree(node);
        } else {
            removeRightSubTree(node);
        }
    }

    private void removeRightSubTree(Node node) {
        node.parent.right = null;
    }

    private void removeLeftSubTree(Node node) {
        node.parent.left = null;
    }

    private boolean isLeftSubTreeRootNode(Node node) {
        return node.parent.left == node;
    }

    private boolean isLeafNode(Node node) {
        return node.left == null && node.right == null;
    }

    public void print(String str){
            System.out.println(str);
    }

}
