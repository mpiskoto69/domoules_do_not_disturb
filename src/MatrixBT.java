import java.util.ArrayList;
import java.util.List;

public class MatrixBT {
    public int K;
    public int[][] data;
    public int avail;
    public MatrixBT(int k, int avail){
        K = k;
        data = new int[3][K];
        this.avail = avail;
    }


    void insert(int elem){

        for (int i = 0; i < K; i++){
            if (data[i] == null)
                return new BinNodePtr(val);
            Elem it = (Elem) rt.element();
            if (it.key() > val.key())
                rt.setLeft(inserthelp(rt.left(), val));
            else
                rt.setRight(inserthelp(rt.right(), val));
            return rt;
        }
    }

    int search(int){

    }

    boolean delete(int){

    }

    List rangeSearch(int, int){

    }

    void inorder(){

    }

    void printName(){

    }

}
