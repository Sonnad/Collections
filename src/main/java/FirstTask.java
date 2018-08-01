import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Sonad on 01.08.18.
 */
public class FirstTask {

    public static Set<String> getWords(String path) {

        String line = null;
        SortedSet<String> resultSet = new TreeSet<>();



        try(BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(path))) {

            while((line = bufferedReader.readLine()) != null) {
                resultSet.addAll(Arrays.asList(line.split(" ")));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String element : resultSet) {
            System.out.println(element);
        }

        return resultSet;

    }

}
