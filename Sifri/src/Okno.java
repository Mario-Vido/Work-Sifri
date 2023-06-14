import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Okno extends JFrame implements ActionListener {

    private JTextField TextFromUser;
    private JLabel TextAfterEncryption;
    private JButton ButtonForEncryption;
    private JButton ButtonForDecryption;


   Okno() {
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setSize(500,300);

       JPanel frame = new JPanel();
       frame.setLayout(new BorderLayout(3,1));

       TextFromUser = new JTextField("Write text for encryption",JTextField.CENTER);
       ButtonForDecryption = new JButton("Decryption");
       ButtonForEncryption = new JButton("Encryption");
       TextAfterEncryption= new JLabel("HAAHAHAHAHAHAHAHA");

       frame.add(TextFromUser,BorderLayout.PAGE_START);
       frame.add(ButtonForEncryption,BorderLayout.LINE_START);
       frame.add(ButtonForDecryption,BorderLayout.LINE_END);
       frame.add(TextAfterEncryption,BorderLayout.PAGE_END);

       this.add(frame);
       this.setLocationRelativeTo(null);
       this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
