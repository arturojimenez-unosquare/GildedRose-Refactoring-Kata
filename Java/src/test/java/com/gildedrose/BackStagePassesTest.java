package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.ItemTestHelper.assertItemEquals;

public class BackStagePassesTest {

    @Test
    public void backStagePassesItem_increasesInQuality_byOneWhenThere10DaysMore() {
        GildedRose app = new GildedRose(new Item("Backstage passes to a TAFKAL80ETC concert", 20, 2));
        app.updateQuality();
        assertItemEquals(app.getItems()[0], new Item("Backstage passes to a TAFKAL80ETC concert", 19, 3));
    }

    @Test
    public void backStagePassesItem_increasesInQuality_byTwoWhenThere10DaysLess() {
        GildedRose app = new GildedRose(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 2));
        app.updateQuality();
        assertItemEquals(app.getItems()[0], new Item("Backstage passes to a TAFKAL80ETC concert", 9, 4));
    }

    @Test
    public void backStagePassesItem_increasesInQuality_byThreeWhenThere5DaysLess() {
        GildedRose app = new GildedRose(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 2));
        app.updateQuality();
        assertItemEquals(app.getItems()[0], new Item("Backstage passes to a TAFKAL80ETC concert", 4, 5));
    }

    @Test
    public void backStagePassesItem_increasesInQuality_dropsToZeroWhenSellInExpires() {
        GildedRose app = new GildedRose(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20));
        app.updateQuality();
        assertItemEquals(app.getItems()[0], new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0));
    }
}
