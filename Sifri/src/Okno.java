import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Okno extends JFrame implements ActionListener {

    private JLabel TextFromUser;
    private JLabel TextAfterEncryption;
    private JButton ButtonForEncryption;
    private JButton ButtonForDecryption;


   Okno() {
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setSize(500,500);

       this.setLocationRelativeTo(null);
       this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
