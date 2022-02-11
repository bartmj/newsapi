import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Api {
    final String API_KEY = "69dea6fbd87d4b53a28b19c15ef8ea37";

    public HttpURLConnection startConnection() throws IOException {
        String path = "https://newsapi.org/v2/everything?q=Business&language=pl&from=2022-02-11&sortBy=popularity&apiKey=" + API_KEY;
        URL url = new URL(path);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setConnectTimeout(5000);

        return connection;
    }

    public JSONArray getJsonArray(HttpURLConnection connection) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String inputLine;
        StringBuffer content = new StringBuffer();

        while ((inputLine = bufferedReader.readLine()) != null) {
            content.append(inputLine);
        }
        bufferedReader.close();

        JSONObject jsonResponse = new JSONObject(String.valueOf(content));
        JSONArray articles = jsonResponse.getJSONArray("articles");

        return articles;
    }
}
