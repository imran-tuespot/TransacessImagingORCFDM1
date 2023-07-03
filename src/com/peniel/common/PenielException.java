/*******************************************************************************
* FILE: PenielException.java
*
* SYNOPSIS: PenielException is a common component used to catch exceptions thrown
*           by components of TA. This class extends java.lang.Exception.
*
* AUTHOR: Nitin Singh
*
* CHANGE HISTORY:
* Programmer          Date            Change Description
* ------------------------------------------------------------------------------
* Nitin Singh      01/25/2010      Original Version
*
*
*/

package com.peniel.common;

/**
* The PenielException class extends java.lang.Exception.
* It is used to catch exceptions thrown by processes of TA.
*/
public class PenielException extends Exception
{
	private static byte [] id_ =
    (new String("@(#) [viewpath]/[item];[version];[state];[author];[crtime]"))
	.getBytes();

    /***************************************************************************
    * Method: PenielException
    * Synopsis: Constructor
    * @parms: void
    * @return: N/A
    * @exceptions: none.
    ***************************************************************************/
    public PenielException()
    {
        stack_ = fillInStackTrace();
    }

    /***************************************************************************
    * Method: PenielException
    * Synopsis: Constructor - overloaded version to convert standard java
    *           exception.
    * @parms: java.lang.Exception
    * @return: N/A
    * @exceptions: none.
    ***************************************************************************/
    public PenielException(Exception exception)
    {
        stack_ = exception.fillInStackTrace();
        exception_ = exception;
        String message = exception_.toString();
        appendMessage(message);
    }

    /***************************************************************************
    * Method: PenielException
    * Synopsis: Constructor - overloaded version to except 3 strings of info.
    * @parms: String exceptionComponent - The componant that threw the
    *             exception.
    *         String codeLocation - Specifying the class and method where the
    *             exception was encountered.
    *         String exceptionMessage - A customized message passed by the 
    *             calling routine.
    * @return: N/A
    * @exceptions: none.
    ***************************************************************************/
    public PenielException(String exceptionComponent, String codeLocation,
        String exceptionMessage)
    {
        stack_ = fillInStackTrace();
        exceptionComponent_ = exceptionComponent;
        codeLocation_ = codeLocation;
        exceptionMessage_ = exceptionMessage;
    }

    /***************************************************************************
    * Method: PenielException
    * Synopsis: Constructor - overloaded version to except 5 parms of info.
    * @parms: String exceptionComponent - The componant that threw the
    *             exception.
    *         String typeOfError - Specifies whether the error is an application
    *             or system.
    *         int errorID - Specifies the error ID.
    *         String codeLocation - Specifying the class and method where the
    *             exception was encountered.
    *         String exceptionMessage - A customized message passed by the 
    *             calling routine.
    * @return: N/A
    * @exceptions: none.
    ***************************************************************************/
    public PenielException(String exceptionComponent, String typeOfError,
        int errorID, String codeLocation, String exceptionMessage)
    {
        stack_ = fillInStackTrace();
        exceptionComponent_ = exceptionComponent;
        typeOfError_ = typeOfError;
        errorID_ = errorID;
        codeLocation_ = codeLocation;
        exceptionMessage_ = exceptionMessage;
    }

    /***************************************************************************
    * Method: PenielException
    * Synopsis: Constructor - overloaded version to except 1 String Message.
    *     This constructor calls the appendMessage method.
    * @parms: String msg - The error Message.
    * @return: N/A
    * @exceptions: none.
    ***************************************************************************/
    public PenielException(String msg)
    {
        stack_ = fillInStackTrace();
        appendMessage(msg);
    }

    /***************************************************************************
    * Method: PenielException
    * Synopsis: Constructor - overloaded version to except an Exception and
    *           an Message.
    * @parms: Exception exception - The Exception encountered.
    *         String exceptionMessage - A customized message passed by the
    *             calling routine.
    * @return: N/A
    * @exceptions: none.
    ***************************************************************************/
    public PenielException(Exception exception, String exceptionMessage)
    {
        stack_ = exception.fillInStackTrace();
        exception_ = exception;
        exceptionMessage_ = exception.getMessage() + exceptionMessage;
    }

    /***************************************************************************
    * Method: appendMessage
    * Synopsis: The message string contains details to be added to the exception
    *     message.
    * @parms: String msg - The error Message.
    * @return: N/A
    * @exceptions: none.
    ***************************************************************************/
    public void appendMessage(String msg)
    {
        exceptionMessage_ = exceptionMessage_ + "" + msg;
    }

    /***************************************************************************
    * Method: getComponent
    * Synopsis: Returns the internal value of the component where the exception
    *     occured.
    * @parms: none.
    * @return: String - The component where the exception occured.
    * @exceptions: none.
    ***************************************************************************/
    public String getComponent()
    {
        return exceptionComponent_;
    }

    /***************************************************************************
    * Method: getType
    * Synopsis: Returns the internal value of the type of error that occured.
    * @parms: none.
    * @return: String - The type of error that occured.
    * @exceptions: none.
    ***************************************************************************/
    public String getType()
    {
        return typeOfError_;
    }

    /***************************************************************************
    * Method: getErrorID
    * Synopsis: Returns the internal value of the error Id.
    * @parms: none.
    * @return: int - The error Id.
    * @exceptions: none.
    ***************************************************************************/
    public int getErrorID()
    {
        return errorID_;
    }

    /***************************************************************************
    * Method: getCodeLocation
    * Synopsis: Returns the internal the class & method where the exception
    *    occured.
    * @parms: none.
    * @return: String - The class & method where the exception occured.
    * @exceptions: none.
    ***************************************************************************/
    public String getCodeLocation()
    {
        return codeLocation_;
    }

    /***************************************************************************
    * Method: getExceptionMessage
    * Synopsis: Returns the internal value of the exception message.
    * @parms: none.
    * @return: String - The internal value of the exception message.
    * @exceptions: none.
    ***************************************************************************/
    public String getExceptionMessage()
    {
        return exceptionMessage_;
    }

    /***************************************************************************
    * Method: fillInStackTrace
    * Synopsis: Returns the Throwable stack trace object.
    * @parms: none.
    * @return: Throwable - The internal value of the stack trace.
    * @exceptions: none.
    ***************************************************************************/
    public Throwable fillInStackTrace()
    {
        if(stack_ != null)
            return stack_;
        else
            return null;
    }

    /***************************************************************************
    * Method: printStackTrace
    * Synopsis: Prints what is stored in stack trace.
    * @parms: none.
    * @return: void.
    * @exceptions: none.
    ***************************************************************************/
    public void printStackTrace()
    {
        if (stack_ != null)
            stack_.printStackTrace();
        else
            super.printStackTrace();
 
        if (exceptionMessage_ == null)
           System.out.println("exceptionMessage is NULL");
        else
           System.out.println("exceptionMessage: " + exceptionMessage_);
    }

    /**
    * Attributes
    */
    /** Specifies the component (eg parse, transform etc) in which the exception was thrown */
    private String exceptionComponent_;
    /** Specifies whether the error was an application error or a system error */
    private String typeOfError_;
    /** Error Id which is predefined */
    private int errorID_;
    /** The class and method in which the exception was thrown */
    private String codeLocation_;
    /** Details of the exception message */
    private String exceptionMessage_;
    /** The exception that is thrown */
    private Exception exception_;
    /** Throwable object to catch the stack */
    private Throwable stack_=null;
}
