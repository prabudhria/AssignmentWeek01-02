import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilityTest {
    Utility utility = new Utility();

    @Test
    void testExtractGoodName() {

        assertEquals("chocolate bar", utility.ExtractGoodName("1 chocolate bar at 0.85", false));
        assertEquals("chocolate bar", utility.ExtractGoodName("1 imported chocolate bar at 0.85", true));
    }

    @Test
    void testExtractGoodRate() {
        var obj = new ShoppingBasket();
        assertEquals( 0.85f, utility.ExtractGoodRate("1 chocolate bar at 0.85 kind=exemption"));
        assertEquals( 1.85f, utility.ExtractGoodRate("1 imported box of chocolates at 1.85 kind=exemption"));
    }

    @Test
    void testExtractGoodQuantity() {
        assertEquals( 2, utility.ExtractGoodQuantity("2 imported box of chocolates at 10.00"));
        assertEquals( 5, utility.ExtractGoodQuantity("5 box of chocolates at 10.00"));

    }

    @Test
    void testExtractGoodType() {
        assertEquals(Kind.normal, utility.ExtractGoodType("1 book at 12.49 kind=normal"));
        assertEquals(Kind.exemption, utility.ExtractGoodType("1 imported box of chocolates kind=exemption"));
    }

    @Test
    void testExtractGoodImport() {
        assertTrue(utility.ExtractGoodImport("1 imported bottle of perfume at 27.99"));
        assertFalse(utility.ExtractGoodImport("1 bottle of perfume at 27.99"));
    }

    @Test
    void testSalesTaxCalculatorForExemption() {
        assertEquals(0f, utility.SalesTaxCalculator(1,12.49f, false, Kind.exemption));

        assertEquals(0.55f, utility.SalesTaxCalculator(1, 11.25f, true, Kind.exemption));
    }

    @Test
    void testSalesTaxCalculatorForNormal(){
        assertEquals(4.20f, utility.SalesTaxCalculator(1, 27.99f, true, Kind.normal));

        assertEquals(1.5f, utility.SalesTaxCalculator(1, 14.99f, false, Kind.normal));
    }


}