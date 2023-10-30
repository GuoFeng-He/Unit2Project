import java.util.Scanner;
public class LinearEquationLogic {
    Scanner scan;

    public LinearEquationLogic(){
        scan = new Scanner(System.in);
    }

    public void start(){
        getData();
    }

    private void getData(){
        System.out.print("Enter first coordinate point: ");
        String point1 = scan.nextLine();
        System.out.print("Enter second coordinate point: ");
        String point2 = scan.nextLine();

        int x1 = parseX(point1);
        int x2 = parseX(point2);

        // undefined slope check (freestyle)
        while (x1 == x2){
            System.out.println("The points you entered results in a line with an undefined slope");
            System.out.println("Please try again\n\n");
            System.out.print("Enter first coordinate point: ");
            point1 = scan.nextLine();
            System.out.print("Enter second coordinate point: ");
            point2 = scan.nextLine();

            x1 = parseX(point1);
            x2 = parseX(point2);
        }

        int y1 = parseY(point1);
        int y2 = parseY(point2);
        LinearEquation equation = new LinearEquation(x1, y1, x2, y2);
        System.out.println(equation.lineInfo());

        String yesNo = "";
        while (!yesNo.toLowerCase().equals("no")) {
            System.out.print("\nEnter a x value: ");
            double xInput = scan.nextDouble();
            System.out.println("Your corresponding coordinate is: " + equation.coordinateForX(xInput));
            System.out.print("Again? (yes/no): ");
            yesNo = scan.nextLine();
        }
    }

    private int parseX(String point){
        int commaIdx = point.indexOf(",");
        return Integer.parseInt(point.substring(1,commaIdx));
    }

    private int parseY(String point){
        int commaIdx = point.indexOf(",");
        return Integer.parseInt(point.substring(commaIdx + 2, point.length() - 1));
    }

}
