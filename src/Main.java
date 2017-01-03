import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
    //===Members===
    private JFrame mainFrame;
    private JPanel mainPanel;
//    private JButton btn_addItem;
//    private JTextField textField;
//    private String[] Seqs = new String[10000];
//    private int stringCounter=0;
//    private JTextField textField_1;
//    private JTextArea txtrD;
//    private String file="";
//    private char[][] matrix = new char[24][3];


    //===Methods===
    public Main(){
        this.mainFrame = new JFrame("DNA Progressive Alignment:");
        BorderLayout border = new BorderLayout();
        //get the screen resolution for display frame in full screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.mainFrame.setBounds(0,0,(int)screenSize.getWidth(),(int)screenSize.getHeight());
        this.mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.mainFrame.setVisible(true);

        //Main panel of the screen
        this.mainPanel = new JPanel();
        this.mainPanel.setBackground(Color.white);
        this.mainFrame.add(this.mainPanel, border.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        Main window = new Main();
    }
}
