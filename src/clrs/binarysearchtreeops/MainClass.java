package clrs.binarysearchtreeops;

public class MainClass {

    public static void main(String[] args) {

        /*Node root= new Node(10);

        root.left = new Node(4);
        root.right = new Node(17);
        root.left.left = new Node(1);
        root.left.right = new Node(5);
        root.right.left=new Node(16);
        root.right.right = new Node(21);*/


        Node root = new Node(25);

        root.left = new Node(15);
        root.right = new Node(50);
        root.parent = null;
        root.left.parent = root;
        root.right.parent = root;

        root.left.left = new Node(10);
        root.left.right = new Node(22);
        root.left.left.parent = root.left;
        root.left.right.parent = root.left;

        root.left.right.left = new Node(18);
        root.left.right.right = new Node(24);
        root.left.right.left.parent = root.left.right;
        root.left.right.right.parent = root.left.right;

        root.left.left.left = new Node(4);
        root.left.left.right = new Node(12);
        root.left.left.left.parent = root.left.left;
        root.left.left.right.parent = root.left.left;

        root.right.left = new Node(35);
        root.right.right = new Node(70);
        root.right.left.parent = root.right;
        root.right.right.parent = root.right;

        root.right.left.left = new Node(31);
        root.right.left.right = new Node(44);
        root.right.left.left.parent = root.right.left;
        root.right.left.right.parent = root.right.left;

        root.right.right.left = new Node(66);
        root.right.right.right = new Node(90);
        root.right.right.left.parent = root.right.right;
        root.right.right.right.parent = root.right.right;

        BSTreeUtility bstutil = new BSTreeUtility();
        /*Inorder:4 10 12 15 18 22 24 25 31 35 44 50 66 70 90
        bstutil.inorderTraversalUsingStack(root);
        bstutil.inorderTraversalWithouStackWitoutRecursion(root);

        bstutil.preorderRecursive(root);
        System.out.println();
        bstutil.inorderTraversal(root);
        System.out.println();
        bstutil.postorderRecursive(root);*/

        /*bstutil.search(root, 900);
        bstutil.minimum(root);
        bstutil.maximum(root);*/

        /*bstutil.successorOf(18,root);
        bstutil.predessorOf(18,root);*/

        //bstutil.inorderBySucessorLogic(root);
        //bstutil.insertNode(new Node(95),root);


        /*bstutil.print("before delete..");
        bstutil.inorderTraversalUsingStack(root);
        bstutil.delete(root, 25);
        bstutil.print("After deleting 25");
        bstutil.inorderTraversalUsingStack(root);*/

        bstutil.print("before ");
        bstutil.inorderTraversalUsingStack(root);
        bstutil.rotateRight(root,root.right.left);
        bstutil.print("After rotate");
        bstutil.inorderTraversalUsingStack(root);
    }
}
