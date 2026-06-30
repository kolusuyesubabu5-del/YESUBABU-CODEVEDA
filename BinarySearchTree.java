// File Name: BinarySearchTree.java

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinarySearchTree {

    TreeNode root;

    // Insert a node
    TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    // Search a node
    boolean search(TreeNode root, int key) {
        if (root == null)
            return false;

        if (root.data == key)
            return true;

        if (key < root.data)
            return search(root.left, key);

        return search(root.right, key);
    }

    // Delete a node
    TreeNode delete(TreeNode root, int key) {
        if (root == null)
            return null;

        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {
            // Node with one or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children
            root.data = minValue(root.right);
            root.right = delete(root.right, root.data);
        }

        return root;
    }

    // Find minimum value
    int minValue(TreeNode root) {
        int min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    // Inorder Traversal
    void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Preorder Traversal
    void preorder(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Postorder Traversal
    void postorder(TreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        int[] values = {50, 30, 70, 20, 40, 60, 80};

        for (int value : values) {
            bst.root = bst.insert(bst.root, value);
        }

        System.out.print("Inorder Traversal: ");
        bst.inorder(bst.root);

        System.out.print("\nPreorder Traversal: ");
        bst.preorder(bst.root);

        System.out.print("\nPostorder Traversal: ");
        bst.postorder(bst.root);

        int key = 40;
        System.out.println("\n\nSearching " + key + ": " +
                (bst.search(bst.root, key) ? "Found" : "Not Found"));

        bst.root = bst.delete(bst.root, 30);

        System.out.print("Inorder after deleting 30: ");
        bst.inorder(bst.root);
    }
}