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

        testTable.add(123, "jouy123");
        testTable.add(12, "jouy12");
        testTable.add(1, "jouy1");

        testTable.setHash(x -> Math.abs(x.hashCode() + 35) % testTable.getBucketCount() );

        assertEquals("jouy123", testTable.search(123));
        assertEquals("jouy12", testTable.search(12));
        assertEquals("jouy1", testTable.search(1));


    }

}
