package BT_Dong_goi_thu_vien_giai_PTB2;

public class GiaiPhuongTrinhBacHai {
    public static double[] resolve(double a, double b, double c) {
        double[] results = new double[2];
        double delta = b * b - 4 * a * c;
        if(delta > 0) {
            double x_1 = (-b - Math.sqrt(delta) / (2*a));
            double x_2 = (-b + Math.sqrt(delta) / (2*a));
            results[0] = x_1;
            results[1] = x_2;
        }
        else if(delta == 0) {
            double x = -b / (2 * a);
            results[0] = x;
            results[1] = x;
        }
        else    return null;
        return results;
    }
}
