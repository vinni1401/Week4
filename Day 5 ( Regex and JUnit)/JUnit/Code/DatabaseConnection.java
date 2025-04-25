package org.example;

public class DatabaseConnection {
    public boolean connect() {
        System.out.println("Connected");
        return true;
    }

    public boolean disconnect() {
        System.out.println("Disconnected");
        return true;
    }
}
