import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.nio.file.*;

public class Transfer extends JFrame {
	
    private ImageIcon icon, backgroundImg ;
    private JButton back, ok;
    private JLabel amount, lName, lTitle1, lTitle2, under, pin, lnum;
    private JTextField amount1, number, pin11;

    private String textUser, pass11;
    private int a;
    private double[] money;  

    Transfer(String textUser, int a, double[] money) {  
        this.textUser = textUser;
        this.a = a;
        this.money = money;

        // Read user data
        try {
            pass11 = Files.readAllLines(Paths.get("C:\\java\\BANK MANAGEMENT SYSTEM (FINAL)\\Login class\\Data\\user_data.txt")).get(a + 1);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        this.setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ONLINE BANKING ");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Icon image
        icon = new ImageIcon(getClass().getResource("/image/LOGO1.png"));
        this.setIconImage(icon.getImage());

         
        backgroundImg = loadImage("image/transfer5.jpg");
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

        // Labels
        lTitle2 = new JLabel("BB BANK");
        lTitle2.setFont(new Font("Serif Bold Italic", Font.BOLD, 45));
        lTitle2.setBounds(350, 30, 400, 40);
        this.add(lTitle2);

        lTitle1 = new JLabel("      Transfer   ");
        lTitle1.setFont(new Font("osward", Font.BOLD, 28));
        lTitle1.setBounds(350, 100, 250, 40);
        this.add(lTitle1);

        under = new JLabel("      ________");
        under.setFont(new Font("osward", Font.BOLD, 28));
        under.setBounds(348, 100, 250, 40);
        this.add(under);

        lName = new JLabel("Username:     " + textUser);
        lName.setFont(new Font("osward", Font.BOLD, 19));
        lName.setBounds(250, 250, 250, 30);
        this.add(lName);

        lnum = new JLabel("                  Transfer To :");
        lnum.setFont(new Font("osward", Font.BOLD, 19));
        lnum.setBounds(120, 300, 350, 30);
        this.add(lnum);

        pin = new JLabel("  Enter user Password :");
        pin.setFont(new Font("osward", Font.BOLD, 19));
        pin.setBounds(120, 350, 350, 30);
        this.add(pin);

        amount = new JLabel(" Amount:");
        amount.setFont(new Font("osward", Font.BOLD, 19));
		amount.setForeground(Color.BLACK);
        amount.setBounds(250, 400, 250, 30);
        this.add(amount);

        // Text Fields
        amount1 = new JTextField();
        amount1.setFont(new Font("osward", Font.BOLD, 19));
        amount1.setBounds(400, 400, 250, 30);
        this.add(amount1);

        number = new JTextField();
        number.setFont(new Font("osward", Font.BOLD, 19));
        number.setBounds(400, 300, 250, 30);
        this.add(number);

        pin11 = new JTextField();
        pin11.setFont(new Font("osward", Font.BOLD, 19));
        pin11.setBounds(400, 350, 250, 30);
        this.add(pin11);

        // Ok button
        ok = new JButton("Ok");
        ok.setFont(new Font("Raleway", Font.BOLD, 14));
        ok.setBounds(400, 500, 80, 30);
        ok.setBackground(Color.BLACK);
        ok.setForeground(Color.WHITE);
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String text1 = amount1.getText();
                String text2 = number.getText();
                String text3 = pin11.getText();

                if (text1.isEmpty() || text2.isEmpty() || text3.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill All information");
                } else {
                   
                    double transferAmount = Double.parseDouble(text1);
                    money[0] -= transferAmount;  
                    JOptionPane.showMessageDialog(null, "Transfer Successful");

                    setVisible(false);
                    new UserDashboard(textUser, a, money).setVisible(true);  
                }
            }
        });
        this.add(ok);

        // Back button
        back = new JButton("Back");
        back.setFont(new Font("Raleway", Font.BOLD, 14));
        back.setBounds(0, 0, 80, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new UserDashboard(textUser, a, money).setVisible(true);  
            }
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
        Transfer transferFrame = new Transfer("TestUser", 0, initialBalance);
        transferFrame.setVisible(true);
    }
}
