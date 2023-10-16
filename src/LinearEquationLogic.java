import java.util.Scanner;
public class LinearEquationLogic {
    Scanner scan;

    public LinearEquationLogic(){
        scan = new Scanner(System.in);
    }

    public void start(){

    }

    private void getData(){
        System.out.print("Enter first coordinate point: ");
        String point1 = scan.nextLine();
        System.out.print("Enter second coordinate point: ");
        String point2 = scan.nextLine();

        int x1 = parseX(point1);
        int y1 = parseY(point1);
        int x2 = parseX(point2);
        int y2 = parseY(point2);
        LinearEquation equation = new LinearEquation(x1, y1, x2, y2);
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
