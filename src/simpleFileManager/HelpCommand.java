package simpleFileManager;

import java.util.Scanner;

public class HelpCommand 
		extends FileManager{

	//prints to screen.
	public void handleHELPCommand() {
   	 System.out.println("\t\t\tAVAILABLE COMMANDS IN OUR SYSTEM "
   			 			+ "\n1. <HELP>: Lists available commands."
       					+ "\n2. <SIZE>: Displays the total blocks used in the system, or the number of characters in a file."
       					+ "\n3. <READ>: Reads all contents of a file, or a specific block at the front, middle, or back."
       					+ "\n4. <DEL>: Deletes a block at the front, middle, or back of a file."
       					+ "\n5. <APP>: Appends a word at the front, middle, or back of a file."
       					+ "\n6. <EXIT>: Terminated Program."
   			 			+ "\n=> Type <HELP [command]> to view info on other commands. Does not apply to <EXIT> command.");
   } //ends method
   
   public void handleHELPCommand(String [] commandParts) {
   	
   	//scanner obj
   	Scanner scan = new Scanner(System.in);
   	
   	// --------------------------------- HELP SIZE COMMAND
   	if ((commandParts[0].equals("HELP")) && (commandParts[1].equals("SIZE"))) {
   		
   		System.out.println("\t\t\t-- SIZE COMMAND -- "
   							+ "\nBasic Function: View the size of the files available in our system. "
					    		+ "\n\n-- Commands: "
   							+ "\n<SIZE>:\t    View the total blocks used in the system."
   							+ "\n<SIZE [fileName]>: View the total size of the file specified."
   							+ "\nE.g.:'SIZE A' will print the number of characters and block used in File A.");
   	} //ends if
   	
	    	// --------------------------------- HELP READ COMMAND
	    	else if ((commandParts[0].equals("HELP")) && (commandParts[1].equals("READ"))) {
	    		System.out.println("\t\t\t -- READ COMMAND -- "
	    							+ "\nBasic Function: Read the contents of files or a specific block at the front, middle, or back. "
	    							+ "\n\n-- Commands: "
	    							+ "\n<READ> /[position] [fileName]"
	    							+ "\nAccepted position variables:\n\t1.</f> Front\n\t2.</m> Middle\n\t3.</b> Back"
	    							+ "\nE.g.: READ /m B will display File B's middle block, 'legal op'.");
	    	} //ends if
   	
		    	// --------------------------------- HELP DEL COMMAND
		    	else if ((commandParts[0].equals("HELP")) && (commandParts[1].equals("DEL"))) {
		    		System.out.println("\t\tDELETE COMMAND "
		    							+ "\nBasic Function: Delete a block at the front, middle, or back of a file "
		    							+ "\n\n-- Commands: "
		    							+ "\n<DEL /[position] [fileName]>"
		    							+ "\nAccepted position variables:\n\t1.</f> Front\n\t2.</m> Middle\n\t3.</b> Back"
		    							+ "\nE.g.: DEL /b B will delete File B's back block, ' '.");
		    	} //ends if
   	
			    	// --------------------------------- HELP APP COMMAND
			    	else if ((commandParts[0].equals("HELP")) && (commandParts[1].equals("APP"))) {
			    		System.out.println("\t\tAPPEND COMMAND "
			    							+ "\nBasic Function: Append a word at the front, middle, or back of the file. "
			    							+ "\n\n-- Commands: "
			    							+ "\n<APP /[position] [fileName] [stringToAdd]>"
			    							+ "\nAccepted position variables:\n\t1.</f> Front\n\t2.</m> Middle\n\t3.</b> Back"
			    							+ "\nE.g.: APP /f A Now will append the word 'Now' to File A's front block.\nWill only execute if space is available.");
			    	} //ends if
   }//ends method
}