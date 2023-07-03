package com.peniel.dao;

import java.sql.ResultSet;
import java.util.Vector;

import com.peniel.common.DAOHelper;
import com.peniel.common.dbobject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.peniel.bus.vo.Company;


public class CompanyDAO extends DAOHelper<Company> {
    private static Logger logger = LogManager.getLogger(CompanyDAO.class);
    public static final String appUserSeq = null;

    public CompanyDAO() {
        super("CompanyDAO", Company.getCompanySQLHelper());
    }

    @Override
    public String getDocumentDataSeq() {
        return null;
    }

    @Override
    public Company processDbLineToObject(dbobject.dbrow row) {
        return null;
    }

    public Vector<Company> findByProperty(String propertyName, String value) {
        ResultSet resultSet = null;
        Vector<Company> companyList = new Vector<Company>();


        try {
            String sqlStatement = "select /*+ result_cache */ company_id, company_name, address1, address2, city, state, zip, default_Index ,company_fullname from company where " + propertyName + " = '" + value + "'";

            logger.info("query Company: " + sqlStatement);

            companyList = processSelectMulti(sqlStatement);
        } catch (Exception e) {
            logger.info("Error :" + e.getMessage());
        }

        return companyList;
    }

    public Vector<Company> findByCompanyName(String companyName) {
        return findByProperty("COMPANY_NAME", companyName);
    }

    public Vector<Company> findById(String id) {
        return findByProperty("COMPANY_ID", id);
    }

    public String updateCompanyById(String companyId, String address1,
    								String address2, String city, String state, String zip,
    								String indexType) {
    	String success = "";
        try {
           
            StringBuffer sqlStatement = new StringBuffer();
            sqlStatement.append("update company set  ");


           // sqlStatement.append("company_name = '" + companyName + "', ");
            sqlStatement.append("address1 = '" + address1 + "', ");
            sqlStatement.append("address2 = '" + address2 + "', ");
            sqlStatement.append("city = '" + city + "', ");
            sqlStatement.append("state = '" + state + "', ");
            sqlStatement.append("zip = '" + zip + "', ");
            sqlStatement.append("default_index = '" + indexType + "' ");
            

            sqlStatement.append(" where company_id = " + companyId);

            logger.info("query1 : " + sqlStatement);

            executeUpdate(sqlStatement.toString());
            success = "Profile is successfully updated.";
            
        } catch (Exception e) {
        	success = "Error occured while updating the profile";
            e.printStackTrace();
        }
        return success;
    }

//	public static Company findById(Long companyId)
//	{
//		ResultSet resultSet = null;
//		 Vector companyList = new Vector();
//		 Company company = null;
//		 
//		 
//		try 
//		{
//			String sqlStatement="select company_id, company_name, address1, address2, city, state, zip  from company where company_id = " + companyId;
//			//System.out.println(sqlStatement);
//
//			companyList = getCompanyList(DatabaseConnection.getResultSet(sqlStatement));
//			
//			company = (Company)companyList.get(0);
//			
//			
//		} 
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//		
//		return company;
//	}


//    public Vector<Company> getCompanyList(Vector hashMapList) {
//        Vector<Company> companyList = null;
//        Company company;
//
//        companyList = new Vector<Company>();
//        try {
//            for (int y = 0; y < hashMapList.size(); y++) {
//                HashMap hashMap = new HashMap();
//                hashMap = (HashMap) hashMapList.get(y);
//
//                company = new Company();
//                company.setCompanyId(Long.parseLong((String) hashMap.get("COMPANY_ID")));
//                company.setCompanyName((String) hashMap.get("COMPANY_NAME"));
//                company.setAddress1((String) hashMap.get("ADDRESS1"));
//                company.setAddress2((String) hashMap.get("ADDRESS2"));
//                company.setCity((String) hashMap.get("CITY"));
//                company.setState((String) hashMap.get("STATE"));
//                company.setZip((String) hashMap.get("ZIP"));
//
//                companyList.add(company);
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            logger.info("Error :" + e.getMessage());
//        }
//
//
//        return companyList;
//    }

}












