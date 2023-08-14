import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingBasketTest {
    ShoppingBasket obj = new ShoppingBasket();
    @Test
    void extractGoodName() {

        assertEquals("chocolate bar", obj.extractGoodName("1 chocolate bar at 0.85", false));
        assertEquals("chocolate bar", obj.extractGoodName("1 imported chocolate bar at 0.85", true));
    }

    @Test
    void extractGoodRate() {
        var obj = new ShoppingBasket();
        assertEquals( 0.85f, obj.extractGoodRate("1 chocolate bar at 0.85 kind=exemption"));
        assertEquals( 1.85f, obj.extractGoodRate("1 imported box of chocolates at 1.85 kind=exemption"));
    }

    @Test
    void extractGoodQuantity() {
        assertEquals( 2, obj.extractGoodQuantity("2 imported box of chocolates at 10.00"));
        assertEquals( 5, obj.extractGoodQuantity("5 box of chocolates at 10.00"));

    }

    @Test
    void extractGoodType() {
        assertEquals(Kind.normal, obj.extractGoodType("1 book at 12.49 kind=normal"));
        assertEquals(Kind.exemption, obj.extractGoodType("1 imported box of chocolates kind=exemption"));
    }

    @Test
    void extractGoodImport() {
        assertTrue(obj.extractGoodImport("1 imported bottle of perfume at 27.99"));
        assertFalse(obj.extractGoodImport("1 bottle of perfume at 27.99"));
    }

    @Test
    void salesTaxCalculator() {
        Goods good1 = new Goods("book", Kind.exemption, 12.49f, 1, false, 0f);
        obj.salesTaxCalculator(good1);
        assertEquals(0f, good1.getSales_tax());

        Goods good2 = new Goods("music CD", Kind.normal, 14.99f, 1, false, 0f);
        obj.salesTaxCalculator(good2);
        assertEquals(1.5f, good2.getSales_tax());

        Goods good3 = new Goods("chocolates", Kind.exemption, 11.25f, 1, true, 0f);
        obj.salesTaxCalculator(good3);
        assertEquals(0.55f, good3.getSales_tax());

        Goods good4 = new Goods("bottle of perfume", Kind.normal, 27.99f, 1, true, 0f);
        obj.salesTaxCalculator(good4);
        assertEquals(4.20f, good4.getSales_tax());
    }
}