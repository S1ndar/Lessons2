package sixseven;

public class NewtonMethod {
    public static double NewTon(Function f, Function df, double y0, double x, int maxIt, double accuracy){
        double y = y0;
        double newY = 0;
        for (int i = 0; i < maxIt; i++){
            double Fxy = f.evaluate(x,y);
            double dFxy = df.evaluate(x,y);

            if (Math.abs(dFxy) < 1e-100){
                return 0;
            }
            newY = y - (Fxy/dFxy);
            System.out.println(newY);

            if (Math.abs(newY - y) < accuracy){
                return newY;
            }
            y = newY;
        }
        return newY;
    }
    public interface Function{
        double evaluate(double x, double y);
    }
    static void main() {
        Function f = (x, y) -> x * x + y * y - 10;
        Function df = (x,y) -> 2*x + 2*y;

        System.out.println(NewTon(f,df,3,7,100,0.0067));

    }
}

