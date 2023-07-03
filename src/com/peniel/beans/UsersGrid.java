package com.peniel.beans;



import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jmesa.facade.TableFacade;
import org.jmesa.facade.TableFacadeFactory;
import org.jmesa.limit.Limit;
import org.jmesa.model.AllItems;
import org.jmesa.model.TableModel;
import org.jmesa.view.editor.CellEditor;
import org.jmesa.view.html.HtmlBuilder;
import org.jmesa.view.html.component.HtmlColumn;
import org.jmesa.view.html.component.HtmlRow;
import org.jmesa.view.html.component.HtmlTable;
import org.jmesalive.table.WorksheetProperty;

import com.peniel.bus.vo.AppUser;
import com.peniel.dao.AppUserDAO;




public class UsersGrid
{
	
	public static String getUserGrid(final Vector appUserList, HttpServletRequest request, HttpServletResponse response)
	{
		String html = "";
		String id = "formId";
		try 
		{
			TableModel tableModel = new TableModel(id, request, response);
			/*tableModel.setItems(new AllItems() {
	            public Collection<?> getItems() {
	            	return appUserList;
	            }
	        });
			*/
			
			tableModel.setItems(appUserList);
			tableModel.setTable(getRenderedHTML(tableModel, request.getParameter("sessionid")));
				
			html = tableModel.render();
						
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		
		return html;
	}
	
	
public static HtmlTable getRenderedHTML(TableModel tableModel, String sessionId){
		
		HtmlTable table = new HtmlTable();
		table.setCaption("Your Search Results");
		

		HtmlRow row = new HtmlRow().uniqueProperty("id");
		table.setRow(row);
		
		
		HtmlColumn edit = new HtmlColumn("edit");
		edit.setCellEditor(new  CellEditor(){

        	public Object getValue(Object arg0, String arg1, int arg2) {
        		
        		AppUser appUser = (AppUser) arg0;
        		HtmlBuilder htmlB = new HtmlBuilder();
                //String filePath = "javascript:getpdf("+"'/"+searchDataObj1.getFileName()+"/');";
        		String filePath = "javascript:editUserProfile('"+ appUser.getUserId()+"','"+appUser.getUserRoleId()+"')";
        		htmlB.a().href().quote().append(filePath).quote().close();
                htmlB.append("<i style=\"cursor: pointer;\" class=\"zmdi zmdi-edit\"></i>");
                htmlB.aEnd();
                return htmlB.toString();
         }});
		edit.setTitle("<font color=white>Edit User</font>");
		edit.setEditable(false);
		edit.setSortable(false);
		edit.setFilterable(false);
		
		row.addColumn(edit);
		
		
		HtmlColumn userName = new HtmlColumn("username");
		userName.setCellEditor(new  CellEditor(){

        	public Object getValue(Object arg0, String arg1, int arg2) {
        		
        		AppUser appUser = (AppUser) arg0;
        		
                return appUser.getUsername();
         }});
		userName.setTitle("<font color=white>User Name</font>");
		userName.setEditable(false);
		userName.setSortable(true);
		userName.setFilterable(false);
		
		row.addColumn(userName);
		
		HtmlColumn lastName = new HtmlColumn("lastName");
		
		lastName.setCellEditor(new  CellEditor(){

        	public Object getValue(Object arg0, String arg1, int arg2) {
        		
        		AppUser appUser = (AppUser) arg0;
        		HtmlBuilder htmlB = new HtmlBuilder();
                //String filePath = "javascript:getpdf("+"'/"+searchDataObj1.getFileName()+"/');";
        		//String filePath = "javascript:showUserProfile('"+ appUser.getUserId()+"');";
        		//htmlB.a().href().quote().append(filePath).quote().close();
                htmlB.append(appUser.getLastName());
                htmlB.aEnd();
                return htmlB.toString();
         }});
		//lastName.setTitle("<a href=javascript:sortby(\'last_name\')><font color=white>Last Name</font></a>");
		lastName.setTitle("<font color=white>Last Name</font>");
		lastName.setEditable(false);
		lastName.setSortable(true);
		lastName.setFilterable(false);

		row.addColumn(lastName);
		
		HtmlColumn firstName = new HtmlColumn("firstName");
		
		firstName.setCellEditor(new  CellEditor(){

        	public Object getValue(Object arg0, String arg1, int arg2) {
        		
        		AppUser appUser = (AppUser) arg0;
        		return appUser.getFirstName();
         }});
		
		//firstName.setTitle("<a href=javascript:sortby(\'first_name\')><font color=white>First Name</font></a>");
		
		firstName.setTitle("<font color=white>First Name</font>");
		firstName.setEditable(false);
		firstName.setSortable(true);
		firstName.setFilterable(false);
		
		row.addColumn(firstName);
		
		
		/*
		 * HtmlColumn email = new HtmlColumn("email"); email.setCellEditor(new
		 * CellEditor(){
		 * 
		 * public Object getValue(Object arg0, String arg1, int arg2) {
		 * 
		 * AppUser appUser = (AppUser) arg0; return appUser.getEmail(); }});
		 * email.setTitle("<font color=white>Email</font>"); //email.
		 * setTitle("<a href=javascript:sortby(\'email\')><font color=white>Email</font></a>"
		 * ); email.setEditable(false); email.setSortable(true);
		 * email.setFilterable(false);
		 * 
		 * row.addColumn(email);
		 * 
		 * HtmlColumn phone = new HtmlColumn("phone"); phone.setCellEditor(new
		 * CellEditor(){
		 * 
		 * public Object getValue(Object arg0, String arg1, int arg2) {
		 * 
		 * AppUser appUser = (AppUser) arg0; return appUser.getPhoneNo(); }});
		 * phone.setTitle("<font color=white>Phone</font>"); //phone.
		 * setTitle("<a href=javascript:sortby(\'phone_no\')><font color=white>Phone</font></a>"
		 * ); //phone.setSortable(true); phone.setEditable(false);
		 * phone.setSortable(false); phone.setFilterable(false);
		 * 
		 * row.addColumn(phone);
		 * 
		 */		HtmlColumn userRole = new HtmlColumn("role");
		userRole.setCellEditor(new  CellEditor(){

        	public Object getValue(Object arg0, String arg1, int arg2) {
        		
        		AppUser appUser = (AppUser) arg0;
        		
        		//AppUserRoles appUserRoles = new AppUserRoles();
        		//AppUserRolesDAO appUserRolesDao = new AppUserRolesDAO();
        		//Vector appUserRoleList = new Vector();
        		
        		//appUserRoleList = appUserRolesDao.findByUserId(Long.toString(appUser.getUserId()));
        		//appUserRoles = (AppUserRoles) appUserRoleList.get(0);
        		
        		return appUser.getRole(); //appUserRoles.getRoleId();
         }});

		///userRole.setTitle("<a href=javascript:sortby(\'role_name\')><font color=white>User Role</font></a>");
		userRole.setTitle("User Role");
		userRole.setEditable(false);
		userRole.setSortable(true);
		userRole.setFilterable(false);
		
		row.addColumn(userRole);
		
		/*
		 * HtmlColumn status = new HtmlColumn("status"); status.setCellEditor(new
		 * CellEditor(){
		 * 
		 * public Object getValue(Object arg0, String arg1, int arg2) {
		 * 
		 * AppUser appUser = (AppUser) arg0; return appUser.getStatus(); }}); ///status.
		 * setTitle("<a href=javascript:sortby(\'status\')><font color=white>Status</font></a>"
		 * ); status.setTitle("Status"); status.setEditable(false);
		 * status.setSortable(true); status.setFilterable(false);
		 * 
		 * row.addColumn(status);
		 */
		
		return table;
	}
	
public static String getUserEmailsHTML(HashMap emailList)
{
	
	StringBuffer htmlGrid = new StringBuffer();
	
	Set set = emailList.entrySet();
	String strEmailList = "";
	// Get an iterator
	Iterator it = set.iterator();
	// Display elements
	while(it.hasNext()) 
	{
		Map.Entry me = (Map.Entry)it.next();			
		strEmailList = ""+ me.getValue();
	} 	
	
	if(strEmailList.length() > 0)
	{
		//Parse the string
		String[] strEmail;			
		
		strEmail = splitString(strEmailList,";");
		System.out.println("strEmail "+strEmail.length);
		for(int i=0; i<strEmail.length; i++)
		{
			htmlGrid.append("\n <tr style=\"font-size:11px;font-family: Verdana;\">")
			
		    .append("\n <td>")
			.append("\n <input type=\"checkbox\" id='checkbox"+(i+1)+"' ")
			.append("\n </td>")
				        
			.append("\n <td id='email"+(i+1)+"'>"+strEmail[i]+"</td>")
			
			.append("\n </tr>");	
		}
	}		
	
return htmlGrid.toString();
}

public static String[] splitString(String list,String delimiter) 
{
	String[] temp;		 
	temp = list.split(delimiter);
	return temp;
}

public static String getUserGridLinks()
{
	return AppUserDAO.findByAllLinks();
}

}


