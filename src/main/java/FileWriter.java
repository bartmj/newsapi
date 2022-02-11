import org.json.JSONArray;

import java.io.*;

public class FileWriter {

    private FileOutputStream fileOutputStream;
    private File outputFile;
    private BufferedWriter bufferedWriter;

    public void writeJsonArrayToFile(JSONArray jsonArray) throws IOException {

        outputFile = new File("output.txt");
        fileOutputStream = new FileOutputStream(outputFile);
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
        String title;
        String author;
        String description;
        String line;

        for (int i = 0; i < jsonArray.length(); i++) {
            title = jsonArray.getJSONObject(i).getString("title");
            author = jsonArray.getJSONObject(i).getString("author");
            description = jsonArray.getJSONObject(i).getString("description");
            line = String.format("%s:%s:%s", title, description, author);
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
