package com.gildedrose;

/**
 * GildedRose Class that update the sell in and quality of the items
 */
 public class GildedRose {

    /**
     * Constants to validate specific items of name: Aged Brie
      */
    public static final String AGED_BRIE = "Aged Brie";

    /**
     * Constants to validate specific items of name: Backstage passes to a TAFKAL80ETC concert
     */
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    /**
     * Constants to validate specific items of name: Sulfuras, Hand of Ragnaros
     */
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    /**
     * Constants to validate specific items of name: Conjured Mana Cake
     */
    public static final String CONJURED = "Conjured Mana Cake";
    private Item[] items;


    /**
     * GildedRose Constructor
     * @param items
     */
    public GildedRose(Item... items) {
        this.items = items;
    }

    /**
     * Method that updates the quality of products at the end of the day
     */
    public void updateQuality() {
        for (Item item : items) {
            updateQualityItem(item);

        }
    }

    /**
     * Check if a product is expired
     * @param item
     * @return true if is expired or false is not expired
     */
    public boolean isExpired(Item item){
         return item.sellIn < 1;
    }

    /**
     * Method that carries out the process of updating the products according to the type of product:
     * Aged Brie, Backstage Passed, Sulfuras or Conjured
     * @param item
     */
    private void updateQualityItem(Item item) {

        switch (item.name) {
            case AGED_BRIE:
                int value = isExpired(item) ? 2 : 1;
                updateQuality(item, value);
                aging(item);
                break;
            case BACKSTAGE_PASSES:
                updateBackStageQuality(item);
                aging(item);
                break;
            case SULFURAS:
                break;
            case CONJURED:
                updateQuality(item, -2);
                aging(item);
                break;
            default:
                updateQuality(item, -1);
                aging(item);
        }
    }

    /**
     * Method that downgrades the expiration of an item
     * @param item
     */
    private void aging(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    /**
     * Method that updates the quality of a product of type: Backstage passes
     * "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
     * 	Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
     * 	Quality drops to 0 after the concert
     * @param item
     */
    private void updateBackStageQuality(Item item) {
        if (item.sellIn > 5 && item.sellIn <=10 ) {
            updateQuality(item, 2);
        } else  if (item.sellIn > 0 && item.sellIn <= 5) {
            updateQuality(item, 3);
        } else {
            updateQuality(item, 1);
        }

        if (isExpired(item)) {
            item.quality = 0;
        }
    }

    /**
     * Method that updates the quality of the products, reviews the following criteria:
     * 1._ If the article is expired and the value is less than zero: degrade the article twice as fast
     * 2._ Item should never have quality negative value and item can never have its Quality increase above 50
     * @param item
     * @param value
     */
    private void updateQuality(Item item, int value) {
        if (isExpired(item) && value < 0) {
            value = value * 2;
        }
        int newQuality = item.quality + value;

        if (newQuality >= 0 && newQuality <= 50) {
            item.quality = newQuality;
        }
    }

    /**
     * Method that returns an array of items
     * @return array of Item
     */
    public Item[] getItems() {
        return items;
    }
}
