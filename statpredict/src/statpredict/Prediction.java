package statpredict;
import java.util.*;

public class Prediction {

	private User owner;
	private int deciPrice;
	
	public Prediction(User u, int price) {
		setPrice(price);
		owner = u;
	}

	public int truePrice(){
		return getPrice();
	}
	
	public int falsePrice(){
		return 1000-getPrice();
	}
	
	public User owner(){
		return owner;
	}

	public int getPrice() {
		return deciPrice;
	}

	public void setPrice(int deciPrice) {
		this.deciPrice = deciPrice;
	}
}
