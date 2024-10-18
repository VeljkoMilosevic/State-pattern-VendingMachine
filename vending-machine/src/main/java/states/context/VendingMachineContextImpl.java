package states.context;

import states.impl.DollarInserted;
import states.impl.DollarNotInserted;
import states.impl.EmptyMachine;
import states.State;

public class VendingMachineContextImpl implements VendingMachineContext {

    private int numberOfCandies;
    private State currentState;

    private final DollarInserted dollarInserted;
    private final DollarNotInserted dollarNotInserted;
    private final EmptyMachine emptyMachine;

    public VendingMachineContextImpl() {
        this(0);
    }

    public VendingMachineContextImpl(final int numberOfCandies) {
        dollarInserted = new DollarInserted(this);
        dollarNotInserted = new DollarNotInserted(this);
        emptyMachine = new EmptyMachine(this);
        setCurrentState(dollarNotInserted);
        this.numberOfCandies = numberOfCandies;
    }

    private State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(final State currentState) {
        this.currentState = currentState;
    }

    public State getDollarInserted() {
        return dollarInserted;
    }

    public State getDollarNotInserted() {
        return dollarNotInserted;
    }

    public State getEmptyMachine() {
        return emptyMachine;
    }

    @Override
    public void insertDollar() {
        if (numberOfCandies > 0) {
            getCurrentState().insertDollar();
        } else {
            setCurrentState(getEmptyMachine());
        }
    }

    @Override
    public void getCandy() {
        getCurrentState().getCandy();
        System.out.println("Number of candies left:" + numberOfCandies);
    }

    @Override
    public void invalidatePurchase() {
        getCurrentState().invalidatePurchase();
    }

    @Override
    public void fillMachineWithCandies(final int numberOfCandies) {
        this.numberOfCandies += numberOfCandies;
        System.out.println("Candies filled. New number of candies:" + numberOfCandies);
        if (numberOfCandies > 0) {
            setCurrentState(getDollarNotInserted());
        }
    }

    public void reduceCandyNumber() {
        numberOfCandies--;
    }
}
