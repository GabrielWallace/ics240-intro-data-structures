package edu.metrostate.ics240.p5.gaw886.morse;

import edu.metrostate.ics240.p5.morse.TreeNode;

public class BinaryTree<T extends Comparable<T>> {
	BinaryNode<T> root;
	
	public BinaryTree() {
		root = null;
	}

	public void insert(T data) {
		root = insert(root, data);
	}

	private BinaryNode<T> insert(BinaryNode<T> node, T data) {
		if (node == null)
			node = new BinaryNode<T>(data);
		else {
			if (node.getRightChild() == null)
				node.rightChild = insert(node.rightChild, data);
			else
				node.leftChild = insert(node.leftChild, data);
		}
		return node;
	}
	
	public void inorder()
    {
        inorder(root);
    }
    private void inorder(TreeNode<T> treeNode)
    {
        if (treeNode != null)
        {
            inorder(treeNode.getLeftChild());
            System.out.print(treeNode.getValue() +" ");
            inorder(treeNode.getRightChild());
        }
    }
    
    public boolean search(T val)
    {
        return search(root, val);
    }
    /* Function to search for an element recursively */
    private boolean search(TreeNode<T> r, T val)
    {
        if (r.getValue() == val)
            return true;
        if (r.getLeftChild() != null)
            if (search(r.getLeftChild(), val))
                return true;
        if (r.getRightChild() != null)
            if (search(r.getRightChild(), val))
                return true;
        return false;         
    }

}
