import java.util.Scanner;
import static java.lang.System.exit;
public class MainClass {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("MENU:");
            System.out.println("1.Select figure,Enter Data and Print.");
            System.out.println("2.Exit");
            System.out.println("Choose option (1,2..):  ");
            try {
                String option = input.next();
                switch (option) {
                    case "1": {
                        System.out.println("1.Select figure, Enter Data and Print.");
                        System.out.println("Choose option ('Triangle', 'Square', 'Circle'): ");
                        String figure = input.next();
                        switch (figure.toLowerCase()) {
                            case "triangle": {
                                System.out.println("Enter data (a,b,c):  ");
                                double a = input.nextDouble();
                                double b = input.nextDouble();
                                double c = input.nextDouble();
                                Triangle triangle = new Triangle(a, b, c);
                                triangle.print();
                                break;
                            }
                            case "square": {
                                System.out.println("Enter data (side):  ");
                                int side = input.nextInt();
                                Square square = new Square(side);
                                square.print();
                                break;
                            }
                            case "circle": {
                                System.out.println("Enter data (radius):  ");
                                int radius = input.nextInt();
                                Circle circle = new Circle(radius);
                                circle.print();
                                break;
                            }
                            default:
                                throw new IllegalArgumentException();

                        }
                        break;
                    }
                    case "2": {
                        System.out.println("2.Exit");
                        System.out.println("Closing...");
                        exit(0);
                    }
                    default:
                        throw new IllegalArgumentException();

                }
            }
            catch(IllegalArgumentException e){
                System.out.println("Illegal Argument! Try again!");
            }
        }
    }
}

