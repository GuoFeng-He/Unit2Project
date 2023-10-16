public class LinearEquation {
    int x1;
    int y1;
    int x2;
    int y2;

    public LinearEquation(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    private double slope(){
        return (double) (y2 - y1) / (x2 - x1);
    }


}
