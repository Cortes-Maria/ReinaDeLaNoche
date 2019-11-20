/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import common.TestTree;
import java.util.ArrayList;

/**
 *
 * @author javith
 */
public class Probabilistic {
    private  double medium;
    private ArrayList<Integer[]> actionList;

    public Probabilistic() {
        actionList = new ArrayList<Integer[]>();
        medium=0;
    }
    

    
    public ArrayList<Integer[]> selectObjetive(ArrayList<TestTree> treeList) {
        Integer list[] = {1, 2};
        actionList.add(list);
        int count =0;
        int indexTree=0;
        double time=0;
        for (TestTree treeList1 : treeList) {
           // indexTree = (int) (Math.random() * treeList.size());
             if(treeList1.getProbability()<0.20){
              System.out.println("Posi: "+treeList1.getProbability());
              System.out.println("Distancia Total: "+treeList1.getDistanceTotal());
              System.out.println("Hojas Totales: "+treeList1.getLeafCount());
              time+=treeList1.getTimeTotal();
              count++;
             }
             
                
        }
       System.out.println("Imposibles: "+count);
        System.out.println(time/1000);
        return actionList;
    }

}
