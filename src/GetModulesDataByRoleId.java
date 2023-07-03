import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.naming.NamingException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetModulesDataByRoleId {

	// http://localhost:8080/RESTfulExample/json/product/get
	public static AppModules getModulesByRoleId(String roleId) {
		AppModules moduleDetails = new AppModules();
		javax.naming.Context ctx;
		String restURL=null;
		try {
			ctx = new javax.naming.InitialContext();
			 restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");

		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	  try {
		  ObjectMapper mapper = new ObjectMapper();
		URL url = new URL(restURL+"/role/getModulesByRoleId?roleId="+roleId);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
		
		

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
			moduleDetails = mapper.readValue(output, AppModules.class);
		}
		//if(!moduleDetails.getModuleDetails().isEmpty())
	//	System.out.println("staff1"+moduleDetails.getModuleDetails().size());

		conn.disconnect();

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }
	return moduleDetails;

	}

}