package LZW;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LZW
{
    private JButton compress;
    private JButton decompress;
    private JPanel panel;
    public LZW()
    {
        compress.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    JOptionPane.showMessageDialog(null,"Compress will be performed");
                    Compress ob = new Compress();
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });
        decompress.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    JOptionPane.showMessageDialog(null,"DeCompress will be performed");
                    Decompress ob = new Decompress();
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });
    }
    public static void main(String [] args)
    {
        JFrame frame = new JFrame("LZW APP");
        frame.setContentPane(new LZW().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}