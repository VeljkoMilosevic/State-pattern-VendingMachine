package states.impl;

import states.context.VendingMachineContextImpl;
import states.State;

public class EmptyMachine implements State {

    private final VendingMachineContextImpl vendingMachineContext;

    public EmptyMachine(VendingMachineContextImpl vendingMachineContext) {
        this.vendingMachineContext = vendingMachineContext;
    }

    @Override
    public void insertDollar() {
        System.out.println("You cannot insert money because " +
                "the machine is empty!");
    }

    @Override
    public void getCandy() {
        System.out.println("You cannot get candy because " +
                "the machine is empty!");
    }

    @Override
    public void invalidatePurchase() {
        System.out.println("You cannot invalidate purchase because" +
                " you did not start any!");
    }
}
