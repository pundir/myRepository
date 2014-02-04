import com.pundir.location.dto.NotificationRequest;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class RestTest {
	public static void main(String[] args) {

		NotificationRequest st = new NotificationRequest();
		st.setLatitute("1000");
		st.setLongitute("2000");

		ClientConfig clientConfig = new DefaultClientConfig();

		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);

		Client client = Client.create(clientConfig);

		WebResource webResource = client
				.resource("http://localhost:9090/locationServices/getAds/asjson");

		ClientResponse response = webResource.accept("application/json")
				.type("application/json").post(ClientResponse.class, st);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		String output = response.getEntity(String.class);

		System.out.println("Server response .... \n");
		System.out.println(output);
	}
}
