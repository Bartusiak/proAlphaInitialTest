import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class main {

    public static void main(String[] args) throws FileNotFoundException {
        Date compileDate = new Date();
        File file = new File("src/main/Input.txt");
        File tempFile = new File("tempFile.txt");
        File outputFile = new File("outputFile.txt");
        String[] objString;
        List<String> content = new ArrayList<String>();

        try{
            List<String> contents = FileUtils.readLines(file, "UTF-8");
            long start = System.currentTimeMillis();
            for (String line : contents){
                objString = line.split("\" \"");
                String tempContent4 = objString[1].replaceAll(" ","");
                String tempContent5 = objString[2].replaceAll(" ","");
                String tempContent6 = objString[3].replaceAll(" ","");

                if(!tempContent4.equals("")) {
                    String tempElement4 = tempContent4.split(":")[0];
                    tempElement4 = tempElement4.split("PA")[1];
                    tempContent4 = tempContent4.replaceAll("PA", "");
                    tempContent4 = tempContent4.replaceAll(tempElement4, "");
                    tempContent4 = tempContent4.replaceAll(":proALPHA:", "");
                    tempContent4 = tempContent4 + tempElement4;
                    content.add(tempContent4);
                }

                if(!tempContent5.equals("") && !tempContent5.equals("\"") ){
                    String tempElement5 = tempContent5.split(":")[0];
                    tempElement5 = tempElement5.split("PA")[1];
                    tempContent5 = tempContent5.replace("PA","");
                    tempContent5 = tempContent5.replace(tempElement5 ,"");
                    tempContent5 = tempContent5.replace(":proALPHA:","");
                    tempContent5= tempContent5 + tempElement5;
                    content.add(tempContent5);
                }

                if(!tempContent6.equals("") && !tempContent6.equals("\"")){
                    String tempElement6 = tempContent6.split(":")[0];
                    tempElement6 = tempElement6.split("PA")[1];
                    tempContent6 = tempContent6.replace("PA","");
                    tempContent6 = tempContent6.replace(tempElement6,"");
                    tempContent6 = tempContent6.replace(":proALPHA:","");
                    tempContent6 = tempContent6.replace("\"","");
                    tempContent6= tempContent6 + tempElement6;
                    content.add(tempContent6);
                }
            }
            content.sort(Comparator.<String>naturalOrder());
            long end = System.currentTimeMillis();
            long result = (end - start);
            System.out.println(result);
            FileUtils.writeStringToFile(outputFile, String.valueOf(result)+"ms\n","UTF-8");
            for (int i=0; i<content.size();i++){
                FileUtils.writeStringToFile(outputFile, content.get(i)+"\n","UTF-8",true);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(compileDate);
    }

}
