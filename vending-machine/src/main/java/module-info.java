import states.context.VendingMachineContext;
import states.context.VendingMachineContextImpl;

module vending.machine {
    exports states.context;
    provides VendingMachineContext with VendingMachineContextImpl;
}