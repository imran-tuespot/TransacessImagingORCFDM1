package com.peniel.utilities;

import java.util.ArrayList;

public class FolderTree {

	FolderTreeNode root;
	FolderTreeNode commonRoot;

    public FolderTree( FolderTreeNode root ) {
        this.root = root;
        commonRoot = null;
    }

    public void addElement( String elementValue ) { 
        String[] list = elementValue.split("/");

        // latest element of the list is the filename.extrension
        root.addElement(root.incrementalPath, list);

    }

    public ArrayList<String> printTree() {
    	ArrayList<String> list=new ArrayList<String>();
        //I move the tree common root to the current common root because I don't mind about initial folder
        //that has only 1 child (and no leaf)
        getCommonRoot();
       list=commonRoot.printNode(0);
       System.out.println("===============rooot============"+list);
       return list ;
    }

    public FolderTreeNode getCommonRoot() {
        if ( commonRoot != null)
            return commonRoot;
        else {
        	FolderTreeNode current = root;
            while ( current.leafs.size() <= 0 ) {
                current = current.childs.get(0);
            }
            commonRoot = current;
            return commonRoot;
        }

    }


}