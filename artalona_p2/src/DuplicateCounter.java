import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class DuplicateCounter {

    // we need to use a map of strings
    private ArrayList<String> wordCounter = new ArrayList<String>();

    public void count(String dataFile) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(dataFile);
        Scanner scnr = new Scanner(inputStream);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String temp;


        while (scnr.hasNext())
        {
            temp = scnr.next();
            if(map.containsKey(temp))
                {
                    map.replace(temp,map.get(temp), map.get(temp) + 1);
                }
            else
                {
                    map.put(temp,1);
                }
        }

        Iterator iterator = map.entrySet().iterator();

        while (iterator.hasNext())
            {
                Map.Entry mapElement = (Map.Entry)iterator.next();
                wordCounter.add(mapElement.getKey() + " " + mapElement.getValue());
            }
        scnr.close();
    }

    public void write(String outputFile) throws IOException
    {
        File newF = new File(outputFile);
        newF.createNewFile();
        FileOutputStream outputStream = new FileOutputStream(newF,false);
        byte[] toBytes;
        int i;
        for(i = 0; i < wordCounter.size(); i++)
            {
                toBytes = (wordCounter.get(i) + " ").getBytes();
                outputStream.write(toBytes);
            }
        outputStream.close();
    }
}
