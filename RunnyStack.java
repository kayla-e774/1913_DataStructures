package lab8;

public class RunnyStack<Base> {
    private class Run { 
        private Base object;
        private int length;
        private Run next;
        private Run(Base object, int length, Run next) {
            this.object = object;
            this.length = length;
            this.next = next;
        }
    }
    private Run top;
    private int run_count;
    private int length_count;
    
    public RunnyStack() {
        top = null;
        run_count = 0;
        length_count = 0;
    }
    
    public int depth() {
        return length_count;
    }
    
    public boolean isEmpty() {
        return (top == null);
    }
    
    private boolean isEqual(Object ob_one, Object ob_two) {
        boolean a;
        if (ob_one == null) {
            a = (ob_two == null);
        }
        else {
            a = (ob_one.equals(ob_two));
        }
        return a;
    }
    
    public Base peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        else {
            return (top.object);
        }
    }
    
    public void pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        else {
            top.length -= 1;
            length_count -= 1;
            if (top.length == 0) {
                run_count -= 1;
                top = top.next;
            }
        }
    }
    
    public void push(Base object) {
        if (isEmpty()) {
            top = new Run(object, 1, top);
            length_count++;
            run_count++;
        }
        else if (!isEqual(object, top.object)) {
            top = new Run(object, 1, top);
            length_count++;
            run_count++;
        }
        else {
            top.length++;
            length_count++;
        }
    }
    
    public int runs() {
       return  run_count;
    }
}