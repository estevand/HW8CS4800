public class PepsiDispenser extends SnackDispenseHandler
{
    private VendingMachine vendingMachine;

    public PepsiDispenser(VendingMachine vendingMachine)
    {
        this.vendingMachine = vendingMachine;
    }

    @Override
    protected boolean canDispense(Snack snack)
    {
        return snack.getName().equals("Pepsi") && snack.getQuantity() > 0;
    }

    @Override
    protected void dispenseSnack(Snack snack)
    {
        System.out.println("Passed the Coke...");
        System.out.println("Dispensing a can of Pepsi! \n");
        snack.decreaseQuantity(1);
        vendingMachine.setState(new IdleState(vendingMachine));
    }
}

