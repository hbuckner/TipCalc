package sample;
import sample.Main;

public class doWork {
    double newTotal;
    public void setTotal(double Total){
        newTotal=Total;
    }
    public  double getTotal(){
        return newTotal;
    }
    public  double Total(double payment, double tip){
        double tempTotal = (payment*tip)+payment;
        return tempTotal;
    }
}
