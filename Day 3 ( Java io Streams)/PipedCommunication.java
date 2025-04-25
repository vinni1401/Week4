import java.io.*;

public class PipedCommunication {
    public static void main(String[] args) throws IOException {
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);

        Thread writer = new Thread(() -> {
            try {
                String msg = "Hello from writer thread!";
                pos.write(msg.getBytes());
                pos.close();
            } catch (IOException e) {
                System.out.println("Writer Error: " + e.getMessage());
            }
        });

        Thread reader = new Thread(() -> {
            try {
                int ch;
                while ((ch = pis.read()) != -1) {
                    System.out.print((char) ch);
                }
                pis.close();
            } catch (IOException e) {
                System.out.println("Reader Error: " + e.getMessage());
            }
        });

        writer.start();
        reader.start();
    }
}
