/**
 * Created by Sonad on 01.08.18.
 */
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class FirstTaskTest {

    @Test
    public void testAddWord() {

        String[] testArray = new String[]{
                "бетон",
                "бетономешалка",
                "мама",
                "мешает",
                "мыла",
                "раму",
                "сестра",
                "тоже"
        };

        String[] resultArray = new String[]{};
        FirstTask.getWords("src/main/resources/test.txt").toArray(resultArray);
        for (int i = 0; i < resultArray.length; i++) {
            assertEquals(testArray[i], resultArray[i]);
        }
    }

}
