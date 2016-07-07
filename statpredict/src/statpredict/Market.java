package statpredict;
import java.io.*;
import java.util.*;

public class Market {

	User owner;
	String name;

	int deciPrice;
	public Prediction lastprediction;
	Set<User> users;
	ArrayList<Prediction> predictions;

	private void initialize(int price){
		owner = new User("market");
		lastprediction = new Prediction(owner, price);
		deciPrice = price;
		users = new HashSet<User>();
		predictions = new ArrayList<Prediction>();
		predictions.add(lastprediction);
		name = "some market";
	}

	public Market(){
		this.initialize(500);
	}

	public Market(String name){
		this.initialize(500);
		this.owner = owner;
		this.name = name;
	}

	public Market(String name, User owner){
		this.initialize(500);
		this.owner = owner;
		this.name = name;
	}

	public Market(String name, int startingPrice){
		this.initialize(startingPrice);
		this.name = name;
	}

	public Market(String name, int startingPrice, User owner){
		this.initialize(startingPrice);
		this.owner = owner;
		this.name = name;
	}

	public boolean buy(User u, int price){
		if (u==owner)
			return false;
		users.add(u);
		deciPrice = price;
		lastprediction = new Prediction(u, price);
		predictions.add(lastprediction);
		return true;
	}

	public void score(boolean result){
		if(result){
			Prediction p1 = predictions.get(0);
			for (int i = 1; i < predictions.size(); i++){
				Prediction p2 = predictions.get(i);
				User u = p2.owner();
				u.addScore((int)Math.round(100*Math.log((1.0*p2.truePrice())/p1.truePrice())));
				p1 = predictions.get(i);
			}
		} else {
			Prediction p1 = predictions.get(0);
			for (int i = 1; i < predictions.size(); i++){
				Prediction p2 = predictions.get(i);
				User u = p2.owner();
				u.addScore((int)Math.round(100*Math.log((1.0*p2.falsePrice())/p1.falsePrice())));
				p1 = predictions.get(i);
			}
		}
	}

	public String toString(){
		String temp = "";
		temp += "Name: " + name +" Current Price: " + 1.0*deciPrice/10 + " Users: "+users.size() +"\n";
		return temp;
	}

	/*public static void main(String[] args){
		boolean flag = true;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Market> markets = new ArrayList<Market>();
		Market current;
		while(flag){
			System.out.println("Welcome to the market app. \n"
					+"There are currently " +markets.size()+" markets.\n"
					+"[M]ake a new market \n"
					+"[C]reate a new user \n"
					+"[V]iew Markets and Users \n"
					+"[Q]uit \n");
			try {
				String input = in.readLine();
				switch (input.toUpperCase()){
				case "M":
					System.out.println("What do you want to name the market?");
					input = in.readLine();
					current = new Market(input);
					markets.add(current);
					break;
				case "V":
					for (Market m : markets){
						System.out.print(m);
					}
					break;
				case "Q":
					flag = false;
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}*/
}
