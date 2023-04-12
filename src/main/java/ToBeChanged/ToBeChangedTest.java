package ToBeChanged;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToBeChangedTest {

    @Test
    void test1() {
        ToBeChanged f = new ToBeChanged();
        assertEquals(2, f.test());
    }
}