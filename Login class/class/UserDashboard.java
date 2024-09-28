import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.nio.file.*;
import java.util.List;

public class UserDashboard extends JFrame {
    
    private ImageIcon icon,backgroundImg;
    
    
    private JButton deposit, withdraw, checkBalance, logout, profile, transfer, back;
    private JLabel welcomeLabel, lTitle1, lTitle2, under;
    
    private String textUser, pass11;
    private int a;
    private double[] money;  

    public UserDashboard(String textUser, int a, double[] money) {
        this.textUser = textUser;
        this.a = a;
        this.money = money;  

       
        try {
            List<String> lines = Files.readAllLines(Paths.get("C:\\java\\BANK MANAGEMENT SYSTEM (FINAL)\\Login class\\Data\\user_data.txt"));
            pass11 = lines.get(a + 1);
        } catch (Exception ex) {
            System.out.println("Error reading user data: " + ex.getMessage());
        }

        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("User Dashboard");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        // Icon image
        icon = new ImageIcon(getClass().getResource("/image/LOGO1.png"));
        this.setIconImage(icon.getImage());
        
        backgroundImg = loadImage("image/pic2.jpg");
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
        
        // Welcome label
        welcomeLabel = new JLabel("Welcome, " + textUser);
        welcomeLabel.setFont(new Font("osward", Font.BOLD, 19));
        welcomeLabel.setBounds(750, 30, 250, 30);
        this.add(welcomeLabel);
		
        // Dashboard Title
        lTitle1 = new JLabel("User Dashboard");
        lTitle1.setFont(new Font("osward", Font.BOLD, 28));
        lTitle1.setBounds(350, 100, 250, 40);
        this.add(lTitle1);
        
        // Bank Title
        lTitle2 = new JLabel("BB BANK");
        lTitle2.setFont(new Font("Serif Bold Italic", Font.BOLD, 45));
        lTitle2.setBounds(350, 30, 400, 40);
        this.add(lTitle2);

        // Underline for dashboard title
        under = new JLabel("______________");
        under.setFont(new Font("osward", Font.BOLD, 28));
        under.setBounds(348, 100, 250, 40);
        this.add(under);
        
        // Profile button
        profile = new JButton("Profile");
        profile.setBounds(420, 210, 80, 40);
        profile.setBackground(Color.BLACK);
        profile.setForeground(Color.WHITE);
        profile.addActionListener(e -> {
            setVisible(false);
            Profile profileScreen = new Profile(a, textUser);
            profileScreen.setVisible(true);
        });
        this.add(profile);

        // Deposit button
        deposit = new JButton("Deposit");
        deposit.setBounds(170, 300, 100, 40);
        deposit.setBackground(Color.BLACK);
        deposit.setForeground(Color.WHITE);
        deposit.addActionListener(e -> {
            setVisible(false);
            new Deposit(textUser, a, money).setVisible(true); 
        });
        this.add(deposit);
        
        // Withdraw button
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(320, 300, 100, 40);
        withdraw.setBackground(Color.BLACK);
        withdraw.setForeground(Color.WHITE);
        withdraw.addActionListener(e -> {
            setVisible(false);
            new Withdraw(textUser, a, money).setVisible(true); 
        });
        this.add(withdraw);
		
        // Transfer button
        transfer = new JButton("Transfer");
        transfer.setBounds(470, 300, 100, 40);
        transfer.setBackground(Color.BLACK);
        transfer.setForeground(Color.WHITE);
        transfer.addActionListener(e -> {
            setVisible(false);
            new Transfer(textUser, a, money).setVisible(true); 
        });
        this.add(transfer);
        
        // Check Balance button
        checkBalance = new JButton("Check Balance");
        checkBalance.setBounds(620, 300, 150, 40);
        checkBalance.setBackground(Color.BLACK);
        checkBalance.setForeground(Color.WHITE);
        // On click, open the Balance window
        checkBalance.addActionListener(e -> {
            setVisible(false); // Hide UserDashboard
            new Balance(textUser, a, money).setVisible(true); 
        });
        this.add(checkBalance);
        
        // Logout button
        logout = new JButton("Logout");
        logout.setBounds(170, 360, 100, 40);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(e -> System.exit(0));
        this.add(logout);
		
        // Back button
        back = new JButton("Back");
        back.setFont(new Font("Raleway", Font.BOLD, 14));
        back.setBounds(0, 0, 80, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(e -> {
            setVisible(false);
            Login loginFrame = new Login();
            loginFrame.setVisible(true);
        });
        this.add(back);
    }


        private ImageIcon loadImage(String path) {
        ImageIcon img = new ImageIcon(getClass().getResource(path));
        if (img.getIconWidth() == -1) { 
            return null;
        }
        return img;
    }
		


    public static void main(String[] args) {
        double[] initialBalance = {500.0}; 
        UserDashboard dashboardFrame = new UserDashboard("TestUser", 0, initialBalance);
        dashboardFrame.setVisible(true);
    }
}
