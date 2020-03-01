package com.company;

public class Main {

	public static void showMyLinkedList(MyLinkedList list){
		list.traverse(list.getRoot());
		list.removeItem(new Node("Jamaica"));
		list.traverse(list.getRoot());
		list.removeItem(new Node("Caballito"));
		list.traverse(list.getRoot());
		list.removeItem(new Node("Altura"));
		list.traverse(list.getRoot());
		list.removeItem(new Node("Bermudas"));
		list.traverse(list.getRoot());
		list.removeItem(new Node("Gregorias"));
		list.traverse(list.getRoot());
		list.removeItem(new Node("Saballeta"));
		list.traverse(list.getRoot());
		list.removeItem(new Node("Ituzaingo"));
		list.traverse(list.getRoot());
		list.removeItem(new Node("Domingo"));
		list.traverse(list.getRoot());
		list.removeItem(new Node("Osamenta"));
		list.traverse(list.getRoot());
		list.removeItem(new Node("Glamoria"));
		list.traverse(list.getRoot());
		list.removeItem(new Node("Crematoria"));
		list.traverse(list.getRoot());
	}



	public static void main(String[] args) {
		SearchTree tree = new SearchTree(null);
		MyLinkedList list = new MyLinkedList(null);

		String stringdata = "Jamaica Bermudas Ituzaingo Caballito Gregorias Saballeta Altura Domingo Osamenta Crematoria Glamoria Altura";
		String[] data = stringdata.split(" ");
		for(String s : data){
	    	tree.addItem(new Node(s));
	    	list.addItem(new Node(s));
    	}
//		showMyLinkedList(list);

		tree.traverse(tree.getRoot());
		tree.removeItem(new Node("Jamaica"));
		tree.traverse(tree.getRoot());
		tree.removeItem(new Node("Caballito"));
		tree.traverse(tree.getRoot());
		tree.removeItem(new Node("Altura"));
		tree.traverse(tree.getRoot());
		tree.removeItem(new Node("Bermudas"));
		tree.traverse(tree.getRoot());
		tree.removeItem(new Node("Gregorias"));
		tree.traverse(tree.getRoot());
		tree.removeItem(new Node("Saballeta"));
		tree.traverse(tree.getRoot());
		tree.removeItem(new Node("Ituzaingo"));
		tree.traverse(tree.getRoot());
		tree.removeItem(new Node("Domingo"));
		tree.traverse(tree.getRoot());
		tree.removeItem(new Node("Osamenta"));
		tree.traverse(tree.getRoot());
		tree.removeItem(new Node("Glamoria"));
		tree.traverse(tree.getRoot());
		tree.removeItem(new Node("Crematoria"));
		tree.traverse(tree.getRoot());
    }
}
