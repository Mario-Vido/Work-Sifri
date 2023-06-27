package Core;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MyFrame extends JFrame {

    public MyFrame() throws IOException {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,150);
        JPanel frame = new JPanel();
        frame.setLayout(new BorderLayout(3,1));

        Logic logic = new Logic(this);
        frame.add(logic.getLogout(),BorderLayout.SOUTH);
        frame.add(logic.getTextFromUser(),BorderLayout.PAGE_START);
        frame.add(logic.getButtonForEncryption(),BorderLayout.LINE_START);
        frame.add(logic.getChooseEncryption(),BorderLayout.CENTER);
        frame.add(logic.getButtonForDecryption(),BorderLayout.LINE_END);
        frame.add(logic.getTextAfterEncryption(),BorderLayout.PAGE_END);


        this.add(frame);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
