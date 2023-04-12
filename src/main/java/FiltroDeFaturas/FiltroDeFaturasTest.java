package FiltroDeFaturas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FiltroDeFaturasTest {

    @Test
    void test1() {
        FiltroDeFaturas f = new FiltroDeFaturas();
        assertEquals(1, f.test());
    }
}