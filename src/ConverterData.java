
import java.io.File;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.peniel.utilities.ProcessHandler;

public class ConverterData {
	 ExecutorService executorService=null;
	 
	 
	 public ConverterData(){
			
			//executorService = Executors.newFixedThreadPool(10);
		}
	public synchronized void convertFile(String inputFileName, String outputFileName, boolean forceOverwrite, Integer port)
			throws SecurityException, NoSuchFieldException, Exception {
		//executorService.submit(new Runnable(){
          //  public void run() {
            	Process proc =null;
		try {
			
			System.out.println("********* Testing Converter service  synch*************");
						System.out.println("In Converter.jws :::::: Converting File " + inputFileName + " -> " + outputFileName);

			int iend = inputFileName.lastIndexOf("\\");
			String inputPath = "";
			if (iend != -1) {
				inputPath = inputFileName.substring(0, iend);
			}
			System.out.println(inputPath + "*****inputPath");

			// +inputFileName +" --outdir D:/imaging/backup", envp, new
			// File("D:/imaging/backup"));

			String envp[] = new String[1];
			//envp[0] = "LUIB=ABCD";
			
			System.out.println("*** time before -->"+inputFileName+"<--- "+new Date());
			
			 proc = Runtime.getRuntime()
					.exec("C:\\Program Files (x86)\\LibreOffice 5\\program\\soffice --headless --convert-to pdf "
							+ inputFileName + " --outdir " + inputPath);
			
			 
			boolean procFlag = proc.waitFor(250, TimeUnit.SECONDS);

			//System.out.println("Convertion Process i = " + i + "<----");
			
			System.out.println("Convertion Process %%%% -->"+ inputFileName +"<-- " + procFlag + "<----"+new Date());
			
			if(procFlag) {
				System.out.println("Document convertion successful OCR.");

				File outputFile = new File(inputFileName);
				boolean delTxt = outputFile.delete();

				System.out.println(outputFile + " file deleted --> " + delTxt);
			}
			
			if(proc.isAlive()) proc.destroyForcibly();
			
			System.out.println("*** 1. Destroying the process for --->"+inputFileName );
			
			
		} catch (Exception e) {
			System.out.println("Exception during ocr -->" + e.getMessage());
			proc.destroyForcibly();
		}finally
		{
			proc.destroyForcibly();
			
			System.out.println("*** Finally. Destroying the process for --->"+inputFileName );
		}
         //  }
    	//}); 
	}
	public void waitStop() {
        executorService.shutdown();
        try {
			executorService.awaitTermination(99999999L, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    }

}
