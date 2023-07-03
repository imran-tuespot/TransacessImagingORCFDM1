

package com.peniel.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import com.peniel.bus.vo.AppRoles;
import com.peniel.bus.vo.States;
import com.peniel.dao.AppRolesDAO;
import com.peniel.dao.StatesDAO;


public class FormInformation
{
	
	public static String getAppRolesInformation(long appRolesId)
	{
		System.out.println("appRolesId "+appRolesId);
		Vector appRolesList = new Vector();
		AppRoles appRoles = new AppRoles();
		
		AppRolesDAO appRolesDao = new AppRolesDAO();
		
		String appRolesOptions = "";
		
		
		
		appRolesList = appRolesDao.findAll();
		
		//get the roles and place them in the option tag
		for(int y = 0; y < appRolesList.size(); y++)
		{
			appRoles = (AppRoles) appRolesList.get(y);
			
				
				if(appRolesId == appRoles.getRoleId())
				{
					appRolesOptions = appRolesOptions + "<option value=\"" + appRoles.getRoleId() + "\" SELECTED>" + appRoles.getRoleName() + "</option>";
				}
				else
				{
					appRolesOptions = appRolesOptions + "<option value=\"" + appRoles.getRoleId() + "\">" + appRoles.getRoleName() + "</option>";
				}
								
            
		}
        System.out.println("appRolesOptions-------->"+appRolesOptions);
		return appRolesOptions;
	}
	
	public static String getAppRolesInformationSelect(int appUserRole,long companyId)
	{
		System.out.println("appUserRole "+appUserRole);
		Vector appRolesList = new Vector();
		AppRoles appRoles = new AppRoles();
		
		AppRolesDAO appRolesDao = new AppRolesDAO();
		
		String appRolesOptions = "";		
		
		appRolesList = appRolesDao.findAll(Long.toString(companyId));
		for(int j=0;j<appRolesList.size();j++){
			appRoles = (AppRoles) appRolesList.get(j);
			if(appRoles.getRoleId()== appUserRole)
			{
				appRolesOptions = appRolesOptions + "<option value=\"" + appRoles.getRoleId() + "\" SELECTED>" + appRoles.getRoleName() + "</option>";
			}
			else
			{
				appRolesOptions = appRolesOptions + "<option value=\"" + appRoles.getRoleId() + "\">" + appRoles.getRoleName() + "</option>";
			}
			}
		
		//get the roles and place them in the option tag
		
		return appRolesOptions;
	}
	
	/*public static String getAppRolesInformationSelect(int appUserRole,long companyId)
	{
		System.out.println("appUserRole "+appUserRole);
		//Vector appRolesList = new Vector();
		AppRoles appRoles = new AppRoles();
		List<AppRoles> appRolesList = null;  
		
		AppRolesDAO appRolesDao = new AppRolesDAO();
		
		String appRolesOptions = "";		
		
		appRolesList = appRolesDao.findAllDemo(Long.toString(companyId));
		for(int j=0;j<appRolesList.size();j++){
			appRoles = (AppRoles) appRolesList.get(j);
			if(appRoles.getRoleId()== appUserRole)
			{
				appRolesOptions = appRolesOptions + "<option value=\"" + appRoles.getRoleId() + "\" SELECTED>" + appRoles.getRoleName() + "</option>";
			}
			else
			{
				appRolesOptions = appRolesOptions + "<option value=\"" + appRoles.getRoleId() + "\">" + appRoles.getRoleName() + "</option>";
			}
			}
		
		//get the roles and place them in the option tag
		
		return appRolesOptions;
	}*/
	
	
	public static String getStatesInformation(String stateCode)
	{
		Vector statesList = new Vector();
		States states = new States();
		StatesDAO statesDao = new StatesDAO();
		
		String statesOptions = "<option value=\""  + "\" selected>" + "</option>";
		
		statesList = statesDao.findAll();
		
		//get the states and place them in the option tag
		for(int y = 0; y < statesList.size(); y++)
		{
			states = (States) statesList.get(y);
			
			if(stateCode != null && stateCode.equals(states.getState()))
			{
				statesOptions = statesOptions + "<option value=\"" + states.getState() + "\" selected>" + states.getName() + "</option>";
			}
			statesOptions = statesOptions + "<option value=\"" + states.getState() + "\">" + states.getName() + "</option>";
            
		}
		
		
		return statesOptions;
	}
	
	
	public static HashMap getFormInformation(long userTypeId, String stateCode)
	{
		HashMap hashMap = new HashMap();
		//get the user roles
		String userRoles = getAppRolesInformation(userTypeId);
		
		//get the list of states
		String states = getStatesInformation(stateCode);
		
		
		
		//put the form information in a hashmap to get on the jsp
		hashMap.put("userRoles", userRoles);
		hashMap.put("states", states);
		
		return hashMap;
	}
	
	public static HashMap getFormInformation(String appUserRole, String stateCode)
	{
		HashMap hashMap = new HashMap();
		//get the user roles
		String userRoles = getAppRolesInformation(appUserRole);
		
		//get the list of states
		String states = getStatesInformation(stateCode);
		
		
		
		//put the form information in a hashmap to get on the jsp
		hashMap.put("userRoles", userRoles);
		hashMap.put("states", states);
		
		return hashMap;
	}
	
	public static HashMap getFormInformation(String appUserRole, String stateCode,String companyId)
	{
		HashMap hashMap = new HashMap();
		//get the user roles
		//String userRoles = getAppRolesInformation(appUserRole,companyId);

		String userRoles = getAppRolesDefaultInformation(appUserRole,companyId);
		//get the list of states
		String states = getStatesInformation(stateCode);
		
		
		
		//put the form information in a hashmap to get on the jsp
		hashMap.put("userRoles", userRoles);
		hashMap.put("states", states);
		
		return hashMap;
	}
	
	public static String getAppRolesInformation(String appUserRole)
	{
		System.out.println("appUserRole "+appUserRole);
		Vector appRolesList = new Vector();
		AppRoles appRoles = new AppRoles();
		
		AppRolesDAO appRolesDao = new AppRolesDAO();
		
		String appRolesOptions = "";		
		
		appRolesList = appRolesDao.findAll();
		
		//get the roles and place them in the option tag
		for(int y = 0; y < appRolesList.size(); y++)
		{
			appRoles = (AppRoles) appRolesList.get(y);
			if(appUserRole.compareTo("ADMIN") == 0) //ADMIN
			{
				
				if(appUserRole.compareTo("ADMIN") == 0)
				{
					appRolesOptions = appRolesOptions + "<option value=\"" + appRoles.getRoleId() + "\" SELECTED>" + appRoles.getRoleName() + "</option>";
				}
				else
				{
					appRolesOptions = appRolesOptions + "<option value=\"" + appRoles.getRoleId() + "\">" + appRoles.getRoleName() + "</option>";
				}
			}
			else  if(appUserRole.compareTo("POWERUSER") == 0)//POWERUSER
			{
				
				if(appRoles.getRoleName().compareTo("ADMIN")!= 0)
				{
					if(appUserRole.compareTo("POWERUSER") == 0)
					{
						appRolesOptions = appRolesOptions + "<option value=\"" + appRoles.getRoleId() + "\" SELECTED>" + appRoles.getRoleName() + "</option>";
					}
					else
					{
						appRolesOptions = appRolesOptions + "<option value=\"" + appRoles.getRoleId() + "\">" + appRoles.getRoleName() + "</option>";
					}
				}
				
			}
			
            
		}
        System.out.println("appRolesOptions-------->"+appRolesOptions);
		return appRolesOptions;
	}

	
	public static String getAppRolesInformation(String appUserRole, String companyId)
	{
		System.out.println("appUserRole "+appUserRole);
		Vector appRolesList = new Vector();
		AppRoles appRoles = new AppRoles();
		
		AppRolesDAO appRolesDao = new AppRolesDAO();
		
		String appRolesOptions = "";		
		
		appRolesList = appRolesDao.findAll(companyId);
		
		//get the roles and place them in the option tag
		for(int y = 0; y < appRolesList.size(); y++)
		{
			appRoles = (AppRoles) appRolesList.get(y);
			if(appUserRole.compareTo("ADMIN") == 0) //ADMIN
			{
				
				if(appUserRole.compareTo("ADMIN") == 0)
				{
					appRolesOptions = appRolesOptions + "<option value=\"" + appRoles.getRoleId() + "\" SELECTED>" + appRoles.getRoleName() + "</option>";
				}
				else
				{
					appRolesOptions = appRolesOptions + "<option value=\"" + appRoles.getRoleId() + "\">" + appRoles.getRoleName() + "</option>";
				}
			}
			else  if(appUserRole.compareTo("POWERUSER") == 0)//POWERUSER
			{
				
				if(appRoles.getRoleName().compareTo("ADMIN")!= 0)
				{
					if(appUserRole.compareTo("POWERUSER") == 0)
					{
						appRolesOptions = appRolesOptions + "<option value=\"" + appRoles.getRoleId() + "\" SELECTED>" + appRoles.getRoleName() + "</option>";
					}
					else
					{
						appRolesOptions = appRolesOptions + "<option value=\"" + appRoles.getRoleId() + "\">" + appRoles.getRoleName() + "</option>";
					}
				}
				
			}
			
            
		}
        System.out.println("appRolesOptions-------->"+appRolesOptions);
		return appRolesOptions;
	}
	
	public static String getAppRolesDefaultInformation(String appUserRole, String companyId)
	{
		System.out.println("appUserRole "+appUserRole);
		Vector appRolesList = new Vector();
		AppRoles appRoles = new AppRoles();
		
		AppRolesDAO appRolesDao = new AppRolesDAO();
		
		String appRolesOptions = "";		
		
		appRolesList = appRolesDao.findAll(companyId);
		
		//get the roles and place them in the option tag
		for(int y = 0; y < appRolesList.size(); y++)
		{
			appRoles = (AppRoles) appRolesList.get(y);
			if(appUserRole.compareTo("ADMIN") == 0) //ADMIN
			{
				
				if(appUserRole.compareTo("ADMIN") == 0)
				{
					if(appRoles.getRoleName().equalsIgnoreCase("User"))
						appRolesOptions = appRolesOptions + "<option value=\"" + appRoles.getRoleId() + "\" SELECTED>" + appRoles.getRoleName() + "</option>";
					else
						appRolesOptions = appRolesOptions + "<option value=\"" + appRoles.getRoleId() + "\">" + appRoles.getRoleName() + "</option>";
					
				}
				
				
			}
			else  
			{
				
				if(appRoles.getRoleName().compareTo("ADMIN")!= 0)
				{
					if(appUserRole.compareTo("POWERUSER") == 0)
					{
						appRolesOptions = appRolesOptions + "<option value=\"" + appRoles.getRoleId() + "\" SELECTED>" + appRoles.getRoleName() + "</option>";
					}
					else
					{
						appRolesOptions = appRolesOptions + "<option value=\"" + appRoles.getRoleId() + "\">" + appRoles.getRoleName() + "</option>";
					}
				}
				else
				{
					if(appRoles.getRoleName().equalsIgnoreCase("User"))
						appRolesOptions = appRolesOptions + "<option value=\"" + appRoles.getRoleId() + "\" SELECTED>" + appRoles.getRoleName() + "</option>";
					else
						appRolesOptions = appRolesOptions + "<option value=\"" + appRoles.getRoleId() + "\">" + appRoles.getRoleName() + "</option>";
				
				}
			}
			
            
		}
        System.out.println("appRolesOptions-------->"+appRolesOptions);
		return appRolesOptions;
	}


		
}
