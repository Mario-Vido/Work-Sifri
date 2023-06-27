package Service;

import java.net.HttpURLConnection;
import java.net.URL;

public class SetConnectionToServerService {
    private static SetConnectionToServerService instance;
    private HttpURLConnection connection;
    private String sessionId;

    private SetConnectionToServerService() {

        try {
            URL url = new URL("http://localhost:8080");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");

            sessionId = connection.getHeaderField("Set-Cookie");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized SetConnectionToServerService getInstance() {
        if (instance == null) {
            instance = new SetConnectionToServerService();
        }
        return instance;
    }

    public HttpURLConnection getConnection(String url) {
        if (!url.equals("http://localhost:8080")) {
            try {
                URL newURL = new URL(url);
                connection = (HttpURLConnection) newURL.openConnection();
                connection.setRequestMethod("POST");

                connection.setRequestProperty("Cookie", sessionId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}