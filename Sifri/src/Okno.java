import Encryption.EncryptionType1;
import Encryption.EncryptionType2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Okno extends JFrame implements ActionListener {

    private final EncryptionType1 encryptionType1;
    private final EncryptionType2 encryptionType2;
    private JTextField TextFromUser;
    private final JLabel textAfterEncryption;
    private final JButton ButtonForEncryption;
    private final JButton ButtonForDecryption;
    private final JComboBox chooseEncryption;

   Okno() {
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setSize(500,150);
       String encryptionType[]={"Encryption type 1","Encryption type 2"};
       JPanel frame = new JPanel();
       frame.setLayout(new BorderLayout(3,1));

       TextFromUser = new JTextField("Write text to encrypt");
       ButtonForDecryption = new JButton("Decryption");
       ButtonForEncryption = new JButton("Encryption");
       textAfterEncryption= new JLabel();
       chooseEncryption = new JComboBox(encryptionType);

       frame.add(chooseEncryption,BorderLayout.CENTER);
       frame.add(TextFromUser,BorderLayout.PAGE_START);
       frame.add(ButtonForEncryption,BorderLayout.LINE_START);
       frame.add(ButtonForDecryption,BorderLayout.LINE_END);
       frame.add(textAfterEncryption,BorderLayout.PAGE_END);

       chooseEncryption.addActionListener(this);
       ButtonForDecryption.addActionListener(this);
       ButtonForEncryption.addActionListener(this);

       encryptionType1 = new EncryptionType1 ( textAfterEncryption);
       encryptionType2 = new EncryptionType2 ( textAfterEncryption);
       this.add(frame);
       this.setLocationRelativeTo(null);
       this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ButtonForDecryption){

        }
        else if (e.getSource()==ButtonForEncryption){
            String selectedType = (String) chooseEncryption.getSelectedItem();
            assert selectedType != null;
            if(selectedType.equals("Encryption type 1")){
                encryptionType1.performEncryption(TextFromUser.getText());
            }
            else if(selectedType.equals("Encryption type 2")){
                encryptionType2.performEncryption(TextFromUser.getText());
            }
        }
    }
}
