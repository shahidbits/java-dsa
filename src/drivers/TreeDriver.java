package drivers;

import tree.BalancedBinaryTree;
import tree.ConstructBTFromPreorderAndInorder;
import tree.CountGoodNodesInBT;
import tree.HouseRobber3;
import tree.InvertBinaryTree;
import tree.KthSmallestElementInBST;
import tree.LowestCommonAncestorBST;
import tree.MergeTwoBinaryTree;
import tree.RightSideView;
import tree.RootToLeafPaths;
import tree.SortedArrayToBalancedBST;
import tree.SumRootToLeafNumbers;
import tree.SumTree;
import tree.Trie;
import tree.UniqueBST;
import tree.ValidateBST;
import tree.ZigZagTreeTraversal;
import util.TreeNode;
import util.TreePrinter;

public class TreeDriver {

    public void invertBinaryTree() {

        TreeNode root = createTree();

        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        invertBinaryTree.invertTree(root);
    }

    public void mergeTwoBinaryTree() {

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(3);

        MergeTwoBinaryTree mergeTwoBinaryTree = new MergeTwoBinaryTree();
        TreeNode root = mergeTwoBinaryTree.mergeTrees(root1, root2);
    }

    public void lowestCommonAncestorBST() {

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        LowestCommonAncestorBST lowestCommonAncestor = new LowestCommonAncestorBST();
        TreeNode lca = lowestCommonAncestor.lowestCommonAncestor(root, root.left, root.right);
    }

    public void balancedBinaryTree() {

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.left.left = new TreeNode(5);

        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        System.out.println("isBalanced = " + balancedBinaryTree.isBalanced(root));
    }

    public void countGoodNodesInBT() {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        CountGoodNodesInBT countGoodNodesInBT = new CountGoodNodesInBT();
        System.out.println("count = " + countGoodNodesInBT.goodNodes(root));
    }

    public void sortedArrayToBalancedBST() {
        SortedArrayToBalancedBST sortedArrayToBalancedBST = new SortedArrayToBalancedBST();
        TreeNode tree = sortedArrayToBalancedBST.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }

    public void validateBST() {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);

        ValidateBST validateBST = new ValidateBST();
//        System.out.println("valid=" + validateBST.isValidBST(root));
//        System.out.println("valid=" + validateBST.isValidBST(root2));
        System.out.println("valid=" + validateBST.isValidBST(new TreeNode(2147483647)));
    }

    public void sumRootToLeafNumbers() {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

        TreePrinter.print(root);
        SumRootToLeafNumbers sumRootToLeafNumbers = new SumRootToLeafNumbers();
        System.out.println("sum=" + sumRootToLeafNumbers.sumNumbers(root));
    }

    public void uniqueBST() {

        UniqueBST uniqueBST = new UniqueBST();
        System.out.println("total=" + uniqueBST.numTrees(4));
    }

    public void rightSideView() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        RightSideView rightSideView = new RightSideView();
        rightSideView.rightSideView(root);
    }

    public void kthSmallestElementInBST() {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        KthSmallestElementInBST kthSmallestElementInBST = new KthSmallestElementInBST();
        System.out.println("kth smallest=" + kthSmallestElementInBST.kthSmallest(root, 3));
    }

    public void houseRobber3() {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        HouseRobber3 houseRobber3 = new HouseRobber3();
        System.out.println("value=" + houseRobber3.rob(root));
    }

    public void constructBTFromPreorderAndInorder() {

        ConstructBTFromPreorderAndInorder constructBTFromPreorderAndInorder = new ConstructBTFromPreorderAndInorder();
//        constructBTFromPreorderAndInorder.buildTree(new int[]{1, 2}, new int[]{1, 2});
        constructBTFromPreorderAndInorder.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }

    public void sumTree() {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(-4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(5);

        SumTree sumTree = new SumTree();
        TreeNode sumTreeRoot = sumTree.convert(root);
    }

    public void rootToLeafPaths() {

        TreeNode root = createTree();

        TreePrinter.print(root);

        RootToLeafPaths rootToLeafPaths = new RootToLeafPaths();
        rootToLeafPaths.print(root);
    }

    public void zigZagTreeTraversal() {

        TreeNode root = createTree();

        TreePrinter.print(root);

        ZigZagTreeTraversal zigZagTreeTraversal = new ZigZagTreeTraversal();
        zigZagTreeTraversal.traverse(root);
    }

    public void trie() {

        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("applet");
        trie.insert("ape");
        trie.insert("appi");

        System.out.println("search(api)=" + trie.search("api"));
        System.out.println("search(ape)=" + trie.search("ape"));
        System.out.println("startsWith(ap)=" + trie.startsWith("api"));

        System.out.println(trie);
    }

    ///// Util Methods


    private TreeNode createTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        return root;
    }

}
