import java.util.Map;
import java.util.HashMap;
public class DispensingSnackState implements StateOfVendingMachine
{
    private VendingMachine vendingMachine;
    private Map<String, SnackDispenseHandler> snackHandlers;

    public DispensingSnackState(VendingMachine vendingMachine)
    {
        this.vendingMachine = vendingMachine;
        this.snackHandlers = new HashMap<>();
        snackHandlers.put("Coke", new CokeDispenser(vendingMachine));
        snackHandlers.put("Pepsi", new PepsiDispenser(vendingMachine));
        snackHandlers.put("Cheetos", new CheetosDispenser(vendingMachine));
        snackHandlers.put("Doritos", new DoritosDispenser(vendingMachine));
        snackHandlers.put("KitKat", new KitKatDispenser(vendingMachine));
        snackHandlers.put("Snickers", new SnickersDispenser(vendingMachine));
    }


    @Override
    public void selectSnack(String snackName)
    {
        System.out.println("Dispensing a snack.");
    }

    @Override
    public void insertMoney(double amount)
    {
        System.out.println("Already dispensing a snack.");
    }

    @Override
    public void dispenseSnack()
    {
        Snack selectedSnack = vendingMachine.getSelectedSnack();
        if (selectedSnack != null && selectedSnack.getQuantity() > 0) {
            SnackDispenseHandler handler = snackHandlers.get(selectedSnack.getName());
            if (handler != null) {
                handler.dispense(selectedSnack);
            } else {
                System.out.println("No handler found for the selected snack.");
            }
        } else {
            System.out.println("This snack: " + selectedSnack.getName() + ", is out of stock. \n");
            vendingMachine.setState(new IdleState(vendingMachine));
        }
    }
}
