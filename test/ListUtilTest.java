import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Edward Yue Shung Wong
 */
public class ListUtilTest {

    @Test
    public void shouldReturnIndexOfFoundItem() throws Exception {
        List<Integer> sortedListTestData = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int expectedIndex = 6;
        int searchItem = 7;
        int actualIndexOfItem = indexOf(searchItem, sortedListTestData);

        assertEquals(expectedIndex, actualIndexOfItem);
    }

    @Test
    public void shouldReturnMinusOneForMissingItem() throws Exception {
        List<Integer> sortedListTestData = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int expectedIndex = -1;
        int searchItem = 10;
        int actualIndexOfItem = indexOf(searchItem, sortedListTestData);

        assertEquals(expectedIndex, actualIndexOfItem);
    }

    private <T> int indexOf(T item, List<T> sortedList) {
        return sortedList.indexOf(item);
    }
}
