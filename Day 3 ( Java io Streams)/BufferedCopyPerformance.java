import java.io.*;

public class BufferedCopyPerformance {
    public static void main(String[] args) throws IOException {
        String source = "largefile.dat"; // Create a 100MB file manually
        String dest1 = "copy_unbuffered.dat";
        String dest2 = "copy_buffered.dat";

        // Unbuffered
        long start1 = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest1)) {
            byte[] buffer = new byte[4096];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        }
        long end1 = System.nanoTime();

        // Buffered
        long start2 = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest2))) {
            byte[] buffer = new byte[4096];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        }
        long end2 = System.nanoTime();

        System.out.println("Unbuffered Time: " + (end1 - start1) / 1_000_000 + " ms");
        System.out.println("Buffered Time: " + (end2 - start2) / 1_000_000 + " ms");
    }
}
