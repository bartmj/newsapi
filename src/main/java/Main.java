import org.json.JSONArray;

import java.io.*;
import java.net.HttpURLConnection;

public class Main {

    public static void main(String[] args) throws IOException {
        Api api = new Api();
        FileWriter fileWriter = new FileWriter();

        HttpURLConnection connection = api.startConnection();
        JSONArray articles = api.getJsonArray(connection);
        connection.disconnect();

        fileWriter.writeJsonArrayToFile(articles);
    }
}
