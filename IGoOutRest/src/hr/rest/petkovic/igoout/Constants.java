package hr.rest.petkovic.igoout;

import java.util.HashMap;
import java.util.Map;

public class Constants {
	public static final String LIVE_URL="http://62.75.155.123:8081/IGoOutRest/";
	public static final String IMAGES_FOLDER="images/";
	public static final int MAX_COMMENTS_PER_USER_PER_EVENT = 3;
	public static Map<Integer, Integer> RADIUS = new HashMap<Integer, Integer>();

	static {
		RADIUS.put(0, 1);
		RADIUS.put(1, 5);
		RADIUS.put(2, 10);
		RADIUS.put(3, 25);
		RADIUS.put(4, 50);
		RADIUS.put(5, 100000);
	}

}
