import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CartTest {

    private Cart cart;
    private Item testApple = new Item("Apple", 60);
    private Item testOrange = new Item("Orange", 25);


    @Before
    public void setUp() throws Exception {
        cart = new Cart();
    }

    @After
    public void tearDown() throws Exception {
        cart = null;
    }

    @Test
    public void cartCreated_cartIsEmpty_getSizeShouldReturn_Zero() throws Exception{
        assertEquals(cart.getSize(), 0);
    }

    @Test
    public void cartCreated_addItem_getSizeShouldReturnOne() throws Exception{
        cart.addItem(testApple);
        assertEquals(cart.getSize(), 1);
    }

    @Test
    public void cartCreated_cartIsEmpty_getTotalShouldReTurn_Zero() throws Exception {
        assertEquals(cart.getTotal(), 0);
    }


    @Test
    public void cartCreated_addItem_getTotalShould_Increase() throws Exception {
        cart.addItem(testApple);
        cart.addItem(testOrange);
        assertEquals(cart.getTotal(), 85);
    }

    @Test
    public void cartCreated_cartIsEmpty_getItemNamesShouldReturn_String() throws Exception {
        assertEquals(cart.getItemNames(), "[cart is empty]");
    }

    @Test
    public void cartCreated_addItem_getItemNamesShouldReturn_CartIsEmpty() throws Exception {
        assertEquals(cart.getItemNames(), "[cart is empty]");
    }

    @Test
    public void cartCreated_addItem_getItemNamesShouldReturn_ItemNames() throws Exception {
        cart.addItem(testOrange);
        cart.addItem(testApple);
        assertEquals(cart.getItemNames(), "[Orange, Apple]");
    }
}