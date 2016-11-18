package startupGUI;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class MainFrame
{

    private JFrame frame;
    private Button closeButton;
    private Button minimizeButton;
    private JLabel topLabel;
    private JLabel label;
    private JPanel macroCreatorPanel;
    private JEditorPane macroEditField;
    private JPanel macroConfigPanel;
    private JButton exitButton;
    private JButton applyButton;
    private JButton deleteMacroButton;
    private JButton recordButton;
    private JLabel loopLabel;
    private JTextField minuteLoopTextField;
    private JButton newMacroButton;

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    MainFrame window = new MainFrame();
                    window.frame.setVisible(true);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public MainFrame()
    {
        initializeGUIelements();
        setupHandler();
        addGUIelements();

    }

    /**
     * Initialize the contents of the frame.
     */
    private void initializeGUIelements()
    {
        frame = new JFrame();
        frame.getContentPane()
            .setBackground(new Color(51, 102, 204));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 512);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);

        closeButton = new Button("X");
        closeButton.setFont(new Font("Arimo", Font.BOLD, 14));
        closeButton.setBounds(699, 0, 21, 22);
        closeButton.setForeground(new Color(255, 255, 255));
        closeButton.setBackground(new Color(51, 102, 204));

        minimizeButton = new Button("_");
        minimizeButton.setFont(new Font("Arimo", Font.BOLD, 17));
        minimizeButton.setBounds(678, 0, 21, 22);
        minimizeButton.setForeground(new Color(255, 255, 255));
        minimizeButton.setBackground(new Color(51, 102, 204));

        topLabel = new JLabel("");
        topLabel.setBackground(new Color(51, 102, 204));
        topLabel.setIcon(new ImageIcon(
                MainFrame.class.getResource("/images/logo border.png")));
        topLabel.setForeground(new Color(255, 255, 255));
        topLabel.setBounds(0, -10, 720, 68);

        label = new JLabel("tdgkjgbh");
        label.setIcon(new ImageIcon(
                MainFrame.class.getResource("/images/icon small.png")));
        label.setBounds(-289, -155, 404, 333);

    }

    private void setupHandler()
    {
        frame.getContentPane()
            .addMouseMotionListener(new MouseMotionAdapter()
            {
                @Override
                public void mouseDragged(MouseEvent arg0)
                {
                    Double mouseX = MouseInfo.getPointerInfo()
                        .getLocation()
                        .getX();
                    Double mouseY = MouseInfo.getPointerInfo()
                        .getLocation()
                        .getY();

                    frame.setBounds(mouseX.intValue() - 360, mouseY.intValue(),
                            720, 512);

                }
            });
        closeButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
            }
        });
        minimizeButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frame.setState(frame.ICONIFIED);
            }
        });
    }

    private void addGUIelements()
    {
        frame.getContentPane()
            .setLayout(null);
        frame.getContentPane()
            .add(closeButton);
        frame.getContentPane()
            .add(minimizeButton);

        frame.getContentPane()
            .add(topLabel);

        setupMacroReaderPanel();
        setupMacroCreatorPanel();

    }

    public void setupMacroReaderPanel()
    {
        JPanel macroReaderPanel = new JPanel();
        macroReaderPanel.setBounds(10, 69, 258, 419);
        frame.getContentPane()
            .add(macroReaderPanel);
        GridBagLayout gbl_macroReaderPanel = new GridBagLayout();
        gbl_macroReaderPanel.columnWidths = new int[] {0, 0};
        gbl_macroReaderPanel.rowHeights = new int[] {0, 0};
        gbl_macroReaderPanel.columnWeights = new double[] {1.0,
                Double.MIN_VALUE};
        gbl_macroReaderPanel.rowWeights = new double[] {0.0, Double.MIN_VALUE};
        macroReaderPanel.setLayout(gbl_macroReaderPanel);

        newMacroButton = new JButton("New Macro");
        newMacroButton.setBackground(new Color(255, 255, 255));
        newMacroButton.setFont(new Font("Arimo", Font.BOLD, 14));
        newMacroButton.setForeground(new Color(51, 102, 204));
        GridBagConstraints gbc_newMacroButton = new GridBagConstraints();
        gbc_newMacroButton.fill = GridBagConstraints.BOTH;
        gbc_newMacroButton.gridx = 0;
        gbc_newMacroButton.gridy = 0;
        macroReaderPanel.add(newMacroButton, gbc_newMacroButton);
    }

    public void setupMacroCreatorPanel()
    {
        macroCreatorPanel = new JPanel();
        macroCreatorPanel.setBackground(new Color(51, 102, 204));
        macroCreatorPanel.setBounds(280, 69, 430, 432);
        frame.getContentPane()
            .add(macroCreatorPanel);
        macroCreatorPanel.setLayout(null);

        addMacroEditField();
        addMacroConfigPanel();
        addDeleteMacroButton();
        addRecordMacroButton();
        addExitButton();
        addApplyButton();
        addLoopLabel();
        addMinuteLoopTextField();
    }

    public void addDeleteMacroButton()
    {
        deleteMacroButton = new JButton("Delete");
        deleteMacroButton.setForeground(new Color(255, 255, 255));
        deleteMacroButton.setBackground(new Color(51, 102, 204));
        deleteMacroButton.setFont(new Font("Arimo", Font.BOLD, 14));
        deleteMacroButton.setBounds(10, 298, 109, 31);
        macroConfigPanel.add(deleteMacroButton);

    }

    public void addRecordMacroButton()
    {
        recordButton = new JButton("Record");
        recordButton.setFont(new Font("Arimo", Font.BOLD, 14));
        recordButton.setForeground(new Color(255, 255, 255));
        recordButton.setBackground(new Color(51, 102, 204));
        recordButton.setBounds(10, 73, 109, 31);
        macroConfigPanel.add(recordButton);
    }

    public void addExitButton()
    {
        exitButton = new JButton("Exit");
        exitButton.setBackground(new Color(51, 102, 204));
        exitButton.setForeground(new Color(153, 0, 51));
        exitButton.setFont(new Font("Arimo", Font.BOLD, 14));
        exitButton.setBounds(10, 382, 109, 31);
        macroConfigPanel.add(exitButton);
    }

    public void addApplyButton()
    {
        applyButton = new JButton("Apply");
        applyButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                new RecordAlertDialog();
                //TODO debug
            }
        });
        applyButton.setForeground(new Color(255, 255, 255));
        applyButton.setBackground(new Color(51, 102, 204));
        applyButton.setFont(new Font("Arimo", Font.BOLD, 14));
        applyButton.setBounds(10, 340, 109, 31);
        macroConfigPanel.add(applyButton);
    }

    public void addLoopLabel()
    {
        loopLabel = new JLabel("Loop(seconds):");
        loopLabel.setForeground(new Color(51, 102, 204));
        loopLabel.setFont(new Font("Arimo", Font.BOLD, 14));
        loopLabel.setBounds(10, 11, 109, 36);
        macroConfigPanel.add(loopLabel);
    }

    public void addMinuteLoopTextField()
    {
        minuteLoopTextField = new JTextField();
        minuteLoopTextField.setFont(new Font("Consolas", Font.PLAIN, 13));
        minuteLoopTextField.setForeground(new Color(51, 102, 204));
        minuteLoopTextField.setCaretColor(new Color(51, 102, 204));
        minuteLoopTextField.setBorder(
                new MatteBorder(1, 1, 1, 1, (Color) new Color(51, 102, 204)));
        minuteLoopTextField.setBounds(10, 42, 109, 20);
        macroConfigPanel.add(minuteLoopTextField);
        minuteLoopTextField.setColumns(10);
    }

    public void addMacroConfigPanel()
    {
        macroConfigPanel = new JPanel();
        macroConfigPanel.setBounds(301, 0, 129, 421);
        macroCreatorPanel.add(macroConfigPanel);
        macroConfigPanel.setLayout(null);
    }

    public void addMacroEditField()
    {
        macroEditField = new JEditorPane();
        macroEditField.setContentType("plain/text");
        macroEditField.setText("Macro goes here....");
        macroEditField.setForeground(new Color(51, 102, 204));
        macroEditField.setFont(new Font("Consolas", Font.PLAIN, 14));
        macroEditField.setBounds(0, 0, 291, 421);
        macroCreatorPanel.add(macroEditField);
    }
}
