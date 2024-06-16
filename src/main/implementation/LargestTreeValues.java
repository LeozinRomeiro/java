package main.implementation;

import main.dataScructure.Tree;
import main.dataScructure.Tree.Node;

import java.util.List;
import java.util.ArrayList;

public class LargestTreeValues {

    public static List<Integer> largestValues(Tree tree){
        var list = new ArrayList<Integer>();
        salveTree(tree.root, 0, list);
        return list;
    }

    private static void salveTree(Node node, int level, ArrayList<Integer> list) {
        if (node==null) return;
        if (level==list.size()){
            list.add(node.value);
        }else{
            list.set(level, Math.max(list.get(level), node.value));
        }
        salveTree(node.rigth, level+1, list);
        salveTree(node.left, level+1, list);
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(100);

        tree.insert(10);
        tree.insert(5);

        tree.insert(6);
        tree.insert(1);
        tree.insert(7);
        tree.insert(8);

        System.out.println(largestValues(tree));
    }
}
