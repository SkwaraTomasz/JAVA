public class Square extends Figure implements Print {
    private double side;
    public Square(double side){
        if (side <=0) {
            throw new IllegalArgumentException("Illegal Argument!");
        }
        this.side=side;
        System.out.println("Created a square!");
    }
    @Override
    double calculateArea() {
        return side*side;
    }
    @Override
    double calculatePerimeter(){
        return 4*side;
    }

    @Override
    public void print() {
        //System.out.println("Square area: "+calculateArea()+", perimeter: "+calculatePerimeter());
        System.out.println(String.format("Square area: %f, perimeter: %f" ,calculateArea(),calculatePerimeter()));
    }
}
