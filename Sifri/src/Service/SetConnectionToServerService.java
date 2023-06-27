package Service;

import java.net.HttpURLConnection;
import java.net.URL;

public class SetConnectionToServerService {
    private static SetConnectionToServerService instance;
    private HttpURLConnection connection;
    private String sessionId;

    private SetConnectionToServerService() {
// Inicializácia pripojenia tu
        try {
            URL url = new URL("http://localhost:8080/test-login");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
// Nastavte ďalšie parametre pripojenia, ak je to potrebné

// Získajte session ID z prvej odpovede servera
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
// Ak je požadované URL iné ako predvolené, vytvorte nové pripojenie
        if (!url.equals("http://localhost:8080/test-login")) {
            try {
                URL newURL = new URL(url);
                connection = (HttpURLConnection) newURL.openConnection();
                connection.setRequestMethod("GET");
// Nastavte ďalšie parametre pripojenia, ak je to potrebné

// Nastavte session ID do hlavičky požiadavky
                connection.setRequestProperty("Cookie", sessionId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}