public class Driver
{
    public static void main(String[] args)
    {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.addSnack(new Snack("Coke", 1.25, 10));
        vendingMachine.addSnack(new Snack("Pepsi", 1.25, 10));
        vendingMachine.addSnack(new Snack("Cheetos", 1.50, 10));
        vendingMachine.addSnack(new Snack("Doritos", 1.50, 10));
        vendingMachine.addSnack(new Snack("KitKat", 1.00, 10));
        vendingMachine.addSnack(new Snack("Snickers", 1.00, 1));

        SnackDispenseHandler cokeDispenser = new CokeDispenser(vendingMachine);
        SnackDispenseHandler pepsiDispenser = new PepsiDispenser(vendingMachine);
        SnackDispenseHandler cheetosDispenser = new CheetosDispenser(vendingMachine);
        SnackDispenseHandler doritosDispenser = new DoritosDispenser(vendingMachine);
        SnackDispenseHandler kitkatDispenser = new KitKatDispenser(vendingMachine);
        SnackDispenseHandler snickersDispenser = new SnickersDispenser(vendingMachine);

        cokeDispenser.setNextHandler(pepsiDispenser);
        pepsiDispenser.setNextHandler(cheetosDispenser);
        cheetosDispenser.setNextHandler(doritosDispenser);
        doritosDispenser.setNextHandler(kitkatDispenser);
        kitkatDispenser.setNextHandler(snickersDispenser);

        vendingMachine.selectSnack("Coke");
        vendingMachine.insertMoney(1.25);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("Pepsi");
        vendingMachine.insertMoney(2.00);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("Cheetos");
        vendingMachine.insertMoney(3.00);
        vendingMachine.dispenseSnack();


        vendingMachine.selectSnack("Doritos");
        vendingMachine.insertMoney(1.50);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("KitKat");
        vendingMachine.insertMoney(1.00);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("Snickers");
        vendingMachine.insertMoney(2.00);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("Snickers");
        vendingMachine.insertMoney(2.50);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("Coke");

        vendingMachine.selectSnack("Pepsi");
        vendingMachine.insertMoney(1.00);

        vendingMachine.selectSnack("Cheetos");
        vendingMachine.insertMoney(5.00);
        vendingMachine.dispenseSnack();

        vendingMachine.dispenseSnack();




    }
}


