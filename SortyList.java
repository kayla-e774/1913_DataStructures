//
//  SORTY LIST. Skeleton program for CSci 1913 Project 2.
//
//    James Moen
//    07 Apr 17
//

//  SORTY LIST. A linked list of INT's that can be efficiently sorted.

class SortyList
{

//  NODE. A node in a singly linked linear list of INT's.

  private class Node
  {
    private int  key;   //  The INT.
    private Node next;  //  The next NODE in the list, or NULL.

//  Constructor. Make a NODE with KEY and NEXT.

    private Node(int key, Node next)
    {
      this.key  = key;
      this.next = next;
    }
  }

  private Node head;   //  Head NODE.
  private Node first;  //  First NODE in a list of NODEs.

//  SORTY LIST. Constructor. Make a list of NODEs that holds the INT arguments.
//  Also make a HEAD node for SORT to use.

  public SortyList()
  {
    head = new Node(0, null);
  }

  public SortyList(int first, int ... rest)
  {
    Node last = new Node(first, null);
    this.first = last;
    for (int index = 0; index < rest.length; index += 1)
    {
      last.next = new Node(rest[index], null);
      last = last.next;
    }
    head = new Node(0, null);
  }

//  SORT. Sort the list whose first NODE is FIRST. We can't make more NODEs but
//  we can change the NEXT slots of the existing NODEs.

  public SortyList sort()
  {
    first = sort(first);
    return this;
  }

//  Sort the list UNSORTED without making any new NODE's, and return the sorted
//  list.

    private Node sort(Node unsorted)
    {
        Node merged;
        Node left = unsorted;
        Node right;

        // testing --> Return when one or no elements remain (Base Case)
        if(left == null || left.next == null) {
            return unsorted;
        } 
        else {
            /*halving
            initialize pointers:
            lc and rc are left and right cursors, respectively
            left and right indicate point to the beginning nodes of the left and
            right lists.
            */
            right = left.next;
            Node h = left;
            Node rc = right;
            Node lc = left;
            boolean odd = true;

            // split lists into left and right until 'unsorted' ends
            while(lc != null && rc != null) {
                if (odd) {
                    lc = rc.next;
                    h.next = lc;
                    h = rc;
                }
                else {
                    rc = lc.next;
                    h.next = rc;
                    h = lc;
                }
                odd = !odd;
            }
        }
        //Sort: Recursive step
        left = sort(left);
        right = sort(right);
        //Merge: call to helper function
        merged = Merge(left, right);

        // return final ordered list
        return merged;
    }
  
  private void printme(Node list) {
      Node c = list;
      System.out.print("[");
      while (c != null) {
          System.out.print(c.key);
          System.out.print(", ");
          c = c.next;
      }
      System.out.println("]");
  }
  
    /*
    Merge: Helper function to complete merge step and to be called in sort 
    function.
    */ 
    private Node Merge(Node left, Node right) {
        // c is a cursor used to add the next value to the merged list.
        Node c;
        Node h = head;
        // choose first value in the merged list
        if (left.key <= right.key) {
            h.next = left;
            left = left.next;
        }
        else {
            h.next = right;
            right = right.next;
        }
        c = h.next;
        // continue choosing the smaller value until one of the lists is empty.
        while (left != null && right != null) {
            if (left.key <= right.key) {
                c.next = left;
                left = left.next;
                c = c.next;
            }
            else {
                c.next = right;
                right = right.next;
                c = c.next;
            }
        }
        // If a list is empty, add the rest of the other list to merged.
        if (left == null) {
            c.next = right;
        }
        else if(right == null) {
            c.next = left;
        }
        return h.next;
    }

//  TO STRING. Turn FIRST into a string for printing. If the list is empty then
//  the string is "[]". Otherwise it's "[K₁, K₂ ..., Kⱼ]" where the K's are the
//  KEYS from FIRST, in order of appearance.

  public String toString()
  {
    StringBuilder builder = new StringBuilder();
    builder.append('[');
    if (first != null)
    {
      Node temp = first;
      builder.append(temp.key);
      temp = temp.next;
      while (temp != null)
      {
        builder.append(", ");
        builder.append(temp.key);
        temp = temp.next;
      }
    }
    builder.append(']');
    return builder.toString();
  }

//  MAIN. Test SORTY LIST by running it on a few examples.

  public static void main(String[] args)
  {
    System.out.println(new SortyList()                            .sort());
    System.out.println(new SortyList(0)                           .sort());
    System.out.println(new SortyList(1, 0)                        .sort());
    System.out.println(new SortyList(2, 1, 0)                     .sort());
    System.out.println(new SortyList(9, 8, 7, 6, 5, 4, 3, 2, 1, 0).sort());
    System.out.println(new SortyList(5, 8, 4, 9, 0, 1, 2, 3, 7, 6).sort());
    // additional test to show sort works with duplicate elements
    System.out.println(new SortyList(5, 8, 4, 5, 0, 1, 2, 12, 1, 6).sort());
  }
}

/*
Outbut of main:
[]
[0]
[0, 1]
[0, 1, 2]
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
[0, 1, 1, 2, 4, 5, 5, 6, 8, 12]
*/