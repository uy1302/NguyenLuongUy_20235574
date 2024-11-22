package hust.soict.dsai.garbage;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "hust/soict/dsai/garbage/text.txt";
        byte[] inputBytes = { 0 };
        long startTime, endTime;
        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }
        startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes) {
            outputStringBuilder.append((char) b);
        }
        String outputString = outputStringBuilder.toString();
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
