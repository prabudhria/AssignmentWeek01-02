import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ShoppingBasketTest {
    @Test
    public void testCreateGood(){
        //creating mock for class Utility
        Utility utilityMock = mock(Utility.class);

        //testing good 1
        String good1_specification = "1 imported box of chocolates at 10.00 kind=exemption";

        when(utilityMock.ExtractGoodName(good1_specification, true)).thenReturn("box of chocolates");
        when(utilityMock.ExtractGoodImport(good1_specification)).thenReturn(true);
        when(utilityMock.ExtractGoodQuantity(good1_specification)).thenReturn(1);
        when(utilityMock.ExtractGoodType(good1_specification)).thenReturn(Kind.exemption);
        when(utilityMock.ExtractGoodRate(good1_specification)).thenReturn(10.00f);
        when(utilityMock.SalesTaxCalculator(1, 10.00f, true, Kind.exemption)).thenReturn(0.5f);

        ShoppingBasket shoppingBasket = new ShoppingBasket();
        Goods test_good1 = shoppingBasket.CreateGood(utilityMock, good1_specification);
        assertEquals("box of chocolates", test_good1.getName());
        assertTrue(test_good1.isImported());
        assertEquals(Kind.exemption, test_good1.getKind());
        assertEquals(10.5f, test_good1.getRate());
        assertEquals(1, test_good1.getQuantity());
        assertEquals(0.5f, test_good1.getSales_tax());

        //testing good 2
        String good2_specification = "1 bottle of perfume at 18.99 kind=normal";

        when(utilityMock.ExtractGoodName(good2_specification, false)).thenReturn("bottle of perfume");
        when(utilityMock.ExtractGoodImport(good2_specification)).thenReturn(false);
        when(utilityMock.ExtractGoodQuantity(good2_specification)).thenReturn(1);
        when(utilityMock.ExtractGoodType(good2_specification)).thenReturn(Kind.normal);
        when(utilityMock.ExtractGoodRate(good2_specification)).thenReturn(18.99f);
        when(utilityMock.SalesTaxCalculator(1, 18.99f, false, Kind.normal)).thenReturn(1.9f);

        Goods test_good2 = shoppingBasket.CreateGood(utilityMock, good2_specification);
        assertEquals("bottle of perfume", test_good2.getName());
        assertFalse(test_good2.isImported());
        assertEquals(Kind.normal, test_good2.getKind());
        assertEquals(20.89f, test_good2.getRate());
        assertEquals(1, test_good2.getQuantity());
        assertEquals(1.9f, test_good2.getSales_tax());


    }

}