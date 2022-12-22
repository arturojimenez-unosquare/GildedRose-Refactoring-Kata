package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.TestHelper.assertItemEquals;



public class GildedRoseTest {

    @Test
    public void sellInDateDecreases_butQualityCannotBeNegative() {
        GildedRose app = new GildedRose(new Item("article", 0, 0));
        app.updateQuality();
        assertItemEquals(app.getItems()[0], new Item("article", -1, 0));
    }

    @Test
    public void qualityDecreases() {
        GildedRose app = new GildedRose(new Item("article", 10, 10));
        app.updateQuality();
        assertItemEquals(app.getItems()[0], new Item("article", 9, 9));
    }

    @Test
    public void qualityDecreasesFasterAfterSellInDateExpired() {
        GildedRose app = new GildedRose(new Item("article", 0, 10));
        app.updateQuality();
        assertItemEquals(app.getItems()[0], new Item("article", -1, 8));
    }

}
