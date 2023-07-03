package com.peniel.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FolderTreeNode {
  public static  ArrayList<String> list1=new ArrayList<String>();
    List<FolderTreeNode> childs;
    List<FolderTreeNode> leafs;
    String data;
    String incrementalPath;
public FolderTreeNode() {
	
}
    public FolderTreeNode( String nodeValue, String incrementalPath ) {
        childs = new ArrayList<FolderTreeNode>();
        leafs = new ArrayList<FolderTreeNode>();
        data = nodeValue;
        this. incrementalPath = incrementalPath;
    }

    public boolean isLeaf() {
        return childs.isEmpty() && leafs.isEmpty();
    }

    public void addElement(String currentPath, String[] list) {

        //Avoid first element that can be an empty string if you split a string that has a starting slash as /sd/card/
        while( list[0] == null || list[0].equals("") )
            list = Arrays.copyOfRange(list, 1, list.length);

        FolderTreeNode currentChild = new FolderTreeNode(list[0], currentPath+"/"+list[0]);
        if ( list.length == 1 ) {
            leafs.add( currentChild );
            return;
        } else {
            int index = childs.indexOf( currentChild );
            if ( index == -1 ) {
                childs.add( currentChild );
                currentChild.addElement(currentChild.incrementalPath, Arrays.copyOfRange(list, 1, list.length));
            } else {
            	FolderTreeNode nextChild = childs.get(index);
                nextChild.addElement(currentChild.incrementalPath, Arrays.copyOfRange(list, 1, list.length));
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
    	FolderTreeNode cmpObj = (FolderTreeNode)obj;
        return incrementalPath.equals( cmpObj.incrementalPath ) && data.equals( cmpObj.data );
    }

    public ArrayList<String> printNode( int increment ) {
    	ArrayList<String> list= new ArrayList<String>();
//        for (int i = 0; i < increment; i++) {
//            System.out.print(" ");
//        }
    //    System.out.println(incrementalPath+"  incremental path"  );
       if(!"".equals(incrementalPath) && list1!=null && ! list1.contains(incrementalPath)) {
    	list1.add(incrementalPath);
       }
        for( FolderTreeNode n: childs)
            n.printNode(increment+2);
        for( FolderTreeNode n: leafs)
            n.printNode(increment+2);
       // System.out.println(list1+"==============list11");

        return list1;
    }

    @Override
    public String toString() {
        return data;
    }


}
