package desing.patterns.states.main;

import states.context.VendingMachineContext;
import states.context.VendingMachineContextImpl;

public class Main {
    public static void main(String[] args) {
        final VendingMachineContext vendingMachineContext =
                new VendingMachineContextImpl(5);
        flowOne(vendingMachineContext);
    }

    private static void flowOne(final VendingMachineContext vendingMachineContext) {
        gettingCandies(vendingMachineContext, 7);
        vendingMachineContext.fillMachineWithCandies(4);
        gettingCandies(vendingMachineContext, 7);
        vendingMachineContext.fillMachineWithCandies(4);
        invalidatePurchase(vendingMachineContext, 7);
        gettingCandies(vendingMachineContext, 7);
    }

    private static void flowTwo(final VendingMachineContext vendingMachineContext) {
        vendingMachineContext.getCandy();
        vendingMachineContext.insertDollar();
        vendingMachineContext.insertDollar();
        vendingMachineContext.getCandy();
        vendingMachineContext.getCandy();
    }

    private static void flowThree(final VendingMachineContext vendingMachineContext) {
        vendingMachineContext.invalidatePurchase();
        vendingMachineContext.getCandy();
        vendingMachineContext.insertDollar();
        vendingMachineContext.invalidatePurchase();
        vendingMachineContext.getCandy();
        vendingMachineContext.invalidatePurchase();
    }

    private static void gettingCandies(final VendingMachineContext vendingMachineContext, final int attempts) {
        for (int i = 0; i < attempts; i++) {
            vendingMachineContext.insertDollar();
            vendingMachineContext.getCandy();
        }
    }

    private static void invalidatePurchase(final VendingMachineContext vendingMachineContext, final int attempts) {
        for (int i = 0; i < attempts; i++) {
            vendingMachineContext.insertDollar();
            vendingMachineContext.invalidatePurchase();
        }
    }
}