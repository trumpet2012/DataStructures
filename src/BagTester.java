/**
 * Created by William Trent Holliday
 *
 * ===================================================================
 * ++ RUN INSTRUCTIONS ++
 *  Compile BagTester.java in command prompt/terminal using:
 *      - javac BagTester.java
 *  Run compiled java code using:
 *      - java BagTester
 *
 * ====================================================================
 *
 * This is the file that is used to test the Bag object and its operations.
 *
 * ====================================================================
 * ++ WHAT THIS DOES ++
 * =======================
 * Creates two small bags of size 20 and one small bag of size 40. Also
 * creates two big bags of size 500,000 and one big bag of 1,000,000.
 *
 * It populates the two smallest small bags and the two largest big bags with random
 * integers ranging in value from -1000 to 1000.
 *
 * It then runs all of the Bag methods and displays the complexity and the run time for each.
 *
 *
 */
import java.util.Random;

public class BagTester {
    // Smallest number to be generated randomly
    private static int minInt = -1000;
    // Largest number to be generated randomly
    private static int maxInt = 1000;
    public static void main(String[] args) {
        // Size of small bags
        int smallBagSize = 20;
        // Size of big bags
        int largeBagSize = 500000;

        Bag smallBagOne = new Bag(smallBagSize);
        Bag smallBagTwo = new Bag(smallBagSize);
        Bag smallBagThree = new Bag(smallBagSize*2);

        Bag bigBagOne = new Bag(largeBagSize);
        Bag bigBagTwo = new Bag(largeBagSize);
        Bag bigBagThree = new Bag(largeBagSize*2);

        System.out.println("-Creating two large bags with size of " + smallBagSize);

        // This variable is passed to the add method to prevent the print lines from
        // being called until the last add method in the loop runs.
        boolean showComplexity = false;
        for(int index=0; index<smallBagSize;index++){
            if (index == smallBagSize-1)
                showComplexity=true;
            smallBagOne.add(randInt(), showComplexity);
            smallBagTwo.add(randInt(), showComplexity);
        }

        System.out.println("\n-Creating two large bags with size of " + largeBagSize);

        // This variable is passed to the add method to prevent the print lines from
        // being called until the last add method in the loop runs.
        showComplexity = false;
        for(int index=0; index<largeBagSize; index++){
            if (index == largeBagSize-1)
                showComplexity=true;
            bigBagOne.add(randInt(), showComplexity);
            bigBagTwo.add(randInt(), showComplexity);
        }

        System.out.println("\n-Running removeRandom for two small bags");
        smallBagOne.removeRandom();
        smallBagTwo.removeRandom();

        System.out.println("\n-Running removeRandom for two large bags");
        bigBagOne.removeRandom();
        bigBagTwo.removeRandom();

        System.out.println("\n-Running remove for two small bags");
        smallBagOne.remove(randInt());
        smallBagTwo.remove(randInt());

        System.out.println("\n-Running remove for two large bags");
        bigBagOne.remove(randInt());
        bigBagTwo.remove(randInt());

        System.out.println("\n-Running addAll for a small bag");
        smallBagThree.addAll(smallBagOne);

        System.out.println("\n-Running addAll for a large bag");
        bigBagThree.addAll(bigBagOne);

        System.out.println("\n-Running union for a small bag");
        Bag smallUnionBag = Bag.union(smallBagOne, smallBagTwo);

        System.out.println("\n-Running union for a large bag");
        Bag bigUnionBag = Bag.union(bigBagOne, bigBagTwo);

        System.out.println("\n-Running equals for a small bag");
        boolean isSmallEqual = smallBagOne.equals(smallBagTwo);
        System.out.println("\n---smallBagOne is equal to smallBagTwo?: " + isSmallEqual);

        System.out.println("\n-Running equals for a large bag");
        System.out.println("bb1 " + bigBagOne.bag[0] + " bb2 " + bigBagTwo.bag[0]);
        boolean isBigEqual = bigBagOne.equals(bigBagTwo);
        System.out.println("\n---bigBagOne is equal to bigBagTwo?: " + isBigEqual);

    }

    /**
     * Used to create a pseudo-random integer from minInt to maxInt.
     * @return a pseudo-random integer
     */
    private static int randInt(){
        Random randGen = new Random();
        return randGen.nextInt((maxInt-minInt) + 1) + minInt;
    }
}
