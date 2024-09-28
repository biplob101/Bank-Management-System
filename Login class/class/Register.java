

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;





public class Register extends JFrame
{	



	private ImageIcon icon, backgroundImg;
	
	
	
	
	  private JLabel rTitle,pTitle,name,fName,mName,mail,number,birth,gender,status,blood,accountType,nationality;	
	  private JTextField tName,tfName,tmName,tBirth,tMail,tBlood,tNationality,tNumber;
	  private JRadioButton male,female,single,married;
	  private JButton next,back;
	  
			private Random ran = new Random ();
			 public  long  random =Math.abs(ran.nextLong()%10000);
		
		
		Register()
		{
			this.setSize(1000,700);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("ONLINE BANKING ");
			this.setLayout(null);
			this.setLocationRelativeTo(null);
	        this.setResizable(false);        
			
			
	
			 icon = new ImageIcon(getClass().getResource("/image/LOGO1.png"));
		   this.setIconImage(icon.getImage());
		   
		        
        backgroundImg = loadImage("image/regis3.jpg");
        if (backgroundImg == null) {
            System.err.println("Background image not found.");
        }

      
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImg != null) {
                    g.drawImage(backgroundImg.getImage(), 0, 0, getWidth(), getHeight(), null);
                }
            }
        };
        panel.setLayout(null);
        this.setContentPane(panel);
			
			
			
			
			
			
			 rTitle = new JLabel("APPLICATION FORM NO."+random);
			rTitle.setFont(new Font ("Raleway",Font.BOLD,37));
			rTitle.setBounds(200,20,600,80);
			this.add(rTitle);
			
				pTitle = new JLabel("Page 1:personal Details(User) ");
			pTitle.setFont(new Font ("Raleway",Font.BOLD,21));
			pTitle.setBounds(360,70,600,40);
			this.add(pTitle);
			
			
	
					
					
					
					
					//name
				 name = new JLabel("Name:");
			name.setFont(new Font ("Raleway",Font.BOLD,18));
			name.setBounds(100,120,100,40);
			this.add(name);
			
					// father name
			 fName = new JLabel("Father's Name:");
			fName.setFont(new Font ("Raleway",Font.BOLD,18));
			fName.setBounds(100,160,150,40);
			this.add(fName);
			
			
					// Mother name
			 mName = new JLabel("Mother's Name:");
			mName.setFont(new Font ("Raleway",Font.BOLD,18));
			mName.setBounds(100,200,150,40);
			this.add(mName);
			
			
			
			//birthday
			 birth = new JLabel("Date of Birth:");
			birth.setFont(new Font ("Raleway",Font.BOLD,18));
			birth.setBounds(100,240,120,40);
			this.add(birth);

			// gender
			JLabel gender = new JLabel("gender:");
			gender.setFont(new Font ("Raleway",Font.BOLD,18));
			gender.setBounds(100,280,100,40);
			this.add(gender);

			// email
			 mail = new JLabel("Email Address:");
			mail.setFont(new Font ("Raleway",Font.BOLD,18));
			mail.setBounds(100,320,150,40);
			this.add(mail);	



			//  marital status
			JLabel status = new JLabel("Marital Status:");
			status.setFont(new Font ("Raleway",Font.BOLD,18));
			status.setBounds(100,360,150,40);
			this.add(status);
			
			//  nationality
			 nationality = new JLabel("Nationality:");
			nationality.setFont(new Font ("Raleway",Font.BOLD,18));
			nationality.setBounds(100,400,120,40);
			this.add(nationality);
				// blood Group
			 blood = new JLabel("blood Group:");
			blood.setFont(new Font ("Raleway",Font.BOLD,18));
			blood.setBounds(100,440,150,40);
			this.add(blood);	
			// Number
			 number= new JLabel("Mobile Number:");
			number.setFont(new Font ("Raleway",Font.BOLD,18));
			number.setBounds(100,480,150,40);
			this.add(number);	
			
			
			// name
			tName = new JTextField();
			
			tName.setFont(new Font("Raleway",Font.BOLD,16));
			tName.setBounds(250,120,400,30);
			this.add(tName);
			
			
			//father
			tfName = new JTextField();
			
			tfName.setFont(new Font("Raleway",Font.BOLD,16));
			tfName.setBounds(250,160,400,30);
			this.add(tfName);
			
			//mother
			tmName = new JTextField();
			
			tmName.setFont(new Font("Raleway",Font.BOLD,16));
			tmName.setBounds(250,200,400,30);
			this.add(tmName);
			
			// birthday
			
			
			tBirth= new JTextField();
			
			tBirth.setFont(new Font("Raleway",Font.BOLD,16));
			tBirth.setBounds(250,240,200,30);
			this.add(tBirth);
			
			// email
			
			tMail = new JTextField();
			
			tMail.setFont(new Font("Raleway",Font.BOLD,16));
			tMail.setBounds(250,320,400,30);
			this.add(tMail);
			
			
			// Nationality
			
			tNationality = new JTextField();
			
			tNationality.setFont(new Font("Raleway",Font.BOLD,16));
			tNationality.setBounds(250,400,400,30);
			this.add(tNationality);
			
			// Blood Group
			
			tBlood = new JTextField();
			
			tBlood.setFont(new Font("Raleway",Font.BOLD,16));
			tBlood.setBounds(250,440,400,30);
			this.add(tBlood);
			
			// number
			tNumber = new JTextField();
				tNumber.setFont(new Font("Raleway",Font.BOLD,16));
			tNumber.setBounds(250,480,400,30);
			this.add(tNumber);
			
			
			
			
			
			
			
			male = new JRadioButton ("Male");
			male.setBounds(275,290,100,20);
			male.setBackground(Color.decode("#FFFFFF"));
			this.add(male);
			
				
			female = new JRadioButton ("Female");
			female.setBounds(375,290,100,20);
			female.setBackground(Color.decode("#FFFFFF"));
			this.add(female);
					
					
					// status
			single = new JRadioButton ("Single");
			single.setBounds(275,370,100,20);
			single.setBackground(Color.decode("#FFFFFF"));
			this.add(single);
			
				married = new JRadioButton ("Married");
			married.setBounds(375,370,100,20);
			married.setBackground(Color.decode("#FFFFFF"));
			this.add(married);
			
			
			
			// gender group
			
			ButtonGroup genderGroup = new ButtonGroup();
			genderGroup.add(male);
			genderGroup.add(female);
			
			
			// marital Group
			
			ButtonGroup maritalGroup = new ButtonGroup();
			maritalGroup.add(single);
			maritalGroup.add(married);
		
			
			
					
					//next
					next = new JButton("next");
				next.setFont(new Font("Raleway",Font.BOLD,14));
				next.setBounds(880,620,80,30);
				next.setBackground(Color.BLACK);
				next.setForeground(Color.WHITE);
				
						next.addActionListener(new ActionListener() { 
					public void actionPerformed (ActionEvent e)
					{		
					
					
					
						String textName = tName.getText();
						String textFather = tfName.getText();
						String textMother = tmName.getText();
						String textBirth = tBirth.getText();
						String textMail = tMail.getText();
						String textNationality = tNationality.getText();
						String textNumber = tNumber.getText();
						String textBlood = tBlood.getText();
						try{
							
						String textGender = "";
						if(male.isSelected())
						{
							textGender = "Male";
						}
						
						else if(female.isSelected())
						{
							textGender = "Female";
						}
						else{
							textGender = "";
						}
						
						
						String textMarital = "";
						if(single.isSelected())
						{
							textMarital = "Single";
							
						}
						
						else if(married.isSelected())
						{
							
							textMarital= "Married";
					
						}
						else{
							textMarital = "";
						}
						
						if(textName.isEmpty()|| textFather.isEmpty() || textMother.isEmpty() || textBirth.isEmpty()||textBlood.isEmpty()||textNationality.isEmpty()||textNumber.isEmpty()||textMail.isEmpty()||textMarital.isEmpty()||textGender.isEmpty()){			
							
			
							JOptionPane.showMessageDialog(null,"Please Fillup All information");
						}
						
						else
						{
							File file11 = new File("C:\\java\\BANK MANAGEMENT SYSTEM (FINAL)\\Login class\\Data\\user_data.txt");
							
							if(!file11.exists()){
								
								file11.createNewFile();
								
							}
							
							FileWriter fw = new FileWriter(file11,true);
							BufferedWriter bw = new BufferedWriter(fw);
							PrintWriter pw = new PrintWriter(bw);
							
							pw.println("Name = "+textName);
							pw.println("Father's name =  "+textFather);
							pw.println("Mother's name =  "+textMother);
							pw.println("Birthday Date = "+textBirth);
							pw.println("Bolood Group = "+textBlood);
							pw.println(" Email = "+textMail);
							pw.println("Nationality = "+textNationality);
							pw.println("Mobile Number = "+textNumber);
							pw.println("Gender = "+textGender);
							pw.println("Status "+textMarital);
							
							
							
							pw.println("'''''''''''''''''Username and paasword of "+textName+ " given below down'''''''''''''''''''''''");
							
							pw.close();
							
							
							
							
							
							
							
							setVisible(false);
						Register2 siginup2 = new Register2 ();
						siginup2.setVisible(true);
							
						}
						}
						catch(Exception ex){
							System.out.println(ex);
						}
						
						
						
						
						/*setVisible(false);
						Register2 siginup2 = new Register2 ();
						siginup2.setVisible(true);
						*/
					}
					} );
				this.add(next);
				
				
			//back
					back = new JButton("Back");
				back.setFont(new Font("Raleway",Font.BOLD,14));
				back.setBounds(0,0,80,30);
				back.setBackground(Color.BLACK);
				back.setForeground(Color.WHITE);
					back.addActionListener(new ActionListener(){
						
						public void actionPerformed(ActionEvent ae)
						{
							setVisible(false);
							Login frame = new Login();
							frame.setVisible(true);
							
						}
					}
					);		
				
				
				this.add(back);
				
				
			
			
			
			
			
			
			
			
		}
		
		
    private ImageIcon loadImage(String path) {
        ImageIcon img = new ImageIcon(getClass().getResource(path));
        if (img.getIconWidth() == -1) { 
            return null;
        }
        return img;
    }
		



	public static  void main (String [] args)
	{
		Register signup = new Register();
		
		signup.setVisible(true);
		
		
	}

}