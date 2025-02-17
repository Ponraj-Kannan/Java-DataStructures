import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BinarySearchTree1 {

    // Root of the binary search tree
    TreeNode root = null;

    // Define the TreeNode class (internal class for tree nodes)
    class TreeNode {
        int data; // Value of the node
        TreeNode left; // Address of left child
        TreeNode right; // Address of right child

        // Constructor to create a new node
        public TreeNode(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    // Method to insert a new node into the binary search tree
    void insert(int d){
        root = insert(root, d);
    }

    // Helper method to recursively insert a node in the correct position
    TreeNode insert(TreeNode curr, int d){
        if(curr == null){
            TreeNode node = new TreeNode(d); // Create a new node if the current node is null
            return node;
        }
        if(curr.data > d){
            curr.left = insert(curr.left, d); // Insert in the left subtree if the data is smaller
        }
        else{
            curr.right = insert(curr.right, d); // Insert in the right subtree if the data is larger
        }
        return curr;
    }

    // Method to search for a key in the binary search tree
    boolean search(int key){
        return search(key, root);
    }

    // Helper method to recursively search for a key in the binary search tree
    boolean search(int key, TreeNode curr){
        if(curr == null){
            return false; // Key not found
        }
        else if(key == curr.data){
            System.out.print(curr.data + " -> "); // Key found
            return true;
        }
        else if(key < curr.data){
            System.out.print(curr.data + " -> ");
            return search(key, curr.left); // Search in the left subtree
        }
        else {
            System.out.print(curr.data + " -> ");
            return search(key, curr.right); // Search in the right subtree
        }
    }

    // Traversal Methods

    // Pre-order traversal (root, left, right)
    void pre_order() {
        pre_order(root);
    }

    // Helper method for pre-order traversal
    void pre_order(TreeNode curr) {
        if (curr == null) {
            return;
        }
        System.out.print(curr.data + " "); // Visit root node
        pre_order(curr.left);  // Visit left subtree
        pre_order(curr.right); // Visit right subtree
    }

    // In-order traversal (left, root, right)
    void in_order() {
        in_order(root);
    }

    // Helper method for in-order traversal
    void in_order(TreeNode curr) {
        if (curr == null) {
            return;
        }
        in_order(curr.left);  // Visit left subtree
        System.out.print(curr.data + " "); // Visit root node
        in_order(curr.right); // Visit right subtree
    }

    // Post-order traversal (left, right, root)
    void post_order() {
        post_order(root);
    }

    // Helper method for post-order traversal
    void post_order(TreeNode curr) {
        if (curr == null) {
            return;
        }
        post_order(curr.left);  // Visit left subtree
        post_order(curr.right); // Visit right subtree
        System.out.print(curr.data + " "); // Visit root node
    }

    // Level order traversal
    public void levelOrder() {
        if(root != null) {
            Queue<TreeNode> que = new LinkedList<TreeNode>();
            que.add(root);
            while(!que.isEmpty()) {
                TreeNode curr = que.poll();
                System.out.print(curr.data + " ");
                if(curr.left != null) {
                    que.add(curr.left);
                }
                if(curr.right != null) {
                    que.add(curr.right);
                }
            }
            System.out.println();
        }
    }

    // Method to delete a node from BST
    void delete(int key) {
        root = delete(root, key);
    }

    // Helper function to delete a node in BST
    TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return null; // Base case: Tree is empty or key not found
        }

        if (key < root.data) {
            root.left = delete(root.left, key);  // Recur on the left subtree
        }
        else if (key > root.data) {
            root.right = delete(root.right, key); // Recur on the right subtree
        }
        else {
            // Case 1: Node has no child (leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Node has only one child (left or right)
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }

            // Case 3: Node has two children
            // Find the in-order successor (smallest node in right subtree)
            TreeNode successor = findMin(root.right);
            root.data = successor.data; // Copy successor's value to current node
            root.right = delete(root.right, successor.data); // Delete the duplicate node
        }
        return root;
    }

    // Helper function to find the minimum value node in BST
    TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Method to calculate the size of the binary tree (number of nodes)
    int getSize() {
        return getSize(root);
    }

    // Helper method to recursively calculate the size
    int getSize(TreeNode curr) {
        if (curr == null) {
            return 0;
        }
        return 1 + getSize(curr.left) + getSize(curr.right);
        // Sum of sizes of left and right subtrees plus 1 for the current node
    }

    // Method to calculate the sum of all nodes in the binary tree
    int sumBT() {
        return sumBT(root);
    }

    // Helper method to recursively calculate the sum of all nodes
    int sumBT(TreeNode curr) {
        if (curr == null) {
            return 0;
        }
        return curr.data + sumBT(curr.left) + sumBT(curr.right);
        // Sum of values in left and right subtrees plus the current node's data
    }

    // Method to find the minimum value in the binary tree
    int minValue() {
        return minValue(root);
    }

    // Helper method to recursively find the minimum value
    int minValue(TreeNode curr) {
        if (curr == null) {
            return Integer.MAX_VALUE; // Return maximum integer value for null nodes
        }
        return Math.min(curr.data, Math.min(minValue(curr.left), minValue(curr.right)));
        // Find the minimum value among the current node and its children
    }

    // Method to count the number of leaf nodes in the binary tree
    int countLeaves() {
        return countLeaves(root);
    }

    // Helper method to recursively count the leaf nodes
    int countLeaves(TreeNode curr) {
        if (curr == null) {
            return 0;
        }
        if (curr.left == null && curr.right == null) {
            return 1; // If node is a leaf, count it
        }
        return countLeaves(curr.left) + countLeaves(curr.right); // Sum of leaf nodes in left and right subtrees
    }

    // Method to calculate the height of the binary tree
    int height() {
        return height(root);
    }

    // Helper method to recursively calculate the height
    int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
        // Maximum height between left and right subtree plus 1 for the current node
    }

    // Method to get the left view of the binary tree
    ArrayList<Integer> leftView() {
        return leftView(root);
    }

    // Helper method to calculate the left view using level order traversal
    ArrayList<Integer> leftView(TreeNode curr) {
        ArrayList<Integer> list = new ArrayList<>();
        if (curr == null) {
            return list;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.add(curr);

        while (!que.isEmpty()) {
            int n = que.size();
            for (int i = 1; i <= n; i++) {
                TreeNode temp = que.remove();
                if (i == 1) {
                    list.add(temp.data); // Add the first node of each level (leftmost node)
                }
                if (temp.left != null) {
                    que.add(temp.left);
                }
                if (temp.right != null) {
                    que.add(temp.right);
                }
            }
        }
        return list;
    }

    // Method to get the right view of the binary tree
    ArrayList<Integer> rightView() {
        return rightView(root);
    }

    // Helper method to calculate the right view using level order traversal
    ArrayList<Integer> rightView(TreeNode curr) {
        ArrayList<Integer> list = new ArrayList<>();
        if (curr == null) {
            return list;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.add(curr);

        while (!que.isEmpty()) {
            int n = que.size();
            for (int i = 1; i <= n; i++) {
                TreeNode temp = que.remove();
                if (i == n) {
                    list.add(temp.data); // Add the last node of each level (rightmost node)
                }
                if (temp.left != null) {
                    que.add(temp.left);
                }
                if (temp.right != null) {
                    que.add(temp.right);
                }
            }
        }
        return list;
    }

    // Method to calculate the diameter of the binary tree
    int diameterOfBinaryTree() {
        return get_diameter(root) - 1;
    }

    // Helper method to calculate the diameter (longest path between two nodes)
    int get_diameter(TreeNode curr) {
        if (curr == null) {
            return 0;
        }

        int left_height = height(curr.left);
        int right_height = height(curr.right);

        int nodes = 1 + left_height + right_height;
        // Calculate the number of nodes in the path that passes through the current node

        return Math.max(nodes, Math.max(get_diameter(curr.left), get_diameter(curr.right)));
        // Return the maximum diameter found
    }
}
