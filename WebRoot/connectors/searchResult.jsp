<!-- connector file for search page/ Advanced search -->

<%@ page
	import="java.io.File,java.io.FilenameFilter,java.util.Arrays,java.util.Map,java.util.HashMap,java.util.List,java.util.ArrayList,java.util.StringTokenizer,
	java.util.Collections,java.util.Comparator,java.util.*" %>
<%
    String dir = request.getParameter("dir");
   	dir = java.net.URLDecoder.decode(dir, "UTF-8");
   	//String data = request.getParameter("data");
   	String data = (String)request.getSession().getAttribute("data");   	
    System.out.println("Inside jqueryFileTree1.jsp data -->"+data);
    System.out.println("dir in searchResult.jsp-->"+dir);
    
    String appuserrole = (String)request.getSession().getAttribute("appuserrole");
    System.out.println("appuserrole "+appuserrole);
    
    Set<String> rights = (Set<String>)request.getSession().getAttribute("rightNames");
    System.out.println("rights "+rights.size()+rights);
    
    /* Set<String> accessType = (Set<String>)request.getSession().getAttribute("accessPatterenDetails");
    System.out.println("accessType "+accessType.size()+accessType); */
    
    
    
    String foldername = (String)request.getSession().getAttribute("foldernameData");
    
    System.out.println("foldername "+foldername);
    
   
    dir = "/";
    
 	if (dir == null) {
    	return;
	}
	if (dir.charAt(dir.length()-1) == '\\') {
    	dir = dir.substring(0, dir.length()-1) + "/";
	} else if (dir.charAt(dir.length()-1) != '/') 
	{
	    dir += "/";
	}
	
	dir = java.net.URLDecoder.decode(dir, "UTF-8");
	
	 System.out.println("dir -->"+dir);
	
	List<String> pathArray = new ArrayList<String>();
	List<String> dirArray = new ArrayList<String>();
	
	
	
	    
	    //Get search data in pathArray
	    StringTokenizer st = new StringTokenizer(data,",");
	    while (st.hasMoreElements()) {
	    		
	    		String nextElement = (String)st.nextElement();
	    		//System.out.println("nextElement -->"+nextElement);
	    		
	    	    pathArray.add(nextElement);	    
		}
	    
	    //Sort pathArray
		Collections.sort(pathArray);       
         
         System.out.println("pathArray.size() -->"+pathArray.size());
         
	    //Display pathArray
	    for(int j=0; j<pathArray.size(); j++)
	    {
	    	String path = pathArray.get(j);
	    	//Get all children of dir from pathArray and add it to fileArray List if it does not exists
	    	String subdir = "";
	    	
	    	System.out.println("Path " +path);
	    	System.out.println("dir "+dir);
	    	if(path.contains(dir))//If Path contains dir 
	    	{
	    		
	    		int bIn1 = path.indexOf(dir, 0);
	    		int bIn2 = (dir.length()-1);
	    		
	    		System.out.println("bIn1-->"+bIn1+"<-- bIn2 -->"+bIn2+"<--");
	    		
	    		int eIn1 = path.indexOf(dir, 0);
	    		int eIn2 = (dir.length()-1)+1;
	    		
	    		System.out.println("eIn1-->"+eIn1+"<-- eIn2 -->"+eIn2+"<--");
	    		
	    		int beginIndex = (path.indexOf(dir, 0)+(dir.length()-1));
	    		int endIndex = path.indexOf('/', (path.indexOf(dir, 0)+(dir.length()-1))+1);
	    		
	    		System.out.println("Begin index "+beginIndex);
	    		System.out.println("End index "+ endIndex);
	    		if(endIndex > 0)
	    		{
	    			subdir = path.substring(beginIndex+1,endIndex);    
	    			if(subdir.contains("."))
	    			{
	    				System.out.println("** 1 **");
	    				subdir = path.substring(beginIndex+1,path.length());
	    				dir = "/";
	    				System.out.println("** 2 **");
	    			}	
	    			else{
	    				System.out.println("** 3 **");
	    				dir = "/"+subdir+"/";
	    				j = j-1;
	    			}	
	    			System.out.println("Subdir "+ subdir);
	    		}
	    		
	    	}
	    	if(!subdir.equalsIgnoreCase("") && !dirArray.contains(subdir) && subdir.contains("."))
	    	{
	    		//int count = StringUtils.countMatches(subdir, ".");
	    		//if(count == 1)
	    		   		dirArray.add(subdir);
	    	}
	    	
	        
	    }
       
    	//Display dirArray
	    /*for(int k=0; k< dirArray.size(); k++)
	    {
	    	System.out.println("dirArray "+k+" " + dirArray.get(k));
	    }	*/		
   
	
		
   		String[] files = new File(dir).list(new FilenameFilter() 
		{
		    public boolean accept(File dir, String name) {
				return name.charAt(0) != '.';
		    }
		});
		files = dirArray.toArray(new String[dirArray.size()]);
		Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);
		/*System.out.println("File array in searchResults");
		
		for(int i=0; i< files.length; i++)
		{
			System.out.println("files "+files[i]);
		}*/
		if(files.length > 0)
		{
			out.print("<ul class=\"jqueryFileTree\" style=\"display: none;\">");
			// All Files
			int i = 0;
			for (String file : files) {
				String fileId = "doc"+ i++;
				System.out.println("file-->"+file);
			    String[] f = file.split("#");
			    file = f[0].toString().substring(0,f[0].toString().length()-1);	    
			    file = f[0].toString();
			    String filePath = f[1].toString();
			    String docType = f[2].toString();
			    String folderName = f[3].toString();
			    String version = f[4].toString();
			    
			    System.out.println("file= "+file + " filePath= "+filePath + " docType= "+docType + " folderName= "+folderName +" version ="+version);
			    int intVersion = 0;
			    if(version != null) intVersion = Integer.parseInt(version);
			    
			    if(intVersion >= 0) {
			    	version = "Active";
			    } else {
			    	version = "Inactive";
			    }	
			    
			    int dotIndex = f[0].lastIndexOf('.');
					String ext = dotIndex > 0 ? file.substring(dotIndex + 1) : "";
					
					System.out.println("fileId -->"+fileId+"<-- ext -->"+ext+"<-- filePath -->"+filePath+"<-- dir -->"+dir+"<-- file -->"+file+"<--");
					
					//dir = "/";
					
					out.print("<li id=\'"+fileId+"\' class=\"file ext_" + ext + "\"><div > <a href=\"#\" oncontextmenu=\"funct(\'"+filePath+"',event,'fileMenu',\'"+fileId+"')\"  onclick=\"javascript:getDocumentData(\'"+filePath+"')\" style=\"text-align: left; display: inline;overflow: hidden;text-overflow: ellipsis;float: left;width:60%\"  rel=\"" + dir + file + "\">"
					+ file + "</a><a style=\"text-align: left;overflow: hidden;text-overflow: ellipsis;\">Doc Type: "+docType+" </a></div><div><p style=\"text-align: left;width:60%;float:left;padding:0px;line-height:10px\">"+folderName+"</p><a style=\"text-align: left;overflow: hidden;text-overflow: ellipsis;\">Status: "+version+"</a></div></li>");
			}
				out.print("</ul>");
		}
		/*else{
			out.print("<div><h6 style=\"font-family:roboto;\"> This folder is empty.</h6></div>");
		}*/
			
    
%>
<script type="text/javascript">
document.onmouseup = myMouseDownHandler;

 function myMouseDownHandler() {
	document.getElementById('fileMenu').style.display = 'none'; 
 }
function funct(path,e,control,obj)
{
<%-- 	var list="";
	
 list='<%=accessType%>';
		
alert("oiuoiuoi"+list); 
alert("user"+'<%=appuserrole%>');
if (list.indexOf("ReadWrite") >= 0  ) { --%>

	e.preventDefault();
	//alert("obj "+$("#"+obj));
	 var x = $("#"+obj).position();
	//var posx = e.clientX +window.pageXOffset +'px'; //Left Position of Mouse Pointer
    //var posy = e.clientY + window.pageYOffset + 'px'; //Top Position of Mouse Pointer
   // alert("Inside funct " +e.clientX + " " +e.clientY);
   
   var posx =  x.left +20 +'px'; //Left Position of element
   var posy = x.top+ 20 + 'px'; //Top Position of li
   //alert("x: " + posx + " y: " + posy);
   
   document.getElementById(control).style.position = 'absolute';
   document.getElementById(control).style.display = 'inline';
   document.getElementById(control).style.left = posx;
   document.getElementById(control).style.top = posy; 
   
   document.getElementById('openDetails').onclick = function() {
		editDoc(path,'','');		
			
	};
			
/* }

else
	{
	$('#openDetails').hide();
	alert("ReadOnly");
	
	} */
  
}
</script>

<body>
<div style="display:none; "   id="fileMenu">
        <table   border="0" cellpadding="0" cellspacing="0" 
            style="font-family: Verdana, Arial, Helvetica, sans-serif;
				font-size: 11px;
				background: #EEE;
				padding: 5px;border: thin solid #808080; cursor: default;" width="140px" 
            bgcolor="White" >
           
            <tr>
                <td >
                    <a id="openDetails" style="padding:0px;" class="ContextItem">File Properties</a>
                </td>
            </tr>
        </table>
  </div>

</body>
