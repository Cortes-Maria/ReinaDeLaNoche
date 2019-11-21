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
    private ArrayList<Long[]> actionList;
    private List<Integer> treeProbSelection;
    private int totalProb;
    private double demostrationTime;
    private double planingTime;

    public Probabilistic(double pTotalTime) {

        actionList = new ArrayList<Long[]>();
        medium = 0;
        rangeProb = 0;
        totalProb = 0;
        treeProbSelection = new ArrayList<Integer>();
        planingTime = pTotalTime * 0.20;
        demostrationTime = pTotalTime - planingTime;
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

    public ArrayList<Long[]> getActionList() {
        return actionList;
    }

    public void setActionList(ArrayList<Long[]> actionList) {
        this.actionList = actionList;
    }

    public List<Integer> getTreeProbSelection() {
        return treeProbSelection;
    }

    public void setTreeProbSelection(List<Integer> treeProbSelection) {
        this.treeProbSelection = treeProbSelection;
    }

    public void changePostPosibility(ArrayList<TestTree> treeList) {
        treeProbSelection.clear();
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
        for (Integer pes : this.treeProbSelection) {
            System.out.println(pes);

        }
        System.out.println("Size" + this.treeProbSelection.size());
    }

    public double sumPosibility(ArrayList<TestTree> treeList) {
        double total = 0;
        for (TestTree tree : treeList) {
            total += tree.getWeight();
        }
        //System.out.println(total);
        return total;

    }
    // actionList[] = Action
    // action[0] = X
    // action [1] = 2**n/2
    // action [2] = TiempoSalida
    // action [3] = action[2] + (action[1]-1) + tiempoTotal

    public ArrayList<Long[]> selectObjetive(ArrayList<TestTree> treeList) {
        
        int indexTree = 0;
        long timeIni;
        long timeFinal = 0;
        timeIni = System.currentTimeMillis();
        int countTime = 0;
        int cont = 0;
        System.out.println(demostrationTime);
        while ((timeFinal - timeIni) < planingTime) {
            Long[] list = new Long[5];
            int random = (int) (Math.random() * treeProbSelection.size());
            int pos = treeProbSelection.get(random);
            list[0] = (long) treeList.get(pos).getPosX();
            list[1] = (long) ((Math.pow(2, treeList.get(pos).getLevels())) / 2);
            list[2] = (long) countTime;
            list[3] = (long) (((list[2]) + (list[1] - 1) + (treeList.get(pos).getTimeTotal())));
            list[4] = (long) (treeList.get(pos).getDistanceTotal());
            if (list[3] <= demostrationTime) {
                System.out.println("x:" + list[0] + "\n h:" + list[1] + "\n ida: " + list[2] + "\n tot: " + list[3]);
                actionList.add(list);
                 //printActionList();
                 cont++;

                
                countTime = (int) ((list[3]) + 1);
                treeList.get(pos).setLeafCount((int) ((treeList.get(pos).getLeafCount()) - list[1]));
                changePostPosibility(treeList);
                System.out.println("Lista" + treeProbSelection.size());
            }
            timeFinal = System.currentTimeMillis();
        }
        return actionList;
    }

    public void printActionList() {
        for (int i = 0; i < actionList.size(); i++) {
            System.out.println("x:" + actionList.get(i)[0] + "\n h:" + actionList.get(i)[1] + "\n ida: " + actionList.get(i)[2]
                    + "\n tot: " + actionList.get(i)[3]);
        }
    }

}
