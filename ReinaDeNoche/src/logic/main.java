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
        Probabilistic proba = new Probabilistic(60000);
        
        long timeIni=System.currentTimeMillis();
        System.out.println(timeIni);
        
        proba.changePostPosibility(generator.getTests()[0]);
        ArrayList<Long[]> laita = proba.selectObjetive(generator.getTests()[0]);
        proba.printActionList();
        
        FileCsv archivo=new FileCsv();
        archivo.writeCsvFile(laita, "Archivo.csv", ",");
        conectionFTP.changeDataFTP();
        /*for(int i=0; i<laita.size();i++){
            System.out.println("x:" +laita.get(i)[0]+"\n h:"+laita.get(i)[1]+"\n ida: "+laita.get(i)[2]+"\n tot: "+laita.get(i)[3]);
        }*/
        //proba.treeProbPrint();
       
    }
}
