package misc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class everySecondIteratorMain {


    public static void main(String [] args){
        myArrayList<Integer> arrayList = new myArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        Iterator itr = arrayList.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }

}

class myArrayList<T> extends ArrayList<T> implements Iterable<T>{

    Object[] elementData;

    @Override
    public Iterator<T> iterator() {
        return new evenIterrator<T>(super.iterator());
    }

    class evenIterrator<T> implements Iterator<T> {

        Iterator<T> iterator;

        public evenIterrator(Iterator<T> iterator) {
            this.iterator=iterator;
        }



        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public T next() {
            iterator.next();
            T t =null;
             try{
                 t =iterator.next();
             }catch (NoSuchElementException e){

             }
            return t;
        }
    }
}

