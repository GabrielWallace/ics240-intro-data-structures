package edu.metrostate.ics240.p5.gaw886.morse;

import java.util.Map;

import edu.metrostate.ics240.p5.morse.TreeNode;


public class DecodeTree {	
	static class MorseNode implements TreeNode<Character>{
		protected MorseNode parent;
		private TreeNode<Character> leftChild;
		private TreeNode<Character> rightChild;
		private Character value;

		public MorseNode() {
		}
		
		public MorseNode(Character key) {
            setValue(key);
        } 
		
		private void setParent (MorseNode n) {
	        parent = n;
	    }

		private void setLeftChild(TreeNode<Character> newNode) {
			this.leftChild = newNode;
		}

		private void setRightChild(TreeNode<Character> newNode) {
			this.rightChild = newNode;
		}
		
		public boolean hasLeftChild () {
            return (leftChild != null);
        }

        public boolean hasRightChild () {
            return (rightChild != null);
        }
		
		@Override
		public TreeNode<Character> getLeftChild() {
			return this.leftChild;
		}

		@Override
		public TreeNode<Character> getRightChild() {
			return this.rightChild;
		}
		
		private void setValue (Character key) {
            value = key;
        }

		@Override
		public Character getValue() {
			return this.value;
		}
	}
    MorseNode root = new MorseNode();
    DecodeTree decodeTree;
    public MorseNode getRoot() {
        return root;
    }
	
    public void insert (Character character, String code) {
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
    
    public DecodeTree buildDecodingTree() {
    	Map<Character, String> dict = new EncodeMap().buildMap();
		DecodeTree decodingTree = new DecodeTree();
		for(Map.Entry<Character, String> entry : dict.entrySet()) {
			(decodingTree).insert(entry.getKey(), entry.getValue());
		}
		return decodingTree;
	}
}
