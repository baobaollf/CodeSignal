package Tree;


public class isTreeSymmetric {
    //
// Binary trees are already defined with this interface:
    public static class Tree<T> {
        Tree(T x) {
            value = x;
        }

        T value;
        Tree<T> left;
        Tree<T> right;
    }

    boolean isTreeSymmetric(Tree<Integer> t) {
        if (t == null) {
            return true;
        }
        return isSymmetric(t.left, t.right);
    }

    boolean isSymmetric(Tree<Integer> left, Tree<Integer> right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (!left.value.equals(right.value)) {
            return false;
        } else {
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
    }

    public static void main(String[] args) {
        isTreeSymmetric isTreeSymmetric = new isTreeSymmetric();
        Tree<Integer> one = new Tree<>(1);
        Tree<Integer> two1 = new Tree<>(2);
        Tree<Integer> two2 = new Tree<>(2);
        Tree<Integer> three1 = new Tree<>(3);
        Tree<Integer> three2 = new Tree<>(3);
        one.left = two1;
        one.right = two2;
        two1.right = three1;
        two2.right = three2;

        isTreeSymmetric.isTreeSymmetric(one);
    }


}
