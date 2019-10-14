package bg.tao.utility;

import java.nio.file.FileSystems;

public class SystemUtility {
    public static void main(String[] a) {
        String c = getOperationSystem();
        System.out.println(c);
    }


    public static String parentFolder;
    public static String separator;

    static {
        separator = FileSystems.getDefault().getSeparator();
        if(isLinuxDistribution()){
            parentFolder ="";
        }else{
            parentFolder = "resources"+separator;
        }

    }


    /**
     * @return operation System
     */
    public static String getOperationSystem() {
        return System.getProperty("os.name");
    }

    /**
     * @return check if the app is running on linux
     */
    public  static  boolean isLinuxDistribution() {
        String distribution = getOperationSystem();
        if (distribution.contains("Windows")) {
            return false;
        } else {
            return true;
        }
    }

    public static String getSeparator(){
        String separator;
        separator = FileSystems.getDefault().getSeparator();
        return separator;
    }

}
