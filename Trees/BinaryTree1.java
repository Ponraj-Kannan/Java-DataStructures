import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BinaryTree1 {

    // Root node of the binary tree
    TreeNode root = null;

    // Inner class representing a node in the binary tree
    class TreeNode {
        int data;         // Data stored in the node
        TreeNode left;    // Reference to the left child
        TreeNode right;   // Reference to the right child

        // Constructor to initialize the node with data
        public TreeNode(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    // Method to insert nodes into the binary tree
    void insert() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the root val : ");
        int val = sc.nextInt();
        if (val != -1) {
            TreeNode node = new TreeNode(val); // Create the root node
            root = node;
            insert(root); // Recursively insert left and right children
        }
    }

    // Recursive method to insert nodes into the binary tree
    void insert(TreeNode curr) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the left val of " + curr.data + " : ");
        int left_val = sc.nextInt();
        if (left_val != -1) {
            TreeNode node = new TreeNode(left_val); // Create left child node
            curr.left = node;
            insert(curr.left); // Recursively insert for the left child
        }
        System.out.println("Enter the right val of " + curr.data + " : ");
        int right_val = sc.nextInt();
        if (right_val != -1) {
            TreeNode node = new TreeNode(right_val); // Create right child node
            curr.right = node;
            insert(curr.right); // Recursively insert for the right child
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

    // Delete node

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
