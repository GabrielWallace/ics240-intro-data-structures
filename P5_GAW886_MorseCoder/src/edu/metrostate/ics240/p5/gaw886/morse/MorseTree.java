package edu.metrostate.ics240.p5.gaw886.morse;

import org.junit.experimental.theories.Theories;

import edu.metrostate.ics240.p5.morse.TreeNode;

public class MorseTree<T> {
    MorseNode<T> root;
    int size;

    protected final static String DIT = "·";
    protected final static String DAH = "-";
    protected final static String SPACE = " ";
    protected final static String ENDWORD = "/ ";
    protected final static String END = ". ";

    public MorseTree() {
        root = new MorseNode<T>();
    } 
    
    public void printInOrder() {
		printInOrder(this.root, 0);
	}


	private void printInOrder(MorseNode<T> node, int lvl) {
		if (node != null){
			printInOrder((MorseNode<T>) node.getLeftChild(), lvl + 1);

			for (int i = 0; i < lvl; i++) {
				System.out.print("\t");
			}
			System.out.printf("%3d\n", node.getValue());
			printInOrder((MorseNode<T>) node.getRightChild(), lvl + 1);
		}
	}
    
    public <T> void insert (Character character, String code) {
        Character element = character;
        String path = code;
        String nodeKey = "";
        MorseNode<T> cursor = (MorseNode<T>) getRoot();
        MorseNode<T> temp = new MorseNode<T>();

        for (int i=0; i<path.length(); i++) {
            nodeKey = path.substring(i,i+1);
            if (nodeKey.equals(DIT)) {
                if (cursor.hasLeftChild()) {
                    cursor = (MorseNode<T>) cursor.getLeftChild();
                } else {
                    cursor.setLeftChild(new MorseNode<T>());
                    size += 1;
                    temp = cursor;
                    cursor = (MorseNode<T>) cursor.getLeftChild();
                    cursor.setParent(temp);
                }
            } else {
                if (cursor.hasRightChild()) {
                    cursor = (MorseNode<T>) cursor.getRightChild();
                } else {
                    cursor.setRightChild(new MorseNode<T>());
                    size += 1;
                    temp = cursor;
                    cursor = (MorseNode<T>) cursor.getRightChild();
                    cursor.setParent(temp);
                }
            }
        }
        cursor.setElement(element);
    } 
    
    public String decode (String code) throws RuntimeException {
        String path = (String) code;
        String nodeKey = "";
        @SuppressWarnings("unchecked")
		MorseNode<T> cursor = getRoot();
        for (int i=0; i<path.length(); i++) {
            nodeKey = path.substring(i,i+1);
            if (nodeKey.equals(DIT)) {
                if (cursor.hasLeftChild()) {
                    cursor = (MorseNode<T>) cursor.getLeftChild();
                } else {
                    throw new RuntimeException("Code pattern not found.");
                }
            } else if (nodeKey.equals(DAH)) {
                if (cursor.hasRightChild()) {
                    cursor = (MorseNode<T>) cursor.getRightChild();
                } else {
                    throw new RuntimeException("Code pattern not found. ");
                }
            }
        }
        return (String) cursor.element();
    }

    public MorseNode<T> getRoot() {
        return root;
    }
    
    public int size() {
        return size;
    } 
    
    public String toString() {
        String info = "I am a MorseTree object. ";
        info += "I have " + size() + " nodes encoded. ";
        return info;
    }
    
    private class MorseNode<T> implements TreeNode<T> {
        //======================================================================
        // Variables
        //======================================================================
        protected MorseNode<T> parent;
        protected MorseNode<T> leftChild;
        protected MorseNode<T> rightChild;
        protected T value;
        //======================================================================
        // Constructors
        //======================================================================
        /**
         *  This constructor creates an empty MorseNode<T>.
         */
        public MorseNode() {
            
        } // End constructor MorseNode<T>()

        /**
         * This constructor creates a new MorseNode<T> holding an Object passed
         * to it.
         * @param o An object to be associated with the node as an Object.
         */
        public MorseNode(Object o) {
            setElement(o);
        } // End constructor MorseNode<T>(Object o)
        //======================================================================
        // Methods
        //======================================================================
        /**
         * This method sets the parent of the MorseNode<T> to the node passed
         * as a parameter.
         * @param n A MorseNode<T> object to be set as the parent
         */
        private void setParent (MorseNode<T> n) {
            parent = n;
        } // End method setParent (MorseNode<T> n)

        /**
         * This method sets the left child of the current node to the node
         * passed as a parameter.
         * @param child The node to be set as the left child as a MorseNode<T>
         */
        private void setLeftChild (MorseNode<T> child) {
            leftChild = child;
        } // End method setLeftChild(MorseNode<T> child)

        /**
         * This method sets the right child of the current node to the node
         * passed as a parameter.
         * @param child The node to be set as the right child as a MorseNode<T>
         */
        private void setRightChild (MorseNode<T> child) {
            rightChild = child;
        } // End method setLeftChild(MorseNode<T>)
        
        /**
         * This method tests the current node for the presence of a left child.
         * @return TRUE if a left child is associated with the current node as a boolean
         */
        private boolean hasLeftChild () {
            return (leftChild != null);
        } // End method hasLeftChild()
        
        /**
         * This method tests the current node for the presence of a right child.
         * @return TRUE if a right child is associated with the current node as a boolean
         */
        private boolean hasRightChild () {
            return (rightChild != null);
        } // End method hasLeftChild()
        
        /**
         * This method associates the current node with an Object passed as a parameter.
         * @param o The element to be associated with the current node as an Object.
         */
        private void setElement (Object o) {
            value = (T) o;
        } // End method setElement(Object o)
        
        private Object element() {
            return value;
        } // End method element()

		@Override
		public TreeNode<T> getLeftChild() {
			return this.leftChild;
		}

		@Override
		public TreeNode<T> getRightChild() {
			return this.rightChild;
		}

		@Override
		public T getValue() {
			return this.value;
		}
    } 
}