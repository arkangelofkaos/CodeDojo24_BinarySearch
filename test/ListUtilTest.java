import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Edward Yue Shung Wong
 */
public class ListUtilTest {

    private static final int LESS_THAN_COMPARE_RESULT = -1;
    private static final int EQUALS_COMPARE_RESULT = 0;
    private static final int MORE_THAN_COMPARE_RESULT = 1;

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
        Pair startAndEndIndexPair = chopList(searchItem, orderedListTestData);

        assertNotNull(startAndEndIndexPair);
        assertEquals(4, startAndEndIndexPair.getStartIndex());
        assertEquals(7, startAndEndIndexPair.getEndIndex());
    }

    @Test
    public void shouldReturnFirstHalfOfListWhereSearchItemIs() throws Exception {
        Integer searchItem = 1;
        Pair startAndEndIndexPair = chopList(searchItem, orderedListTestData);
        assertEquals(new Pair(0, 3), startAndEndIndexPair);
    }

    @Test
    public void testReturnEqualsSearchItemsIs() throws Exception {
        Integer searchItem = 4;
        Pair startAndEndIndexPair = chopList(searchItem, orderedListTestData);
        assertEquals(new Pair(0, 3), startAndEndIndexPair);
    }

    @Test
    public void shouldReturnPairOfStartAndEndIndexOfChoppedList() throws Exception {
        Integer searchItem = 2;
        Pair startAndEndIndexPair = chopList(searchItem, orderedListTestData);

        assertNotNull(startAndEndIndexPair);
        assertEquals(0, startAndEndIndexPair.getStartIndex());
        assertEquals(3, startAndEndIndexPair.getEndIndex());
    }

    @Test
    public void testName() throws Exception {
        // check what to do in empty case with ChopList?

        // search -> given a list
        // keep chopping until list is empty or single item
        // --> recursing on sublist everytime -> need to record index
        // return index

    }

    @Test
    public void testEmptyListReturnMinusOneWithBinarySearch() throws Exception {
        Integer searchItem = 0;
        assertEquals(-1, binarySearch(searchItem, new ArrayList<Integer>()));
    }

    /**
     * Implementation code below
     */

    private <T> int binarySearch(T item, ArrayList<T> list) {
        return -1;
    }


    private <T> int indexOf(T searchItem, List<T> orderedList) {
        return orderedList.indexOf(searchItem);
    }

    private <T extends Comparable<T>> Pair chopList(T searchItem, List<T> list) {


        int lengthOfList = list.size();

        Integer splitPoint = lengthOfList / 2;

        int middleItemIndex = splitPoint - 1;
        T middleItem = list.get(middleItemIndex);

        int compareToResult = searchItem.compareTo(middleItem);

        switch (compareToResult) {
            case LESS_THAN_COMPARE_RESULT:
            case EQUALS_COMPARE_RESULT:
                return new Pair(0, middleItemIndex);
            case MORE_THAN_COMPARE_RESULT:
                return new Pair(splitPoint, lengthOfList - 1);
        }

        return null;
    }

    private final class Pair {
        int startIndex;
        int endIndex;

        private Pair(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        private int getStartIndex() {
            return startIndex;
        }

        private int getEndIndex() {
            return endIndex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Pair pair = (Pair) o;

            if (endIndex != pair.endIndex) {
                return false;
            }
            if (startIndex != pair.startIndex) {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            int result = startIndex;
            result = 31 * result + endIndex;
            return result;
        }
    }


}
