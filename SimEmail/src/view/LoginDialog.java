package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField address_text;
    private JTextField smtp_addr_text;
    private JTextField pop_addr_text;
    private JPasswordField pass_text;
    ActionListener btnActionListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "OK":

                    String addr = address_text.getText();
                    String pass = String.valueOf(pass_text.getPassword());
                    String smtp_addr = smtp_addr_text.getText();
                    String pop_addr = pop_addr_text.getText();

                    MainFrame frame = new MainFrame(addr, pass, smtp_addr, pop_addr, LoginDialog.this);

                    break;
                default:
                    break;
            }
        }
    };

    /**
     * Create the dialog.
     */
    public LoginDialog() {
        setTitle("登录");
        setBounds(150, 150, 500, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Email Address：");
        lblNewLabel.setBounds(58, 16, 86, 18);
        contentPanel.add(lblNewLabel);

        JLabel label = new JLabel("Email Password：");
        label.setBounds(58, 47, 86, 18);
        contentPanel.add(label);

        JLabel lblSmtp = new JLabel("SMTP Server：");
        lblSmtp.setBounds(58, 78, 86, 18);
        contentPanel.add(lblSmtp);

        JLabel lblPop = new JLabel("POP Server：");
        lblPop.setBounds(58, 109, 86, 18);
        contentPanel.add(lblPop);

        address_text = new JTextField();
        address_text.setBounds(147, 13, 201, 24);
        contentPanel.add(address_text);
        address_text.setColumns(10);

        smtp_addr_text = new JTextField();
        smtp_addr_text.setColumns(10);
        smtp_addr_text.setBounds(147, 75, 201, 24);
        contentPanel.add(smtp_addr_text);

        pop_addr_text = new JTextField();
        pop_addr_text.setColumns(10);
        pop_addr_text.setBounds(147, 106, 201, 24);
        contentPanel.add(pop_addr_text);

        pass_text = new JPasswordField();
        pass_text.setBounds(147, 44, 201, 24);
        contentPanel.add(pass_text);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("SignIn");
        okButton.setActionCommand("OK");

        okButton.addActionListener(btnActionListener);
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            LoginDialog dialog = new LoginDialog();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
