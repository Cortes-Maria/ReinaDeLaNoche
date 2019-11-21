package common;

import static common.ITestConstants.ANT_VELOCITY;

public class TestTree {

    private int posX;
    private int length;
    private int levels;
    private double leafLength;
    private double distanceLeaf;
    private int leafCount;
    private double distanceTotal;
    private double timeTotal;
    private double probPercentage;

    public double getProbPercentage() {
        return probPercentage;
    }

    public void setProbPercentage(double probPercentage) {
        this.probPercentage = probPercentage;
    }
    
    public TestTree(int pPosX, int pLength, int pLevels) {
        this.posX = pPosX;
        this.length = pLength;
        this.levels = pLevels;
        this.distanceLeaf = 0;
        this.probPercentage =0;
        this.leafCount = (int) Math.pow(2, pLevels);
        for (leafLength = pLength; --pLevels > 0; leafLength *= ITestConstants.GROW_PERCENTAGE) {
            distanceLeaf += leafLength;
        }

        
        this.distanceTotal = 2 * (distanceLeaf + ((double) Math.sqrt(Math.pow(ITestConstants.TEST_POSICION_HORMIGUERO - pPosX, 2))));
        this.timeTotal = this.distanceTotal / ANT_VELOCITY;
    }

    public double getDistanceLeaf() {
        return distanceLeaf;
    }

    public double getWeight() {
        return leafCount / timeTotal;
    }

    public int getLeafCount() {
        return leafCount;
    }

    public double getDistanceTotal() {
        return distanceTotal;
    }

    public double getTimeTotal() {
        return timeTotal;
    }

    public static double sizeOfTree(double size, double porcentage, double minleaf, double value, int count) {
        if (size <= minleaf) {
            return value;
        }
        System.out.println(count++);
        return sizeOfTree(size * porcentage, porcentage, minleaf, value + size, count);
    }

    public int getPosX() {
        return posX;
    }

    public int getLength() {
        return length;
    }

    public int getLevels() {
        return levels;
    }

    public double getGrow_percentage() {
        return ITestConstants.GROW_PERCENTAGE;
    }

    public double getLeafLength() {
        return this.leafLength;
    }
}
