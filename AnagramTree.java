package project3;

public class AnagramTree {
    private class TreeNode {
        private byte[] summary;
        private WordNode words;
        private TreeNode left;
        private TreeNode right;
        
        private TreeNode(String word, byte[] summary) {
            this.words = new WordNode(word, null);
            this.summary = summary;
            this.right = null;
            this.left = null;
        }
    }
    
    private class WordNode {
        private String word;
        private WordNode next;
        
        private WordNode(String word, WordNode next) {
            this.word = word;
            this.next = next;
        }
    }
    
    TreeNode head;
    
    public AnagramTree() {
        head = new TreeNode(null, new byte[26]);
    }
    
    public void add(String word) {
        TreeNode subtree = head;
        TreeNode add_node = new TreeNode(word, stringToSummary(word));
        
        while(true) {
            if(compareSummaries(add_node.summary, subtree.summary) < 0) {
                if(subtree.left == null) {
                    subtree.left = add_node;
                    return;
                }
                else {
                    subtree = subtree.left;
                }
            }
            else if (compareSummaries(add_node.summary, subtree.summary) > 0) {
                if(subtree.right == null) {
                    subtree.right = add_node;
                    return;
                }
                else {
                    subtree = subtree.right;
                }
            }
            else {
                if(!isIn(word, subtree.words)) {
                    add_node.words.next = subtree.words;
                    subtree.words = add_node.words;
                }
                return;
            }
        }
    }
    
    private boolean isIn(String word, WordNode start) {
        boolean in = false;
        
        while(start != null) {
            if(word.equals(start.word)) {
                in = true;
                break;
            }
            start = start.next;
        }
        return in;
    }
    
    private void help(TreeNode subtree) {
        if (subtree != null) {
            
            if (subtree.words.next != null) {
                WordNode c_wn = subtree.words;
                
                while (c_wn != null) {
                    System.out.print(c_wn.word + " ");
                    c_wn = c_wn.next;
                }
                System.out.println();
            }
            help(subtree.left);
            help(subtree.right);
        }
    }
    
    public void anagrams() {
        help(head.right);
    }
    
    private int compareSummaries(byte[] left, byte[] right) {
        int index = 0;
        int diff = 0;
        
        while(index < left.length && index < right.length) {
            if (left[index] == right [index]) {
                index ++;
            }
            else {
                diff = left[index] - right[index];
                break;
            }
        }
        return diff;
    }
    
    private byte[] stringToSummary(String word) {
        int place;
        char letter;
        byte[] summary = new byte[26];
        
        for(int i = 0; i < word.length(); i++) {
            letter = word.charAt(i);
            place = (letter - 'a');
            summary[place]++;
        }
        return summary;
    }
}