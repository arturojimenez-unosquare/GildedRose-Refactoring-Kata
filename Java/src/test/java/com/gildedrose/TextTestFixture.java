package com.gildedrose;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.String.format;

/**
 * TextTestFixture Class that validates the expected information against the information that is created in the unit tests
 */
public class TextTestFixture {

    /**
     * Method that compares the file "file.txt" found in the path: resources against
     * the information that is being created
     * @throws IOException
     */
    @Test
    public void checkAllFile() throws IOException {
        String file = new String(Files.readAllBytes(Paths.get("src/test/resources/file.txt")));
        String current = build().toString();
        Assert.assertEquals(trimEachLine(file +"\r\n"), trimEachLine(current));
    }

    private String trimEachLine(String string) {
        return string.replaceAll("(?m)[\\s+&&[^\\n]]+$", "");
    }


    /**
     * Method that writes the file
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        StringBuilder builder = build();
        Files.write(Paths.get("src/test/resources/file.txt"), builder.toString().getBytes());
    }

    /**
     * method that creates a file with sales for a month
     * @return
     */
    private static StringBuilder build() {
        Item[] items = new Item[]{
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Elixir of the Mongoose", 5, 7),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            new Item("Conjured Mana Cake", 3, 6)
        };

        StringBuilder builder = new StringBuilder();
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < 32; i++) {
            builder.append(format("------------------------- day %s -------------------------- %n", i));
            builder.append(format("%42s %6s %-8s %n", "NAME", "SELLIN", "QUALITY"));
            for (Item item : items) {
                builder.append(format("%42s %6s %-8s %n", item.name, item.sellIn, item.quality));
            }
            builder.append(format("%n"));
            app.updateQuality();
        }

        return builder;
    }

}
