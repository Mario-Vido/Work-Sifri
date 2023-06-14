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
       this.setSize(500,500);

       JPanel frame = new JPanel();
       frame.setLayout(new BorderLayout(3,1));

       TextFromUser = new JTextField("Write text for encryption",JTextField.CENTER);

       frame.add(TextFromUser,BorderLayout.NORTH);

       this.add(frame);
       this.setLocationRelativeTo(null);
       this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
