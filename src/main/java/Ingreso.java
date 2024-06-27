public class Ingreso {
    long tMinTotal = System.currentTimeMillis() / (60 * 1000);
    int tMinCurrent = (int) (tMinTotal % (24 * 60));
    int hours = tMinCurrent / 60;
    int minutes = tMinCurrent % 60;


}
