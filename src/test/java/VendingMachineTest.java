import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendingMachineTest
{
    VendingMachine vendingMachine = new VendingMachine();
    @Test
    public void testSelectSnack()
    {
        vendingMachine.addSnack(new Snack("Coke", 1.25, 10));
        vendingMachine.selectSnack("Coke");
        String expected = "Coke";
        String actual = vendingMachine.getSelectedSnack().getName();
        assertEquals(expected, actual);
    }

    @Test
    public void testPrice()
    {
        vendingMachine.addSnack(new Snack("Snickers", 1.00, 1));
        vendingMachine.selectSnack("Snickers");
        vendingMachine.insertMoney(1.00);
        double expected = 1.00;
        double actual = vendingMachine.getSnack("Snickers").getPrice();
        assertEquals(expected, actual);

    }

    @Test
    public void testOutOfStock()
    {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addSnack(new Snack("Cheetos", 1.50, 0));
        vendingMachine.selectSnack("Cheetos");
        vendingMachine.insertMoney(1.50);
        int expected = 0;
        int actual = vendingMachine.getSnack("Cheetos").getQuantity();
        assertEquals(expected, actual);
    }
}
