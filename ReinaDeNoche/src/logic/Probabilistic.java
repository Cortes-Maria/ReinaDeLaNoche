/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import common.TestTree;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javith
 */
public class Probabilistic {

    private int rangeProb;
    private double medium;
    private ArrayList<Integer[]> actionList;
    private List<Integer> treeProbSelection;
    private int totalProb;

    public Probabilistic() {

        actionList = new ArrayList<Integer[]>();
        medium = 0;
        rangeProb = 0;
        totalProb = 0;
        treeProbSelection = new ArrayList<Integer>();
    }

    public void listConcatenation(double pPercentage, int pTreePos) {
        for (int pos = 0; pos < pPercentage; pos++) {
            treeProbSelection.add(pTreePos);
        }
    }

    public int getRangeProb() {
        return rangeProb;
    }

    public void setRangeProb(int rangeProb) {
        this.rangeProb = rangeProb;
    }

    public double getMedium() {
        return medium;
    }

    public void setMedium(double medium) {
        this.medium = medium;
    }

    public ArrayList<Integer[]> getActionList() {
        return actionList;
    }

    public void setActionList(ArrayList<Integer[]> actionList) {
        this.actionList = actionList;
    }

    public List<Integer> getTreeProbSelection() {
        return treeProbSelection;
    }

    public void setTreeProbSelection(List<Integer> treeProbSelection) {
        this.treeProbSelection = treeProbSelection;
    }

    public void changePostPosibility(ArrayList<TestTree> treeList) {
        double sum = sumPosibility(treeList);
        double actualPercentage = 0.0;
        int treePos = 0;
        for (TestTree tree : treeList) {
            actualPercentage = (100 * tree.getWeight()) / sum;
            tree.setProbPercentage(Math.round(actualPercentage));
            listConcatenation(Math.round(actualPercentage), treePos);
            treePos++;
        }
    }

    public int getTotalProb() {
        return totalProb;
    }

    public void setTotalProb(int totalProb) {
        this.totalProb = totalProb;
    }

    public void printPercentages(ArrayList<TestTree> treeList) {
        int contPorcentage = 0;
        for (TestTree tree : treeList) {
            contPorcentage += tree.getProbPercentage();
            System.out.println(tree.getProbPercentage());
        }
        System.out.println("Total:" + contPorcentage);
    }

    public void printWeight(ArrayList<TestTree> treeList) {
        for (TestTree tree : treeList) {
            System.out.println(tree.getWeight());
        }
    }
  public void treeProbPrint() {
        for(Integer pes: this.treeProbSelection){
            System.out.println(pes);
            
        }
        System.out.println("Size"+this.treeProbSelection.size());
    }
    public double sumPosibility(ArrayList<TestTree> treeList) {
        double total = 0;
        for (TestTree tree : treeList) {
            total += tree.getWeight();
        }
        //System.out.println(total);
        return total;
        
    }

    public ArrayList<Integer[]> selectObjetive(ArrayList<TestTree> treeList) {
        Integer list[] = {1, 2};
        actionList.add(list);
        int count = 0;
        int indexTree = 0;
        double time = 0;
        for (TestTree treeList1 : treeList) {
            indexTree = (int) (Math.random() * treeList.size());

            System.out.println("Posi: " + treeList1.getWeight());
            System.out.println("Distancia Total: " + treeList1.getDistanceTotal());
            System.out.println("Hojas Totales: " + treeList1.getLeafCount());
            time += treeList1.getTimeTotal();
            count++;

        }
        System.out.println("Imposibles: " + count);
        System.out.println(time / 1000);
        return actionList;
    }

}
