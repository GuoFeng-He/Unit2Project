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

    public double slope(){
        return roundToHundredth(((double) y2 - y1) / (x2 - x1));
    }

    private double distance(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private String equation(){
        if (y2 == y1){
            return "y=" + y1;
        }
        return "y=" + slope() + "x+" + yIntercept();
    }

    public double yIntercept(){
        return (y2 - x2 * slope());
    }

    private double roundToHundredth(double toRound){
        return Math.round(toRound * 100) / 100.;
    }

}
