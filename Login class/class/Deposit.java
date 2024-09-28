import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Deposit extends JFrame {

    private ImageIcon icon, backgroundImg;
  
    private JButton back, ok;
    private JLabel amountLabel, titleLabel, underLabel, lTitle1, lName, form, lnum, pin;
    private JTextField amountField, number, pin11;
    private JRadioButton bkash, nagad;
    private ButtonGroup option;

    private String textUser;
    private int a;
    private double[] money; // Use an array for balance

    public Deposit(String textUser, int a, double[] money) {
        this.textUser = textUser;
        this.a = a;
        this.money = money;

        this.setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Deposit Money");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Icon image
        icon = new ImageIcon(getClass().getResource("/image/LOGO1.png"));
        this.setIconImage(icon.getImage());

       backgroundImg = loadImage("image/login1.jpg");
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


        // Title label
        titleLabel = new JLabel("BB BANK");
        titleLabel.setFont(new Font("Serif Bold Italic", Font.BOLD, 28));
        titleLabel.setBounds(350, 30, 400, 40);
        this.add(titleLabel);

        // Sub Title
        lTitle1 = new JLabel("Deposit");
        lTitle1.setFont(new Font("osward", Font.BOLD, 28));
        lTitle1.setBounds(350, 100, 250, 40);
        this.add(lTitle1);

        // Underline
        underLabel = new JLabel("________");
        underLabel.setFont(new Font("Serif Bold Italic", Font.BOLD, 28));
        underLabel.setBounds(348, 100, 250, 40);
        this.add(underLabel);

        // Username label
        lName = new JLabel("Username: " + textUser);
        lName.setFont(new Font("osward", Font.BOLD, 19));
        lName.setBounds(250, 200, 250, 30);
        this.add(lName);

        // Deposit from label
        form = new JLabel("Deposit from:");
        form.setFont(new Font("osward", Font.BOLD, 19));
        form.setBounds(250, 250, 250, 30);
        this.add(form);

        // Bkash/Nagad Number label
        lnum = new JLabel("Enter Bkash/Nagad number:");
        lnum.setFont(new Font("osward", Font.BOLD, 19));
        lnum.setBounds(120, 300, 350, 30);
        this.add(lnum);

        // Bkash/Nagad Pin label
        pin = new JLabel("Enter Bkash/Nagad pin:");
        pin.setFont(new Font("osward", Font.BOLD, 19));
        pin.setBounds(120, 350, 350, 30);
        this.add(pin);

        // Bkash/Nagad Number text field
        number = new JTextField();
        number.setFont(new Font("osward", Font.BOLD, 19));
        number.setBounds(400, 300, 250, 30);
        this.add(number);

        // Bkash/Nagad Pin text field
        pin11 = new JTextField();
        pin11.setFont(new Font("osward", Font.BOLD, 19));
        pin11.setBounds(400, 350, 150, 30);
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

        // Group Bkash/Nagad options
        option = new ButtonGroup();
        option.add(bkash);
        option.add(nagad);

        // Amount label
        amountLabel = new JLabel("Amount to deposit:");
        amountLabel.setFont(new Font("osward", Font.BOLD, 19));
        amountLabel.setBounds(120, 400, 350, 30);
        this.add(amountLabel);

        // Amount text field
        amountField = new JTextField();
        amountField.setFont(new Font("osward", Font.BOLD, 19));
        amountField.setBounds(400, 400, 250, 30);
        this.add(amountField);

        // OK button
        ok = new JButton("Ok");
        ok.setFont(new Font("Raleway", Font.BOLD, 14));
        ok.setBounds(400, 450, 80, 30);
        ok.setBackground(Color.BLACK);
        ok.setForeground(Color.WHITE);
        ok.addActionListener(e -> {
            String textAmount = amountField.getText();
            if (textAmount.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter an amount to deposit");
            } else {
                try {
                    double depositAmount = Double.parseDouble(textAmount);
                    if (depositAmount <= 0) {
                        JOptionPane.showMessageDialog(this, "Amount must be greater than zero");
                    } else {
                        money[0] += depositAmount; // Update the balance
                        JOptionPane.showMessageDialog(this, "Deposit Successful! New Balance: " + money[0]);
                        setVisible(false);
                        new UserDashboard(textUser, a, money).setVisible(true); // Go back to dashboard
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
            new UserDashboard(textUser, a, money).setVisible(true); // Go back to dashboard
        });
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

    public static void main(String[] args) {
        double[] initialBalance = {500.0}; // Example balance
        Deposit deposit = new Deposit("TestUser", 0, initialBalance);
        deposit.setVisible(true);
    }
}
