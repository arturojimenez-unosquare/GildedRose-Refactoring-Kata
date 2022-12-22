package com.gildedrose;


import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * TestHelper Class to compare the items
 */
public class TestHelper {

    /**
     *
     * @param actual Actual Value to compare
     * @param expected Expected value in the comparison
     */
    public static void assertItemEquals(Item actual, Item expected) {
        assertEquals(expected.name, actual.name);
        assertEquals(expected.quality, actual.quality);
        assertEquals(expected.sellIn, actual.sellIn);
    }
}
