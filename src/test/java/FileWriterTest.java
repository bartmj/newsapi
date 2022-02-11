import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;

public class FileWriterTest {

    private File file;

    @BeforeEach
    public void setupForTests() {
        file.delete();
    }

    @Test
    public void outputFileGetsCreated() throws IOException {
        file = new File("output.txt");
        Assert.assertTrue(file.exists());
    }

}
