package lab9;

public class AssociationList<Key, Value> {
    private class Node{
        private Key key;
        private Value value;
        private Node next;
        
        private Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.next = first;
        }
    }
    
    private Node first;
    
    public AssociationList(){
        first = null;
    }
    
    public Value get(Key key) {
        Node start;
        if(!isIn(key)) {
            throw new IllegalArgumentException("Key not in AssociationList!");
        }
        else {
            start = first;
            while (!isEqual(start.key, key)) {
                start = start.next;
            }
        }
        return start.value;
    }
    
    private boolean isEqual(Key leftKey, Key rightKey) {
        if (leftKey == null) {
            return (rightKey == null);
        }
        else {
            return (leftKey.equals(rightKey));
        }
    }
    
    public boolean isIn(Key key) {
        Node start = first;
        boolean in = false;
        while (!in) {
            if (start == null) {
                break;
            }
            else if (isEqual(start.key, key)) {
                in = true;
                break;
            }
            else {
                start = start.next;
            }
        }
        return in;
    }
    
    public void put (Key key, Value value) {
        Node start = first;
        boolean found = false;
        while (!found) {
            if(start == null) {
                break;
            }
            else if (isEqual(key, start.key)) {
                start.value = value;
                break;
            }
            else {
                start = start.next;
            }
        }
        if (!found) {
            Node NewNode = new Node(key, value);
            first = NewNode;
        }
    }
}
