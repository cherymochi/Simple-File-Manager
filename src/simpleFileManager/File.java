package simpleFileManager;

import java.util.LinkedList;

public class File {
    private String name;
    private int size;
    private char[] content;
    
    public File(String name, int size, char[] content) {
        this.name = name;
        this.size = size;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public char[] getContent() {
        return content;
    }
}