package Àƒ‘Ú;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
public class Checkanswer {
    
    public void check(String expath,String anpath) throws IOException{
        BufferedReader brex=new BufferedReader(new FileReader(expath));
        BufferedReader bran=new BufferedReader(new FileReader(anpath));
        BufferedWriter bwgrade=new BufferedWriter(new FileWriter(".\\Grade.txt"));
        List<String> Correct=new ArrayList<String>();
        List<String> Wrong=new ArrayList<String>();
        String an=null;
        String ex=null;
        while((an=bran.readLine())!=null) {
            ex=brex.readLine();
            int point=an.indexOf(".");
            String stran=an.substring(point+1);
            stran=stran.trim();
            String strex=ex.substring(point+1);
            strex=strex.trim();
            if(stran.equals(strex)) {           
                String cno=an.substring(0, point);
                Correct.add(cno);
            }else {
                String wno=an.substring(0, point);
                Wrong.add(wno);
            }
        }
        String corr=String.join(",",Correct); 
        String wr=String.join(",",Wrong); 
        bwgrade.write("Correct: "+Correct.size()+" ("+corr+")"+"\r\n");
        bwgrade.write("Wrong: "+Wrong.size()+" ("+wr+")");
        bwgrade.flush();
        bwgrade.close();    
    }
}