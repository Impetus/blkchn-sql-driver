package com.impetus.blkch.sql.parser;

import java.util.ArrayList;
import java.util.List;


public class TreeNode{
	
	private List<TreeNode> childNodes = new ArrayList<TreeNode>();
	private TreeNode parent = null;
	private boolean isRootNode = false;
	private String description;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TreeNode(String description){
		this.description = description;
	}
	
	public void addChildNode(TreeNode child){
		this.childNodes.add(child);
		child.setParent(this);
	}
	
	public TreeNode getChildNode(int i) {
		if(i < childNodes.size()){
			return childNodes.get(i);
		}
		return null;
	}
	
	public List<TreeNode> getChildNodes() {
		return childNodes;
	}
	
	public void setChildNodes(List<TreeNode> childNodes) {
		this.childNodes = childNodes;
	}
	
	public TreeNode getParent() {
		return parent;
	}
	
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	
	public boolean isRootNode() {
		return isRootNode;
	}
	
	public void setRootNode(boolean isRootNode) {
		this.isRootNode = isRootNode;
	}
	
	public void traverse(TreeNode node){
		traverseDepthFirst(node, 0);
	}
	
	public void traverse(){
		traverseDepthFirst(this, 0);
	}
	
	private void traverseDepthFirst(TreeNode node, int level){
		System.out.println(addspace(level * 2, node.getDescription()));
		for(TreeNode childNode : node.getChildNodes()){
			traverseDepthFirst(childNode, level + 1);
		}
	}
	
	public String toString(){
		return this.getDescription();
	}
	
	public static void main(String args[]){
		TreeNode rootNode = new TreeNode("CEO");
		rootNode.setRootNode(true);
		TreeNode cfo = new TreeNode("CFO");
		TreeNode cto = new TreeNode("CTO");
		TreeNode arch1 = new TreeNode("ARCHITECT-1");
		TreeNode arch2 = new TreeNode("ARCHITECT-2");
		TreeNode lead1 = new TreeNode("LEAD-1");
		TreeNode lead2 = new TreeNode("LEAD-2");
		TreeNode dev1 = new TreeNode("DEV-1");
		TreeNode dev2 = new TreeNode("DEV-2");
		TreeNode dev3 = new TreeNode("DEV-3");
		TreeNode dev4 = new TreeNode("DEV-4");
		TreeNode dev5 = new TreeNode("DEV-5");
		
		rootNode.addChildNode(cfo);
		rootNode.addChildNode(cto);
		cto.addChildNode(arch1);
		cto.addChildNode(arch2);
		arch1.addChildNode(lead1);
		lead1.addChildNode(dev1);
		lead1.addChildNode(dev2);
		arch2.addChildNode(lead2);
		lead2.addChildNode(dev3);
		lead2.addChildNode(dev4);
		lead2.addChildNode(dev5);
		rootNode.traverse(rootNode.getChildNode(1).getChildNode(1));
		//rootNode.traverse();
		
	}
	
	String addspace(int i, String str) {       
        StringBuilder str1 = new StringBuilder();
        for(int j=0;j<i;j++){
                str1.append(" ");
            }
            str1.append(str);           
        return str1.toString();         
    }
}
