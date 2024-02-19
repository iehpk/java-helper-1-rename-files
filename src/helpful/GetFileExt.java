package helpful;
import java.io.File;

public class GetFileExt {

    public static void main(String[] args) {
        File fileDir = new File("C:/Users/henry/Downloads/source");
        if(fileDir.exists()) {
            for(File f: fileDir.listFiles()){
                String fileName = f.getName();
                String fileExt = fileName.substring(fileName.lastIndexOf('.'), fileName.length());
                System.out.println(fileExt);
            }
        }
    }

}
