import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Login extends JFrame {

    private ImageIcon icon, backgroundImg;
    
    private JButton login, register, about, clear, admin;
    private JLabel lname, lpassword, title;
    private JTextField nameField;
    private JPasswordField passwordField;

    private int a;  
    private double[] balance = {500.0};  

    public Login() {
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ONLINE BANKING");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

  
        icon = loadImage("image/LOGO1.png");
        if (icon != null) {
            this.setIconImage(icon.getImage());
        } else {
            System.err.println("Icon image not found.");
        }

     
        backgroundImg = loadImage("image/log1.jpg");
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

        // Username label
        lname = new JLabel("UserName:");
        lname.setFont(new Font("osward", Font.BOLD, 22));
		lname.setForeground(Color.BLACK);
        lname.setBounds(200, 145, 250, 40);
        panel.add(lname);

        // Password label
        lpassword = new JLabel("Password:");
        lpassword.setFont(new Font("osward", Font.BOLD, 22));
		lpassword.setForeground(Color.BLACK);
        lpassword.setBounds(200, 185, 250, 40);
        panel.add(lpassword);

        // Title label
        title = new JLabel("BB BANK");
        title.setFont(new Font("Serif Bold Italic", Font.BOLD, 42));
        title.setBounds(250, 70, 400, 40);
        panel.add(title);

        // Username field
        nameField = new JTextField();
        nameField.setBounds(330, 150, 150, 30);
        nameField.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(nameField);

        // Password field
        passwordField = new JPasswordField();
        passwordField.setBounds(330, 190, 150, 30);
        panel.add(passwordField);

        // Login button
        login = new JButton("Login");
        login.setBounds(170, 240, 90, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String textUser = nameField.getText();
                String textPass = new String(passwordField.getPassword());

                if (textUser.isEmpty() || textPass.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Fill All Fields");
                } else {
                    try {
                        String userNames = "UserName = " + textUser;
                        String userPasswords = "Password = " + textPass;
                        BufferedReader reader = new BufferedReader(new FileReader("C:\\java\\BANK MANAGEMENT SYSTEM (FINAL)\\Login class\\Data\\user_data.txt"));

                        int totalLines = 0;
                        while (reader.readLine() != null) totalLines++;

                        reader.close();

                        for (int i = 0; i <= totalLines; i++) {
                            String line = Files.readAllLines(Paths.get("C:\\java\\BANK MANAGEMENT SYSTEM (FINAL)\\Login class\\Data\\user_data.txt")).get(i);

                            if (line.equals(userNames)) {
                                String line2 = Files.readAllLines(Paths.get("C:\\java\\BANK MANAGEMENT SYSTEM (FINAL)\\Login class\\Data\\user_data.txt")).get(i + 1);

                                if (line2.equals(userPasswords)) {
                                    a = i;  // Set the user index
                                    setVisible(false);
                                    // Pass the username, user index, and balance to the UserDashboard
                                    new UserDashboard(textUser, a, balance).setVisible(true);
                                    break;
                                }
                            }
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Incorrect username or password");
                    }
                }
            }
        });
        panel.add(login);

        // Clear button
        clear = new JButton("Clear");
        clear.setBounds(310, 240, 90, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                passwordField.setText("");
            }
        });
        panel.add(clear);

        // Register button
        register = new JButton("Register");
        register.setBounds(440, 240, 90, 30);
        register.setBackground(Color.BLACK);
        register.setForeground(Color.WHITE);
        register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Register().setVisible(true);  // Open registration window
            }
        });
        panel.add(register);

        // About button
        about = new JButton("About Us");
        about.setBounds(690, 410, 90, 30);
        about.setBackground(Color.BLACK);
        about.setForeground(Color.WHITE);
        about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new About().setVisible(true);
            }
        });
        panel.add(about);

        // Admin button
        admin = new JButton("Admin Login");
        admin.setBounds(0, 0, 150, 30);
        admin.setBackground(Color.BLACK);
        admin.setForeground(Color.WHITE);
        admin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AdminLogin().setVisible(true);
            }
        });
        panel.add(admin);
    }

    // Method to load images
    private ImageIcon loadImage(String path) {
        ImageIcon img = new ImageIcon(getClass().getResource(path));
        if (img.getIconWidth() == -1) { // Check if image was loaded correctly
            return null;
        }
        return img;
    }

    public static void main(String[] args) {
        Login frame = new Login();
        frame.setVisible(true);
    }
}
