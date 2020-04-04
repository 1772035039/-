package 四则;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class Run {
 
    public static void main(String[] args) throws IOException  {
        Scanner scan=new Scanner(System.in);
        String command=null;
        Create create=new Create();
        Checkanswer checkanswer=new Checkanswer();
        String nr="^\\-n\\s+\\d+\\s+\\-r\\s+\\d+$||^\\-r\\s+\\d+\\s+\\-n\\s+\\d+$";
        String ea="^\\-e\\s+\\S+\\s+\\-a\\s+\\S+$";
        int n = 0;
        int r = 0;
        String exercisesfile=null;
        String answersfile=null;
        System.out.println("小学四则运算题目生成程序");
        System.out.println("-r 题目中数值（该参数可以设置为1或其他自然数）");
        System.out.println("-n 题目个值（该参数可以设置为1或其他自然数）");
        System.out.println("-e 需要批改的答案的文件路径");
        System.out.println("-a 正确答案的文件路径"); 
        System.out.println("请按照下面的格式输入命令");
        System.out.println("例：-n 10 -r 10 或 -r 10 -n 10 (-r和-n命令需要一起使用)"); 
        System.out.println("例：-e D:\\\\myanswer.txt -a D:\\\\Answers.txt (-e和-a命令需要一起使用)");
        while(scan.hasNextLine()) {
            if (scan.hasNextLine()) {
                command = scan.nextLine();}            
        
        //检查命令是否正确
        Pattern pa = Pattern.compile(nr);
        Matcher ma = pa.matcher(command);
        Pattern p = Pattern.compile(ea);
        Matcher m = p.matcher(command);
        if(!(ma.matches()||m.matches())) {
            System.out.println("命令格式错误，请重新输入");
            continue;
        }
        //对命令进行分割
        String[] c=command.split("\\s+");
        if(c[0].equals("-n")&&c[2].equals("-r")) {
            n=Integer.parseInt(c[1]);
            r=Integer.parseInt(c[3]);
            create.cr(n,r);
            System.out.println("练习题目Exercises.txt和答案文件Answers.txt已生成，放置在本程序的当前目录下");
        }
        else if(c[0].equals("-r")&&c[2].equals("-n")){
            r=Integer.parseInt(c[1]);
            n=Integer.parseInt(c[3]);
            create.cr(n,r);
            System.out.println("练习题目Exercises.txt和答案文件Answers.txt已生成，放置在本程序的当前目录下");
        }
        if(c[0].equals("-e")&&c[2].equals("-a")) {
            exercisesfile=c[1];
            answersfile=c[3];
            try {
            checkanswer.check(exercisesfile,answersfile);}
            catch(FileNotFoundException e) {
                System.out.println("找不到指定文件,请重新输入正确的文件路径");
                continue;
            }
            System.out.println("批改文件Grade.txt已生成，放置在本程序的当前目录下");
        }
        System.out.println("请及时保存文件，再次使用程序时上一次生成的文件会被覆盖");
        //归零
        n=0;
        r=0;
        }   
        
    }
}