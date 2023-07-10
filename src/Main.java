import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the book title");
        Book book = new Book(scanner.nextLine());

        try (FileReader fileReader = new FileReader(book.getBookName())){
            System.out.println(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}