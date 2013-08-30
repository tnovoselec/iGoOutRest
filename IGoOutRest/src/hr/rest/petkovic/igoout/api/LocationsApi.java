package hr.rest.petkovic.igoout.api;

import hr.rest.petkovic.igoout.dao.LocationsDao;
import hr.rest.petkovic.igoout.model.Location;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@Path("/locations")
public class LocationsApi {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Location> getLocations(JSONObject json) throws JSONException {
		int[] interests = jsonArrayToIntArray(json.getJSONArray("interests"));
		int[] venues = jsonArrayToIntArray(json.getJSONArray("venues"));
		int radiusId = json.getInt("radiusId");
		double lat = json.getDouble("lat");
		double lng = json.getDouble("lng");
		List<Location> loc = LocationsDao.instance.getLocations(interests, venues, radiusId, lat, lng);
		return loc;
	}

	@GET
	@Path("/all")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Location> getAllLocations() throws JSONException {

		return LocationsDao.instance.getAllLocations();
	}

	private int[] jsonArrayToIntArray(JSONArray array) {
		int[] values = new int[array.length()];
		for (int i = 0; i < array.length(); i++) {
			try {
				values[i] = array.getInt(i);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return values;
	}
}
