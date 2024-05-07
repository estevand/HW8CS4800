public class WaitingForMoneyState implements StateOfVendingMachine
{
    private VendingMachine vendingMachine;

    public WaitingForMoneyState(VendingMachine vendingMachine)
    {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectSnack(String snackName)
    {
        System.out.println("Waiting for money. \n");
    }

    @Override
    public void insertMoney(double amount)
    {
        Snack selectedSnack = vendingMachine.getSelectedSnack();
        if (selectedSnack != null)
        {
            if (amount >= selectedSnack.getPrice())
            {
                vendingMachine.setState(new DispensingSnackState(vendingMachine));
            }
            else
            {
                System.out.println("Not enough money. Please insert more. \n");
            }
        }
        else
        {
            System.out.println("Please select a snack first. \n");
        }
    }

    @Override
    public void dispenseSnack()
    {
        System.out.println("Please insert money first.");
    }
}
