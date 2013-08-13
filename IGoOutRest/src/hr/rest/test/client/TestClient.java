package hr.rest.test.client;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class TestClient {
	public static void main(String[] args) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());

		JSONObject json = new JSONObject();
		JSONArray interests = new JSONArray();
		interests.put(1);
		interests.put(2);
		interests.put(3);
		JSONArray venues = new JSONArray();
		venues.put(2);
		venues.put(3);
		venues.put(4);
		venues.put(5);
		int radiusId = 1;
		try {
			json.put("interests", interests);
			json.put("venues", venues);
			json.put("radiusId", radiusId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Fluent interfaces
		// System.out.println(service.path("rest").path("hello")
		// .accept(MediaType.TEXT_PLAIN).get(ClientResponse.class)
		// .toString());
		// Get plain text
		System.out.println(service.path("rest").path("locations")
				.accept(MediaType.APPLICATION_JSON).post(String.class, json));
		// Get XML
		System.out.println(service.path("rest").path("events/10")
				.accept(MediaType.APPLICATION_JSON).get(String.class));
		// The HTML
		// System.out.println(service.path("rest").path("hello")
		// .accept(MediaType.TEXT_HTML).get(String.class));

	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/IGoOutRest/").build();
	}

}