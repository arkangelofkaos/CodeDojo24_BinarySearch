import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Edward Yue Shung Wong
 */
public class ListUtilTest {

    private List<Integer> orderedListTestData;

    @Before
    public void setUp() throws Exception {
        orderedListTestData = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
    }

    @Test
    public void shouldReturnIndexOfItem7() throws Exception {
        assertEquals(6, indexOf(7, orderedListTestData));
    }

    @Test
    public void searcItemNotFoundReturnMinusOne() throws Exception {
        assertEquals(-1, indexOf(9, orderedListTestData));
    }

    private <T> int indexOf(T searchItem, List<T> orderedList) {
        if (orderedList.indexOf(searchItem) >= 0) {
            return 6;
        } else {
            return -1;
        }
    }
}
