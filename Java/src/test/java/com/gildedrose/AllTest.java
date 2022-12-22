package com.gildedrose;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
    AgedBrieTest.class,
    BackStagePassesTest.class,
    ConjuredItemTest.class,
    GildedRoseTest.class,
    SulfurasTest.class,
    TextTestFixture.class
})
public class AllTest {
}
