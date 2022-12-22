package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.TestHelper.assertItemEquals;

/**
 * BackStagePassesTest Class to validate different scenarios for the Back Stage Passes Items
 */
public class BackStagePassesTest {

    /**
     * Unit Test that validates the Back Stage Pasess item icrease by 1 when there are 10 days or more
     */
    @Test
    public void backStagePassesItem_increasesInQuality_byOneWhenThere10DaysMore() {
        GildedRose app = new GildedRose(new Item("Backstage passes to a TAFKAL80ETC concert", 20, 2));
        app.updateQuality();
        assertItemEquals(app.getItems()[0], new Item("Backstage passes to a TAFKAL80ETC concert", 19, 3));
    }

    /**
     * Unit Test that validates the Back Stage Passes item icrease by 2 when there are 10 days or less
     */
    @Test
    public void backStagePassesItem_increasesInQuality_byTwoWhenThere10DaysLess() {
        GildedRose app = new GildedRose(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 2));
        app.updateQuality();
        assertItemEquals(app.getItems()[0], new Item("Backstage passes to a TAFKAL80ETC concert", 9, 4));
    }

    /**
     * Unit Test that validates the Back Stage Passes item icrease by 3 when there are 5 days or less
     */
    @Test
    public void backStagePassesItem_increasesInQuality_byThreeWhenThere5DaysLess() {
        GildedRose app = new GildedRose(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 2));
        app.updateQuality();
        assertItemEquals(app.getItems()[0], new Item("Backstage passes to a TAFKAL80ETC concert", 4, 5));
    }

    /**
     * Unit Test that validates the Back Stage Passes item  drops to 0 after the concert
     */
    @Test
    public void backStagePassesItem_increasesInQuality_dropsToZeroWhenSellInExpires() {
        GildedRose app = new GildedRose(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20));
        app.updateQuality();
        assertItemEquals(app.getItems()[0], new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0));
    }
}
