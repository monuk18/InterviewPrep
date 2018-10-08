package DesignPattern.objectPool;

public interface Pool {

    Object get();
    void  release(Object object);
    void shutDown();

}
