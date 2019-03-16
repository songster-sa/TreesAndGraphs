package FindCousins;

public class Solution1 {
    public boolean isCousins(TreeNode root, int x, int y) {
        // cousins means they have to be on same level... but not share the same parent
        // hence, first find their levels

        TreeNode parent1 = root, parent2 = root;

        int level1 = findLevelAndParent(parent1, x, null, 0);
        int level2 = findLevelAndParent(parent2, y, null, 0);

        if (level1 == level2 && parent1 != parent2 && level1 != -1 && level2 != -1) {
            return true;
        }
        return false;
    }

    // this did not work as return value was wrong..
    private int findLevelAndParent(TreeNode node, int x, TreeNode parent, int level) {
        if (node.val == x) {
            return level;
        }

        if (node.left != null) {
            int l1 = findLevelAndParent(node.left, x, node, level + 1);
            if (l1 != -1) {
                // found  - no need to go ahead
                parent = node;
                return l1;
            }
        }
        if (node.right != null) {
            int l2 = findLevelAndParent(node.right, x, node, level + 1);
            if (l2 != -1) {
                // found  - no need to go ahead
                parent = node;
                return l2;
            }
        }

        return -1;
    }
}
