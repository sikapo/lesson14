import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Book {
    private final String bookName;
    private final String file;

    public Book(String bookName) {
        this.bookName = bookName;
        String filePath = "D:/IT Hillel/JavaPro/lesson14/src";
        this.file = filePath + "/" + bookName;
    }

    public String getBookName() {
        return bookName;
    }
    public String getFile() {
        return file;
    }

    public void mostPopular (FileReader bookName) throws IOException {
        ArrayList<String> words = new ArrayList<>();
        HashMap<String, Integer> mostPopular = new HashMap<>();
        String text;
        int c;
        StringBuilder wordBuilder = new StringBuilder();
        while ((c = bookName.read()) != -1) {
            wordBuilder.append((char) c);
        }
        text = wordBuilder.toString();
        Pattern pattern = Pattern.compile("\\b\\p{L}+\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            if (matcher.group().toLowerCase().length() > 2) {
            words.add(matcher.group().toLowerCase());
            }
        }
        for (String word : words) {
            if (!mostPopular.isEmpty()) {
                if (mostPopular.containsKey(word)) {
                    mostPopular.replace(word, mostPopular.get(word), mostPopular.get(word) + 1);
                }
                else mostPopular.put(word, 1);
            }
            else mostPopular.put(word, 1);
        }
        HashMap<String, Integer> mostPopularTen = new HashMap<>();
        mostPopular.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .forEach(w -> mostPopularTen.put(w.getKey(), w.getValue()));
        System.out.println("Here is top 10 most used more than two symbols words: \n" + mostPopularTen);
    }
    public void uniqueWords (FileReader bookName) throws IOException {
        HashSet <String> unique = new HashSet<>();
        int c;
        StringBuilder wordBuilder = new StringBuilder();
        while ((c = bookName.read()) != -1) {
                wordBuilder.append((char) c);
        }
        String text = wordBuilder.toString();
        Pattern pattern = Pattern.compile("\\b\\p{L}+\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            unique.add(matcher.group().toLowerCase());
        }
        System.out.println("Your book " + "\"" + getBookName() + "\"" + " has " + unique.size() + " unique words.");
    }
}
