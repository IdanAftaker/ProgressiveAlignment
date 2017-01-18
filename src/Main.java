import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main implements ActionListener {

    public static String str1 = "AATCGATCGGATCGACTGATTCAGATGTACGCATCGTAGCCATGTGGCTACTAACCGCCTAGCACGACGGTATTTAGCTG";
    public static String str2 = "AATCGATCGGATCGACTGATTCAGATGTACGCATCGTAGCCATGTGGCTACTAACCGCCTAGCACGACGGTAGTCGATTT";
//public static String str1 = "ABCDE";
//public static String str2 = "DEFGACABC";
    public ProgressiveAlignment obj;
    //===Members===
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JPanel upperPanel;
    private JPanel buttonsPanel;
    private JPanel centerPanel;
    private JPanel lowerPanel;
    private JButton btn_AddSequence;
    private JButton btn_Compute;
    private JButton btn_SubMatrix;
    private JButton btn_ProgressiveAlli;

    private JLabel lblEnterSequences;
    private JLabel lblScore;

    private JTextField textField;
    private JTextField textField_2;
    private JTextField textField_score;

    private ScrollPane scrollPane;

    private int stringCounter = 0;
    private String[] Seqs = new String[10000];
    private JTextArea txtrD;
    private String file="";
    private char[][] matrix = new char[24][3];

    //===Methods===

    /**
     * Main frame and components
     */
    public Main(){

        this.mainFrame = new JFrame("DNA Progressive Alignment:");
        mainFrame.setLayout(new BorderLayout());

        BorderLayout border = new BorderLayout();

        //get the screen resolution for display frame in full screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        //Labels
        this.lblEnterSequences = new JLabel("Enter Sequences :");
        this.lblScore = new JLabel("Score of multiply sequences aligmnet:");


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

        this.btn_ProgressiveAlli = new JButton("ProgressiveAlignment");
        btn_ProgressiveAlli.setFont(new Font("Helvetica",Font.ITALIC,14));
        btn_ProgressiveAlli.addActionListener(this);

        //Buttons Panel
        this.buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout());
        buttonsPanel.add(btn_AddSequence);
        buttonsPanel.add(btn_SubMatrix);
        buttonsPanel.add(btn_Compute);
        buttonsPanel.add(btn_ProgressiveAlli);

        //Text field
        this.textField = new JTextField();
        textField.setText(">");
        textField.setColumns(10);


        //Upper panel
        this.upperPanel = new JPanel();
//        upperPanel.setSize(screenSize.width, screenSize.height);
        upperPanel.setLayout(new BorderLayout());
        upperPanel.add(lblEnterSequences, border.NORTH);
        upperPanel.add(textField, border.CENTER);
        upperPanel.add(buttonsPanel, border.SOUTH);


        //Center panel
        this.centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        txtrD = new JTextArea();
        txtrD.setFont(new Font("Courier New", Font.BOLD, 14));

        this.scrollPane = new ScrollPane();
//        scrollPane.setLayout(new GroupLayout());
//        scrollPane.setViewportView(txtrD);
        scrollPane.add(txtrD);
        centerPanel.add(scrollPane);


        //Lower panel
        this.lowerPanel = new JPanel();
        lowerPanel.setLayout(new GridLayout());
        lowerPanel.add(lblScore);
//        this.textField_score = new JTextField();
//        lowerPanel.add(textField_score, 1);
        this.textField_2 = new JTextField();
        textField_2.setSize(100, 1000);
        lowerPanel.add(textField_2);




        //Main panel of the screen
        this.mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.white);
        mainPanel.add(upperPanel,border.NORTH);
        mainPanel.add(centerPanel,border.CENTER);
        mainPanel.add(lowerPanel, border.SOUTH);

        //Add panels to main frame
        mainFrame.add(mainPanel);
        mainFrame.pack();

        this.mainFrame.setBounds(0,0,(int)screenSize.getWidth(),(int)screenSize.getHeight());
        this.mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.mainFrame.setVisible(true);

    }

    /**
     * Action listener for the buttons
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_AddSequence){
//            this.txtrD = new JTextArea();
            Seqs[stringCounter]=textField.getText();
            txtrD.append(Seqs[stringCounter]+"\n");
            CenterStar.sequence[stringCounter]=Seqs[stringCounter];
            stringCounter++;
            textField.setText(">");
        }
        if (e.getSource() == btn_Compute){
            if(file == "")
                JOptionPane.showMessageDialog(null,"File needs to be choose first.");
            else{
                this.txtrD = new JTextArea();
                txtrD.setText(CenterStar.compute(matrix,stringCounter));
                textField_2.setText(String.valueOf(CenterStar.totalScore));
            }
        }
        if (e.getSource() == btn_SubMatrix){
            JFileChooser fs = new JFileChooser(new File("c:\\"));
            fs.setDialogTitle("Open a File");
            fs.showOpenDialog(null);
            File fi =fs.getSelectedFile();
            try {
                BufferedReader br = new BufferedReader(new FileReader(fi.getPath()));
                String line ="";
                while((line = br.readLine())!= null){
                    file+=line;
                }
                if(br !=null)
                    br.close();

            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage());
            }
            initMatrix();
        }
        if (e.getSource() == btn_ProgressiveAlli){
            this.obj = new ProgressiveAlignment(str1, str2);
        }
    }

    /**
     * initilatize the matrix
     */
    private void initMatrix(){
        file=file.replace(" ", "");
        for(int i=0;i<24;i++){
            matrix[i] = file.substring(i*3, i*3+3).toCharArray();
        }
    }

    /**
     * main function
     * @param args
     */
    public static void main(String[] args) {
        Main window = new Main();
    }
}
