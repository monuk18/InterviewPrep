package DesignPattern.objectPool;

public class ExpensiveResourcePool extends ObjectPool {

    public ExpensiveResourcePool(int size) {
        super(size);
    }



    @Override
    public ExpensiveResource createNew() {
        //return an object with random name
        return new ExpensiveResource("random"+Math.random());
    }
}
