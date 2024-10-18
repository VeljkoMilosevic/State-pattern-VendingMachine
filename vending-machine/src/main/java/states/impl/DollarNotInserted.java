package states.impl;

import states.context.VendingMachineContextImpl;
import states.State;

public class DollarNotInserted implements State {
    private final VendingMachineContextImpl vendingMachineContext;

    public DollarNotInserted(VendingMachineContextImpl vendingMachineContext) {
        this.vendingMachineContext = vendingMachineContext;
    }

    @Override
    public void insertDollar() {
        System.out.println("You insert dollar into machine!");
        vendingMachineContext.setCurrentState(vendingMachineContext.getDollarInserted());
    }

    @Override
    public void getCandy() {
        System.out.println("You cannot get candy because you did " +
                "not insert money!");
    }

    @Override
    public void invalidatePurchase() {
        System.out.println("You cannot invalidate purchase because " +
                "you did not insert money!");
    }
}
