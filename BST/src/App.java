import java.util.LinkedList;
import java.util.Queue;

class BinaryNode {
    int value;
    BinaryNode left, right;

    public BinaryNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

class BinaryTree {
    BinaryNode root;

    public void deleteNode(int value) {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        if (root.left == null && root.right == null) {
            if (root.value == value) {
                root = null;
            } else {
                System.out.println("Value not found.");
            }
            return;
        }

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        BinaryNode targetNode = null;
        BinaryNode currentNode = null;

        // Step 1: Find the target node and the last (deepest) node
        while (!queue.isEmpty()) {
            currentNode = queue.remove();

            if (currentNode.value == value) {
                targetNode = currentNode;
            }
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

        if (targetNode != null) {
            int deepestValue = currentNode.value;
            deepdelete(currentNode);
            targetNode.value = deepestValue;
        } else {
            System.out.println("Not found");
        }
    }

    // Additional Delete
    private void deepdelete(BinaryNode deleteNode) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode currentNode = queue.remove();

            if (currentNode.left != null) {
                if (currentNode.left == deleteNode) {
                    currentNode.left = null;
                    return;
                } else {
                    queue.add(currentNode.left);
                }
            }

            if (currentNode.right != null) {
                if (currentNode.right == deleteNode) {
                    currentNode.right = null;
                    return;
                } else {
                    queue.add(currentNode.right);
                }
            }
        }
    }

    // search a value in binary tree
    public boolean searchNode(int value) {
        if (root == null) {
            return false;
        }

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode currentNode = queue.remove();
            if (currentNode.value == value) {
                return true;
            }
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return false;
    }

    // Level-order Traversal: Print nodes level by level
    public void levelOrderTraversal(BinaryNode node) {
        if (node == null) {
            return;
        }

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            BinaryNode currentNode = queue.remove();
            System.out.print(currentNode.value + " ");

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }

    // Method to insert
    public void insert(int value) {
        BinaryNode node = new BinaryNode(value);

        if (root == null) {
            root = node;
            return;
        }

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode currentNode = queue.remove();

            if (currentNode.left == null) {
                currentNode.left = node;
                return;
            } else {
                queue.add(currentNode.left);
            }

            // If the right child is null, insert the new node here
            if (currentNode.right == null) {
                currentNode.right = node;
                return;
            } else {
                queue.add(currentNode.right);
            }
        }
    }
}

public class App {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(2);
        tree.insert(12);
        tree.insert(1);
        tree.insert(3);
        tree.insert(9);
        tree.insert(21);
        tree.insert(19);
        tree.insert(25);

        tree.levelOrderTraversal(tree.root);

    }
}
