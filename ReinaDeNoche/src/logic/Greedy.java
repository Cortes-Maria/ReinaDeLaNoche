package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TestTree;

public class Greedy {

    private List<Double> treeWeights;
    private List<Double> sortedWeights;
    Queue<TestTree> trees;//cola de arboles de mejor a peor
    private double demostrationTime;
    private double planingTime;
    private ArrayList<Long[]> actionList;

    public Greedy(double pTotalTime) {
        treeWeights = new ArrayList<>();
        trees = new LinkedList<>();
        sortedWeights = new ArrayList<>();
        planingTime = pTotalTime * 0.20;
        demostrationTime = pTotalTime - planingTime;
        actionList = new ArrayList<Long[]>();
    }

    public List<Double> getTreeWeights() {
        return treeWeights;
    }

    public void setTreeWeights(List<Double> treeWeights) {
        this.treeWeights = treeWeights;
    }

    public List<Double> getSortedWeights() {
        return sortedWeights;
    }

    public void setSortedWeights(List<Double> sortedWeights) {
        this.sortedWeights = sortedWeights;
    }

    public Queue<TestTree> getTrees() {
        return trees;
    }

    public void setTrees(Queue<TestTree> trees) {
        this.trees = trees;
    }

    public void fillWeights(ArrayList<TestTree> treeList) {
        for (TestTree actualtree : treeList) {
            treeWeights.add(actualtree.getWeight() * 10);
        }
        sortedWeights = treeWeights;
        Collections.sort(sortedWeights);
    }

    public double getMax() {
        return sortedWeights.get(sortedWeights.size() - 1);
    }

    public void fillQueue(ArrayList<TestTree> treeList) {
        fillWeights(treeList);
        //PrintWeights();
        int cant = treeList.size();
        for (int i = 0; i < cant; i++) {
            int bestTreeIndex = treeWeights.indexOf(getMax());
            TestTree bestTree = treeList.get(bestTreeIndex);
            trees.add(bestTree);
            treeList.remove(bestTreeIndex);
            treeWeights.remove(bestTreeIndex);
        }
    }

    public void PrintWeights() {
        for (int i = 0; i < sortedWeights.size(); i++) {
            System.out.println(sortedWeights.get(i));
        }
    }

    public ArrayList<Long[]> selectObjetive(ArrayList<TestTree> treeList) {
        fillQueue(treeList);
        long timeIni;
        long timeFinal = 0;
        timeIni = System.currentTimeMillis();
        int countTime = 0;
        System.out.println(demostrationTime);
        while ((timeFinal - timeIni) < planingTime) {
            Long[] list = new Long[5];
            if (!trees.isEmpty()) {
                TestTree actualTree = trees.poll();
                list[0] = (long) actualTree.getPosX();
                list[1] = (long) ((Math.pow(2, actualTree.getLevels())) / 2);
                list[2] = (long) countTime;
                list[3] = (long) (((list[2]) + (list[1] - 1) + (actualTree.getTimeTotal())));
                list[4] = (long) (actualTree.getDistanceTotal());
                if (list[3] <= demostrationTime) {
                    System.out.println("x:" + list[0] + "\n h:" + list[1] + "\n ida: " + list[2] + "\n tot: " + list[3]);
                    actionList.add(list);
                    countTime = (int) ((list[3]) + 1);
                }
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
