public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    private double deltaX(){
        return (double) x2 - x1;
    }
    private double deltaY(){
        return (double) y2 - y1;
    }

    private double slope(){
        return roundToHundredth((deltaY() / deltaX()));
    }

    /* 3rd extra credit criteria (part 1): all slopes returned from this method are positive so the negative sign can
    get added before the slope in equation()*/
    // 4th extra credit criteria: all slopes returned are positive so a double negative will still make a positive slope
    private String fractionalSlope(){
        // 1st extra credit criteria: rounds slope to the nearest whole number if the fraction reduces to a whole number
        if (deltaY() % deltaX() == 0){
            return "" + (int) Math.abs((deltaY() / deltaX()));
        }
        return (int) Math.abs(deltaY()) + "/" + (int) Math.abs(deltaX());
    }

    private double distance(int x1, int y1, int x2, int y2){
        return roundToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }

    private String equation(){
        String baseEquation = "y = ";
        double yIntercept = yIntercept();
        String slopeSign = "";
        String slope = fractionalSlope();

        if (y2 == y1){
            return baseEquation + y1;
        }
        // 3rd extra credit criteria (part 2): this makes sure that the negative sign only gets placed before the slope
        if (slope() < 0){
            slopeSign = "-";
        }
        // 2nd extra credit criteria: 1 gets omitted if the slope is -1 or 1
        if (slope() == 1 || slope() == -1){
            slope = "";
        }
        baseEquation += slopeSign + slope + "x";
        /* 5th extra credit criteria: omits y-intercept if it's equal to 0 (y-intercept will not get concatenated if
        it's equal 0). If both the y intercept and slope are equal to 0, returns y = 0*/
        if (yIntercept == 0 && slope() == 0){
            return "y = 0";
        } else if (yIntercept < 0){                         // 6th extra credit criteria: only the negative sign will
            baseEquation += " - " + Math.abs(yIntercept);   // get printed if y-intercept is negative
        } else if (yIntercept > 0){
            baseEquation += " + " + yIntercept;
        }
        // returns the final equation!
        return baseEquation;
    }

    public String coordinateForX(double x){
        double yCoordinate = slope() * x + yIntercept();
        return "(" + x + ", " + yCoordinate + ")";
    }

    public double yIntercept(){
        return (y2 - x2 * slope());
    }

    private double roundToHundredth(double toRound){
        return Math.round(toRound * 100) / 100.;
    }

    public String lineInfo(){
        return "\n\nThe two points are: (" + x1 + ", " + y1 + ")" + " and (" + x2 + ", " + y2 + ")" + "\n" +
                "The equation of the line between these points is: " + equation() + "\n" +
                "The slope of this line is: " + slope() + "\n" +
                "The y-intercept of this line is: " + yIntercept() + "\n" +
                "The distance between these points is " + distance(x1, y1, x2, y2);
    }

}
