package lab13.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static void readAndPrintLine() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine();
            System.out.println(s);
        } catch (IOException e) {
            System.out.println("IO exception!");
        }
     }

    public static void main(String[] args) {
        readAndPrintLine();
    }
}
