import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatClientGUI extends JFrame {
    private JTextArea txtOutput;
    private JTextField txtMessage;
    private JButton btnSend;
    private String pseudo;
    private ChatClient client;

    public ChatClientGUI(ChatClient client) {
        super("Chat Room");
        this.client = client;
        createGUI();
        requestPseudo();
    }

    private void createGUI() {
        JPanel panel = (JPanel)this.getContentPane();
        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        txtOutput.setBackground(new Color(220,220,220));
        
        JScrollPane scrollPane = new JScrollPane(txtOutput);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        JPanel southPanel = new JPanel(new BorderLayout());
        txtMessage = new JTextField();
        btnSend = new JButton("Envoyer");
        
        southPanel.add(txtMessage, BorderLayout.CENTER);
        southPanel.add(btnSend, BorderLayout.EAST);
        panel.add(southPanel, BorderLayout.SOUTH);

        btnSend.addActionListener(e -> sendMessage());
        txtMessage.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (e.getKeyChar() == '\n') sendMessage();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setVisible(true);
    }

    private void requestPseudo() {
        pseudo = JOptionPane.showInputDialog(this, "Entrez votre pseudo :", "Chat Room", JOptionPane.QUESTION_MESSAGE);
        if (pseudo == null) System.exit(0);
        client.connect(pseudo);
    }

    private void sendMessage() {
        String message = txtMessage.getText().trim();
        if (!message.isEmpty()) {
            client.sendMessage(message);
            txtMessage.setText("");
        }
        txtMessage.requestFocus();
    }

    public void displayMessage(String message) {
        txtOutput.append(message + "\n");
    }

    public String getPseudo() {
        return pseudo;
    }
}