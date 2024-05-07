public class DoritosDispenser extends SnackDispenseHandler
{
    private VendingMachine vendingMachine;

    public DoritosDispenser(VendingMachine vendingMachine)
    {
        this.vendingMachine = vendingMachine;
    }

    @Override
    protected boolean canDispense(Snack snack)
    {
        return snack.getName().equals("Doritos") && snack.getQuantity() > 0;
    }

    @Override
    protected void dispenseSnack(Snack snack)
    {
        System.out.println("Passed the Coke...");
        System.out.println("Passed the Pepsi...");
        System.out.println("Passed the Cheetos...");
        System.out.println("Dispensing a bag Doritos! \n");
        snack.decreaseQuantity(1);
        vendingMachine.setState(new IdleState(vendingMachine));
    }
}
