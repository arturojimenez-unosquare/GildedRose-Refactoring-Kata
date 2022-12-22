package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.TestHelper.assertItemEquals;


/**
 * GildedRoseTest Class to validate different scenarios for some Items
 */
public class GildedRoseTest {

    /**
     * Unit Test that validates that the sell in decrease but the quality can not be negative in an item
     */
    @Test
    public void sellInDateDecreases_butQualityCannotBeNegative() {
        GildedRose app = new GildedRose(new Item("Magical Mana Generator", 10, 30));
        app.updateQuality();
        assertItemEquals(app.getItems()[0], new Item("Magical Mana Generator", 9, 29));
    }

    /**
     * Unit Test that validates that the quality of the item decrease
     */
    @Test
    public void qualityDecreases() {
        GildedRose app = new GildedRose(new Item("Magical Mana Generator", 1, 21));
        app.updateQuality();
        assertItemEquals(app.getItems()[0], new Item("Magical Mana Generator", 0, 20));
    }

    /**
     * Unit Test that validates that the quality of the item decrease faster if the sell in is expired
     */
    @Test
    public void qualityDecreasesFasterAfterSellInDateExpired() {
        GildedRose app = new GildedRose(new Item("Magical Mana Generator", 0, 20));
        app.updateQuality();
        assertItemEquals(app.getItems()[0], new Item("Magical Mana Generator", -1, 18));
    }

}
