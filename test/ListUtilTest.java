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

    public static final int LESS_THAN_COMPARE_RESULT = -1;

    public static final int MORE_THAN_COMPARE_RESULT = 1;

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
    public void searchItemNotFoundReturnMinusOne() throws Exception {
        assertEquals(-1, indexOf(9, orderedListTestData));
    }

    @Test
    public void shouldReturnIndexOfItem1() throws Exception {
        assertEquals(0, indexOf(1, orderedListTestData));
    }


    @Test
    public void testEmptyListReturnMinusOne() throws Exception {
        assertEquals(-1, indexOf(0, new ArrayList<Object>()));

    }

    @Test
    public void shouldReturnSecondHalfOfListWhereSearchItemIs() throws Exception {
        Integer searchItem = 5;
        List<Integer> choppedList = chopList(searchItem, orderedListTestData);
        assertEquals(Arrays.asList(5, 6, 7, 8), choppedList);
    }

    @Test
    public void shouldReturnFirstHalfOfListWhereSearchItemIs() throws Exception {
        Integer searchItem = 1;
        List<Integer> choppedList = chopList(searchItem, orderedListTestData);
        assertEquals(Arrays.asList(1, 2, 3, 4), choppedList);
    }

    /**
     * Implementation code below
     */

    private <T> int indexOf(T searchItem, List<T> orderedList) {
        return orderedList.indexOf(searchItem);
    }

    private <T extends Comparable<T>> List<T> chopList(T searchItem, List<T> list) {
        int lengthOfList = list.size();
        Integer listSubSize = lengthOfList / 2;

        int middleItemIndex = listSubSize - 1;
        T middleItem = list.get(middleItemIndex);

        int compareToResult = searchItem.compareTo(middleItem);

        switch (compareToResult) {
            case LESS_THAN_COMPARE_RESULT:
                return list.subList(0, listSubSize);
            case MORE_THAN_COMPARE_RESULT:
                return list.subList(listSubSize, lengthOfList);
        }

        return null;
    }
}
