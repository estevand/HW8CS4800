public abstract class SnackDispenseHandler
{
    private SnackDispenseHandler nextHandler;

    public void setNextHandler(SnackDispenseHandler nextHandler)
    {
        this.nextHandler = nextHandler;
    }

    public void dispense(Snack snack)
    {
        if (canDispense(snack))
        {
            dispenseSnack(snack);
        } else if (nextHandler != null)
        {
            nextHandler.dispense(snack);
        }
        else
        {
            System.out.println("Snack not available. \n");
        }
    }

    protected abstract boolean canDispense(Snack snack);

    protected abstract void dispenseSnack(Snack snack);
}

