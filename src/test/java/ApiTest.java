import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;

public class ApiTest {

    @Test
    public void apiCallReturnStatusOK() throws IOException {
        Api api = new Api();
        HttpURLConnection connection = api.startConnection();
        Assert.assertTrue(connection.getResponseMessage().equals("OK"));
        connection.disconnect();
    }

    @Test
    public void apiCallReturnsJson() throws IOException {
        Api api = new Api();
        HttpURLConnection connection = api.startConnection();
        Assert.assertEquals(api.getJsonArray(connection).getClass(), JSONArray.class);
        connection.disconnect();
    }
}