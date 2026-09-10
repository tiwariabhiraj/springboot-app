package DesignPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface FileSystem{
    void showDetails();
}

class File implements FileSystem{
    String name;

    File(String name){
        this.name=name;
    }

    @Override
    public void showDetails() {
        System.out.println("File Name : " + name);
    }
}

class Folder implements FileSystem{
    String name;
    List<FileSystem> files = new ArrayList<>();
    Folder(String name){
        this.name=name;
    }
    public void addFile(FileSystem file){
        files.add(file);
    }

    @Override
    public void showDetails() {
        for(FileSystem fs : files){
            System.out.println(name);
            fs.showDetails();;
        }
    }
}

public class Composite {
    public static void start(){
        Folder root = new Folder("Root");
        File file1= new File("file1");
        File file2= new File("file2");
        File file3= new File("file3");
        File file4= new File("file4");
        root.addFile(file1);
        root.addFile(file2);
        root.addFile(file3);
        Folder nested= new Folder("Nested");
        nested.addFile(file4);
        root.addFile(nested);
        root.showDetails();
    }
}