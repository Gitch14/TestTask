import org.junit.gen5.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

import static org.junit.gen5.api.Assertions.assertTrue;

public class TestFile {
    @Test
    public void testFileContentEquals() throws IOException {
        File file1 = new File("src/main/resources/expected.txt");
        File file2 = new File("orders.txt");

        try {
            if (Files.size(file1.toPath()) == Files.size(file2.toPath())) {
                byte[] first = Files.readAllBytes(file1.toPath());
                byte[] second = Files.readAllBytes(file2.toPath());

                assertTrue(Arrays.equals(first, second));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


