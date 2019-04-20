public class Circle extends Figure implements Print {
    private double radius;
    public Circle(double radius){
        if(radius<=0){
            throw new IllegalArgumentException("Illegal Argument!");

        }
        this.radius=radius;
        System.out.println("Created a circle!");
    }
    @Override
    double calculateArea(){
        return Math.PI*Math.pow(radius,2);
    }
    @Override
    double calculatePerimeter(){
        return 2*Math.PI*radius;
    }
    @Override
    public void print(){
        //System.out.println("Circle area: "+calculateArea()+", perimeter: "+calculatePerimeter());
        System.out.println(String.format("Circle area: %f, perimeter: %f" ,calculateArea(),calculatePerimeter()));
    }
}
