package com.peniel.utilities;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;

public class ParseMultiForm extends java.lang.Object {

	private ServletInputStream In;

    private byte buffer[] = new byte[4096];

    private String delimitor = null;

    private String filename=null;

    private ArrayList<String> paramList = new ArrayList<String>();


    public ParseMultiForm( ServletRequest _req ) throws IOException{

      In  = _req.getInputStream();

      delimitor   = _req.getContentType();
      
      if ( delimitor.indexOf("boundary=") != -1 ){

        delimitor = delimitor.substring( delimitor.indexOf("boundary=")+9, delimitor.length() );

        delimitor = "--" + delimitor;

      }
      
      
    }



    private String readLine(StringBuffer s){

      try{

        int noData = In.readLine( buffer, 0, buffer.length );

        s.append("Bytes read = "+noData);

        if ( noData != -1 )

          return new String( buffer, 0, noData, "ISO-8859-1");

      }catch(Exception E){}

      return null;

    }

    private String readLine(){

      try{

        int noData = In.readLine( buffer, 0, buffer.length );

        if ( noData != -1 )

        {

          return new String( buffer, 0, noData, "ISO-8859-1");

        }

      }catch(Exception E){}

      return null;

    }

    void test() throws IOException{

      String LineIn;

      while( (LineIn=readLine()) != null )

        System.out.println( LineIn  );

    }



    public String getFilename(){

      return filename;

    }



    public String getParameter(){

                    String pv=readLine();

                    if (pv.length()>0)

		if (((int)pv.charAt(pv.length()-1))==13) pv=pv.substring(0,pv.length()-1);
		
		if (pv.length()>0)
		
		if (((int)pv.charAt(pv.length()-1))==10) pv=pv.substring(0,pv.length()-1);
		
		if (pv.length()>0)
		
		if (((int)pv.charAt(pv.length()-1))==13) pv=pv.substring(0,pv.length()-1);



      return pv;

    }

    public String getMessage(){

                    String reStr="";

          int noData;

          try

          {

          while ( (noData=In.readLine(buffer,0,buffer.length)) != -1 ){

            if ( buffer[0] == '-' ){

              if ( new String( buffer, 0, noData, "ISO-8859-1").indexOf(delimitor) == 0 )

                break;

            }else

              reStr+=(new String(buffer)).substring(0,noData);

          }

          } catch (Exception e)

          {

                  e.printStackTrace();

          }



      return reStr;

    }



    public String getNextParameter(StringBuffer s) {

      try{

        String LineIn=null, paramName=null;

        s.append(" Inside get");

        while ( (LineIn=readLine(s)) != null ){

                    s.append(" LineIn ");

          if ( LineIn.indexOf( "name=" ) != -1 ){

            int c1 = LineIn.indexOf( "name=" );

            int c2 = LineIn.indexOf( "\"", c1+6 );

            paramName = LineIn.substring( c1+6, c2 );



            if ( LineIn.indexOf( "filename=") != -1 ){

              c1 = LineIn.indexOf( "filename=" );

              c2 = LineIn.indexOf( "\"", c1+10 );

              filename = LineIn.substring( c1+10, c2 );

              if ( filename.lastIndexOf( "\\" ) != -1 )

                filename = filename.substring( filename.lastIndexOf( "\\" )+1 );



              if ( filename.length() == 0 )

                filename = null;

            }



            //- Move the pointer to the start of the data

            LineIn = readLine();

            if ( LineIn.indexOf( "Content-Type" ) != -1 )

              LineIn = readLine();

//        System.out.println("Last char="+(int)paramName.charAt(paramName.length()-1));

            if (paramName.length()>0)

            if (((int)paramName.charAt(paramName.length()-1))==13) paramName=paramName.substring(0,paramName.length()-1);

            if (paramName.length()>0)

            if (((int)paramName.charAt(paramName.length()-1))==10) paramName=paramName.substring(0,paramName.length()-1);

            if (paramName.length()>0)

            if (((int)paramName.charAt(paramName.length()-1))==13) paramName=paramName.substring(0,paramName.length()-1);

            if(!paramList.contains(paramName))
            {
            	paramList.add(paramName);
            }
            else 
            	paramName = null;
            
           return paramName;

          }

        }

      }

      catch( Exception E ){}

      s.append("   NULL in getnext ");

      return null;

    }



    public boolean getParameter( OutputStream _Out ){

      try{

          int noData;

          while ( (noData=In.readLine(buffer,0,buffer.length)) != -1 ){

            if ( buffer[0] == '-' ){
            	
              if ( new String( buffer, 0, noData, "ISO-8859-1").indexOf(delimitor) == 0 ){
            	  break;
              } else {
            	  _Out.write( buffer, 0, noData );
              }

            }else{
              _Out.write( buffer, 0, noData );
            }  
          }



          _Out.flush();

        return true;

      }

      catch( Exception E ){

        System.out.println( E  );

      }



      return false;

    }

  }


