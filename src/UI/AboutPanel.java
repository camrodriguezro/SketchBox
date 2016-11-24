package UI;

import java.awt.Dimension;
import static java.awt.EventQueue.invokeLater;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

public class AboutPanel extends JFrame {

    private JPanel Container = new JPanel();

    private JButton sendButton = new JButton();
    private JButton rate5 = new JButton("5");
    private JButton rate4 = new JButton("4");
    private JButton rate3 = new JButton("3");
    private JButton rate2 = new JButton("2");
    private JButton rate1 = new JButton("1");
    private JButton opinionImage = new JButton();

    private JLabel createdBy = new JLabel();
    private JLabel person1 = new JLabel();
    private JLabel person2 = new JLabel();
    private JLabel rights = new JLabel();
    private JLabel madeIn = new JLabel();
    private JLabel commentLabel = new JLabel();
    private JLabel version = new JLabel();

    private JTextField commentArea = new JTextField();

    private JComboBox<String> languageSelector = new JComboBox<String>();
    private Locale language = new Locale("en", "EN");
    private ResourceBundle translator = ResourceBundle.getBundle("MessagesBundle", language);

    public AboutPanel() {
        initComponents();
        Image image = new ImageIcon(this.getClass().getResource("/Resources/iconImage.png")).getImage();
        setIconImage(image);
    }

    private void initComponents() {

        GroupLayout ContainerLayout = new GroupLayout(Container);
        Container.setLayout(ContainerLayout);
        ContainerLayout.setHorizontalGroup(
                ContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 100, Short.MAX_VALUE)
        );
        ContainerLayout.setVerticalGroup(
                ContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 100, Short.MAX_VALUE)
        );
        this.setGraphicLayout();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(400, 400));
        setResizable(false);
        setSize(new Dimension(400, 400));

        rate5.setIcon(new ImageIcon(getClass().getResource("/Resources/miniRate5.png")));
        rate4.setIcon(new ImageIcon(getClass().getResource("/Resources/miniRate4.png")));
        rate3.setIcon(new ImageIcon(getClass().getResource("/Resources/miniRate3.png")));
        rate2.setIcon(new ImageIcon(getClass().getResource("/Resources/miniRate2.png")));
        rate1.setIcon(new ImageIcon(getClass().getResource("/Resources/miniRate1.png")));
        opinionImage.setIcon(new ImageIcon(getClass().getResource("/Resources/Rated5.png")));

        createdBy.setText("Created by: ");
        person1.setText("Carlos Rodriguez (@camrodriguezro)");
        person2.setText("Daniel Zuñiga (@dfzunigah)");
        rights.setText("All rights reserved - 2016");
        madeIn.setText("Coded with ❤ in Bogotá");
        commentLabel.setText("Write your comments here...");
        sendButton.setText("Send!");
        version.setText("V2.1.0");

        sendButton.addActionListener(new OpinionListener(sendButton, commentArea));
        rate5.addMouseListener(new ReviewListener(rate5, opinionImage));
        rate4.addMouseListener(new ReviewListener(rate4, opinionImage));
        rate3.addMouseListener(new ReviewListener(rate3, opinionImage));
        rate2.addMouseListener(new ReviewListener(rate2, opinionImage));
        rate1.addMouseListener(new ReviewListener(rate1, opinionImage));

        rate5.setToolTipText(translator.getString("click") + 5);
        rate4.setToolTipText(translator.getString("click") + 4);
        rate3.setToolTipText(translator.getString("click") + 3);
        rate2.setToolTipText(translator.getString("click") + 2);
        rate1.setToolTipText(translator.getString("click") + 1);
        sendButton.setToolTipText(translator.getString("sendHelper"));

        languageSelector.setModel(new DefaultComboBoxModel<>(new String[]{"English", "Español", "Francais"}));
        languageSelector.setSelectedItem("English");
        languageSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                changeLanguage(evt);
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    private void changeLanguage(ActionEvent evt) {
        String idiom = (String) languageSelector.getSelectedItem();
        if (idiom == null || idiom.isEmpty()) {
            language = new Locale("en", "EN");
            translator = ResourceBundle.getBundle("MessagesBundle", language);
            this.sendButton.setText(translator.getString("send"));
            this.commentLabel.setText(translator.getString("comments"));
            this.createdBy.setText(translator.getString("created"));
            this.madeIn.setText(translator.getString("coded"));
            this.rights.setText(translator.getString("rights"));
            sendButton.setToolTipText(translator.getString("sendHelper"));

        } else if (idiom.equals("English")) {
            language = new Locale("en", "EN");
            translator = ResourceBundle.getBundle("MessagesBundle", language);
            this.sendButton.setText(translator.getString("send"));
            this.commentLabel.setText(translator.getString("comments"));
            this.createdBy.setText(translator.getString("created"));
            this.madeIn.setText(translator.getString("coded"));
            this.rights.setText(translator.getString("rights"));
            rate5.setToolTipText(translator.getString("click") + " 5");
            rate4.setToolTipText(translator.getString("click") + " 4");
            rate3.setToolTipText(translator.getString("click") + " 3");
            rate2.setToolTipText(translator.getString("click") + " 2");
            rate1.setToolTipText(translator.getString("click") + " 1");
            sendButton.setToolTipText(translator.getString("sendHelper"));

        } else if (idiom.equals("Español")) {
            language = new Locale("es", "ES");
            translator = ResourceBundle.getBundle("MessagesBundle", language);
            this.sendButton.setText(translator.getString("send"));
            this.commentLabel.setText(translator.getString("comments"));
            this.createdBy.setText(translator.getString("created"));
            this.madeIn.setText(translator.getString("coded"));
            this.rights.setText(translator.getString("rights"));
            rate5.setToolTipText(translator.getString("click") + " 5");
            rate4.setToolTipText(translator.getString("click") + " 4");
            rate3.setToolTipText(translator.getString("click") + " 3");
            rate2.setToolTipText(translator.getString("click") + " 2");
            rate1.setToolTipText(translator.getString("click") + " 1");
            sendButton.setToolTipText(translator.getString("sendHelper"));

        } else if (idiom.equals("Francais")) {
            language = new Locale("fr", "FR");
            translator = ResourceBundle.getBundle("MessagesBundle", language);
            this.sendButton.setText(translator.getString("send"));
            this.commentLabel.setText(translator.getString("comments"));
            this.createdBy.setText(translator.getString("created"));
            this.madeIn.setText(translator.getString("coded"));
            this.rights.setText(translator.getString("rights"));
            rate5.setToolTipText(translator.getString("click") + " 5");
            rate4.setToolTipText(translator.getString("click") + " 4");
            rate3.setToolTipText(translator.getString("click") + " 3");
            rate2.setToolTipText(translator.getString("click") + " 2");
            rate1.setToolTipText(translator.getString("click") + " 1");
            sendButton.setToolTipText(translator.getString("sendHelper"));
        }

    }

    private void setGraphicLayout() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(createdBy))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(person2)
                                                .addComponent(person1)
                                                .addComponent(madeIn)
                                                .addComponent(rights))))
                        .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(commentLabel)
                                                                .addGap(116, 116, 116)
                                                                .addComponent(opinionImage, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(commentArea, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(rate5, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(rate4, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(rate3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(rate2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(rate1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(0, 33, Short.MAX_VALUE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(sendButton)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(version))))))
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(languageSelector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(languageSelector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(createdBy)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(person1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(person2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(madeIn)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(rights)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(commentLabel))
                                .addComponent(opinionImage, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(commentArea, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(rate4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addComponent(rate5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addComponent(rate3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addComponent(rate2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addComponent(rate1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(sendButton)
                                        .addGap(81, 81, 81))
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(version)
                                        .addGap(68, 68, 68))))
        );
    }

    public void initiate() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AboutPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AboutPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AboutPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AboutPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        invokeLater(new Runnable() {

            @Override
            public void run() {
                new AboutPanel().setVisible(true);
            }
        });
        
    }

}
