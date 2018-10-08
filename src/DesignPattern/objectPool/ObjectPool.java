package DesignPattern.objectPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class ObjectPool implements  Pool,ObjectFactory{

    private int size;
    private BlockingQueue  poolQueue ;
    private boolean shutDown ;

    public ObjectPool(int size) {
        this.size = size;
        shutDown=false;
        init();
    }

    public void  init(){
        poolQueue = new LinkedBlockingQueue();
        for(int i=0;i<size;i++){
            poolQueue.add(createNew());
        }
    }

    @Override
    public void shutDown() {
        shutDown=true;
        poolQueue.clear();
    }

    @Override
    public Object get()  {
        Object obj = null;
        try {
            obj = poolQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  obj;
    }

    @Override
    public void release(Object object) {
        poolQueue.offer(object);
    }

    public int size(){
      return  poolQueue.size();
    }
}
