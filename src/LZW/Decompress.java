package LZW;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Decompress
{

    private static ArrayList<Integer>position = new ArrayList<Integer>();
    private static ArrayList<String>dic = new ArrayList<String>();

    private final static String path = "compress.txt";
    private final static String pathTo ="decompress.txt";
    private static String input;

    public Decompress() throws Exception  //1
    {
        input = takeInput();
        adding();
        decompress();
    }

    private static String takeInput() throws Exception  //2
    {
        File file = new File(path);
        BufferedReader READ = new BufferedReader(new FileReader(file));
        int q = 0;
        q = READ.read();
        String data = new String("");
        while(q != -1)
        {
            data+=(char)q;
            q=READ.read();
        }
        return data;
    }

    private void adding() //3
    {
        for(int i=0; i<128 ; i++)
            dic.add((char)i+"");
    }

    private static void decompress()  throws Exception//4
    {
        String willSent= "";
       String [] name = input.split(" ");
       for(int i=0;i<name.length;i++)
           position.add(Integer.valueOf(name[i]));
       String temp = "";
       for(int i=0;i<position.size();i++)
       {
           if(position.get(i)<dic.size())
           {
               if(i==0)
               {
                   willSent += dic.get(position.get(i));
               }
               else
               {
                    String first = dic.get(position.get(i));
                    dic.add(dic.get(position.get(i-1))+ first.charAt(0));
                    willSent+=first;
               }
           }
           else
           {
                String second = dic.get(position.get(i-1));
                temp = second + second.charAt(0) ;
                dic.add(temp);
                willSent+=temp;
           }
       }
       WriteToFile(willSent);
    }

    private static void WriteToFile(String data) throws Exception //5
    {
        File obj1 = new File(pathTo);
        BufferedWriter w= new BufferedWriter(new FileWriter(obj1));
        w.write(data);
        w.close();
    }
}