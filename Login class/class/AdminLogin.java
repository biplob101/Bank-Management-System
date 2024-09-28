
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;


public class AdminLogin extends JFrame 

{
	private ImageIcon icon, backgroundImg;
	
	private JButton name,password,about,clear,back,login,register;
	private JLabel lname,lpassword,title,image1;
	private JTextField nameField;
	private JPasswordField passwordField;
	
	
		private  int a;
	
	   AdminLogin(){
			
			this.setSize(800,500);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("ONLINE BANKING ");
			this.setLayout(null);
			this.setLocationRelativeTo(null);
	        this.setResizable(false);                   
	   
	   
	   

	   
	   
	     //icon image 
		   
		   icon = new ImageIcon(getClass().getResource("/image/LOGO1.png"));
		   this.setIconImage(icon.getImage());
		   
		     backgroundImg = loadImage("image/pic4.jpg");
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


		
		 
	
			//  name label part
			
			
			
		    lname	= new JLabel ("Admin Username:");
			lname.setFont(new Font("osward",Font.BOLD,22));
			lname.setBounds(150,145,250,40);
			this.add(lname);
			// password label part
			
			
			
			lpassword = new JLabel ("password:");
			lpassword.setFont(new Font("osward",Font.BOLD,22));
			lpassword.setBounds(200,185,250,40);
			this.add(lpassword);
			// title label part
			
			
		    title = new JLabel("BB BANK(Admin)");			
			title.setFont(new Font("Serif Bold Italic",Font.BOLD,42));
			title.setBounds(250,70,400,40);
			this.add(title);
			//  name TEXT Field part
			
			
		    nameField = new JTextField();
			nameField.setBounds(360,150,150,30);
			nameField.setFont(new Font("Arial",Font.BOLD,14));
			this.add(nameField);
			
			//password Text field part
			
			
			
		    passwordField = new JPasswordField();	
			passwordField.setBounds(360,190,150,30);
			this.add(passwordField);
			
			
			// Login button part
			
			
			
			 login = new JButton("Login");
			login.setBounds(170,240,90,30);
			login.setBackground(Color.BLACK);
			login.setForeground(Color.WHITE);
			
					login.addActionListener(new ActionListener() { 
					public void actionPerformed (ActionEvent e)
					{
						String textUser = nameField.getText();
						String textPass = passwordField.getText();
						
						
						if(textUser.isEmpty()||textPass.isEmpty())
						{
							JOptionPane.showMessageDialog(null,"Please Fill All Field");
						}
						else{
							
							
							try{
								
								
								String userNames = "Admin UserName = " +textUser;
								String userPasswords= "Admin Password = "+textPass;
								BufferedReader reader = new BufferedReader(new FileReader("C:\\java\\BANK MANAGEMENT SYSTEM (FINAL)\\Login class\\Data\\admin_data.txt"));
								
								
								
								int totalLines = 0;
								
								while(reader.readLine()!=null)
									totalLines++;
								
								
									reader.close();
									
								for(int i= 0 ; i<=totalLines;i++)
								{
								String line = Files.readAllLines(Paths.get("C:\\java\\BANK MANAGEMENT SYSTEM (FINAL)\\Login class\\Data\\admin_data.txt")).get(i);
										
															
															
									   if(line.equals(userNames)){

										  String line2 = Files.readAllLines(Paths.get("C:\\java\\BANK MANAGEMENT SYSTEM (FINAL)\\Login class\\Data\\admin_data.txt")).get(i+1);
										   
										   if(line2.equals(userPasswords)){
											   
											  a=i;
											   		
						
																setVisible(false);
														new AdminDashboard (textUser,a).setVisible(true);
		
															
															
															break;
						
					   
										   }
										   
									   }
									
									
								}
							
								
								
								
								
								
								
							}
							
							catch(Exception ex)
							{
								JOptionPane.showMessageDialog(null,"Incorrect username or Password");
								
							}
							
							
							
							
							
							
							
						}
						

						
						
				
						
					}
					} );
						
				
					
			
			
			
			
			
			
			this.add(login);
									
			// claer button part
			
			
			 clear = new JButton("Clear");
			clear.setBounds(310,240,90,30);
			clear.setBackground(Color.BLACK);
			clear.setForeground(Color.WHITE);
			
			
						clear.addActionListener(new ActionListener() { 
					public void actionPerformed (ActionEvent e)
					{
						nameField.setText("");
						passwordField.setText("");
						
						
						JOptionPane.showMessageDialog(null,"clear");
						
					}
					} );
			
			this.add(clear);
			
			
			
			// register button 
			
			
			 register = new JButton("Register");
			register.setBounds(440,240,90,30);
			register.setBackground(Color.BLACK);
			register.setForeground(Color.WHITE);
			
				register.addActionListener(new ActionListener() { 
					public void actionPerformed (ActionEvent e)
					{
						
						String a = "0000";
						 String name1 = JOptionPane.showInputDialog(null,"Enter Admin secret code:","Question",1);
						
						
						if(name1.equals(a))
						{
						setVisible(false);
						
						
						AdminRegister adminSignup = new AdminRegister();
						
						adminSignup.setVisible(true);
						}
						else{
							JOptionPane.showMessageDialog(null,"Wrong secret code.... Please try again");
						}
						
					}
					} );
					
					
					
			this.add(register);
			
			
			// about button part
			
			 about = new JButton("about us");
			 about.setBounds(690,410,90,30);
			about.setBackground(Color.BLACK);
			about.setForeground(Color.WHITE);
			
					about.addActionListener(new ActionListener() { 
					public void actionPerformed (ActionEvent e)
					{	
							setVisible(false);
						  new About2().setVisible(true);
					}
					} );
					
					
					
			
			this.add(about);
			
			
			
			
			
			 //back button part
			 back = new JButton("Back");
			back.setBounds(0,0,150,30);
			back.setBackground(Color.BLACK);
			back.setForeground(Color.WHITE);
			
			
				back.addActionListener(new ActionListener() { 
					public void actionPerformed (ActionEvent e)
					{
						setVisible(false);
						
						Login frame = new Login();
						
						frame.setVisible(true);
						
					}
					} );
			
			
			
			this.add(back);
			
			
                 }
				 
				 
				 // Method to load images
         private ImageIcon loadImage(String path) {
        ImageIcon img = new ImageIcon(getClass().getResource(path));
        if (img.getIconWidth() == -1) { // Check if image was loaded correctly
            return null;
        }
        return img;
    }
			
				public static void main (String[] args)
		{
		
		
		
		AdminLogin adminFrame = new AdminLogin ();
		
			adminFrame.setVisible(true);
			

		}
		
		
}
