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
	
	public Greedy() {
		treeWeights = new ArrayList<>();
		trees = new LinkedList<>();
		sortedWeights = new ArrayList<>();
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
		for(TestTree actualtree : treeList) {
			treeWeights.add(actualtree.getWeight()*10);
		}
		sortedWeights = treeWeights;
		Collections.sort(sortedWeights);
	}
	public double getMax() {
		return sortedWeights.get(sortedWeights.size()-1);
	}
	public void fillQueue(ArrayList<TestTree> treeList) {
		fillWeights(treeList);
		PrintWeights();
		int cant = treeList.size();
		for(int i=0; i < cant ;i++ ) {
			int bestTreeIndex = treeWeights.indexOf(getMax());
			TestTree bestTree = treeList.get(bestTreeIndex);
			trees.add(bestTree);
			treeList.remove(bestTreeIndex);
			treeWeights.remove(bestTreeIndex);
		}
	}
	
	public void PrintWeights() {
		for(int i=0; i<sortedWeights.size();i++) {
			System.out.println(sortedWeights.get(i));
		}
	}
	
}
