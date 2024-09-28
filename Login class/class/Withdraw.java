import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Withdraw extends JFrame {
    
    private ImageIcon icon,  backgroundImg;
 
    private JButton back, ok;
    private JLabel lTitle2, lTitle1, under, lName, amount, form, lnum, pin;
    private JTextField amount1, number, pin11;
    private JRadioButton bkash, nagad;
    private ButtonGroup option;

    private String textUser;
    private int a;
    private double[] money; 

    public Withdraw(String textUser, int a, double[] money) {
        this.textUser = textUser;
        this.a = a;
        this.money = money;

        this.setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Withdraw Money");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        // Icon image
        icon = new ImageIcon(getClass().getResource("/image/LOGO1.png"));
        this.setIconImage(icon.getImage());
        
       
        backgroundImg = loadImage("image/bou1.jpg");
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
         
        // Title
        lTitle2 = new JLabel("BB BANK");			
        lTitle2.setFont(new Font("Serif Bold Italic", Font.BOLD, 45));
        lTitle2.setBounds(350, 30, 400, 40);
        this.add(lTitle2);
		
        // Sub Title
        lTitle1 = new JLabel("Withdraw");
        lTitle1.setFont(new Font("osward", Font.BOLD, 28));
        lTitle1.setBounds(350, 100, 250, 40);
        this.add(lTitle1);
		
        // Underline
        under = new JLabel("________");
        under.setFont(new Font("osward", Font.BOLD, 28));
        under.setBounds(348, 100, 250, 40);
        this.add(under);
		
        // Username label
        lName = new JLabel("Username: " + textUser);
        lName.setFont(new Font("osward", Font.BOLD, 19));
        lName.setBounds(250, 200, 250, 30);
        this.add(lName);
		
        // Deposit To Label
        form = new JLabel("Withdraw To:");
        form.setFont(new Font("osward", Font.BOLD, 19));
        form.setBounds(250, 250, 250, 30);
        this.add(form);
		
        // Bkash/Nagad Number label
        lnum = new JLabel("Enter Bkash/Nagad number:");
        lnum.setFont(new Font("osward", Font.BOLD, 19));
        lnum.setBounds(120, 300, 350, 30);
        this.add(lnum);
		
        // User Pin label
        pin = new JLabel("Enter user password:");
        pin.setFont(new Font("osward", Font.BOLD, 19));
        pin.setBounds(120, 350, 350, 30);
        this.add(pin);
		
        // Amount label
        amount = new JLabel("Amount:");
        amount.setFont(new Font("osward", Font.BOLD, 19));
        amount.setBounds(250, 400, 250, 30);
        this.add(amount);
		
        // Amount text field
        amount1 = new JTextField();
        amount1.setFont(new Font("osward", Font.BOLD, 19));
        amount1.setBounds(400, 400, 250, 30);
        this.add(amount1);
		
        // Bkash/Nagad Number text field
        number = new JTextField();
        number.setFont(new Font("osward", Font.BOLD, 19));
        number.setBounds(400, 300, 250, 30);
        this.add(number);
		
        // User Pin text field
        pin11 = new JTextField();
        pin11.setFont(new Font("osward", Font.BOLD, 19));
        pin11.setBounds(400, 350, 250, 30);
        this.add(pin11);
		
        // Bkash Radio Button
        bkash = new JRadioButton("Bkash");
        bkash.setBackground(Color.decode("#FFFFFF"));
        bkash.setBounds(400, 250, 80, 30);
        this.add(bkash);
		
        // Nagad Radio Button
        nagad = new JRadioButton("Nagad");
        nagad.setBackground(Color.decode("#FFFFFF"));
        nagad.setBounds(500, 250, 80, 30);
        this.add(nagad);
		
        // Group the Bkash/Nagad options
        option = new ButtonGroup();
        option.add(bkash);
        option.add(nagad);
		
        // OK button
        ok = new JButton("Ok");
        ok.setFont(new Font("Raleway", Font.BOLD, 14));
        ok.setBounds(400, 450, 80, 30);
        ok.setBackground(Color.BLACK);
        ok.setForeground(Color.WHITE);
        ok.addActionListener(e -> {
            String textAmount = amount1.getText();
            if (textAmount.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter an amount to withdraw");
            } else {
                try {
                    double withdrawAmount = Double.parseDouble(textAmount);
                    if (withdrawAmount <= 0) {
                        JOptionPane.showMessageDialog(this, "Amount must be greater than zero");
                    } else if (withdrawAmount > money[0]) {
                        JOptionPane.showMessageDialog(this, "Insufficient funds!");
                    } else {
                        money[0] -= withdrawAmount; 
                        JOptionPane.showMessageDialog(this, "Withdrawal Successful! New Balance: " + money[0]);
                        setVisible(false);
                        new UserDashboard(textUser, a, money).setVisible(true); 
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid amount");
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
        back.addActionListener(e -> {
            setVisible(false);
            new UserDashboard(textUser, a, money).setVisible(true); 
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
        Withdraw withdraw = new Withdraw("TestUser", 0, initialBalance);
        withdraw.setVisible(true);
    }
}
