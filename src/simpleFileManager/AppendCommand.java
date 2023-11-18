package simpleFileManager;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AppendCommand 
		extends FileManager{
	
	private String updatedFileContent;
	
	public void handleAPPCommand(String[] commandParts) throws IOException {
        
	   	 if (commandParts.length != 4) {
	            System.out.println("Invalid command format. Please specify the block and file name you'd like to append to."
	            					+ "\nSee <HELP APP> for more information. ");
	            return;
	        }
	   	 
	   	   String fileName = commandParts[2]; //stores file name
	       String blockType = commandParts[1]; //stores block position
	       String newText = commandParts[3]; //stores what to append
	       String fileContent = readFileContent(fileName);  
	       
	       appendToBlock(fileContent, blockType, fileName, newText);
	   }
	
	public String readFileContent(String fileName) {
	       // This method should read the file content based on the file name provided.
	       switch (fileName) {
	           case "A":
	               return "The Power to Be Your Best.";
		           case "B":
		               return "This program has performed an illegal operation and will be shut down.";
			           case "C":
			               return "From tiny ACORNS mighty UNIX trees grow.";
				           default:
				               return null;
	       }
	   }
	
	public void appendToBlock(String fileContent, String blockType, String fileName, String newText) throws IOException {
		Scanner scanner = new Scanner(System.in);
        
		if (checkSize(fileName, newText) == 1) {
	       	 System.out.println("Error: The total number of characters in the file will exceed the limit after appending.");
		}
		else {
			//splits files into blocks
			String[] blocks = fileContent.split("(?<=\\G.{8})");
			
			switch (blockType) {
			case "/f": // ---------------------------------------------------- front block
           System.out.println("\nFile blocks after appending: '" 
	        		   				+ "\n1: [" + newText +"] "
	        		   				+ "\n2: [" + blocks[0] +"] "
	        		   				+ "\n3: [" + blocks[1] +"] "
	        		   				+ "\n4: [" + blocks[2] +"] ");
	           break;
	           
		       case "/b": // ---------------------------------------------------- back block 
		           System.out.println("\nFile blocks after  appending: '" 
		        		   				+ "\n1: [" + blocks[0] +"] "
		        		   				+ "\n2: [" + newText +"] "
		        		   				+ "\n3: [" + blocks[1] +"] "
		        		   				+ "\n4: [" + blocks[2] +"] ");
		           break;
			        case "/m": // ---------------------------------------------------- middle block
			        	System.out.println("\nFile blocks after  appending: '" 
				        		  			+ "\n1: [" + blocks[0] +"] "
				        		   				+ "\n2: [" + blocks[1] +"] "
				        		   				+ "\n3: [" + blocks[2] +"] "
				        		   				+ "\n4: [" + newText +"] ");
				        break;
				        default:
				            System.out.println("Invalid block type. See <HELP APP> for acceptable block types.");
				            break;
			}//ends switch case
		}//ends else block		
   } //ends method
	
	public int checkSize(String fileName, String newText) throws IOException {
		
		//gets file content
		String fileContent = readFileContent(fileName);
		
		//checks if file content would exceed the limit of 30 chars after appending
		if(fileContent.length() + newText.length() >= 30) {
			return 1;
		}
			return 0;

	} //ends method

}//ends class