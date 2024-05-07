public class IdleState implements StateOfVendingMachine
{
    private VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine)
    {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectSnack(String snackName)
    {
        Snack snack = vendingMachine.getSnack(snackName);
        if (snack != null)
        {
            vendingMachine.setSelectedSnack(snack);
            vendingMachine.setState(new WaitingForMoneyState(vendingMachine));
        }
        else
        {
            System.out.println("Snack not available. \n");
        }
    }

    @Override
    public void insertMoney(double amount)
    {
        System.out.println("Please select a snack first. \n");
    }

    @Override
    public void dispenseSnack()
    {
        System.out.println("Please select a snack first. \n");
    }
}
