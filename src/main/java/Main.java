import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    final static String API_KEY = "69dea6fbd87d4b53a28b19c15ef8ea37";

    public static void main(String[] args) throws IOException {
        String path = "https://newsapi.org/v2/everything?q=Business&language=pl&from=2022-02-11&sortBy=popularity&apiKey=" + API_KEY;
        URL url = new URL(path);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        con.setConnectTimeout(5000);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        con.disconnect();

        JSONObject jsonResponse = new JSONObject(String.valueOf(content));
        JSONArray articles = jsonResponse.getJSONArray("articles");

        File fout = new File("output.txt");
        FileOutputStream fos = new FileOutputStream(fout);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        for (int i = 0; i < articles.length(); i++) {
            String title = articles.getJSONObject(i).getString("title");
            String author;
            try {
                author = (String) articles.getJSONObject(i).get("author");
            } catch (NullPointerException | ClassCastException exception) {
                author = "no author";
            }
            String description = articles.getJSONObject(i).getString("description");

            String line = String.format("%s:%s:%s", title, description, author);
            bw.write(line);
            bw.newLine();
        }

        bw.close();
    }


}
