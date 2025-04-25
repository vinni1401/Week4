import java.io.*;

public class UpperToLower {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {

            int ch;
            while ((ch = br.read()) != -1) {
                bw.write(Character.toLowerCase(ch));
            }
            System.out.println("Converted to lowercase.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
