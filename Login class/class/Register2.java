
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Register2 extends JFrame
{	
   private ImageIcon icon,backgroundImg;
	
	  
	  private JLabel rTitle,pTitle,username,userpassword,accountType;	
	  private JTextField tusername,tPass;
	  private JRadioButton current,savings;
	  private JButton registration,back;
	  
	
		
		
		Register2()
		{
			this.setSize(1000,700);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("ONLINE BANKING ");
			this.setLayout(null);
			this.setLocationRelativeTo(null);
	        this.setResizable(false);        
			
			
			 icon = new ImageIcon(getClass().getResource("/image/LOGO1.png"));
		   this.setIconImage(icon.getImage());
		   
		             
        backgroundImg = loadImage("image/bp1.jpg");
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
			
			
			
			 rTitle = new JLabel("BB BANK");
			rTitle.setFont(new Font ("Raleway",Font.BOLD,37));
			rTitle.setBounds(400,20,600,40);
			this.add(rTitle);
			
				pTitle = new JLabel("Page 2:Account Details(User) ");
			pTitle.setFont(new Font ("Raleway",Font.BOLD,21));
			pTitle.setBounds(360,70,600,40);
			this.add(pTitle);
			
			
					
					
					
					
					//username
				 username = new JLabel("Username:");
			username.setFont(new Font ("Raleway",Font.BOLD,18));
			username.setBounds(200,220,150,30);
			this.add(username);
			
					// password
			 userpassword = new JLabel(" Password:");
			userpassword.setFont(new Font ("Raleway",Font.BOLD,18));
			userpassword.setBounds(200,260,150,30);
			this.add(userpassword);

			// accountType
			accountType = new JLabel("Account Type:");
			accountType.setFont(new Font ("Raleway",Font.BOLD,18));
			accountType.setBounds(200,300,150,40);
			this.add(accountType);
			
			// username
			tusername = new JTextField();
			
			tusername.setFont(new Font("Raleway",Font.BOLD,16));
			tusername.setBounds(300,220,250,30);
			this.add(tusername);
			
			
			// password
			tPass = new JTextField();
			
			tPass.setFont(new Font("Raleway",Font.BOLD,16));
			tPass.setBounds(300,260,250,30);
			this.add(tPass);
			
		
			
	
	
		
			
			
			
			
			
			
		
		
						// accountType
			
				current = new JRadioButton ("Current Account");
			current.setBounds(350,305,150,30);
			current.setBackground(Color.decode("#FFFFFF"));
			this.add(current);
			
			
				savings = new JRadioButton ("Savings Account");
			savings.setBounds(500,305,150,30);
			savings.setBackground(Color.decode("#FFFFFF"));
			this.add(savings);
			
			
		
			
			
			// accountType group
			
				ButtonGroup accountTypeGroup = new ButtonGroup();
			accountTypeGroup.add(current);
			accountTypeGroup.add(savings);
			
			
			
					
					//registration
					registration = new JButton("Registration");
				registration.setFont(new Font("Raleway",Font.BOLD,14));
				registration.setBounds(820,620,150,30);
				registration.setBackground(Color.BLACK);
				registration.setForeground(Color.WHITE);
				
				registration.addActionListener(new ActionListener(){
						
						public void actionPerformed(ActionEvent ae)
						{
						
					
					
						String user1 = tusername.getText();
						String  pass1 = tPass.getText();
						
						try{
							
						String acc1 = "";
						if(current.isSelected())
						{
									acc1 = "Current Account";
						}
						
						else if(savings.isSelected())
						{
							acc1 = "savings Account";
						}
						else{
							acc1 = "";
						}
						
						
						
						
						if( user1.isEmpty() || acc1.isEmpty() || pass1.isEmpty()){			
							
							JOptionPane.showMessageDialog(null,"Please Fillup All information");
						}
						
						else
						{
							
							File file = new File("C:\\java\\BANK MANAGEMENT SYSTEM (FINAL)\\Login class\\Data\\user_data.txt");
							
							if(!file.exists())
							{
								file.createNewFile();
							}
							FileWriter fw = new FileWriter(file,true);
							BufferedWriter bw = new BufferedWriter(fw);
							PrintWriter pw = new PrintWriter(bw);
							
							
					
							
							pw.println("UserName = "+user1 );
							pw.println("Password = "+pass1 );
							pw.println("Accout Type  = "+acc1 );
														
							
	
							
							pw.println("=========================================================" );
							pw.close();
							
			
							
							JOptionPane.showMessageDialog(null,"Registration complete");
							
							setVisible(false);
							
							Login frame = new Login ();
		
							frame.setVisible(true);
						}
						}
						catch(Exception ex){
							System.out.println(ex);
						}
						
						
						
							
							/*setVisible(false);
							Login frame = new Login();
							frame.setVisible(true);
							*/
						}
					}
					);
				
				this.add(registration);
				
				
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
							Register signup = new Register();
							signup.setVisible(true);
							
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
		Register2 signup = new Register2();
		
		signup.setVisible(true);
		
		
	}

}
