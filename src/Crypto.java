

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peniel.utilities.GeneratePassword;

/**
 * Servlet implementation class Crypto
 */
@WebServlet("/Crypto")
public class Crypto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Crypto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String keyPhrase = (String)request.getParameter("keyPhrase");
		System.out.println("keyPhrase :============== " + keyPhrase);
		String btn = (String)request.getParameter("btn");
		System.out.println("Button :============== " + btn);
		String pwd = (String)request.getParameter("password");
		//System.out.println("Login Img Original User Pass Phrase:============== " + pwd);
		String responseText = "";
		GeneratePassword generatePassphrase;
		javax.naming.Context ctx;
		try {
			ctx = new javax.naming.InitialContext();
		
	        String appProperty = (String) ctx.lookup("java:comp/env/appProperty");
		
			generatePassphrase = new GeneratePassword(appProperty);
			//Validate key
			if(generatePassphrase.validateKey(keyPhrase))
			{
				if(btn.equalsIgnoreCase("Encrypt")){
					responseText = generatePassphrase.encrypt(pwd);
					//System.out.println("Login Img Encrypted User Pass Phrase:==================== " + pwd);
 
					responseText = generatePassphrase.decrypt(pwd);
					//System.out.println("Login Img Decrypted User Pass Phrase:==================== " + pwd);
				}
			}
			else{
				responseText = "Error";
			}
			
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			responseText = "Error";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			responseText = "Error";
		}

		response.setContentType("text/plain");
		System.out.println("Sending Response "+responseText);
		(response.getWriter()).write(responseText);
    	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
