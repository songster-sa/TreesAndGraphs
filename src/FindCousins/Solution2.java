package FindCousins;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    // DFS
    // Parse tree twice , but only until you find x and y
    // if both dont exist... you end up parsing the whole tree twice
    // we can better this by checking list1 is null or not before proceeding to find list2

    public boolean isCousins(TreeNode root, int x, int y) {
        // cousins means they have to be on same level... but not share the same parent
        // hence, first find their levels

        if (x == y || root.val == x || root.val == y) {
            return false;
        }

        // parse tree twice but only until required
        List list1 = findLevelAndParent(root, x, null, 0);
        List list2 = findLevelAndParent(root, y, null, 0);

        if (list1 != null && list2 != null
                && list1.get(0) != list2.get(0)
                && list1.get(1) == list2.get(1)) {
            return true;
        }
        return false;
    }

    private List findLevelAndParent(TreeNode node, int x, TreeNode parent, int level) {
        if (node.val == x) {
            List list = new ArrayList();
            list.add(parent);
            list.add(level);
            return list;
        }

        if (node.left != null) {
            List l1 = findLevelAndParent(node.left, x, node, level + 1);
            if (l1 != null) {
                return l1;
            }
        }
        if (node.right != null) {
            List l2 = findLevelAndParent(node.right, x, node, level + 1);
            if (l2 != null) {
                return l2;
            }
        }

        return null;
    }
}
