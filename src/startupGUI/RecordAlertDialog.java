package startupGUI;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class RecordAlertDialog
{
    String _message;

    private JDialog dialog;

    /**
     * Launch the application.
     */

    /**
     * Create the dialog.
     */
    public RecordAlertDialog(String message)
    {
        _message = message;
        initDialog();
    }

    public void initDialog()
    {
        dialog = new JDialog((Frame) null);
        dialog.getContentPane()
            .setBackground(new Color(51, 102, 204));
        //dialog.getContentPane().setSize(new Dimension(200, 100));
        dialog.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setResizable(false);
        dialog.setSize(250, 130);
        dialog.setUndecorated(true);
        dialog.getContentPane()
            .setLayout(null);

        JLabel label = new JLabel("");
        label.setBorder(
                new MatteBorder(1, 1, 1, 1, (Color) new Color(51, 102, 204)));
        label.setIcon(new ImageIcon(RecordAlertDialog.class
            .getResource("/images/ss (2016-11-18 at 12.44.35).png")));
        label.setBounds(0, 0, 250, 28);
        dialog.getContentPane()
            .add(label);

        JButton btnNewButton = new JButton("X");
        btnNewButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                dialog.dispose();
            }
        });
        btnNewButton.setFont(new Font("Arimo", Font.BOLD, 14));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(51, 102, 204));
        btnNewButton.setBounds(220, 0, 30, 28);
        dialog.getContentPane()
            .add(btnNewButton);

        JLabel lblRecordInProgress = new JLabel(_message);
        lblRecordInProgress.setFont(new Font("Arimo", Font.BOLD, 16));
        lblRecordInProgress.setForeground(new Color(255, 255, 255));
        lblRecordInProgress.setHorizontalAlignment(SwingConstants.CENTER);
        lblRecordInProgress.setBorder(
                new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
        lblRecordInProgress.setBounds(10, 42, 230, 40);
        dialog.getContentPane()
            .add(lblRecordInProgress);

        JButton btnDone = new JButton("Ok");
        btnDone.setFont(new Font("Arimo", Font.BOLD, 14));
        btnDone.setForeground(new Color(51, 102, 204));
        btnDone.setBackground(new Color(255, 255, 255));
        btnDone.setBounds(20, 96, 89, 23);
        dialog.getContentPane()
            .add(btnDone);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBackground(new Color(255, 255, 255));
        btnCancel.setFont(new Font("Arimo", Font.BOLD, 14));
        btnCancel.setForeground(new Color(51, 102, 204));
        btnCancel.setBounds(129, 96, 89, 23);
        dialog.getContentPane()
            .add(btnCancel);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
