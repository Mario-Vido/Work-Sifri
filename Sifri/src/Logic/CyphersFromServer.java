package Logic;

import Service.SetConnectionToServerService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.*;

public class CyphersFromServer {

    private List<String> names;

    public CyphersFromServer() throws IOException {
        getKeysFromCyphers();
    }

    public void getKeysFromCyphers() throws IOException {
        names = new ArrayList<>();
        StringBuilder response;
        String line;
        String url = ("http://localhost:8080/creatingcypher");

        HttpURLConnection connection;
        connection = SetConnectionToServerService.getInstance().getConnection(url);
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

        String namesString = response.toString();
        String[] namesArray = namesString.split(", ");

        names.addAll(Arrays.asList(namesArray));
    }

    public List<String> getNames() {
        return names;
    }
}

