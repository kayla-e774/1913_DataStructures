package zillion;

class Zillion {
    int[] ar;
    int num;
    
    //constructor
    public Zillion(int size) {
        num = size;
        ar = new int[num];
    }
    
    public void increment() {
        if (num == 0) {
            num = 0;
        }
        else {
            if (ar[ar.length - 1] < 9) {
                ar[ar.length - 1] += 1;
            }
            else {
                if (ar[ar.length - 1] == 9) {
                    int i = (ar.length - 1);
                    
                    while((i >= 0) && (ar[i] == 9)) {
                       ar[i] = 0;
                       i -= 1;
                    }
                    
                    if (i < 0) {
                        ar[ar.length - 2] = 0;
                    }
                    else {
                        ar[i] += 1;
                    }
                }
            }
          
        }
    }
    
    
    public String toString() {
        String x = "";
        
        for(int i=0; i < ar.length; i++) {
            x += ar[i];
        }
        return x;
    }
}