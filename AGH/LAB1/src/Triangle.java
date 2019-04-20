public class Triangle extends Figure implements Print{
    private double sideA,sideB,sideC;

    public Triangle(double sideA, double sideB,double sideC){
        if (sideA <= 0 || sideB <= 0 || sideC <= 0 || sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA){
            throw new IllegalArgumentException("Illegal Argument!");
        }

        this.sideA=sideA;
        this.sideB=sideB;
        this.sideC=sideC;
        System.out.println("Created a triangle!");
    }


    @Override
    double calculateArea() {
        return Math.sqrt((sideA+sideB+sideC)*(sideA+sideB-sideC)*(sideA-sideB+sideC)*(-sideA+sideB+sideC))/4;
    }

    @Override
    double calculatePerimeter() {
        return sideA+sideB+sideC;
    }

    @Override
    public void print() {
        //System.out.println("Triangle area: "+calculateArea()+", perimeter: "+calculatePerimeter());
        System.out.println(String.format("Triangle area: %f, perimeter: %f" ,calculateArea(),calculatePerimeter()));
    }
}
