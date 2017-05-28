package polygon;

class Rectangle extends Polygon {
    int length;
    int width;
    
    public Rectangle(int length, int width) {
        super(4, length, width, length, width);
        this.length = length;
        this.width = width;
    }
    
    public int area() {
        return length * width;
    }
    
}
