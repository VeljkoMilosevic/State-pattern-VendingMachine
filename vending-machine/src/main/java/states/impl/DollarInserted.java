package states.impl;

import states.context.VendingMachineContextImpl;
import states.State;

import java.lang.ref.PhantomReference;

public class DollarInserted implements State {

    private final VendingMachineContextImpl vendingMachineContext;

    public DollarInserted(VendingMachineContextImpl vendingMachineContext) {
        this.vendingMachineContext = vendingMachineContext;
    }

    @Override
    public void insertDollar() {
        System.out.println("You already inserted dollar! You cannot" +
                " insert another one!");
    }

    @Override
    public void getCandy() {
        System.out.println("You will be get your candy!");
        vendingMachineContext.setCurrentState(vendingMachineContext.getDollarNotInserted());
        vendingMachineContext.reduceCandyNumber();
    }

    @Override
    public void invalidatePurchase() {
        System.out.println("You will get your dollar back!");
        vendingMachineContext.setCurrentState(vendingMachineContext.getDollarNotInserted());
    }
}
