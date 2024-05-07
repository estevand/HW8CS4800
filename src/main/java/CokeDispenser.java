public class CokeDispenser extends SnackDispenseHandler
{
    private VendingMachine vendingMachine;

    public CokeDispenser(VendingMachine vendingMachine)
    {
        this.vendingMachine = vendingMachine;
    }

    @Override
    protected boolean canDispense(Snack snack)
    {
        return snack.getName().equals("Coke") && snack.getQuantity() > 0;
    }

    @Override
    protected void dispenseSnack(Snack snack)
    {
        System.out.println("Dispensing a can of Coke! \n");
        snack.decreaseQuantity(1);
        vendingMachine.setState(new IdleState(vendingMachine));
    }
}
