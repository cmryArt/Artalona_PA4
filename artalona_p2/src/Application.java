import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException
    {
        //reading from problem2, write to unique_words
        DuplicateCounter duplicateCounter = new DuplicateCounter();
        duplicateCounter.count("problem2.txt");
        duplicateCounter.write("unique_words.txt");
    }
}
