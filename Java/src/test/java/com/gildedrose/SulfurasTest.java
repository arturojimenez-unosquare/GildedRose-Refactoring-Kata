package com.gildedrose;


import org.junit.Test;

import static com.gildedrose.TestHelper.assertItemEquals;

/**
 * SulfurasTest Class to validate different scenarios for the Sulfuras Items
 */
public class SulfurasTest {

    /**
     * Unit Test that validates that Sulfuras item never change, because is a legendary item
     */
    @Test
    public void sulfuras_legendaryItem_neverChanges() {
        GildedRose app = new GildedRose(new Item("Sulfuras, Hand of Ragnaros", 100, 100));
        app.updateQuality();
        assertItemEquals(app.getItems()[0], new Item("Sulfuras, Hand of Ragnaros", 100, 100));
    }
}
