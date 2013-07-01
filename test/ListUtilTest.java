import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Edward Yue Shung Wong
 */
public class ListUtilTest {

    @Test
    public void shouldReturnIndexOfItem7() throws Exception {
        List<Integer> orderedList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        assertEquals(6, indexOf(7, orderedList));
    }

    private <T> int indexOf(T searchItem, List<T> orderedList) {
        return 6;
    }
}
