package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.TestHelper.assertItemEquals;

/**
 * AgedBrieTest Class to validate different scenarios for the Aged Brie Items
 */
public class AgedBrieTest {

   /**
     * Unit Test that validates the increase in quality of an Aged Brie item
     */
    @Test
    public void agedBrieItem_increasesInQuality() {
        GildedRose app = new GildedRose(new Item("Aged Brie", 2, 2));
        app.updateQuality();
        assertItemEquals(app.getItems()[0], new Item("Aged Brie", 1, 3));
    }

    /**
     * Unit Test that validates the increase in quality  twice as fast when Aged Brie item passed
     */
    @Test
    public void agedBrieItem_increasesInQuality_DoublesWhenPassed() {
        GildedRose app = new GildedRose(new Item("Aged Brie", 0, 2));
        app.updateQuality();
        assertItemEquals(app.getItems()[0], new Item("Aged Brie", -1, 4));
    }

    /**
     * Unit test that validate that the Aged Brie item can never have its Quality increase above 50
     */
    @Test
    public void agedBrieItem_neverMore50Quality() {
        GildedRose app = new GildedRose(new Item("Aged Brie", 2, 50));
        app.updateQuality();
        assertItemEquals(app.getItems()[0], new Item("Aged Brie", 1, 50));
    }
}
