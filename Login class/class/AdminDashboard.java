
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AdminDashboard extends JFrame {

    private ImageIcon icon, backgroundImg;
    private JButton profile, back;
    private JLabel lName, lTitle1, lTitle2, under, lPass;
    private JPasswordField passwordField;
    private String textUser, textPass;
    private int a;

    AdminDashboard(String textUser, int a) {
        this.textUser = textUser;
        this.a = a;

        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ONLINE BANKING ");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Icon image
        icon = new ImageIcon(getClass().getResource("/image/LOGO1.png"));
        this.setIconImage(icon.getImage());

        backgroundImg = loadImage("image/money4.jpg");
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

        // Label
        lName = new JLabel("Username:" + textUser);
        lName.setFont(new Font("osward", Font.BOLD, 19));
        lName.setBounds(750, 30, 250, 30);
        this.add(lName);

        lTitle1 = new JLabel("Admin Dashboard");
        lTitle1.setFont(new Font("osward", Font.BOLD, 28));
        lTitle1.setBounds(350, 100, 250, 40);
        this.add(lTitle1);

        lTitle2 = new JLabel("BB BANK");
        lTitle2.setFont(new Font("Serif Bold Italic", Font.BOLD, 45));
        lTitle2.setBounds(350, 30, 400, 40);
        this.add(lTitle2);

        under = new JLabel("_______________");
        under.setFont(new Font("osward", Font.BOLD, 28));
        under.setBounds(348, 100, 250, 40);
        this.add(under);

        // Profile button
        profile = new JButton("Profile");
        profile.setBounds(420, 210, 80, 40);
        profile.setBackground(Color.BLACK);
        profile.setForeground(Color.WHITE);
        profile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AdminProfile(a, textUser).setVisible(true);
            }
        });
        this.add(profile);

        // Back button
        back = new JButton("Back");
        back.setFont(new Font("Raleway", Font.BOLD, 14));
        back.setBounds(0, 0, 80, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                AdminLogin frame = new AdminLogin();
                frame.setVisible(true);
            }
        });
        this.add(back);
    }

    // Method to load an image
    private ImageIcon loadImage(String path) {
        ImageIcon img = new ImageIcon(getClass().getResource(path));
        if (img.getIconWidth() == -1) { // Check if image was loaded correctly
            return null;
        }
        return img;
    }

    public static void main(String[] args) {
        AdminDashboard userFrame = new AdminDashboard("", 0);
        userFrame.setVisible(true);
    }
}
