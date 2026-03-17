
import java.io.*;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;

public class ClassicBT implements BinarySearchTree{
    private static RandomAccessFile MyFile;
    private static long pos;
    private static final int serialized_object_size = 56;

    private BinNode root; // The root of the tree

    public ClassicBT() {
        root = null;
    } // Initialize root to null

    public void clear() {
        root = null;
    } // Throw the nodes away

    public void insert(Object val) {
        root = inserthelp(root, (Elem) val);
    }

    public void remove(int key) {
        root = removehelp(root, key);
    }

    public Elem find(int key) {
        return findhelp(root, key);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void print() { // Print out the BST
        if (root == null)
            System.out.println("The BST is empty.");
        else {
            printhelp(root, 0);
            System.out.println();
        }
    }

    public void printRange(int low, int high) {
        System.out.print("\nPrint keys between " + low + " and " + high + ": ");
        printrangehelp(root, low, high);
        System.out.println();
    }

    public int count() {
        return counthelp(root);
    }

    public void preorder() {
        preorderhelp(root);
        System.out.println();
    }

    public void postorder() {
        postorderhelp(root);
        System.out.println();
    }

    public void inorder() {
        inorderhelp(root);
        System.out.println();
    }

    private Elem findhelp(BinNode rt, int key) {
        if (rt == null)
            return null;
        Elem it = (Elem) rt.element();
        if (it.key() > key)
            return findhelp(rt.left(), key);
        else if (it.key() == key)
            return it;
        else
            return findhelp(rt.right(), key);
    }

    private BinNode inserthelp(BinNode rt, Elem val) {
        if (rt == null)
            return new BinNodePtr(val);
        Elem it = (Elem) rt.element();
        if (it.key() > val.key())
            rt.setLeft(inserthelp(rt.left(), val));
        else
            rt.setRight(inserthelp(rt.right(), val));
        return rt;
    }

    private BinNode deletemin(BinNode rt) {
        if (rt.left() == null)
            return rt.right();
        else {
            rt.setLeft(deletemin(rt.left()));
            return rt;
        }
    }

    private Elem getmin(BinNode rt) {
        if (rt.left() == null)
            return (Elem) rt.element();
        else
            return getmin(rt.left());
    }

    private BinNode removehelp(BinNode rt, int key) {
        if (rt == null)
            return null;
        Elem it = (Elem) rt.element();
        if (key < it.key())
            rt.setLeft(removehelp(rt.left(), key));
        else if (key > it.key())
            rt.setRight(removehelp(rt.right(), key));
        else { // Found it
            if (rt.left() == null)
                rt = rt.right();
            else if (rt.right() == null)
                rt = rt.left();
            else { // Two children
                Elem temp = getmin(rt.right());
                rt.setElement(temp);
                rt.setRight(deletemin(rt.right()));
            }
        }
        return rt;
    }

    private void printhelp(BinNode rt, int level) {
        if (rt == null)
            return;
        printhelp(rt.right(), level + 1);
        for (int i = 0; i < level; i++) // Indent based on level
            System.out.print("  ");
        System.out.println((Elem) rt.element()); // Print node value
        printhelp(rt.left(), level + 1);
    }

    private void printrangehelp(BinNode root, int low, int high) {
        if (root == null)
            return;
        Elem it = (Elem) root.element();
        if (high < it.key()) // all to left
            printrangehelp(root.left(), low, high);
        else if (low > it.key()) // all to right
            printrangehelp(root.right(), low, high);
        else { // Must process both children
            printrangehelp(root.left(), low, high);
            System.out.print(" " + it.key());
            printrangehelp(root.right(), low, high);
        }
    }

    private int counthelp(BinNode rt) {
        if (rt == null)
            return 0;
        return 1 + counthelp(rt.left()) + counthelp(rt.right());
    }

    private void inorderhelp(BinNode subroot) {
        if (subroot == null)
            return; // Empty, do nothing
        inorderhelp(subroot.left());
        visit(subroot); // Perform desired action
        inorderhelp(subroot.right());
    }

        private void postorderhelp(BinNode subroot) {
        if (subroot == null)
            return; // Empty, do nothing
        postorderhelp(subroot.left());
        postorderhelp(subroot.right());
        visit(subroot); // Perform desired action
    }

    private void preorderhelp(BinNode rt) // rt is the root of the subtree
    {
        if (rt == null)
            return; // Empty subtree
        visit(rt);
        preorderhelp(rt.left());
        preorderhelp(rt.right());
    }

    private void visit(BinNode rt) {
        System.out.print(rt.element() + " ");
    }
}
