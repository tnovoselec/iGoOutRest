package hr.rest.petkovic.igoout;

import java.util.HashMap;
import java.util.Map;

public class Constants {
	
	public static Map<Integer, Integer> RADIUS = new HashMap<Integer, Integer>();
	
	static {
		RADIUS.put(1, 1);
		RADIUS.put(2, 5);
		RADIUS.put(3, 10);
		RADIUS.put(4, 25);
		RADIUS.put(5, 50);
		RADIUS.put(6, 1000);
	}

}
