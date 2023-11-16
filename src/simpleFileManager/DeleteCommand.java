package simpleFileManager;

public class DeleteCommand 
        extends FileManager{

    public void handleDELCommand(String[] commandParts) {
        
            if (commandParts.length != 3) {
                System.out.println("Invalid command format. Please specify the block and file name you'd like to delete."
                                    + "\nSee <HELP DEL> for more information. ");
                return;
            }
            
           String fileName = commandParts[2];
           String blockType = commandParts[1];
           String fileContent = readFileContent(fileName);
           
           deleteBlock(fileContent, blockType, fileName);
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
    
    public void deleteBlock(String fileContent, String blockType, String fileName) {
        
        String[] blocks = fileContent.split("(?<=\\G.{8})");
        StringBuilder updatedFileContent = new StringBuilder();
        
        switch (blockType) {
        case "/f":  // ---------------------------------------------------- front block
            // Print contents of the file before deletion
            System.out.println("Before deletion: '" + fileContent + "'"
                                + "\nBlock to be deleted: '" + blocks[0] + "'");
            
            //deletes block
            blocks[0] = "";
            
            for (String block : blocks) {
                updatedFileContent.append(block);
            }
            
            System.out.println("\nAfter deletion: '" + updatedFileContent + "'");
            break;
            case "/b": // ---------------------------------------------------- back block
                // Print contents of the file before deletion
                System.out.println("Before deletion: '" + fileContent + "'"
                                    + "\nBlock to be deleted: '" + blocks[2] + "'");
                
                //deletes block
                blocks[2] = "";
                
                for (String block : blocks) {
                    updatedFileContent.append(block);
                }
                
                System.out.println("\nAfter deletion: '" + updatedFileContent + "'");
                break;
                case "/m": // ---------------------------------------------------- middle block
                    // Print contents of the file before deletion
                    System.out.println("Before deletion: '" + fileContent + "'"
                                        + "\nBlock to be deleted: '" + blocks[1] + "'");
                    
                    //deletes block
                    blocks[1] = "";
                    
                    for (String block : blocks) {
                        updatedFileContent.append(block);
                    }
                    
                    System.out.println("\nAfter deletion: '" + updatedFileContent + "'");
                    break;
                    default:
                        System.out.println("Invalid block type. See <HELP DEL> for acceptable block types.");
                        break;
        }
    
    }
}//ends class
