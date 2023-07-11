import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the book title");
        Book book = new Book(scanner.nextLine());
        FileReader fileReader;
        try {
            fileReader = new FileReader(book.getFile());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String statisticsFile = book.getFile() + "_statistic.txt";
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(statisticsFile, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.write(book.mostPopular(fileReader));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.write(book.uniqueWords(fileReader));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}