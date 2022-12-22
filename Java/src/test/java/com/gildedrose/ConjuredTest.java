package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.TestHelper.assertItemEquals;

public class ConjuredTest {

    @Test
    public void conjuredItem_decreasesQuality_twiceAsFast() {
        GildedRose app = new GildedRose(new Item("Conjured Mana Cake", 3, 6));
        app.updateQuality();
        assertItemEquals(app.getItems()[0], new Item("Conjured Mana Cake", 2, 4));
    }

    @Test
    public void conjuredItem_decreasesQuality_twiceAsFast_whenSellInExpired() {
        GildedRose app = new GildedRose(new Item("Conjured Mana Cake", 0, 6));
        app.updateQuality();
        assertItemEquals(app.getItems()[0], new Item("Conjured Mana Cake", -1, 2));
    }
}
