package FindCousins;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // BREADTH FIRST SEARCH

    public boolean isCousins(TreeNode root, int x, int y) {
        // cousins means they have to be on same level... but not share the same parent
        // hence, first find their levels

        if (x == y || root.val == x || root.val == y) {
            return false;
        }

        List<TreeNode> currLevel = new ArrayList<TreeNode>();
        currLevel.add(root.left);
        currLevel.add(root.right);
        List<TreeNode> nextLevel = new ArrayList<TreeNode>();

        while (!currLevel.isEmpty()) {
            int found = 0, indexX = 0, indexY = 0;

            // parse through nodes of this level
            for (TreeNode node : currLevel) {
                if (node.val == x) {
                    indexX = currLevel.indexOf(node);
                    found++;
                } else if (node.val == y) {
                    indexY = currLevel.indexOf(node);
                    found++;
                }
                nextLevel.add(node.left);
                nextLevel.add(node.right);
            }

            // found both in same level
            if (found == 2) {
                return checkDiffParents(indexX, indexY);
            }
            // found only 1
            if (found == 1) {
                return false;
            }
            currLevel.clear();
            currLevel.addAll(nextLevel);
            nextLevel.clear();
        }
        return false;
    }

    private boolean checkDiffParents(int indexX, int indexY) {
        // we know when node is not present there will be a "null"
        // so tree will be "balanced"
        // TODO
        return false;

    }

}
