import java.io.File;
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
        String filePath = "src";
        this.file = new File("").getAbsolutePath() + "/" + filePath + "/" + bookName;
    }

    public String getBookName() {
        return bookName;
    }
    public String getFile() {
        return file;
    }

    public String mostPopular (FileReader bookName) throws IOException {
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
        return "Here is top 10 most used more than two symbols words: \n" + mostPopularTen;
    }
    public String uniqueWords (FileReader bookName) throws IOException {
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
        return "Your book " + "\"" + getBookName() + "\"" + " has " + unique.size() + " unique words.";
    }
}
