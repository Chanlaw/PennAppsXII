package statpredict;

import static org.junit.Assert.*;

import org.junit.Test;

public class tests {

	@Test
	public void userTest() {
		User u = new User("a");
		assertEquals(u.getScore(),User.STARTING_SCORE);
		u.addScore(100);
		assertEquals(u.getScore(),User.STARTING_SCORE+100);
	}

	@Test
	public void predictionTest(){
		Market m = new Market();
		assertEquals(m.lastprediction.getPrice(), 500);
		User u = new User("a");
		m.buy(u, 900);
		assertEquals(m.lastprediction.getPrice(), 900);
		assertEquals(m.lastprediction.truePrice(), 900);
		m.score(true);
		assertEquals(u.score, User.STARTING_SCORE+59);
	}
	
	@Test
	public void predictionTest2(){
		Market m = new Market();
		assertEquals(m.lastprediction.getPrice(), 500);
		User u = new User("a");
		User u2 = new User("b");
		m.buy(u, 900);
		m.buy(u2, 500);
		m.score(true);
		assertEquals(u.score, User.STARTING_SCORE+59);
		assertEquals(u2.score, User.STARTING_SCORE-59);
	}
	
	@Test
	public void predictionTest3(){
		Market m = new Market();
		assertEquals(m.lastprediction.getPrice(), 500);
		User u = new User("a");
		User u2 = new User("b");
		m.buy(u, 900);
		m.buy(u2, 800);
		m.score(false);
		assertEquals(u.score, User.STARTING_SCORE-161);
		assertEquals(u2.score, User.STARTING_SCORE+69);
	}
	
	@Test
	public void predictionTest4(){
		User u = new User("a");
		Market m = new Market("a",u);
		assertEquals(m.lastprediction.getPrice(), 500);
		User u2 = new User("b");
		m.buy(u, 900);
		m.buy(u2, 800);
		assertEquals(m.lastprediction.getPrice(), 800);
	}
}
