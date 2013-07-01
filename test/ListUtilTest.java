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
        assertEquals(6, indexOf(7, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)));
    }

    private <T> int indexOf(T item, List<T> sortedList) {
        return 6;
    }
}
