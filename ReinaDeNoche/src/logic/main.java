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
        //Probabilistic proba = new Probabilistic(60000);
        
        long timeIni=System.currentTimeMillis();
        System.out.println(timeIni);
        
      //  proba.changePostPosibility(generator.getTests()[0]);
        //ArrayList<Long[]> laita = proba.selectObjetive(generator.getTests()[0]);
       //  proba.printActionList();
        
        Greedy voraz=new Greedy(60000);
        ArrayList<Long[]> laita2= voraz.selectObjetive(generator.getTests()[0]);
        
        //FileCsv archivo=new FileCsv();
        //archivo.writeCsvFile(laita, "Archivo.csv", ",");
        
        FileCsv archivo2=new FileCsv();
        archivo2.writeCsvFile(laita2, "Archivo2.csv", ",");
        
     
       
    }
}
