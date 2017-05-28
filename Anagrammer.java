package project3;

public class Anagrammer {
    public static void main(String[] args) {
        Words book = new Words("C:\\Users\\kenge\\1913\\project3\\src\\project3\\skylight.txt");
        AnagramTree test = new AnagramTree();
        
        String word;
        while(book.hasNext()) {
            word = book.next();
            test.add(word);
        }
        
        test.anagrams();
    }
}
