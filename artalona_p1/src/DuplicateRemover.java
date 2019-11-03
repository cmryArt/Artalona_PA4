import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Iterator;
import java.io.File;

//Data structure Hash Set best for removing duplicates
public class DuplicateRemover {

    private ArrayList<String> uniqueWords = new ArrayList<String>();

    public void remove(String dataFile) throws IOException
    {
        FileInputStream inputStream = new FileInputStream("dataFile");
        Scanner scnr = new Scanner(inputStream);
        HashSet<String> x = new HashSet<String>();
        Iterator<String> iteration = x.iterator();

        while(scnr.hasNext())
            {
                x.add(scnr.next());
            }

        while(iteration.hasNext())
            {
                uniqueWords.add(iteration.next());
            }
        inputStream.close();
    }

    public void write(String outputFile) throws IOException
    {
    File NewF = new File(outputFile);
    NewF.createNewFile();
    FileOutputStream outputStream = new FileOutputStream(NewF, false);
    byte[] toBytes;
    int i;
    for (i = 0; i <uniqueWords.size(); i++)
        {
            toBytes = (uniqueWords.get(i) + " ").getBytes();
            outputStream.write(toBytes);
        }
    outputStream.close();
    }
}
