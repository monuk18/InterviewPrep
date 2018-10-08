package DesignPattern.objectPool;

public class ExpensiveResource {

    private String name;

    public ExpensiveResource(String name) {
        this.name = name;
    }

    public void doSomething() {
        System.out.println("I am resource " + this.name + ".");
    }

}