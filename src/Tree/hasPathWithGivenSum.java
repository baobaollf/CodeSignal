package Tree;

public class hasPathWithGivenSum {
    //
// Binary trees are already defined with this interface:
    class Tree<T> {
        Tree(T x) {
            value = x;
        }

        T value;
        Tree<T> left;
        Tree<T> right;
    }

    boolean hasPathWithGivenSum(Tree<Integer> t, int s) {
        if (t == null) {
            return false;
        }
        int leftOVer = s - t.value;
        if (leftOVer == 0) {
            if (t.left == null && t.right == null) {
                return true;
            }
        }
        boolean left = hasPathWithGivenSum(t.left, leftOVer);
        boolean right = hasPathWithGivenSum(t.right, leftOVer);
        return left || right;
    }

}
