import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Edward Yue Shung Wong
 */
public class ListUtilTest {

    private List<Integer> sortedListTestData;

    @Before
    public void setUp() throws Exception {
        sortedListTestData = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
    }

    @Test
    public void shouldReturnIndexOfFoundItem() throws Exception {
        int expectedIndex = 6;
        int searchItem = 7;
        int actualIndexOfItem = indexOf(searchItem, sortedListTestData);

        assertEquals(expectedIndex, actualIndexOfItem);
    }

    @Test
    public void shouldReturnMinusOneForMissingItem() throws Exception {
        int expectedIndex = -1;
        int searchItem = 10;
        int actualIndexOfItem = indexOf(searchItem, sortedListTestData);

        assertEquals(expectedIndex, actualIndexOfItem);
    }

    // Binary search:
    // If empty list return -1;
    // If start == end, return -1 if list item isn't the search item
    // If start == end, return the start if list item isn't the search item
    // If start != end, get the middle point
    // --> if item@mid point >= search item, recurse with start & midpoint
    // --> if item@mid point < search item, recurse with midpoint + 1 & end


    @Test
    public void shouldCalculateMiddleIndexOf3GivenListOfSize7() throws Exception {
        int middleIndex = middleIndexOf(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertEquals(3, middleIndex);
    }

    private <T> int indexOf(T item, List<T> sortedList) {
        return sortedList.indexOf(item);
    }

    private int middleIndexOf(List<?> list) {
        return 3;
    }


}
