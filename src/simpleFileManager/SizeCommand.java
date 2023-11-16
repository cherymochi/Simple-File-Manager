package simpleFileManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SizeCommand 
		extends FileManager{

	private static long charCountA; //counts the number of chars in file a
	private static long charCountB;
    private static long charCountC;
    
    // -------------------------- getters and setters
    public long getCharCountA() {
		return charCountA;
	}

	public void setCharCountA(long charCountA) {
		SizeCommand.charCountA = charCountA;
	}

	public long getCharCountB() {
		return charCountB;
	}

	public void setCharCountB(long charCountB) {
		SizeCommand.charCountB = charCountB;
	}

	public long getCharCountC() {
		return charCountC;
	}

	public static void setCharCountC(long charCountC) {
		SizeCommand.charCountC = charCountC;
	}
	
	// ------------------------------ methods
    
	public void handleSIZECommand(String[] commandParts) {   
    	
    	Scanner scan = new Scanner(System.in); //used in catch block collects info from user.
    	
    	// --------------------------------- GETS SIZE OF FILE A
    	if ((commandParts[0].equals("SIZE")) && (commandParts[1].equals("A"))) { 
    		
    		//should fix n use relative referencing
    		String fileName = "C:\\Users\\MiltonV\\eclipse-workspace\\OSProj23\\src\\simpleFIleManager\\File A.txt";
    		
    		//new br object
            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            	
            	//counts characters & blocks
            	charCountA = 0;
            	
            	//as long as there's a character, count it.
                while (fileReader.read() != -1) {
                	charCountA++;
                }//ends while loop
                
                //calc blocks
                int blocksCount = (int) (charCountA / 8);
                
                //prints character and blocks in file... does calculation in the same line
                System.out.println("=> File A" + " size: " + charCountA + " characters, and " + blocksCount + " blocks.");
                
            } catch (IOException e) {
                System.out.println("File not found.");
                //System.out.print("\n<&&> ");
                //command = scan.nextLine(); //collects from user using scanner object
                
            } //ends catch block
            
    	} //ends else if
	    	// --------------------------------- GETS SIZE OF FILE A
	    	else if ((commandParts[0].equals("SIZE")) && (commandParts[1].equals("B"))) { 
	    		
	    		String fileName = "C:\\Users\\MiltonV\\eclipse-workspace\\OSProj23\\src\\simpleFIleManager\\File B.txt";
	    		
	    		//new br object
	            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
	            	
	            	//counts characters
	            	charCountB = 0;
	                
	            	//as long as there's a character, count it.
	                while (fileReader.read() != -1) {
	                	charCountB++;
	                }//ends while loop
	                
	              //calc blocks
	                int blocksCount = (int) (charCountB / 8);
	                
	                //prints character and blocks in file... does calculation in the same line
	                System.out.println("=> File B" + " size: " + charCountB + " characters, and " + blocksCount + " blocks.");
	                
	            } catch (IOException e) {
	                System.out.println("File not found.");
	                System.out.print("\n<&&> ");
	                command = scan.nextLine(); //collects from user using scanner object
	                
	            } //ends catch block
	            
	    	} //ends else if
		    	// --------------------------------- GETS SIZE OF FILE A
		    	else if ((commandParts[0].equals("SIZE")) && (commandParts[1].equals("C"))) { 
		    		
		    		String fileName = "C:\\Users\\MiltonV\\eclipse-workspace\\OSProj23\\src\\simpleFIleManager\\File C.txt";
		    		
		    		//new br object
		            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
		            	
		            	//counts characters
		                charCountC = 0;
		                
		            	//as long as there's a character, count it.
		                while (fileReader.read() != -1) {
		                	charCountC++;
		                }//ends while loop
		                
		              //calc blocks
		                int blocksCount = (int) (charCountC / 8);
		                
		                //prints character and blocks in file... does calculation in the same line
		                System.out.println("=> File C" + " size: " + charCountC + " characters, and " + blocksCount + " blocks.");
		                
		            } catch (IOException e) {
		                System.out.println("File not found."); //if file not found.
		                System.out.print("\n<&&> ");
		                command = scan.nextLine(); //collects from user using scanner object
		                
		            } //ends catch block
		            
		    	} //ends else if
    }//ends method
}
