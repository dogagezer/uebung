import java.util.*;

public class TreeNode<T> {
    T data;
    List<TreeNode<T>> children;

    public TreeNode(T newValue) {
        data = newValue;
        children = new ArrayList<>();
    }

    public class TreeIterator<T> implements Iterator<T> {

        private Stack<TreeNode<T>> stack;

        public TreeIterator(TreeNode<T> root) {
            stack = new Stack<>();
            stack.push(root);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            TreeNode<T> current = stack.pop();
            for (int i = current.children.size() - 1; i >= 0; i--) {
                stack.push(current.children.get(i));
            }
            return current.data;
        }

        public int findHeight(TreeNode<T> root) {
            if (root == null) {
                return 0;
            }
            int maxHeight = 0;
            for (TreeNode<T> child : root.children) {
                int childHeight = findHeight(child);
                maxHeight = maxHeight < childHeight ? childHeight : maxHeight;
            }
            return maxHeight + 1;
        }

        public int findSize(TreeNode<T> root) {
            if (root == null) {
                return 0;
            }
            int size = 0;
            for (TreeNode<T> child : root.children) {
                size += findSize(child);
            }
            return size + 1;
        }

        public String toString(TreeNode<T> root) {
            if (root.children.isEmpty()) {
                return "[" + root.data.toString() + "]";
            }
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < root.children.size(); i++) {
                TreeNode<T> child = root.children.get(i);
                String childStr = toString(child);  // Recursive call with child as the new root
                if (i > 0) {
                    result.append(", ");
                }
                result.append(childStr);
            }
            return "[" + result + ", " + root.data.toString() + "]";
        }

    }
}
