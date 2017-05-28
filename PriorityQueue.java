package lab13;
public class PriorityQueue<Base> {
    private class Node {
        private Base object;
        private int rank;
        private Node left;
        private Node right;
        
        private Node(Base object, int rank) {
            this.object = object;
            this.rank = rank;
            left = null;
            right = null;
        }
    }
    
    Node head;
    
    public PriorityQueue() {
        head = new Node(null, 4);
    }
    
    public Base dequeue() {
        Node subtree;
        if (isEmpty()) {
            throw new IllegalStateException("MTQ");
        }
        else {
            if (head.left != null) {
                subtree = head.left;
            }
            else {
                subtree = head.right;
            }
            Node temp = head;
            Base obj;
            while (subtree.left != null) {
                temp = subtree;
                subtree = subtree.left;
            }
            obj = subtree.object;
            if (subtree.right != null) {
                if (temp.left == null) {
                    temp.right = subtree.right;
                }
                else {
                    temp.left = subtree.right;
                }
            }
            else {
                temp.left = null;
            }
            return obj;
            
        }
    }
    
    public void enqueue(Base object, int rank) {
        Node root = head;
        if(rank < 0) {
            throw new IllegalArgumentException("No negative ranks.");
        }
        else if (root == null) {
            root = new Node(object, rank);
        }
        else {
            Node subtree = root;
            while(true) {
                if (rank <= subtree.rank) {
                    if(subtree.left == null) {
                        subtree.left = new Node(object, rank);
                        //System.out.print(subtree.left.object);
                        //System.out.println();
                        return;
                    }
                    else subtree = subtree.left;
                }
                else {
                    if(subtree.right == null) {
                        subtree.right = new Node(object,rank);
                        //System.out.print(subtree.right.object);
                        //System.out.println();
                        return;
                    }
                    else {
                        subtree = subtree.right;
                    }
                }
            }
        }
    }
    
    public boolean isEmpty() {
        return head.left == null && head.right == null;
    }
}
