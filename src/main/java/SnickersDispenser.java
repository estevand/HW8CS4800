public class SnickersDispenser extends SnackDispenseHandler
{
    private VendingMachine vendingMachine;

    public SnickersDispenser(VendingMachine vendingMachine)
    {
        this.vendingMachine = vendingMachine;
    }

    @Override
    protected boolean canDispense(Snack snack)
    {
        return snack.getName().equals("Snickers") && snack.getQuantity() > 0;
    }

    @Override
    protected void dispenseSnack(Snack snack)
    {
        System.out.println("Passed the Coke...");
        System.out.println("Passed the Pepsi...");
        System.out.println("Passed the Cheetos...");
        System.out.println("Passed the Doritos...");
        System.out.println("Passed the KitKat...");
        System.out.println("Dispensing a Snickers! \n");
        snack.decreaseQuantity(1);
        vendingMachine.setState(new IdleState(vendingMachine));
    }
}
