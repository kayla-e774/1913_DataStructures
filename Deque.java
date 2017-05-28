class Deque<Base> {
    private class Node {
        private Base object;
        private Node right;
        private Node left;
        
        private Node(Base object, Node left, Node right) {
          this.object = object;
          this.left = left;
          this.right = right;
        }
    }
    private Node head;
    
    public Deque() {
        head = new Node(null, null, null);
        head.left = head;
        head.right = head;
    }
    
    public void enqueueFront(Base object) {
       Node n = new Node(object, head, head.right);
       head.right.left = n;
       head.right = n;
    }
    
    public void enqueueRear(Base object) {
        Node n = new Node(object, head.left, head);
        head.left.right = n;
        head.left = n;
    }
    
    public Base dequeueFront() {
        Base temp;
        if (isEmpty()) {
            throw new IllegalStateException("No hands on deque.");
        }
        else {
            temp = head.right.object;
            head.right = head.right.right;
            head.right.left = head;
        }
        return temp;
    }
    
    public Base dequeueRear() {
        Base temp;
        if (isEmpty()) {
            throw new IllegalStateException("No hands on deque.");
        }
        else {
            temp = head.left.object;
            head.left =head.left.left;
            head.left.right = head;
        }
        return temp;
    }
    
    public boolean isEmpty() {
        return head.right == head;
    }
}
