package statpredict;
import java.util.*;

public class User {
	ArrayList<Prediction> predictions;
	String name;
	int score;
	public static final int STARTING_SCORE = 0;
	
	public User(String name){
		predictions = new ArrayList<Prediction>();
		this.name = name;
		score = User.STARTING_SCORE;
	}
	
	public void add(Prediction p){
		predictions.add(p);
	}
	
	public void addScore(int i){
		score += i;
	}
	
	public int getScore(){
		return score;
	}
	
	public int hashcode(){
		int i = 1;
		i = (i + name.hashCode())* 31;
		i = (i + score)*31;
		i = (i+predictions.size());
		return i;
	}
	
	public boolean equals(User other){
		if (this.hashCode() != other.hashcode())
			return false;
		else if((this.name != other.name)||(this.score!=other.score)||(this.predictions.size()!=other.predictions.size()) ){
			return false;
		}
		return true;
	}
	
}
