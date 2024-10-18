package states.context;

public interface VendingMachineContext {

    void insertDollar();

    void getCandy();

    void invalidatePurchase();

    void fillMachineWithCandies(final int numberOfCandies);
}
