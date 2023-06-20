package Core;

import Objects.Cypher;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CyphersFromServer {
    private List<Integer> keys;
    private List<String> names;

    private List<Cypher> cypherList = new ArrayList<>();

    public CyphersFromServer() throws IOException {
        getKeysFromCyphers();
    }

    public void getKeysFromCyphers() throws IOException {
        keys = new ArrayList<>();
        names = new ArrayList<>();
        cypherList = new ArrayList<>();

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

        Gson gson = new Gson();
        Cypher[] cyphers = gson.fromJson(response.toString(), Cypher[].class);

        for (Cypher cypher : cyphers) {
            keys.add(cypher.getKey());
            names.add(cypher.getName());
            cypherList.add(cypher);
        }
    }

    public List<Integer> getKeys() {
        return keys;
    }

    public List<String> getNames() {
        return names;
    }
    public List<Cypher> getCypherList(){
        return cypherList;
    }
}

