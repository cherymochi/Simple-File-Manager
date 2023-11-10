class SimpleFileSystem:
    def __init__(self):
        # Initialize the storage for up to 30 blocks
        self.blocks = [None] * 30
        
         # File index to track which blocks are occupied by which files
        self.file_index = {}
        
        # Store the initial content of the files
        self.store_file('A', "The Power to Be Your Best.")
        self.store_file('B', "This program has performed an illegal operation and will be shut down.")
        self.store_file('C', "From tiny ACORNS mighty UNIX trees grow.")
    
    def store_file(self, file_id, content):
        blocks_needed = -(-len(content) // 8)  # Calculate blocks needed (ceiling division)
        available_blocks = self.blocks.count(None)
        
        if blocks_needed > available_blocks:
            raise Exception("Not enough space to store file.")
        
        block_indices = [i for i, block in enumerate(self.blocks) if block is None][:blocks_needed]
        
        for i in range(blocks_needed):
            start = i * 8
            end = (i + 1) * 8
            self.blocks[block_indices[i]] = (file_id, content[start:end])
    
    # Other operations like reading, appending, and deleting will be added here...
     # Update the file index
        self.file_index[file_id] = block_indices

# Let's test the initialization
fs = SimpleFileSystem()
print(fs.blocks)  # This should print the initial content of files A, B, and C across the blocks
print(fs.file_index)  # This should print the block indices occupied by each file

# We'll then define the command line interface for interacting with the file system:

def main():
    fs = SimpleFileSystem()
    
    while True:
        command = input("> ").split()
        
        if not command:
            continue
        
        if command[0] == "HELP":
            # Handle HELP command...
            pass
        elif command[0] == "SIZE":
            # Handle SIZE command...
            pass
        elif command[0] == "READ":
            # Handle READ command...
            pass
        elif command[0] == "DEL":
            # Handle DEL command...
            pass
        elif command[0] == "APP":
            # Handle APP command...
            pass
        elif command[0] == "EXIT":
            print("Exiting the file manager.")
            break
        else:
            print(f"Unknown command: {command[0]}")

if __name__ == "__main__":
    main()
