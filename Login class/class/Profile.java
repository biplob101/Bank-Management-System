
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;


						


public class Profile extends JFrame
{	



	private ImageIcon icon,backgroundImg;
	
	
	 private String name11,father11,mother11,birth11,blood11,email11,nationality11,gender11,status11,type,number11;
	
	
	private JLabel name, fName,mName, birth,gender,mail,status,nationality, blood ,number,pTitle,bank,under,accout;
	 
	  
	  private JButton back;
	  
	  
			
		private String textUser;
	
		// file line
		private int a;
		
		Profile(int a,String textUser )
		{
			this.a= a;
			this.textUser= textUser;
				
			
			
			
			
		
			
			
			
			
			this.setSize(1000,700);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("ONLINE BANKING ");
			this.setLayout(null);
			this.setLocationRelativeTo(null);
	        this.setResizable(false);        
			
			
			
			 icon = new ImageIcon(getClass().getResource("/image/LOGO1.png"));
		   this.setIconImage(icon.getImage());
		   
		   
		   
		    backgroundImg = loadImage("image/pic8.jpg");
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
			
			
			bank = new JLabel("BB BANK");
			bank.setFont(new Font("Serif Bold Italic",Font.BOLD,42));
			bank.setBounds(400,20,400,40);
			this.add(bank);
			
			
			pTitle = new JLabel("User Personal Information");
		     pTitle.setFont(new Font("Serif Bold Italic",Font.BOLD,22));
			pTitle.setBounds(370,60,400,40);
			this.add(pTitle);
			
			
			under = new JLabel("____________________________________________");
			
			under.setBounds(370,65,400,40);
			this.add(under);
			
		
			
			
			
			
		try{	
			//  file reading.........
			
			name11 = Files.readAllLines(Paths.get("C:\\java\\BANK MANAGEMENT SYSTEM (FINAL)\\Login class\\Data\\user_data.txt")).get(a-11);
			father11 = Files.readAllLines(Paths.get("C:\\java\\BANK MANAGEMENT SYSTEM (FINAL)\\Login class\\Data\\user_data.txt")).get(a-10);
			mother11 = Files.readAllLines(Paths.get("C:\\java\\BANK MANAGEMENT SYSTEM (FINAL)\\Login class\\Data\\user_data.txt")).get(a-9);
			birth11 = Files.readAllLines(Paths.get("C:\\java\\BANK MANAGEMENT SYSTEM (FINAL)\\Login class\\Data\\user_data.txt")).get(a-8);
			blood11 = Files.readAllLines(Paths.get("C:\\java\\BANK MANAGEMENT SYSTEM (FINAL)\\Login class\\Data\\user_data.txt")).get(a-7);
			email11 = Files.readAllLines(Paths.get("C:\\java\\BANK MANAGEMENT SYSTEM (FINAL)\\Login class\\Data\\user_data.txt")).get(a-6);
			nationality11 = Files.readAllLines(Paths.get("C:\\java\\BANK MANAGEMENT SYSTEM (FINAL)\\Login class\\Data\\user_data.txt")).get(a-5);
			number11 = Files.readAllLines(Paths.get("C:\\java\\BANK MANAGEMENT SYSTEM (FINAL)\\Login class\\Data\\user_data.txt")).get(a-4);
			 gender11= Files.readAllLines(Paths.get ("C:\\java\\BANK MANAGEMENT SYSTEM (FINAL)\\Login class\\Data\\user_data.txt")).get(a-3);
			status11 = Files.readAllLines(Paths.get("C:\\java\\BANK MANAGEMENT SYSTEM (FINAL)\\Login class\\Data\\user_data.txt")).get(a-2);
			type = Files.readAllLines(Paths.get("C:\\java\\BANK MANAGEMENT SYSTEM (FINAL)\\Login class\\Data\\user_data.txt")).get(a+2);
			
			
		}
		
		catch (Exception ex)
		{
			System.out.println(ex);
			
		}
			
			
			
			
			
			
			
			
			
			
			
			
					
					
					
					
					//name
				 name = new JLabel(name11);
			name.setFont(new Font ("Raleway",Font.BOLD,18));
			name.setBounds(100,120,400,40);
			this.add(name);
			
					// father name
			 fName = new JLabel(father11);
			fName.setFont(new Font ("Raleway",Font.BOLD,18));
			fName.setBounds(100,160,400,40);
			this.add(fName);
			
			
					// Mother name
			 mName = new JLabel(mother11);
			mName.setFont(new Font ("Raleway",Font.BOLD,18));
			mName.setBounds(100,200,400,40);
			this.add(mName);
			
			
			
			//birthday
			 birth = new JLabel(birth11);
			birth.setFont(new Font ("Raleway",Font.BOLD,18));
			birth.setBounds(100,240,400,40);
			this.add(birth);

			// gender
			 gender = new JLabel(gender11);
			gender.setFont(new Font ("Raleway",Font.BOLD,18));
			gender.setBounds(100,280,400,40);
			this.add(gender);

			// email
			 mail = new JLabel(email11);
			mail.setFont(new Font ("Raleway",Font.BOLD,18));
			mail.setBounds(100,320,400,40);
			this.add(mail);	



			//  marital status
			 status = new JLabel(status11);
			status.setFont(new Font ("Raleway",Font.BOLD,18));
			status.setBounds(100,360,400,40);
			this.add(status);
			
			//  nationality
			 nationality = new JLabel(nationality11);
			nationality.setFont(new Font ("Raleway",Font.BOLD,18));
			nationality.setBounds(100,400,400,40);
			this.add(nationality);
				// blood Group
			 blood = new JLabel(blood11);
			blood.setFont(new Font ("Raleway",Font.BOLD,18));
			blood.setBounds(100,440,400,40);
			this.add(blood);	
			// Number
			 number= new JLabel(number11);
			number.setFont(new Font ("Raleway",Font.BOLD,18));
			number.setBounds(100,480,400,40);
			this.add(number);


			//accout type
			accout= new JLabel(type);
			accout.setFont(new Font ("Raleway",Font.BOLD,18));
			accout.setBounds(100,520,400,40);
			this.add(accout);			
			
		
			
	
		
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
					new UserDashboard(textUser, a, new double[0]).setVisible(true); 

						
							
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
		Profile signup = new Profile(0,"");
		
		signup.setVisible(true);
		
		
	}

}