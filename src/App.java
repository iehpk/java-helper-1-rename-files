/*
 * Thsis is another Java helper program that
 *  renames single files inside folders with the folder name
 *  and moves them to a different directory!
 * 
 * Created by Henry Patrick Karugendo
 * Date last updated: 19 Feb 2024
 */
import java.io.File;

public class App {
    public static void main(String[] args) throws Exception {
        //This is the main directory with the folders containing a file each
        String mainDir = "C:/Users/user/Downloads/source";
        String targetDir = "C:/Users/user/Downloads/target";
        File filesDir = new File(mainDir);

        //Checking to make sure we are working with a real directory
        if(filesDir.exists()){

            //If directory exists, cycle through all folders inside the directory
            for(File f : filesDir.listFiles()) {

                //Print name of the current folder
                System.out.println(f.getName());

                //Get and store the name of the current folder
                String newName = f.getName();
                //Create temp file object that will store current file data
                File tempFile;

                //Cycle through all files in the current folder
                for(File of : f.listFiles()){
                    //Get file name
                    String fileName = of.getName();
                    //If file size is bigger than 10mb, store current file data into temp file
                    if(of.length() > 10000000){
                        //Get current file extension
                        String fileExt = fileName.substring(fileName.lastIndexOf('.'), fileName.length());
                        //Store current file data into temp file
                        tempFile = of;
                        //Copy file to a different directory and rename it with the folder name
                        tempFile.renameTo(new File(targetDir + "/" + newName + fileExt));
                    }
                }
            }

        //Error message for missing directory
        } else {
            System.out.println("Directory does not exist");
        }
    }
}

/*
 * End progam
 * 
 * Possible improvements
 * =====================
 * 1. Account for multiple files in folder bigger than 10mb
 * 2. Create GUI that is flexible and can work with other directories
 */