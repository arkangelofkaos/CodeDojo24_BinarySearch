import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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
        int actualIndexOfItem = binarySearch(searchItem, sortedListTestData);

        assertEquals(expectedIndex, actualIndexOfItem);
    }

    @Test
    public void shouldReturnMinusOneForMissingItem() throws Exception {
        int expectedIndex = -1;
        int searchItem = 10;
        int actualIndexOfItem = binarySearch(searchItem, sortedListTestData);

        assertEquals(expectedIndex, actualIndexOfItem);
    }

    @Test
    public void shouldCalculateMiddleIndexOf3GivenListOfSize7() throws Exception {
        int middleIndex = splitIndex(7);
        assertEquals(3, middleIndex);
    }

    @Test
    public void shouldCalculateMiddleIndexOf1GivenListOfSize4() throws Exception {
        int middleIndex = splitIndex(4);
        assertEquals(1, middleIndex);
    }

    @Test
    public void shouldReturnMinusOneForEmptyList() {
        assertEquals(-1, binarySearch(1, new ArrayList<Integer>()));
    }

    @Test
    public void shouldReturnMinusOneForItemNotInSingletonList() {
        assertEquals(-1, binarySearch(0, Arrays.asList(1)));
    }

    private <T extends Comparable<T>> int binarySearch(T item, List<T> sortedList) {
        if (sortedList == null || sortedList.isEmpty()) {
            return -1;
        }

        int startIndex = 0;
        int endIndex = sortedList.size() - 1;

        return doBinarySearch(item, sortedList, startIndex, endIndex);
    }

    private <T extends Comparable<T>> int doBinarySearch(T item, List<T> sortedList, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            T element = sortedList.get(startIndex);
            if (element.equals(item)) {
                return startIndex;
            } else {
                return -1;
            }
        }

        int splitIndex = splitIndex(endIndex - startIndex) + startIndex;
        T middleItem = sortedList.get(splitIndex);

        if (middleItem.compareTo(item) < 0) {
            return doBinarySearch(item, sortedList, splitIndex + 1, endIndex);
        } else {
            return doBinarySearch(item, sortedList, startIndex, splitIndex);
        }
    }

    private int splitIndex(int size) {
        int splitIndex = size / 2;

        if (size % 2 == 0) {
            --splitIndex;
        }

        return splitIndex;
    }


}
