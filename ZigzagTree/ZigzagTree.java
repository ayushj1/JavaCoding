import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
    }
}

public class ZigzagTree {
    public static void createTreeZigzag(TreeNode root, List<List<Integer>> levelLists, int level) {
        if(root == null)
            return;

        if(levelLists.size() == level)
            levelLists.add(new ArrayList<Integer>());

        levelLists.get(level).add(root.data);
        createTreeZigzag(root.left, levelLists, level+1);
        createTreeZigzag(root.right, levelLists, level+1);
    }

    public static void printTreeInorder(TreeNode root) {
        if(root == null)
            return;
        printTreeInorder(root.left);
        System.out.print(root.data);
        printTreeInorder(root.right);
    }

    public static void main(String[] args) {
        try {
            TreeNode root = new TreeNode(4);
            root.left = new TreeNode(2);
            root.right = new TreeNode(6);
            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(3);
            root.right.left = new TreeNode(5);
            root.right.right = new TreeNode(7);
            printTreeInorder(root);

            System.out.println();

            List<List<Integer>> levelLists = new ArrayList<>();
            createTreeZigzag(root, levelLists, 0);

            for(int i=0; i<levelLists.size(); i++) {
                List<Integer> curLevel = levelLists.get(i);
                if(i%2 != 0)
                    Collections.reverse(curLevel);
                for(Integer x : curLevel)
                    System.out.print(x);
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}