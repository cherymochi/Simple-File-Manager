package simpleFileManager;

public class ReadCommand 
        extends FileManager {
    
    public void handleREADCommand(String[] commandParts) {
       
     //if the command is invalid (meaning it doesn't have three parts) display error
        if (commandParts.length != 3) {
            System.out.println("Invalid command format. Please specify the block and file name you'd like to read."
                                + "\nSee <HELP READ> for more information. ");
            return;
        }
        
          String fileName = commandParts[2]; //stores file name
       String blockType = commandParts[1]; //stores position (front, middle, back)
       String fileContent = readFileContent(fileName); //stores file content
       
       //method call
       displayBlock(fileContent, blockType, fileName);    
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
   
   public void displayBlock(String fileContent, String blockType, String fileName) {
       //splits the file into three block every 8 chars
       String[] blocks = fileContent.split("(?<=\\G.{8})");
       
       //prints them to screen based on position
       switch (blockType) {
           case "/f":
               System.out.println("Front block of file " + fileName + ": " + blocks[0]);
               break;
               case "/b":
                   System.out.println("Back block of file " + fileName + ": " + blocks[2]);
                   break;
                   case "/m":
                       System.out.println("Middle block of file " + fileName + ": " + blocks[1]);
                       break;
                       default:
                           System.out.println("Invalid block type. See <HELP READ> for acceptable block types.");
                           break;
       }
   }

} //ends class