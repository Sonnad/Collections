/**
 * Created by Sonad on 01.08.18.
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class MyHashTableTest {

    @Test
    public void testAllMethods() {
        Integer capacity = 44;
        MyHashTable testTable = new MyHashTable(capacity);
        assertEquals(capacity, testTable.getBucketCount());
        testTable.add(123, "jouy");
        assertEquals("jouy", testTable.search(123));
        testTable.add(123, "jouy123");
        assertEquals("jouy123", testTable.search(123));
        testTable.remove(123);
        assertNull(testTable.search(123));

    }

}
