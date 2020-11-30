package LZW;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.*;
public class Compress
{
    private static ArrayList<Integer>position = new ArrayList<Integer>();
    private static ArrayList<String> dic = new ArrayList<String>();

    private final static String path = "data.txt";
    private final static String pathTo ="compress.txt";
    private static String input;

    public Compress() throws Exception //1
    {
        input = takeInput();
        adding();
        compress();
    }
    private static String takeInput() throws Exception  //2
    {
        File file = new File(path);
        BufferedReader READ = new BufferedReader(new FileReader(file));
        int q=READ.read();
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

    private void compress() throws Exception//4
    {
        String WillSent = "";
        char [] name = input.toCharArray();
        String prev = "";
        for(int i = 0;i<input.length();i++)
        {
            String temp = prev + name[i];
            if(dic.contains(temp))
                prev = temp;
            else
            {
                position.add(dic.indexOf(prev));
                dic.add(temp);
                prev = ""+name[i];
            }
        }
        position.add(dic.indexOf(prev));

        for(int p=0;p<position.size();p++)
            WillSent+=Integer.toString(position.get(p))+ " ";
        WriteToFile(WillSent);
    }

    private static void WriteToFile(String data) throws Exception//5
    {
        File obj1 = new File(pathTo);
        BufferedWriter w= new BufferedWriter(new FileWriter(obj1));
        w.write(data);
        w.close();
    }
}
//ABAABABAABBBBBBBBBCCVCNABAABABAABBBBBBBBBCCVCNABAABABAABBBBBBBBBCCVCN