import java.io.*;
import java.util.Scanner;

public class StudentDataStream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String file = "students.dat";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            System.out.print("Enter number of students: ");
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < n; i++) {
                System.out.print("Enter roll, name, GPA: ");
                int roll = sc.nextInt();
                String name = sc.next();
                float gpa = sc.nextFloat();
                dos.writeInt(roll);
                dos.writeUTF(name);
                dos.writeFloat(gpa);
            }
        } catch (IOException e) {
            System.out.println("Write Error: " + e.getMessage());
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            while (true) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                float gpa = dis.readFloat();
                System.out.println(roll + " " + name + " " + gpa);
            }
        } catch (EOFException e) {
            // End of file
        } catch (IOException e) {
            System.out.println("Read Error: " + e.getMessage());
        }
    }
}
