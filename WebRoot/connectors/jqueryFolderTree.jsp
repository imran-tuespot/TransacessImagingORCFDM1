<!-- connector file for create new folders page -->

<%@ page
	import="java.io.File,java.io.FilenameFilter,java.util.Arrays,java.util.Map,java.util.HashMap,java.util.List,java.util.ArrayList,java.util.StringTokenizer,
	java.util.Collections,java.util.Comparator" %>
	  <jsp:useBean id="folderBean" scope="request" class="com.peniel.beans.FolderBean" />
	
<%
    String dir = request.getParameter("dir");
   	dir = java.net.URLDecoder.decode(dir, "UTF-8");
   //	String data = (String)request.getSession().getAttribute("folderData");
   	List<String> pathArraydata = (List<String>)request.getSession().getAttribute("folderData");
    int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());

   	
   	//String data = request.getParameter("data");
   	//System.out.println("dir ***********"+dir);
   	//System.out.println("folder data -----> "+data);
   	
   	   	
 	if (dir == null) {
    	return;
	}
	if (dir.charAt(dir.length()-1) == '\\') {
    	dir = dir.substring(0, dir.length()-1) + "/";
	} else if (dir.charAt(dir.length()-1) != '/') 
	{
	    dir += "/";
	}
	
	List<String> pathArray = new ArrayList<String>();
	List<String> dirArray = new ArrayList<String>();
	if(dir.equalsIgnoreCase("/"))
	{
		
		dirArray=pathArraydata;
	}
	else
	{
		pathArray = folderBean.getFolderNameGridHTML(""+cid,dir);
		
		
	}
	    //Get search data in pathArray
	   /*  StringTokenizer st = new StringTokenizer(data,",");
	    while (st.hasMoreElements()) {
	    	    pathArray.add((String)st.nextElement());	    
		} */
	    
	    //Sort pathArray
	//	Collections.sort(pathArray);
       
         
	    //Display pathArray
	    for(int j=0; j<pathArray.size(); j++)
	    {
	    	String path = pathArray.get(j);
	    	//Get all children of dir from pathArray and add it to dirArray List if it does not exists
	    	String subdir = "";
	    	
	    	//System.out.println("Path " +path);
	    	//System.out.println("dir "+dir);
	    	if(path.startsWith(dir))//Path contains dir 
	    	{
	    		//System.out.println("Path "+path + " starts with dir "+dir);
	    		int beginIndex = (path.indexOf(dir, 0)+(dir.length()-1));
	    		int endIndex = path.indexOf('/', (path.indexOf(dir, 0)+(dir.length()-1))+1);
	    			    		
	    		if(endIndex > 0)
	    		{
	    			subdir = path.substring(beginIndex+1,endIndex);    		
	    			//System.out.println("Subidr "+ subdir);
	    		}
	    		
	    	}
	    	if(!subdir.equalsIgnoreCase("") && !dirArray.contains(subdir))
	    	{
	    		dirArray.add(subdir);
	    	}    	
	        
	    }    
	    //Display dirArray
	    for(int k=0; k< dirArray.size(); k++)
	    {
	    	//System.out.println("dirArray "+k+" " + dirArray.get(k));
	    }		
   
		
	
   		String[] files = new File(dir).list(new FilenameFilter() 
		{
		    public boolean accept(File dir, String name) {
				return name.charAt(0) != '.';
		    }
		});
		files = dirArray.toArray(new String[dirArray.size()]);
		Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);
		//System.out.println("File array in jqueryFolderTree");
	
		for(int k=0; k< files.length; k++)
		{
			//System.out.println("files "+files[k]);
		}
		out.print("<ul class=\"jqueryFileTree\" style=\"display: none;\">");
		// All dirs
		int i = 0;
		
		for (String file : files) {
		    String dirId = "dir_"+ i++;
		    
			out.print("<li id=\'"+dirId+"\' class=\"directory collapsed\"><a href=\"#\"  style=\"text-align:left\" oncontextmenu=\"showContextMenu(\'"+dir+file+"',event,'contextMenu',\'"+dirId+"')\"    rel=\"" 
			+ dir + file + "/\">"
					+ file + "</a></li>");
					
			//System.out.println(""+"<li class=\"directory collapsed\"><a href=\"#\"  style=\"text-align:left\" oncontextmenu=\"showContextMenu(\'"+dir+file+"',event,'contextMenu')\"   rel=\"" + dir + file + "/\">"
			//+ file + "</a></li>");
					
		}
		
		out.print("</ul>");
/* 		out.println("<script type='text/javascript'>$('#my_popup').popup('hide');</script>");
 */
%>
<script type="text/javascript">
document.onmouseup = myMouseDownHandler;

    function myMouseDownHandler() {
		document.getElementById('contextMenu').style.display = 'none'; 
    }
function showContextMenu(path,e,control,obj)
{
	e.preventDefault();
	var x = $("#"+obj).position();
	/*var posx = e.clientX +window.pageXOffset; //Left Position of Mouse Pointer
            var posy = e.clientY + window.pageYOffset; //Top Position of Mouse Pointer
            var postionx = posx - 350;
            var postiony = posy - 350;*/
 	var posx =  x.left +120 +'px'; //Left Position of element
   // var posy = x.top+ 20 + 'px'; //Top Position of li
    var posy = e.clientY + window.pageYOffset - 380; //Top Position of Mouse Pointer
  
    //alert("x: " + posx + " y: " + posy);
            
    document.getElementById(control).style.position = 'absolute';
    document.getElementById(control).style.display = 'block';
    document.getElementById(control).style.left = posx;
    document.getElementById(control).style.top = posy;
            
                       
			document.getElementById('newFolder').onclick = function() {
			//alert("You are creating under "+path);
			document.getElementById(control).style.display = 'none';
			jPrompt('Please enter folder name', 'New Folder', 'New Folder', function(folderName) {
	    	if( folderName)     			
	    		if(folderName != null)
	    		{
	    			document.getElementById("folderName").value = path+"/"+folderName+"/";	    		
	    			saveForm('add','');
	    		}
			});
			};
			
			/*var folderName = prompt("Please enter folder name", "New Folder");
			if (folderName != null) {
    			//alert("You have entered "+folderName);
    			document.getElementById("folderName").value = path+"/"+folderName+"/";
    			//alert("You have entered "+document.getElementById("folderName").value);
    			
    			saveForm('add','');
			}
			};*/
			document.getElementById('editFolder').onclick = function() {
			//alert("You are editing folder "+path+"/");
			document.getElementById(control).style.display = 'none';
			
			jPrompt('Please enter folder name', 'New Folder', 'New Folder', function(folderName) {
	    	if( folderName)     			
	    		var newPath = path.substring(0,path.lastIndexOf('/'));
       			if(folderName != null)
       			{
       				document.getElementById("folderName").value = newPath+"/"+folderName+"/";       				
       			   // jAlert("You have entered "+document.getElementById("folderName").value+ " as new name");       			
       			    saveForm('edit',path+"/");
       			}
			});
			};
			
			/*var folderName = prompt("Please enter folder name", "New Folder");
			if (folderName != null) {
			    var newPath = path.substring(0,path.lastIndexOf('/'));
    			document.getElementById("folderName").value = newPath+"/"+folderName+"/";
       			alert("You have entered "+document.getElementById("folderName").value+ " as new name");
       			
    			saveForm('edit',path+"/");
			}						
			};*/
			
			
			document.getElementById('deleteFolder').onclick = function() {
			//alert("You are deleting folder "+path+"/");
			
			/*var confirmDelete = window.confirm("Do you want to delete folder "+path+"/");
			if(confirmDelete == true)
			{
				document.getElementById("folderName").value = path+"/";			
				document.getElementById(control).style.display = 'none';
  				saveForm('delete',path+"/");
  			}						
			};*/
			jConfirm('Do you want to delete folder'+path + '?', 'Confirmation Dialog', function(confirmDelete) {
   			//jAlert('Confirmed: ' + confirmDelete, 'Confirmation Results');
   				if(confirmDelete == true)
				{
					document.getElementById("folderName").value = path+"/";			
					document.getElementById(control).style.display = 'none';
					saveForm('delete',path+"/");
				}
			});
			};
}
</script>

<body>
<div style="display:none; "   id="contextMenu">
        <table id="contextMenu"  border="0" cellpadding="0" cellspacing="0" 
            style="font-family: Verdana, Arial, Helvetica, sans-serif;
				font-size: 11px;
				background: #EEE;
				padding: 5px;border: thin solid #808080; cursor: default;" width="100px" 
            bgcolor="White" >
            <tr>
                <td >
                    <a id="newFolder" class="ContextItem">New Folder</a>
                </td>
            </tr>
            <tr>
                <td >
                <a  id="editFolder" class="ContextItem">Edit Folder</a>
                </td>
            </tr>
            <tr>
                <td >
                    <a id="deleteFolder" class="ContextItem">Delete Folder</a>
                </td>
            </tr>
        </table>
  </div>

</body>
