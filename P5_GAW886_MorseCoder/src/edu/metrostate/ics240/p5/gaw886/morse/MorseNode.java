package edu.metrostate.ics240.p5.gaw886.morse;
import edu.metrostate.ics240.p5.morse.TreeNode;;

public class MorseNode<T> implements TreeNode<T>{
		
		MorseNode<T> root;
		protected MorseNode<T> parent;
		int depth;
	 	protected final static String DOT = "·";
	    protected final static String DASH = "-";
	    protected final static String SPACE = " ";
	    protected final static String ENDWORD = "/ ";
	    protected final static String END = ". ";
		private TreeNode<T> leftChild;
		private TreeNode<T> rightChild;
		private T value;

		public MorseNode() {
		}

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

		public void setLeftChild(TreeNode<T> newNode) {
			this.leftChild = newNode;
		}

		public void setRightChild(TreeNode<T> newNode) {
			this.rightChild = newNode;
		}	
		
		private boolean hasLeftChild () {
            return (leftChild != null);
        }
		
        private boolean hasRightChild () {
            return (rightChild != null);
        }
        
		@SuppressWarnings("unchecked")
		private MorseNode<T> setValue (T element) {
            value = (T) element;
			return parent;
        }
        
        public MorseNode(T o) {
            setValue(o);
        } 

        private void setParent (MorseNode<T> n) {
            parent = n;
        } 
        
        @SuppressWarnings("unchecked")
		public void insert (Character key, String code) {
        	root = new MorseNode<>();
            T element = (T) key;
            T path = (T) code;
            String nodeKey = null;
            MorseNode<T> currNode = getRoot();
            MorseNode<T> temp = new MorseNode<T>();

            for (int i=0; i<((String) path).length(); i++) {
                nodeKey = ((String) path).substring(i,i+1);
                if (nodeKey.equals(DOT)) {
                    if (currNode.hasLeftChild()) {
                        currNode = (MorseNode<T>) currNode.getLeftChild();
                    } else {
                        currNode.setLeftChild(new MorseNode<>());
                        depth += 1;
                        temp = currNode;
                        currNode = (MorseNode<T>) currNode.getLeftChild();
                        currNode.setParent(temp);
                    }
                } else {
                    if (currNode.hasRightChild()) {
                        currNode = (MorseNode<T>) currNode.getRightChild();
                    } else {
                        currNode.setRightChild(new MorseNode<>());
                        depth += 1;
                        temp = currNode;
                        currNode = (MorseNode<T>) currNode.getRightChild();
                        currNode.setParent(temp);
                    }
                }
            }
            currNode = setValue((T) element);
        }
        
        public MorseNode<T> getRoot() {
            return root;
        }
        
        public void printInOrder() {
    		printInOrder(root, 0);
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
	}


