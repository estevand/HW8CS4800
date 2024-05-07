public class CheetosDispenser extends SnackDispenseHandler
{
    private VendingMachine vendingMachine;

    public CheetosDispenser(VendingMachine vendingMachine)
    {
        this.vendingMachine = vendingMachine;
    }

    @Override
    protected boolean canDispense(Snack snack)
    {
        return snack.getName().equals("Cheetos") && snack.getQuantity() > 0;
    }

    @Override
    protected void dispenseSnack(Snack snack)
    {
        System.out.println("Passed the Coke...");
        System.out.println("Passed the Pepsi...");
        System.out.println("Dispensing a bag of Cheetos! \n");
        snack.decreaseQuantity(1);
        vendingMachine.setState(new IdleState(vendingMachine));
    }
}
