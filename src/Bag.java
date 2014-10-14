import java.util.Random;
/**
 * Created by William Trent Holliday
 *
 * This is the Bag class. It is the implementation of the collection type known
 * as a Bag. Contains all of the operations that apply to Bags.
 *
 * Test this class using the provided BagTester.java file.
 *
 * Created by Trent Holliday
 */
public class Bag {
    public int bag[];
    public int numElements; //number of elements currently in the array

    /**
     * Constructs a bag of the specified size.
     *
     * @param bagSize size to make the bag
     */
    public Bag(int bagSize){
        bag = new int[bagSize];
        numElements = 0;
    }

    /**
     * Adds a value to the bag if there is room.
     *
     * @param addValue Value to be added to the bag.
     * @param showComplexity If false will not print the complexity
     */
    public void add(int addValue, boolean showComplexity){
        long start_time = System.nanoTime();
        int count=0;
        if(numElements != bag.length) {
            bag[numElements] = addValue;
            count++;
        }
        else {
            System.out.println("---(ERROR) Could not add element, array is full.");
            if(showComplexity)
                System.out.println("---Bag " + this + " - complexity for add method: " + count);
            return;
        }
        count++;
        numElements++;
        count++;

        if(showComplexity) {
            System.out.println("---Bag " + this + " - complexity for add method: " + count);
            long end_time = System.nanoTime();
            System.out.println("---Add method run time: " + (end_time - start_time) + " ns");
        }
    }

    /**
     * Removes a random value from the bag.
     */
    public void removeRandom(){
        long start_time = System.nanoTime();
        int count=0;
        bag[new Random().nextInt(numElements)] = bag[numElements-1];
        count++;
        bag[numElements-1] = 0;
        count++;
        numElements--;
        count++;
        System.out.println("---Bag " + this +" - complexity for removeRandom method: " + count);
        long end_time = System.nanoTime();
        System.out.println("---removeRandom run time: " + (end_time - start_time) + " ns");
    }

    /**
     * Removes the specified value from the bag. Prints an error message if
     * unable to find the specified value.
     *
     * @param integer The value to be removed from the bag.
     */
    public void remove(int integer){
        long start_time = System.nanoTime();
        int count=0;
        if(contains(integer) != -1){
            for(int index=0; index<numElements; index++){
                if(bag[index] == integer){
                    count++;
                    bag[index] = bag[numElements-1];
                    count++;
                    bag[numElements-1] = 0;
                    count++;
                    numElements--;
                    count++;
                    break;
                }
            }
        }else{
            System.out.println("---(ERROR) Bag does not contain " + integer);
        }
        count++;
        System.out.println("---Bag " + this +" - complexity for remove method: " + count);
        long end_time = System.nanoTime();
        System.out.println("---remove method run time: " + (end_time - start_time));
    }

    /**
     * Checks whether or not the bag is empty.
     *
     * @return true if bag is empty, false otherwise.
     */
    public boolean isEmpty(){
        long start_time = System.nanoTime();
        int count=1;
        System.out.println("---Bag " + this +" - complexity for isEmpty method: " + count);
        long end_time = System.nanoTime();
        System.out.println("---isEmpty method run time: " + (end_time - start_time) + " ns");
        return (numElements == 0);
    }

    /**
     * Loops through the bag checking to see if the specified value is in the bag.
     *
     * @param integer the value to search for
     * @param showComplexity set to false to not print the complexity for the method
     * @return true if the value was found, false otherwise.
     */
    public int contains(int integer, boolean showComplexity){
        long start_time = System.nanoTime();
        int count=0;
        for(int index=0; index<numElements;index++){
            if (bag[index] == integer){
                if(showComplexity)
                    System.out.println("---Bag " + this +" - complexity for contains method: " + count);

                return index;
            }
            count++;
        }
        if(showComplexity)
            System.out.println("---Bag " + this +" - complexity for contains method: " + count);
        long end_time = System.nanoTime();
        System.out.println("---contains method run time: " + (end_time - start_time) + " ns");
        return -1;
    }

    /**
     * Helper method for contains(int, bool). Used to set showComplexity to false.
     * Just a convenience method.
     * @param integer value to search the Bag for
     * @return true if value is in Bag, false otherwise
     */
    public int contains(int integer){
        return contains(integer, false);
    }

    /**
     * Gets the number of values currently in the bag.
     * @return number of values in the bag.
     */
    public int size(){
        return numElements;
    }

    /**
     * Adds all of the values from the specified bag into the current bag.
     *
     * @param otherBag the bag that contains the values to add
     * @return the Bag the method was called on
     */
    public Bag addAll(Bag otherBag){
        long start_time = System.nanoTime();
        int count=0;
        for(int value : otherBag.bag){
            if(numElements != bag.length) {
                bag[numElements] = value;
                count++;
                numElements++;
                count++;
            }else{
                System.out.println("---(ERROR) Bag " + this +" - could not add value, maximum array size reached.");
                break;
            }
            count++;
        }
        System.out.println("---Bag " + this +" - complexity for addAll method: " + count);
        long end_time = System.nanoTime();
        System.out.println("---addAll method run time: " + (end_time - start_time) + " ns");
        return this;
    }

    /**
     * Adds all of the values from the two specified bags into a third bag.
     *
     * @param bag1 Bag to pull values from.
     * @param bag2 Bag to pull values from.
     * @return Bag that contains all the values from bag1 and bag2
     */
    public static Bag union(Bag bag1, Bag bag2){
        long start_time = System.nanoTime();
        int count=0;
        Bag unionBag = new Bag(bag1.numElements + bag2.numElements);
        count++;
        int unionBagCount = 0;
        for(int index=0;index<bag1.numElements; index++){
            unionBag.bag[unionBagCount] = bag1.bag[index];
            count++;
            unionBagCount++;
            count++;
        }
        for(int index=0;index<bag2.numElements; index++){
            unionBag.bag[unionBagCount] = bag2.bag[index];
            count++;
            unionBagCount++;
            count++;
        }
        unionBag.numElements = unionBagCount;
        System.out.println("---Complexity for union method: " + count);
        long end_time = System.nanoTime();
        System.out.println("---union method run time: " + (end_time - start_time) + " ns");
        return unionBag;
    }

    /**
     * Checks whether the specified Bag is equal to the current Bag. Order
     * does not matter when checking for equality. Simply checks that both
     * bags contain the same values.
     *
     * @param otherBag the Bag to compare to the current Bag.
     * @return true if the Bags are equal, false otherwise.
     */
    public boolean equals(Bag otherBag){
        long start_time = System.nanoTime();
        int count=0;
        Bag combinedBag = Bag.union(this, otherBag);
        count++;
        if(numElements != otherBag.numElements){
            System.out.println("---Bag " + this +" - complexity for equals method: " + count);
            return false;
        }
        count++;
        int index = 0;
        while(numElements > 0 && otherBag.numElements > 0){
            int itemCombinedBag=combinedBag.bag[index];
            count++;
            int indexBagOne = this.contains(itemCombinedBag);
            count++;
            int indexBagTwo = otherBag.contains(itemCombinedBag);
            count++;
            if(indexBagOne==-1 || indexBagTwo==-1){
                System.out.println("---Bag " + this +" - complexity for equals method: " + count);
                return false;
            }else{
                this.bag[indexBagOne] = this.bag[numElements];
                this.bag[numElements] = 0;
                numElements--;

                otherBag.bag[indexBagTwo] = otherBag.bag[otherBag.numElements];
                otherBag.bag[otherBag.numElements] = 0;
                otherBag.numElements--;
            }
            count++;
            index++;
        }
        System.out.println("---Bag " + this +" - complexity for equals method: " + count);
        long end_time = System.nanoTime();
        System.out.println("---equals method run time: " + (end_time - start_time) + " ns");
        return true;
    }

}
