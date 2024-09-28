

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.io.*;






public class AdminRegister2 extends JFrame
{	



	private ImageIcon icon,backgroundImg;
	
	
	
	
	  private JLabel rTitle,pTitle,username,userpassword;	
	  private JTextField tUser,tPass;
	  
	  private JButton registration,back;
	  
	
		
		
		AdminRegister2()
		{
			this.setSize(1000,700);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("ONLINE BANKING ");
			this.setLayout(null);
			this.setLocationRelativeTo(null);
	        this.setResizable(false);        
			
			
			
			 icon = new ImageIcon(getClass().getResource("/image/LOGO1.png"));
		   this.setIconImage(icon.getImage());
		   
			  backgroundImg = loadImage("image/user.jpg");
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
			
				pTitle = new JLabel("Page 2:Account Details(Admin) ");
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
			
			
				
			
			

			


	
			
		
	
			
			// username
			tUser = new JTextField();
			
			tUser.setFont(new Font("Raleway",Font.BOLD,16));
			tUser.setBounds(300,220,250,30);
			this.add(tUser);
			
			
			// password
			tPass = new JTextField();
			
			tPass.setFont(new Font("Raleway",Font.BOLD,16));
			tPass.setBounds(300,260,250,30);
			this.add(tPass);
			
		
			
	
	
		
			
			
			
		
			
			
		
		
				
			
			
		
			
			
			
			
			
					
					//registration
					registration = new JButton("Registration");
				registration.setFont(new Font("Raleway",Font.BOLD,14));
				registration.setBounds(820,620,150,30);
				registration.setBackground(Color.BLACK);
				registration.setForeground(Color.WHITE);
				registration.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae)
						{
							String user1 = tUser.getText();
						String  pass1 = tPass.getText();
						
						try{
							
					
						
						
						
						if( user1.isEmpty() || pass1.isEmpty() ){			
							
							JOptionPane.showMessageDialog(null,"Please Fillup All information");
						}
						
						else
						{
							File file1 = new File("C:\\java\\BANK MANAGEMENT SYSTEM (FINAL)\\Login class\\Data\\admin_data.txt");
							
							if(!file1.exists())
							{
								file1.createNewFile();
							}
							FileWriter fw = new FileWriter(file1,true);
							BufferedWriter bw = new BufferedWriter(fw);
							PrintWriter pw = new PrintWriter(bw);
							
							
					
							
							pw.println("Admin UserName = "+user1 );
							pw.println("Admin Password = "+pass1 );
							
							
						
							
							pw.println("=========================================================" );
							pw.close();
							
							
			JOptionPane.showMessageDialog(null,"Registration complete");
				setVisible(false);
				AdminLogin adminFrame = new AdminLogin();
							adminFrame.setVisible(true);
			
			
						}
						}
						catch(Exception ex){
							System.out.println(ex);
						}
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
							AdminRegister adminSignup = new AdminRegister();
							adminSignup.setVisible(true);
							
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
		AdminRegister2 adminSignup2 = new AdminRegister2();
		
		adminSignup2.setVisible(true);
		
		
	}

}
