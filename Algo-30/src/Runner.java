import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        MyTree2 tree = new MyTree2();
        List<Integer> list = new ArrayList<>(Arrays.asList(6,2,8,0,4,7,9,3,5));

        for ( int i : list ){

            tree.insert(i);
        }

        VisualizeTree.printTree(tree.root, null,false);

        System.out.println("result is  = " + tree.findLeastCommonAncestor(tree.root, 8, 9));
    }
}
