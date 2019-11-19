package logic;

import common.TestGenerator;
import common.TestTree;
import java.util.ArrayList;

public class main {

    public static double sizeOfTree(double size, double porcentage, double minleaf, double value) {
        if (size <= minleaf) {
            return value;
        }
        return sizeOfTree(size - (size * porcentage), porcentage, minleaf, value + size);
    }

    public static void main(String args[]) {
        TestGenerator generator = new TestGenerator();
        TestTree  tree = generator.getTests()[0].get(0));
        
       System.out.println(tree.getGrow_percentage());
        System.err.println(tree.getLength() + "-" + tree.getGrow_percentage() + "-" + tree.getLeafLength());
        double value = 0;
       double length = tree.getLength();
       
       System.err.println("Final:" + value);
       System.out.println(sizeOfTree(tree.getLength(), tree.getGrow_percentage(), tree.getLeafLength(), 0));

        System.out.println("Hello, World");

    }
}
