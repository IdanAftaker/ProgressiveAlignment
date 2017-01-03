import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
    //===Members===
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JPanel upperPanel;
    private JPanel buttonsPanel;
    private JPanel lowerPanel;
    private JButton btn_AddSequence;
    private JButton btn_Compute;
    private JButton btn_SubMatrix;

    private JLabel lblEnterSequences;
    private JTextField textField;

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

        //Labels
        this.lblEnterSequences = new JLabel("Enter Sequences :");


        //Add buttons
        //Add Sequence
        this.btn_AddSequence = new JButton("Add Sequence");
        btn_AddSequence.setFont(new Font("Helvetica",Font.ITALIC,14));
        btn_AddSequence.addActionListener(this);

        //Compute
        this.btn_Compute = new JButton("Compute");
        btn_Compute.setFont(new Font("Helvetica",Font.ITALIC,14));
        btn_Compute.addActionListener(this);

        //Subtitution matrix
        this.btn_SubMatrix = new JButton("Subtitution Matrix File:");
        btn_SubMatrix.setFont(new Font("Helvetica",Font.ITALIC,14));
        btn_SubMatrix.addActionListener(this);



        //Buttons Panel
        this.buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout());
        buttonsPanel.add(btn_AddSequence);
        buttonsPanel.add(btn_SubMatrix);
        buttonsPanel.add(btn_Compute);



        //Upper panel
        this.upperPanel = new JPanel();
        upperPanel.setLayout(new BorderLayout());
        upperPanel.add(lblEnterSequences, border.NORTH);
        upperPanel.add(buttonsPanel, border.SOUTH);

        //Main panel of the screen
        this.mainPanel = new JPanel();
        mainPanel.setBackground(Color.white);
        mainFrame.add(this.mainPanel, border.CENTER);
        mainFrame.add(upperPanel,border.NORTH);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_AddSequence){
            // TODO: 03/01/2017
        }
        if (e.getSource() == btn_Compute){
            // TODO: 03/01/2017
        }
        if (e.getSource() == btn_SubMatrix){
            // TODO: 03/01/2017
        }

    }

    public static void main(String[] args) {
        Main window = new Main();
    }
}
