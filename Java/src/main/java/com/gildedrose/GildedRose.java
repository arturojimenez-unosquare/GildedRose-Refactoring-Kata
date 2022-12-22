package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "Conjured Mana Cake";
    private Item[] items;

    public GildedRose(Item... items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQualityItem(item);

        }
    }

    public boolean isExpired(Item item){
         return item.sellIn < 1;
    }

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

    private void aging(Item item) {
        item.sellIn = item.sellIn - 1;
    }

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

    private void updateQuality(Item item, int value) {
        if (isExpired(item) && value < 0) {
            value = value * 2;
        }
        int newQuality = item.quality + value;

        if (newQuality >= 0 && newQuality <= 50) {
            item.quality = newQuality;
        }
    }

    public Item[] getItems() {
        return items;
    }
}
