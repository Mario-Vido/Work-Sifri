package Core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class CyphersFromServer {

    private List<String> names;

    public CyphersFromServer() throws IOException {
        getKeysFromCyphers();
    }

    public void getKeysFromCyphers() throws IOException {
//        keys = new ArrayList<>();
//        names = new ArrayList<>();
//        cypherMap = new HashMap<>();
//
//        URL url = new URL("http://localhost:8080/creatingcypher");
//
//        HttpURLConnection connection;
//        connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestMethod("GET");
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//        StringBuilder response = new StringBuilder();
//        String line;
//        while ((line = reader.readLine()) != null) {
//            response.append(line);
//        }
//        reader.close();
//
//        Gson gson = new Gson();
//        Cypher[] cyphers = gson.fromJson(response.toString(), Cypher[].class);
//
//        for (Cypher cypher : cyphers) {
//            keys.add(cypher.getKey());
//            names.add(cypher.getName());
//            cypherMap.put(cypher.getKey(), cypher);
//        }
        names = new ArrayList<>();

        URL url = new URL("http://localhost:8080/creatingcypher");

        HttpURLConnection connection;
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        String namesString = response.toString();
        String[] namesArray = namesString.split(",");

        names.addAll(Arrays.asList(namesArray));
    }

    public List<String> getNames() {
        return names;
    }
}

