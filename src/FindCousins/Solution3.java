package FindCousins;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {

    // another flavour built on top og solution 2
    // parse tree only once but parse it completely (even after x and y are found .. or even when one or both are not found)
    // Still DFS

    public boolean isCousins(TreeNode root, int x, int y) {
        // cousins means they have to be on same level... but not share the same parent
        // hence, first find their levels

        if (x == y || root.val == x || root.val == y) {
            return false;
        }

        List result = new ArrayList();
        findLevelAndParent(root, x, y, null, 0, result);

        if (result.size() == 4
                && result.get(0) != result.get(2)
                && result.get(1) == result.get(3)) {
            return true;
        }
        return false;
    }

    private void findLevelAndParent(TreeNode node, int x, int y, TreeNode parent, int level, List result) {
        if (node.val == x || node.val == y) {
            result.add(parent);
            result.add(level);
        }

        if (node.left != null) {
            findLevelAndParent(node.left, x, y, node, level + 1, result);

        }
        if (node.right != null) {
            findLevelAndParent(node.right, x, y, node, level + 1, result);

        }
    }
}
