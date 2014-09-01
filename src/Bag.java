import java.util.Random;
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
        int count=0;
        if(numElements != bag.length) {
            bag[numElements] = addValue;
            count++;
        }
        else {
            System.out.println("Could not add element, array is full.");
        }
        count++;
        numElements++;
        count++;
        System.out.println("Complexity for add method: " + count);
    }
    public void removeRandom(){
        int count=0;
        bag[new Random().nextInt(numElements)] = bag[numElements-1];
        count++;
        bag[numElements-1] = 0;
        count++;
        numElements--;
        count++;
        System.out.println("Complexity for removeRandom method: " + count);
    }
    public void remove(int integer){
        int count=0;
        if(contains(integer)){
            for(int index=0; index<numElements; index++){
                if(bag[index] == integer){
                    count++;
                    bag[index] = bag[numElements-1];
                    count++;
                    bag[numElements-1] = 0;
                    count++;
                    numElements--;
                    count++;
                }
            }
        }
        count++; //To count the contains conditional check
        System.out.println("Complexity for remove method: " + count);
    }

    public boolean isEmpty(){
        int count=1;
        System.out.println("Complexity for isEmpty method: " + count);
        return (numElements==0) ? true: false;
    }

    public boolean contains(int integer){
        int count=0;
        for(int index=0; index<numElements;index++){
            if (bag[index] == integer){
                return true;
            }
            count++;
        }
        System.out.println("Complexity for contains method: " + count);
        return false;
    }

    public int size(){
        return numElements;
    }

    public Bag addAll(Bag otherBag){
        int count=0;
        for(int value : otherBag.bag){
            if(numElements != bag.length){
                bag[numElements]=value;
                count++;
            }else{
                System.out.println("Could not add value, maximum array size reached.");
                break;
            }
            count++;
        }
        return this;
    }

    public static Bag union(Bag bag1, Bag bag2){
        Bag unionBag = new Bag(bag1.bag.length + bag2.bag.length);
        return unionBag;
    }

    public boolean equals(Bag otherBag){
        return true;
    }

}
