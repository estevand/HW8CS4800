import java.util.HashMap;
import java.util.Map;

public class VendingMachine
{
    private StateOfVendingMachine currentState;
    private Snack selectedSnack;
    private Map<String, Snack> snacks;
    private double currentMoney;


    public VendingMachine()
    {
        currentState = new IdleState(this);
        snacks = new HashMap<>();
    }

    public void setState(StateOfVendingMachine state)
    {
        this.currentState = state;
    }

    public void setSelectedSnack(Snack selectedSnack)
    {
        this.selectedSnack = selectedSnack;
    }

    public Snack getSelectedSnack()
    {
        return selectedSnack;
    }

    public void addSnack(Snack snack)
    {
        snacks.put(snack.getName(), snack);
    }

    public Snack getSnack(String name)
    {
        return snacks.get(name);
    }

    public void selectSnack(String snackName)
    {
        currentState.selectSnack(snackName);
    }

    public void insertMoney(double amount)
    {
        currentState.insertMoney(amount);
    }

    public void dispenseSnack()
    {
        currentState.dispenseSnack();
    }
}
