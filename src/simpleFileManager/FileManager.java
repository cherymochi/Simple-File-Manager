package simpleFileManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class FileManager {
	
	protected static final int MAX_BLOCKS = 30;
    protected static final int MAX_FILE_SIZE = 8;
    protected static final char SPACE = ' ';
    protected static final char END_OF_FILE = '.';
    protected static char[] fileSystem = new char[MAX_BLOCKS * MAX_FILE_SIZE]; //holds the file system in blocks
    protected static String command = null; //collects from user using scanner object
    
    

    public static void main(String[] args) {
    	//creates the files, sets the size and contents of each
        File A = new File("File A.txt", 26, "The Power to Be Your Best.".toCharArray());
        File B = new File("File B.txt", 70, "This program has performed an illegal operation and will be shut down.".toCharArray());
        File C = new File("File C.txt", 40, "From tiny ACORNS mighty UNIX trees grow.".toCharArray());
        
        //adds the files into the array in order to separate into blocks for the READ, DEL & APP commands
        

        //adds the files to the fileSystem linked list
        LinkedList<File> fileSystem = new LinkedList<>();
        fileSystem.add(A);
        fileSystem.add(B);
        fileSystem.add(C);

        // <-- PRINTS TO SCREEN... JUST A WELCOME MESSAGE -->
        System.out.println(" **** WELCOME TO OUR BASIC FILE MANAGER! **** "
        					+ "\nCurrent files in system: ");
        
        //while the list isn't empty
        while (!fileSystem.isEmpty()) {
        	
        	//removes the current file from the list
            File currentFile = fileSystem.remove();
            
            //gets the file size in blocks
            //gets size, divides by max file size, adds to the modulus file size and max file size. 
            //if greater than 0, return one, else zero
            int fileSizeInBlocks = currentFile.getSize() / MAX_FILE_SIZE + (currentFile.getSize() % MAX_FILE_SIZE > 0 ? 1 : 0);

            //validation for file size
            if (fileSizeInBlocks <= MAX_BLOCKS) {
                
            	System.out.println("=> File: " + currentFile.getName() + ", Size: " + currentFile.getSize() + " bytes.");
	            
            	} else {
	                System.out.println("File: " + currentFile.getName() + " cannot be stored in the file system. It exceeds the maximum number of blocks.");
	            }//ends  if
        
        }//ends while loop
        
        // <-- PRINTS TO SCREEN... JUST A WELCOME MESSAGE TO THE COMMAND LINE -->
        System.out.println("\n\t **** COMMAND LINE **** ");
        
        //command loop
        while (true) {
        	try (Scanner scanner = new Scanner(System.in)) {
				
        		System.out.println("Enter 'HELP' to get a list of all available commands,");
				System.out.print("or 'EXIT' to terminate: "); //prompts user
				
				while (command != "EXIT") { //keeps going until they enter "EXIT"
					
					System.out.print("\n<&&> "); // where the enter their command... just a bunch of symbols to make it give the terminal vibe
					command = scanner.nextLine(); //collects from user using scanner object
				
					//splits the command wherever there's a space.. stores into the array
					//so given "SIZE A" by the user, "SIZE" would be stored in index 0, "A" would be stored in index 1
					String[] commandParts = command.split(" "); 
					
					
					//calls based on base command ("HELP", "SIZE", "READ" etc)
/*switch case*/		switch (commandParts[0]) { 

/*help command*/	case "HELP":
						//creates help object
						HelpCommand hc = new HelpCommand();
						
				    	if (commandParts.length > 1) {
				    		hc.handleHELPCommand(commandParts);
				    	}
					    	else {
					    		hc.handleHELPCommand(); //method call
					    	}
				        break;
				        
/*size command*/		case "SIZE": 
							//creates size object
							SizeCommand sc = new SizeCommand();
					    	if (commandParts.length > 1) {
					    		sc.handleSIZECommand(commandParts);
					    	}
						    	else {
						    		
						    		try { 
										System.out.println("Total blocks used in the system: " + Files.getFileStore(Paths.get(".")).getTotalSpace() / 1024);
						    		} catch (IOException e) {
									
						    			e.printStackTrace();
						    		}//ends try/catch
						    	}//ends else
					    	
					        break;
				        
/*read command*/			case "READ": 
								//creates read object
								ReadCommand rc = new ReadCommand();
						        rc.handleREADCommand(commandParts); //for "read + cmd"
						        break;
				        
/*delete command*/				case "DEL": 
									//creates del object
									DeleteCommand dc = new DeleteCommand();
							        dc.handleDELCommand(commandParts);
							        break;
				        
/*append command*/					case "APP":
								    	//creates append object
								    	AppendCommand ac = new AppendCommand();
										
								    	try {
											ac.handleAPPCommand(commandParts);
										} catch (IOException e) {
											e.printStackTrace();
										}
								        break;
				        
									    case "EXIT":
									        System.out.println("Program terminated. Exit code: 2003. ");
									    	System.exit(0);
									    	break;
				    	
										    default:
										    	//if they enter an invalid cmd
										        System.out.println("Unknown command. Type <HELP> for a list of available commands.");
					}//ends switch case
					
				}//ends while loop
				
			}//ends try block
        	// <-- CATCH BLOCK? -->
        	
        }//ends while loop
        
    }//ends main method
 
}//ends class
