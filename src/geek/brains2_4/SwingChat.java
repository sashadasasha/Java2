package geek.brains2_4;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class SwingChat {

    public static void createPanelUI(Container cont) {
        JButton btn;
        JTextField txt;
        JTextArea jarea;
        JList<String> jlst;
        String[] names = {"Петр", "Мария", "Иван"};

        cont.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        cont.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        jlst = new JList<String>(names);
        jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        constraints.ipady = 400;
        constraints.ipadx = 100;
        constraints.gridwidth = 1;
        constraints.gridheight = 4;
        cont.add(jlst, constraints);

        jarea = new JTextArea();
        constraints.gridx = 1;
        constraints.ipady = 300;
        constraints.ipadx = 300;
        constraints.gridwidth = 3;
        constraints.gridheight = 3;
        cont.add(jarea, constraints);

        txt = new JTextField();
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.ipady = 100;
        constraints.ipadx = 200;
        cont.add(txt, constraints);

        btn = new JButton("Отправить");
        constraints.gridx = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.ipady = 100;
        constraints.ipadx = 100;
        cont.add(btn, constraints);


        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (jarea.getText().equals("Выберите получателя!")) {
                    jarea.setText("");
                }
                jarea.setText(jarea.getText() + "\n" + txt.getText() + "\n" + txt.getText());
                txt.setText("");
            }
        });

        jlst.addListSelectionListener(listSelectionEvent -> {
                    int idx = jlst.getSelectedIndex();
                    if (idx != -1) {
                        txt.setText(names[idx] + ": ");
                    }
                }
        );
    }

    SwingChat() {
        JFrame jfrm = new JFrame("GeekBrains чат");
        jfrm.setSize(500, 500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createPanelUI(jfrm.getContentPane());
        jfrm.pack();
        jfrm.setVisible(true);


    }
}
