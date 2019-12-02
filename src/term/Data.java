package term;
import java.util.*;

public class Data {
	double bound;
	double weight;
	double value;
	double price;
	double time;
	int seatNumber;
	boolean removeState = false;
	LinkedList<SeatCondition> seatRecord = new LinkedList<SeatCondition>();
	int index;
	LinkedList<SeatCondition> seatList;
	
	public Data(double bound, double weight, double value)
	{
		this.bound = bound; this.weight = weight; this.value = value;
	}
    public void calculateInitialValue(double time, double price)
    {
    	this.time = time; this.price = price;
    	this.value = ((30/(this.time+1))/10)*(this.price/1000)*this.weight;
    }
   
}
