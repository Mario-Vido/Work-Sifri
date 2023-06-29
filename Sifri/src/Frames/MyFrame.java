package Frames;

import Logic.Logic;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MyFrame extends JFrame {

    public MyFrame() throws IOException {


        JPanel frame = new JPanel();
        frame.setLayout(new GridLayout(2,3));

        Logic logic = new Logic(this);
        frame.add(logic.getTextFromUser());
        frame.add(logic.getLogout());
        frame.add(logic.getButtonForEncryption());
        frame.add(logic.getButtonForDecryption());
        frame.add(logic.getChooseEncryption());
        frame.add(logic.getTextAfterEncryption());

        frame.add(logic.getLogout());

        this.setSize(500,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(frame);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
