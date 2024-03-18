// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.*;
class file_handling{
 
  void create_file(String filename){
    String Filename = filename;
   try{ File file = new File(Filename);
    if(file.createNewFile()){
      System.out.println("File created:  "+Filename);
    }
   else{
      System.out.println("File already exists.");
    }
       
  }catch(Exception e){
     System.out.println("Error ....."+ e);
    }
  }
  
  void write_file(String filename,String text){
    
    try{
      FileWriter file = new FileWriter(filename);
      file.write(text);
        System.out.println("File written: "+filename);
      file.close();
    }catch(Exception e){
      System.out.println("Error ....."+ e);
    }
  }
  void read_file(String filename){
    try{File file = new File(filename);
       Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
       System.out.println(sc.nextLine());}
        
  }catch(Exception e){
      System.out.println("Error ....."+ e);
    }
  }
  void delete_file(String filename){
    try{File file = new File(filename);
       if(file.delete()){
         System.out.println("File deleted: "+filename);
       }else{
         System.out.println("Error ....."+ filename);
       }
  }catch(Exception e){
      System.out.println("Error ....."+ e);
    }
  }
  void see_file(){
    try{
      String currentDir = System.getProperty("user.dir");
      System.out.println("Current Directory: "+currentDir);
      String directoryPath =currentDir;
      File directory = new File(directoryPath); 
      File[] files = directory.listFiles(); 

      if (files != null) { 

        for (File file : files) { 

          System.out.println(file.getName()); 

        } 

      }else{System.out.println("Not a File");
           } 
}catch(Exception e){
      System.out.println("Error ....."+ e);
    }
  }
  void re_name(String filename,String new_name){
    try{
      File file = new File(filename);
      if(file.renameTo(new File(new_name))){
        System.out.println("File renamed: "+filename);
      }else{
        System.out.println("Error ....."+ filename);
      }
    }catch(Exception e){
      System.out.println("Error ....."+ e);
    }
  }
}

public class Main {
  public static void main(String[] args) {
    file_handling obj = new file_handling();
    Scanner input = new Scanner(System.in);
    Scanner input1 = new Scanner(System.in);
    Boolean exit = true;
    String filename;
    System.out.println("-----------------------------------\n  Welcome To The File System 😇\n-----------------------------------");
    
    
    while(exit){
      
      System.out.println("-----------------------------------\n Press A for Create File \n Press B for Write File \n Press C for Read File\n Press D for Delete File\n Press E for Exit\n Press F for See All Files\n Press G for Rename File");
    char input_char=input.next().charAt(0);
     if(input_char=='A'){
       System.out.println("Enter the name of the file");
       filename=input1.nextLine();
       obj.create_file(filename);
     }
     else if(input_char=='B'){
       String text;
       System.out.println("Enter the text you want to write");
       text=input1.nextLine();
       System.out.println("Enter the name of the file");
       filename=input1.nextLine();
       obj.write_file(filename,text);
       System.out.println("File written");
     }
      else if(input_char=='C'){
        System.out.println("Enter the name of the file");
        filename=input1.nextLine();
        obj.read_file(filename);
      }
      else if(input_char=='D'){
        System.out.println("Enter the name of the file");
        filename=input1.nextLine();
        obj.delete_file(filename);
      }
      else if(input_char=='E'){
        System.out.println("Thank You for useing the file system");
        exit=false;
      }
      else if(input_char=='F'){
        obj.see_file();
      }
      else if(input_char=='G'){
        System.out.println("Enter the name of the file");
        filename=input1.nextLine();
        System.out.println("Enter the new name of the file");
        String new_name=input1.nextLine();
        obj.re_name(filename,new_name);
      }
      else{
        System.out.println("Invalid Input");
      }
    }
  }

  // @Test
  // void addition() {
  //     assertEquals(2, 1 + 1);
  // }
}