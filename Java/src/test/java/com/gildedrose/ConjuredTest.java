package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.TestHelper.assertItemEquals;

/**
 * ConjuredTest Class to validate different scenarios for the Conjured Items
 */
public class ConjuredTest {

    /**
     * Unit Test that validates the Conjured item icrease twice as fast  as normal items
     */
    @Test
    public void conjuredItem_decreasesQuality_twiceAsFast() {
        GildedRose app = new GildedRose(new Item("Conjured Mana Cake", 3, 6));
        app.updateQuality();
        assertItemEquals(app.getItems()[0], new Item("Conjured Mana Cake", 2, 4));
    }

    /**
     * Unit Test that validates the Conjured item icrease twice as fast when sell in is expired
     */
    @Test
    public void conjuredItem_decreasesQuality_twiceAsFast_whenSellInExpired() {
        GildedRose app = new GildedRose(new Item("Conjured Mana Cake", 0, 6));
        app.updateQuality();
        assertItemEquals(app.getItems()[0], new Item("Conjured Mana Cake", -1, 2));
    }
}
