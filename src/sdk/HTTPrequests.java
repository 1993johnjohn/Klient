package sdk;

import com.sun.jersey.api.client.*;

import java.util.ArrayList;

public class HTTPrequests {

    static Client client = Client.create();

    public static ClientResponse get (String path) {
        ClientResponse clientResponse = null;
        try{
            WebResource webResource = client
                    .resource("http://localhost:8080/server2_0_war_exploded/")
                    .path(path);
            clientResponse = webResource.accept("application/json").get(ClientResponse.class);
        }
        catch
            (UniformInterfaceException | ClientHandlerException e) {
                e.printStackTrace();
            }
            return clientResponse;
        }

        public static ClientResponse post(String path, String info) {
            ClientResponse clientResponse = null;
            try {
                WebResource webResource = client
                        .resource("http://localhost:8080/server2_0_war_exploded/")
                        .path(path);
                clientResponse = webResource.accept("application/json").post(ClientResponse.class, info);

                // if (token != null) {
                // clientResponse = webResource.accept("authorization").post(ClientResponse.class, token);}

            } catch (UniformInterfaceException | ClientHandlerException e) {
                e.printStackTrace();
            }
            return clientResponse;
        }

        public static ClientResponse put(String path, String info, ArrayList<String> headerinfo) {
            ClientResponse clientResponse = null;
            try {
                WebResource webResource = client
                        .resource("http://localhost:8080/server2_0_war_exploded/")
                        .path(path);
                clientResponse = webResource.accept("application/json")
                        .header(headerinfo.get(0), headerinfo.get(1))
                        .put(ClientResponse.class, info);
                System.out.println(headerinfo.get(0) + "--" + headerinfo.get(1));
            } catch (UniformInterfaceException | ClientHandlerException e) {
                e.printStackTrace();
            }
            return clientResponse;
        }

        public static ClientResponse delete(String path, String info, ArrayList<String> headerinfo) {
            ClientResponse clientResponse = null;
            try {
                WebResource webResource = client
                        .resource("http://localhost:8080/server2_0_war_exploded")
                        .path(path);
            clientResponse = webResource
                    .accept("application/json")
                    .header(headerinfo.get(0), headerinfo.get(1))
                    .delete(ClientResponse.class);
        } catch (UniformInterfaceException | ClientHandlerException e) {
            e.printStackTrace();
        }
        return clientResponse;
    }
    public static ClientResponse logOut (String path, String info) {
            ClientResponse clientResponse = null;
            try {
                WebResource webResource = client
                        .resource("http://localhost:8080/server2_0_war_exploded")
                        .path(path);
                clientResponse = webResource.accept("application/json").post(ClientResponse.class, info);
            } catch (UniformInterfaceException | ClientHandlerException e) {
                e.printStackTrace();
            }
        return clientResponse;
    }

}


