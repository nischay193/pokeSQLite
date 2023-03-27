import org.junit.Test;
import org.nischay.Main;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RandomTest {

    @Test
    public void square_returnsSquareOfNumber() throws IOException {
        assertThat(Main.sq(3), is(9));
        assertThat(Main.sq(2), is(8));
    }

}
