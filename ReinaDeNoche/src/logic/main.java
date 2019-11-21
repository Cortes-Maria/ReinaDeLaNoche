package logic;

import common.TestGenerator;
import common.TestTree;
import java.util.ArrayList;

public class main {

    public static double sizeOfTree(double size, double porcentage, double minleaf, double value, int count) {
        if (size <= minleaf) {
            return value;
        }
        System.out.println(count++);
        return sizeOfTree(size * porcentage, porcentage, minleaf, value + size, count);
    }

    public static void main(String args[]) {
        TestGenerator generator = new TestGenerator();
        Probabilistic proba = new Probabilistic();
        System.err.println(generator.getTests().getClass());
        // System.out.println(proba.selectObjetive( generator.getTests()[2]));
        /*int number = 0;
        for (int i = 0; i < 3; i++) {
            number =  (number | 1);
            number = (number << 1);
        }
        number = (number >> 1);
        System.out.println(number);
*/
        proba.changePostPosibility(generator.getTests()[1]);
        //proba.printPercentages(generator.getTests()[2]);
        //proba.printWeight(generator.getTests()[2]);
        //proba.sumPosibility(generator.getTests()[2]);
        proba.treeProbPrint();
        
        /*
        TestTree tree = (generator.getTests()[0].get(0));
        System.out.println(generator.getTests()[2].size());
        System.err.println(tree.getLength() + "-" + tree.getGrow_percentage() + "-" + tree.getLeafLength());
        double value = 0;
        double length = tree.getLength();
        System.out.println("S" + sizeOfTree(tree.getLength(), tree.getGrow_percentage(), tree.getLeafLength(), 0, 0));
        System.out.println("Hello, World");
         */
    }
}
