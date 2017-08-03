package edu.metrostate.ics240.p5.gaw886.morse;

import java.util.Map;

import edu.metrostate.ics240.p5.morse.TreeNode;


public class DecodeTree {	
	
	static class MorseNode implements TreeNode<Character>{
		protected MorseNode parent;
		private TreeNode<Character> leftChild;
		private TreeNode<Character> rightChild;
		private Character value;

		private void setParent (MorseNode n) {
	        parent = n;
	    }

		private void setLeftChild(TreeNode<Character> newNode) {
			this.leftChild = newNode;
		}

		private void setRightChild(TreeNode<Character> newNode) {
			this.rightChild = newNode;
		}
		
		/**
		 * Helper method to check the current node for a left child node
		 * @return true if left child is present else false
		 */
		public boolean hasLeftChild () {
            return (leftChild != null);
        }
		
		/**
		 * Helper method to check the current node for a right child node
		 * @return true if right child is present else false
		 */
        public boolean hasRightChild () {
            return (rightChild != null);
        }
		
        /**
         * Method to return the current node's left child node
         * @return this nodes left child node
         */
		@Override
		public TreeNode<Character> getLeftChild() {
			return this.leftChild;
		}

		/**
         * Method to return the current node's right child node
         * @return this nodes right child node
         */
		@Override
		public TreeNode<Character> getRightChild() {
			return this.rightChild;
		}
		
		private void setValue (Character key) {
            value = key;
        }

		/**
		 * Returns the value of this node
		 */
		@Override
		public Character getValue() {
			return this.value;
		}
		
	    /**
	     * Takes a single Morse code letter and searches the <code>DecodeTree()</code> to find its corresponding
	     * plain text English counterpart
	     * @param code the Morse code letter to be decoded
	     * @return The node value containing the plain text English counterpart to the Morse letter
	     */
	 	public String decodeLetter(String code, StringBuffer sb) {
	 		TreeNode<Character> currNode = getRoot();
	 		String morseLetter = code;
	 		String key = "";

	 		for (int i = 0; i < morseLetter.length(); i++) {
	 			key = morseLetter.substring(i, i + 1);
	 			if (key.equals("-")) {
	 				if (((MorseNode) currNode).hasLeftChild()) {
	 					currNode = currNode.getLeftChild();
	 				} else {
	 					throw new IllegalArgumentException(
	 							String.format("Invalid code encountered %s[%s]", sb.toString().trim(),code));
	 				}
	 			} else if (key.equals("*")) {
	 				if (((MorseNode) currNode).hasRightChild()) {
	 					currNode = currNode.getRightChild();
	 				} else {
	 					throw new IllegalArgumentException(
	 							String.format("Invalid code encountered %s[%s]", sb.toString().trim(),code));
	 				}
	 			}
	 		}
	 		return currNode.getValue().toString();
	 	}
		
	}
	
    static MorseNode root = new MorseNode();
    DecodeTree decodeTree;
    
    public static MorseNode getRoot() {
        return root;
    }
    
    private void insert (Character character, String code) {
        Character value = character;
        String path = code;
        String nodeKey = "";
        MorseNode currNode = getRoot();
        MorseNode temp = new MorseNode();

        for (int i=0; i<path.length(); i++) {
            nodeKey = path.substring(i,i+1);
            if (nodeKey.equals("-")) {
                if (currNode.hasLeftChild()) {
                    currNode = (MorseNode) currNode.getLeftChild();
                } else {
                    currNode.setLeftChild(new MorseNode());
                    temp = currNode;
                    currNode = (MorseNode) currNode.getLeftChild();
                    currNode.setParent(temp);
                }
            } else {
                if (currNode.hasRightChild()) {
                    currNode = (MorseNode) currNode.getRightChild();
                } else {
                    currNode.setRightChild(new MorseNode());
                    temp = currNode;
                    currNode = (MorseNode) currNode.getRightChild();
                    currNode.setParent(temp);
                }
            }
        } 
        currNode.setValue(value);
    }
    
    /**
     * This method builds the actual Morse Decoder Tree based off of the values in the <code>EncodeMap()</code>
     * @return a new Binary Tree holding all of the plain text English characters and following the rules of 
     * "-" (dashes) to the left and "*" dots to the right while traversing and building the tree
     */
    public DecodeTree buildDecodingTree(Map<Character, String> encoder) {
    	Map<Character, String> dict = encoder;
		DecodeTree decodingTree = new DecodeTree();
		for(Map.Entry<Character, String> entry : dict.entrySet()) {
			(decodingTree).insert(entry.getKey(), entry.getValue());
		}
		return decodingTree;
	}
}
