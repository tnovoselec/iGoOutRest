package hr.rest.petkovic.igoout.api;

import hr.rest.petkovic.igoout.dao.UsersDao;
import hr.rest.petkovic.igoout.model.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONObject;

@Path("/user")
public class UsersApi {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User register(JSONObject data){
		String username = data.optString("username");
		String password = data.optString("password");
		
		return UsersDao.instance.register(username, password);
	}

}
