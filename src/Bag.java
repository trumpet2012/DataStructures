/**
 * Created by trent on 9/1/14.
 */
public class Bag {
    public int bag[];
    private int numElements; //number of elements currently in the array

    public Bag(int bagSize){
        bag = new int[bagSize];
        numElements = 0;
    }

    public void add(int addValue){
        bag[numElements] = addValue;
        numElements++;
    }
    public void removeRandom(){

    }
    public void remove(int element){

    }
    public boolean isEmpty(){
        return true;
    }
    public boolean contains(int integer){
        return true;
    }
    public int size(){
        return numElements;
    }
    public Bag addAll(Bag otherBag){

    }
    public Bag union(Bag bag1, Bag bag2){

    }
    public boolean equals(Bag otherBag){

    }

}
