public class FamilyTree {
    Node root;
    private class Node{
        String name;
        Node father;
        Node mother;
        
        // constructor for private class
        private Node(String name, Node father, Node mother) {
            this.name = name;
            this.father = father;
            this.mother = mother;
        }
    }
    
    // constructor
    public FamilyTree(String ego) {
       root = new Node (ego, null, null);
    }
    
    private Node find(String name) {
        return find(name, root);
    }
    
    private Node find(String name, Node root) {
        Node f;
        Node m;
        // Base case: return null when 'top' of tree is reached
        if (root == null) {
            return null;
        }
        // check current node, return the node if it's name slot matches
        else if (root.name.equals(name)) {
            return root;
        }
        // recursion: check father and mother branches and begin again
        else {
            f = find(name, root.father);
            m = find(name, root.mother);
        }
        // if name isn't found in either branch, return null
        if (f == null && m == null) {
            return null;
        }
        // if found in father branch, return f
        if (f != null) {
            return f;
        }
        // otherwise, if found in mother branch, return m
        return m;
    }
    
    public void addParents(String ego, String father, String mother) {
        Node n = find(ego);
        // if node is found, set father and mother accordingly
        if (n != null) {
            n.mother = new Node(mother, null, null);
            n.father = new Node(father, null, null);
        }
        // throw error if not found
        else {
            throw new IllegalArgumentException("Ego doesn't exist.");
        }
    }
    
    public boolean isDescendant(String ego, String ancestor) {
        Node n = find(ego);
        Node a = find(ancestor);
        // if ego or ancestor do not exist in the tree, return false
        if (n == null || a == null) {
            return false;
        }
        // otherwise, call isDescendant (new root is at 'ego')
        return isDescendant(n, a);
    }
    
    public boolean isDescendant(Node root, Node ancestor) {
        // base case: if 'top' of tree is reached, return null
        if (root == null) {
            return false;
        }
        // check current node while going down the tree, if it matches the
        // ancestor node, return true
        else if (root == ancestor) {
            return true;
        }
        // recursive step: else check mother and father branches 
        else {
            boolean f = isDescendant(root.father, ancestor);
            boolean m = isDescendant(root.mother, ancestor);
            // if a match for ancestor is found in either branch, return true.
            if (f || m) {
                return true;
            }
        }
        // if a match for ancestor is not found, return false.
        return false;
    }
}
