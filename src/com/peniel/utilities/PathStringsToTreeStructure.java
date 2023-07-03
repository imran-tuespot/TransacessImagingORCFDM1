package com.peniel.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;

public class PathStringsToTreeStructure {

//	public static void main(final String... args) {
//		final String[] list = new String[] {
//				"/800226326/",
//				"/800226326/800226326-1/Asset Management/Change in Operator/2015/07-13-2015/",
//				"/800226326/085-49003/Production/Closing/",
//				"/800226326/Asset Management/",
//				"/800226326/Asset Management/Accounts Receivable Financing/",
//				"/800226326/Asset Management/Change in Operator/",
//				"/800226326/Asset Management/Non Critical Repair Escrow/",
//				"/800226326/Asset Management/Other/",
//				"/800226326/Asset Management/Reserve for Replacement/",
//				"/800226326/Asset Management/TPA (Full)/" };
	public LinkedHashMap<String,Integer> getFolderCounts(String[] list){

		final DirectoryNode directoryRootNode = createDirectoryTree(list);
		//directoryRootNode.getValue();

		//System.out.println(">>"+directoryRootNode);
		
		String finalStr = directoryRootNode.toString();
		ArrayList<String> strLst1 = new ArrayList<String>();
		ArrayList<String> strLst= new ArrayList<String>();

		while (finalStr.indexOf('#') != -1) {
			
			String subStr = finalStr.substring(finalStr.indexOf('#')+1, finalStr.indexOf('@'));
			finalStr = finalStr.substring(finalStr.indexOf('@')+1, finalStr.length());
			
			strLst1.add(subStr);
		//	System.out.println("subStr>>>>"+subStr);
		}
			
		//}
		
		String [] arrayList1= new String[strLst1.size()];
		arrayList1=strLst1.toArray(arrayList1);
		for (int i=0;i<arrayList1.length-1; i++) {
			String temp1 = arrayList1[i].substring(0, arrayList1[i].indexOf(':'));
			String temp2 = arrayList1[i+1].substring(0, arrayList1[i+1].indexOf(':'));
			String tmpCount = arrayList1[i].substring(arrayList1[i].indexOf(':')+1, arrayList1[i].length());
//			if(temp2.contains(temp1)) {
//				arrayList1 = (String[]) ArrayUtils.remove(arrayList1,i);
//				temp1+= "/" +temp2+":"+ tmpCount;
//				arrayList1[i] = temp1;
//			}
		}
		strLst.addAll(Arrays.asList(arrayList1));		
		//	return getPathsMappedToCount(strLst,list);
		FolderTreeNode.list1=new ArrayList<String>();
		  FolderTree tree = new FolderTree(new FolderTreeNode("root", ""));
	        for (String data : list) {
	            tree.addElement(data);
	        }
	        ArrayList<String> pathlist= new ArrayList<String>();
	        pathlist= tree.printTree();
	       System.out.println(pathlist+"=========aa============");
	       System.out.println(strLst+"------bbbbbbbbb----------");
		//getPathsMappedToCount(strLst,list);
		//directoryRootNode.toString();
	      return getPathMappedtoCount1(pathlist,strLst);
	      // getPathMappedtoCount1(pathlist,strLst);
		/*Set tmpSet = (Set) directoryRootNode;
		
		//System.out.println(":::::"+directoryRootNode.getValue() + ">>>>" + directoryRootNode.getChildren().size() );
		System.out.println("tmpSet>>>>"+tmpSet);*/
		
	}

	private static LinkedHashMap<String,Integer> getPathMappedtoCount1(ArrayList<String> pathlist, List<String> foldercountList) {
		LinkedHashMap<String,Integer> countpathlist= new LinkedHashMap<String,Integer>();
		for(int i=0;i<foldercountList.size();i++) {
			if(foldercountList.size()==pathlist.size()) {
			String breakcount=foldercountList.get(i);
			breakcount=breakcount.substring(breakcount.indexOf(":")+1);
			countpathlist.put(pathlist.get(i),Integer.parseInt(breakcount));
			}
		}
		System.out.println("countpathlist:::"+countpathlist);
		return countpathlist;
	}

	public static DirectoryNode createDirectoryTree(final String[] list) {
		
		DirectoryNode treeRootNode = null;
		for (final String rawPath : list) {
			final String path = rawPath.startsWith("/") ? rawPath.substring(1) : rawPath;
			final String[] pathElements = path.split("/");
			DirectoryNode movingNode = null;
			for (final String pathElement : pathElements) {
				movingNode = new DirectoryNode(movingNode, pathElement);
			}

			if (treeRootNode == null) {
				treeRootNode = movingNode.getRoot();
			} else {
				treeRootNode.merge(movingNode.getRoot());
			}
		}

		return treeRootNode;
	}

	private static class DirectoryNode {

		private final Set<DirectoryNode> children = new LinkedHashSet<>();

		private final String value;

		private final DirectoryNode parent;
		
		private String finalStr = null;
		
		Map sampleMap = new HashMap();


		public DirectoryNode(final DirectoryNode parent, final String value) {
			
			this.parent = parent;
			
			if (this.parent != null) {
				this.parent.children.add(this);
			}
			
			this.value = value;
			//this.count = this.children.size();
		}

		public Set<DirectoryNode> getChildren() {
			return this.children;
		}

		public String getValue() {
			return this.value;
		}

		public DirectoryNode getParent() {
			return this.parent;
		}

		public int getLeafCount() {
			int leafCount = this.isLeaf() ? 1 : 0;
			for (final DirectoryNode child : this.children) {
				leafCount += child.getLeafCount();
			}

			return leafCount;
		}

		public boolean isLeaf() {
			return this.children.isEmpty();
		}

		public DirectoryNode getRoot() {
			//System.out.println("");
			return this.parent == null ? this : this.parent.getRoot();
		}

		public void merge(final DirectoryNode that) {
			
			if (!this.value.equals(that.value)) {
				return;
			} else if (this.children.isEmpty()) {
				this.children.addAll(that.children);
				return;
			}

			final DirectoryNode[] thisChildren = this.children.toArray(new DirectoryNode[this.children.size()]);
			for (final DirectoryNode thisChild : thisChildren) {
				for (final DirectoryNode thatChild : that.children) {
					if (thisChild.value.equals(thatChild.value)) {
						thisChild.merge(thatChild);
					} else if (!this.children.contains(thatChild)) {
						this.children.add(thatChild);
					}
				}
			}
			
		}

		@Override
		public boolean equals(final Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			final DirectoryNode that = (DirectoryNode) o;
			return Objects.equals(this.value, that.value) && Objects.equals(this.parent, that.parent);
		}

		@Override
		public int hashCode() {
			return Objects.hash(this.value, this.parent);
		}

		@Override
		public String toString() {
			
			
			//StringBuffer str = null; 
			//System.out.println(">>>>>::::"+"{" + "Parent='" + this.value + '\'' + ", children=" + this.children.size() + '}');
			//finalStr += "{" + "Parent='" + this.value + '\'' + ", children=" + this.children.size() + '}';
			//str.append("{" + "Parent='" + this.value + '\'' + ", children=" + this.children.size() + '}');
			
			//return "{" + "Parent='" + this.value + '\'' + ", children=" + this.children + '}';
			
			//return "{" + "Parent='" + this.value + '\''+"size::"+ this.getChildren().size() + '\'' + ", children=" + this.children + '}' ;
			
			return  "#"+this.value +":"+ this.getChildren().size() +"@"+ this.children  ;
			//return finalStr;
		}
		
		
	/*	
				                                               
		{Parent='800226326', 
			children=[{Parent='085-22056', 
						children=[{Parent='Asset Management', 
								children=[{Parent='Change in Operator', 
											children=[{Parent='2015', 
														children=[{Parent='07-13-2015', 
																children=[]}]}]}]}]}, 
					{Parent='085-49003', 
						children=[{Parent='Production', 
							children=[{Parent='Closing', children=[]}]}]}, 
					{Parent='Asset Management', 
						children=[{Parent='Accounts Receivable Financing', children=[]}, 
								  {Parent='Change in Operator', children=[]}, 
								  {Parent='Non Critical Repair Escrow', children=[]}, 
								  {Parent='Other', children=[]}, 
								  {Parent='Reserve for Replacement', children=[]}, 
								  {Parent='TPA (Full)', 
								  	children=[{Parent='sribala', children=[]}]}]}]}
								  	
		{Parent='800226326', 
			children=[{Parent='085-22056', children=[{Parent='Asset Management', children=[{Parent='Change in Operator', children=[{Parent='2015', children=[{Parent='07-13-2015', children=[]}size::0]}size::1]}size::1]}size::1]}size::1, {Parent='085-49003', children=[{Parent='Production', children=[{Parent='Closing', children=[]}size::0]}size::1]}size::1, {Parent='Asset Management', children=[{Parent='Accounts Receivable Financing', children=[]}size::0, {Parent='Change in Operator', children=[]}size::0, {Parent='Non Critical Repair Escrow', children=[]}size::0, {Parent='Other', children=[]}size::0, {Parent='Reserve for Replacement', children=[]}size::0, {Parent='TPA (Full)', children=[{Parent='sribala', children=[]}size::0]}size::1]}size::6]}size::3
						  	
		                                               
*/
	}
	
	public static LinkedHashMap<String,Integer> getPathsMappedToCount(ArrayList<String> strLst,String[] folderColonCountArray) { 
		ArrayList<String> folderBreak = new ArrayList<String>();	
		
	ArrayList<String> folderColonCountList= new ArrayList<>();
	folderColonCountList.addAll(Arrays.asList(folderColonCountArray));
	Map<String, Integer> mapFolderPathCount = new LinkedHashMap<String, Integer>();
	for (int i = 0; i < folderColonCountList.size(); i++) {

		for (int j = 0; j < strLst.size(); j++) {

			String path = folderColonCountList.get(i);

			String folderAndCount = strLst.get(j);

			String folderName = folderAndCount.substring(0, folderAndCount.indexOf(":"));

			int count = Integer.parseInt(folderAndCount.substring(folderAndCount.indexOf(":") + 1));

			if (path.contains(folderName+"/")) {

				int index =getNextIndexOfSlash(path, folderName + "/");
				
				mapFolderPathCount.put(path.substring(0, index + folderName.length()), count);

			}


		}	

	}
	folderBreak.addAll(mapFolderPathCount.keySet());
//	System.out.println(folderBreak+"==============folderBreak=====");
	 System.out.println("********************strLst******************************"+strLst);

	 System.out.println("**************************************************"+mapCounttoPath(folderBreak,strLst));

	return mapCounttoPath(folderBreak,strLst);

	
}

public static int getNextIndexOfSlash(String word, String guess) {

	int slashIndex = 0;

	for (int index = word.indexOf(guess); index >= 0; index = word.indexOf(guess, index + 1)) {

		// System.out.println(index +"============"+word.substring(0, index));

		slashIndex = index;

		break;

	}

	return slashIndex;

}


public static LinkedHashMap<String,Integer> mapCounttoPath(ArrayList<String> pathList,ArrayList<String> folderCountList){
	System.out.println(pathList.size()+"=====pathlistsize========");
	System.out.println(pathList.size()+"=====folderCountList========");
	LinkedHashMap<String,Integer> map=new  LinkedHashMap<String,Integer>();
	for(int i=0;i<pathList.size();i++) {
		String folderCount= folderCountList.get(i).substring(folderCountList.get(i).indexOf(":")+1);
		map.put(pathList.get(i),Integer.parseInt(folderCount));
	}
	System.out.println(map+"======================");
	return map;
}

	
	

}