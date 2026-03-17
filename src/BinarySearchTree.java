package tuc.bst;

import java.io.IOException;
import tuc.Elem;

/*
 * Interface for binary search tree
 */
interface BinarySearchTree {

	public void clear();

	public void insert(Object val);

	public void remove(int key);

	public Elem find(int key);

	public boolean isEmpty();

	public void print();

	public void printRange(int low, int high);

	public int count();

	public void preorder();

	public void postorder();

	public void inorder();

}
