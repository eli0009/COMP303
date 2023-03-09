package code;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Testing {

    @Test
    public void test() {
        assertEquals(5, 5);
        assertNotEquals(5, 4);
        assertSame("test", "test");
        assertNotSame("Test", "test");
        assertTrue(true);
    }
}
