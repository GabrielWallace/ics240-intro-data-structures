package edu.metrostate.ics240.p5.gaw886.morse;

import edu.metrostate.ics240.p5.morse.TreeNode;

public class BinaryNode<T extends Comparable<T>> implements TreeNode<T> {
	BinaryNode<T> leftChild, rightChild;
    T value;

    /* Constructor */
    public BinaryNode()
    {
        leftChild = null;
        rightChild = null;
        value = null;
    }
    /* Constructor */
    public BinaryNode(T n)
    {
        leftChild = null;
        rightChild = null;
        value = n;
    }

    public void setLeftChild(BinaryNode<T> n)
    {
        leftChild = n;
    }

    public void setRightChild(BinaryNode<T> n)
    {
        rightChild = n;
    }

    public void setValue(T d)
    {
        value = d;
    }  

	@Override
	public TreeNode<T> getLeftChild() {
		return leftChild;
	}

	@Override
	public TreeNode<T> getRightChild() {
		return rightChild;
	}

	@Override
	public T getValue() {
		return value;
	}
}
