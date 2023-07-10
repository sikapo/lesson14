import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the book title");
        Book book = new Book(scanner.nextLine());

        try (FileReader fileReader = new FileReader(book.getFile())){
            book.mostPopular(fileReader);
        } catch (IOException e) {
            System.err.println("No such book was found. Please, enter the correct title.");
        }

        try (FileReader fileReader = new FileReader(book.getFile())){
            book.uniqueWords(fileReader);
        } catch (IOException e) {
            System.err.println("No such book was found. Please, enter the correct title.");
        }
    }
}