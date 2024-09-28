import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Balance extends JFrame{
	
	private ImageIcon icon, backgroundImg;

	
	private JButton back, ok;
	private JLabel amount, lName, lTitle1, lTitle2, under;
	
	private String textUser;
	private int a;
	private double[] money; // Use money as an array to be consistent with UserDashboard

	Balance(String textUser, int a, double[] money) {
		this.textUser = textUser;
		this.a = a;
		this.money = money;
		
		this.setSize(900,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("ONLINE BANKING");
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);                   

		// Icon image
		icon = new ImageIcon(getClass().getResource("/image/LOGO1.png"));
		this.setIconImage(icon.getImage());
		
		 backgroundImg = loadImage("image/money5.jpg");
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
			
		// Bank Title
		lTitle2 = new JLabel("BB BANK");			
		lTitle2.setFont(new Font("Serif Bold Italic", Font.BOLD, 45));
		lTitle2.setBounds(350, 30, 400, 40);
		this.add(lTitle2);

		// Balance Title
		lTitle1 = new JLabel("      Balance");
		lTitle1.setFont(new Font("osward", Font.BOLD, 28));
		lTitle1.setBounds(350, 100, 250, 40);
		this.add(lTitle1);
			
		under = new JLabel("      ________");
		under.setFont(new Font("osward", Font.BOLD, 28));
		under.setBounds(348, 100, 250, 40);
		this.add(under);
			
		// Username label
		lName = new JLabel("Username: " + textUser);
		lName.setFont(new Font("osward", Font.BOLD, 19));
		lName.setBounds(250, 200, 250, 30);
		this.add(lName);
			
		// Balance label
		amount = new JLabel("Balance: " + money[0]);
		amount.setFont(new Font("osward", Font.BOLD, 19));
		amount.setBounds(250, 250, 250, 30);
		this.add(amount);
			
		// OK button to return to UserDashboard
		ok = new JButton("Ok");
		ok.setFont(new Font("Raleway", Font.BOLD, 14));
		ok.setBounds(400, 300, 80, 30);
		ok.setBackground(Color.BLACK);
		ok.setForeground(Color.WHITE);
		ok.addActionListener(e -> {
			setVisible(false);
			new UserDashboard(textUser, a, money).setVisible(true); // Pass money array
		});
		this.add(ok);

		// Back button to return to UserDashboard
		back = new JButton("Back");
		back.setFont(new Font("Raleway", Font.BOLD, 14));
		back.setBounds(0, 0, 80, 30);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(e -> {
			setVisible(false);
			new UserDashboard(textUser, a, money).setVisible(true); // Pass money array
		});
		this.add(back);
	}
	
	
	
    private ImageIcon loadImage(String path) {
        ImageIcon img = new ImageIcon(getClass().getResource(path));
        if (img.getIconWidth() == -1) { // Check if image was loaded correctly
            return null;
        }
        return img;
    }
	

	public static void main(String[] args) {
		double[] initialBalance = {500.0}; // Example balance
		Balance balanceFrame = new Balance("TestUser", 0, initialBalance);
		balanceFrame.setVisible(true);
	}
}
