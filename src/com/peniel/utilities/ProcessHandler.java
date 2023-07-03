package com.peniel.utilities;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessHandler extends Thread {

	InputStream inpStr;
	String strType;

	public ProcessHandler(InputStream inpStr, String strType) {
		this.inpStr = inpStr;
		this.strType = strType;
	}

	public void run() {
		try {
			InputStreamReader inpStrd = new InputStreamReader(inpStr);
			BufferedReader buffRd = new BufferedReader(inpStrd);
			String line = null;
			while((line = buffRd.readLine()) != null) {
				//System.out.println(strType + " �> " + line);
			}
			buffRd.close();
			inpStrd.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
	
	
