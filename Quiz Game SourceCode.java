import java.awt.Toolkit;
import java.util.concurrent.*;
import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.net.*;
import java.io.*;
class  Quiz1 extends JFrame implements ActionListener{

public static int qaid;
    JPanel panel;
            JLabel timeLabel;

            JPanel panelresult;

            JRadioButton choice1;

            JRadioButton choice2;

            JRadioButton choice3;

            JRadioButton choice4;

            ButtonGroup bg;

            JLabel lblmess;
                                                   public static InetAddress address;

                                      public static  MulticastSocket socket;

public static int nSeconds;
public static int count=0;
 private Timer timer;
public static JButton btnext;

ActionListener timerListener;
String[][] qpa;
          String[][] qca;

            HashMap<Integer, String> map;
            Quiz1(){
initializedata();
 timeLabel = new JLabel("0.00");

                      setTitle("Quiz Program");

                      setDefaultCloseOperation(EXIT_ON_CLOSE);

                      setSize(430,350);

                      setLocation(300,100);

                      setResizable(false);

                      Container cont=getContentPane();

                     cont.setLayout(null);

                     cont.setBackground(Color.GRAY);

                    bg=new ButtonGroup();

                    choice1=new JRadioButton("Choice1",true);

                    choice2=new JRadioButton("Choice2",false);

                    choice3=new JRadioButton("Choice3",false);

                    choice4=new JRadioButton("Choice4",false);

                    bg.add(choice1);

                   bg.add(choice2);

                    bg.add(choice3);
bg.add(choice4);

                    lblmess=new JLabel("Choose a correct anwswer");

                    lblmess.setForeground(Color.BLUE);

lblmess.setFont(new Font("Arial", Font.BOLD, 11));

                    btnext=new JButton("Next");

                    btnext.setForeground(Color.GREEN);

                    btnext.addActionListener(this);

                    panel=new JPanel();

                    panel.setBackground(Color.LIGHT_GRAY);

                    panel.setLocation(10,10);

                    panel.setSize(400,300);
                    panel.setLayout(new GridLayout(7,2));

                    panel.add(timeLabel);
                        panel.add(lblmess);

                    panel.add(choice1);

                    panel.add(choice2);
panel.add(choice2);

                    panel.add(choice3);

                    panel.add(choice4);

                    panel.add(btnext);
cont.add(panel);
 setVisible(true);

                   qaid=0;
readqa(qaid);


            }



        public void actionPerformed(ActionEvent e){

final String s,u;
long startTime,endTime, duration;
if(count==1)
timer.cancel();
timer = new Timer();
count=1;
 timer.schedule(new UpdateITask(), 0, 1000);

if(btnext.getText().equals("Next")){

System.out.println("enter");
                                    if(qaid<9){
 startTime = System.nanoTime();
s=getSelection();
SendRequest(s);
// *************************************map.put(qaid,s);
qaid++;
 readqa(qaid);
endTime = System.nanoTime();
duration = (endTime - startTime);
System.out.println("time took:"+duration);
nSeconds=0;
//timer.cancel();

                                                }

                                    else {
 map.put(qaid,getSelection());

                                                btnext.setText("Show score");
 }

                                    }

                        else if(btnext.getText().equals("Show score"))

                                   { //new Report
try
{
//JOptionPane.showMessageDialog(null,"your score is:"+"sdd");
        byte message[] =new byte[1024];
 DatagramPacket packet1 = new DatagramPacket(message,message.length);
                                        socket.receive(packet1);
    String recmessage =new String(packet1.getData());
System.out.println(recmessage);

JOptionPane.showMessageDialog(null,"your score is:"+recmessage);
socket.close();
}
catch(IOException yy)
        {
            System.out.println("IOError");
        }

//qaid=0;
//qaid=1;
  //btnext.addActionListener(this);
                       }}


// cont.add(panel);


public void initializedata(){

                        qpa=new String[10][5];
                  qpa[0][0]="How to run Java program on the command prompt?";

                        qpa[0][1]="1.mepco  schlenk engineering college ";

                        qpa[0][2]="2.psg engineering college";

                        qpa[0][3]="3.sri krishna engineering college";

                        qpa[0][4]="4.srm engineering college";



                        qpa[1][0]="SAND is written as UCPF then how would CUTE be written in that code";

                        qpa[1][1]="1.EVUF";

                        qpa[1][2]="2.EWBG";

                        qpa[1][3]="3.DVUF";

                        qpa[1][4]="4.EWVF";

                       

                        qpa[2][0]="Find what is next? 64,66,68,70,____,74";

                        qpa[2][1]="1.71";

                        qpa[2][2]="2.73";

                        qpa[2][3]="3.72";

                        qpa[2][4]="4.75";



                        qpa[3][0]="Find what is next? U32,V29,___X23,Y20";

                        qpa[3][1]="1.W26";

                        qpa[3][2]="2.W17";

                        qpa[3][3]="3.Z17";

                        qpa[3][4]="4.Z26";



                        qpa[4][0]=" find odd number? 51,144,64,121,256";

                        qpa[4][1]="1.51";

                        qpa[4][2]="2.144";

                        qpa[4][3]="3.64";

                        qpa[4][4]="4.121";



                        qpa[5][0]="find the missing letter in the series? B,E,H,K,___";

                        qpa[5][1]="1.N";

                        qpa[5][2]="2.M";

                        qpa[5][3]="3.P";

                        qpa[5][4]="4.S";



                        qpa[6][0]="Find the next term in the series? AEC,GKI,PTR,TXV,____";

                        qpa[6][1]="1.JKL";

                        qpa[6][2]="2.UWW";

                        qpa[6][3]="3.ZBY";

                        qpa[6][4]="4.HLJ";



                        qpa[7][0]="Find what is next? 6,20,56,176,__";

                        qpa[7][1]="1.416";

                        qpa[7][2]="2.525";
                        qpa[7][3]="3.256";

                        qpa[7][4]="4.none of the above";



                        qpa[8][0]="Find odd number pair (2-8),(3-27),(4-32),(5-125)";

                        qpa[8][1]="1.(2-8)";

                        qpa[8][2]="2.(3-27)";

                        qpa[8][3]="3.(4-32)";

                        qpa[8][4]="4.(5-125)";



                        qpa[9][0]="choose the ratio  6:18::4:__";

                        qpa[9][1]="1.2";

                        qpa[9][2]="2.6";

                        qpa[9][3]="3.8";

                        qpa[9][4]="4.16";



                       

                        //qca stores pairs of question and its correct answer

                        qca=new String[10][2];

                       

                        qca[0][0]="How to run Java program on the command prompt?";

                        qca[0][1]="1.java JavaProgram";



                        qca[1][0]="What is the use of the println method?";

                        qca[1][1]="1.It is used to print text on the screen with the line break.";



                        qca[2][0]="How to read a character from the keyboard?";

                        qca[2][1]="char c=(char)System.in.read()";



                        qca[3][0]="Which one is a single-line comment?";

                        qca[3][1]="//...";





                        qca[4][0]="How do you declare an integer variable x?";

                        qca[4][1]="int x";



                        qca[5][0]="How do you convert a string of number to a number?";

                        qca[5][1]="int num=Integer.parseInt(str_num)";



                        qca[6][0]="What is the value of x? int x=3>>2";

                        qca[6][1]="0";

                       

                        qca[7][0]="How to do exit a loop?";

                        qca[7][1]="Using break";

                       

                        qca[8][0]="What is the correct way to allocate one-dimensional array?";

                        qca[8][1]="int[] arr=new int[size]";



                        qca[9][0]="What is the correct way to allocate two-dimensional array?";

                        qca[9][1]="int[][] arr=new int[rows][cols]";


                        map=new HashMap<Integer, String>();

                       

                        }

 public class UpdateITask extends TimerTask {

       // int nSeconds = 0;


        public void run() {
            EventQueue.invokeLater(new Runnable() {


                public void run() {

if(nSeconds<=7)    

                timeLabel.setText(String.valueOf(nSeconds++));
else
{
SendRequest("null");
qaid=qaid+1;
readqa(qaid);
nSeconds=0;
//sendRequest("null");
//timer.cancel();
//count=0;

 }              }

            });
        }

    }

       

 

            public static void SendRequest(String s){

try
{                      

                                        //String dip = field1.getText();

                                        address = InetAddress.getByName("224.0.0.0");

                                        socket = new MulticastSocket();

                                        socket.joinGroup(address);
                                     //   String mess = area.getText();
//String h=Integer.toString(s)
System.out.println("s="+s);

                                        byte message[] = s.getBytes();

                                        DatagramPacket packet = new DatagramPacket(message, message.length, address, 5000);

                                        socket.send(packet);







}


catch(IOException io){}
//System.out.println("error");

}




 public String getSelection(){

                        String selectedChoice=null;

                        Enumeration<AbstractButton> buttons=bg.getElements(); 

                        while(buttons.hasMoreElements()) 

                        { 

                        JRadioButton temp=(JRadioButton)buttons.nextElement(); 

                        if(temp.isSelected()) 

                                    { 

                                                selectedChoice=temp.getText();

                                    } 

                         }  

                        return(selectedChoice);

            }





        public void readqa(int qid){

                        lblmess.setText("  "+qpa[qid][0]);

                        choice1.setText(qpa[qid][1]);

                        choice2.setText(qpa[qid][2]);

                        choice3.setText(qpa[qid][3]);

                        choice4.setText(qpa[qid][4]);

                        choice1.setSelected(true);
            }

        public void reset(){

                        qaid=1;

                       
System.exit(0);
 map.clear();
//  btnext.addActionListener(this);


                        readqa(qaid);
//Quiz();
                        btnext.setText("Next");
//  btnext.addActionListener(this);



                        }


        public int calCorrectAnswer(){

                        int qnum=10;

                        int count=0;

                        for(int qid=0;qid<qnum;qid++)

              if(qca[qid][1].equals(map.get(qid))) count++;

                        return count;

            }



      /*  public class Report extends JFrame{

                        Report(){

                                    setTitle("Answers");

                                    setSize(850,550);

                                    setBackground(Color.WHITE);

                                    addWindowListener(new WindowAdapter(){

                                                            public void windowClosing(WindowEvent e){

                                                                        dispose();

                                                                        reset();

                                                            }

                                                });

                                    Draw d=new Draw();                                  
                                    add(d);

                                    setVisible(true);
 

                                    }*/

                       

                       

              /*     class Draw extends Canvas{

                                    public void paint(Graphics g){

                                                int qnum=10;

                                                int x=10;

                                                int y=20;

                                                for(int i=0;i<qnum;i++){

                                                            //print the 1st column

                                                            g.setFont(new Font("Arial",Font.BOLD,12));                                         

                                                            g.drawString(i+1+". "+qca[i][0], x,y);

                                                            y+=30;           

                                                            g.setFont(new Font("Arial",Font.PLAIN,12));                             

                                                            g.drawString("      Correct answer:"+qca[i][1], x,y);

                                                            y+=30;

                                                            g.drawString("      Your answer:"+map.get(i), x,y);

                                                            y+=30;

                                                            //print the 2nd column

                                                            if(y>400)

                                                            {y=20;

                                                              x=450;

                                                            }

                                                           

                                                }

                                                //Show number of correct answers

                                                int numc=calCorrectAnswer();

                                                g.setColor(Color.BLUE);

                                                g.setFont(new Font("Arial",Font.BOLD,14));

                                                g.drawString("Number of correct answers:"+numc,300,500);

                       

                                               

                                    }

                        }

                        */           

        }





 public class QuizProgram4{


            public static void main(String args[]){

                         new Quiz1();


 EventQueue.invokeLater(new Runnable() {


            public void run() {
                final QuizProgram4 clock = new QuizProgram4();
            }
        });
   


  

            }





}

