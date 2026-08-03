/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ai.chatbot;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Ahsan Khalid
 */
public class ChatbotGUI extends JFrame
{
     private ChatEngine chatEngine;
    private JTextPane chatArea;
    private JTextField inputField;
    private JButton sendButton;
 
    // Colors
    private static final Color BG_COLOR      = new Color(240, 244, 250);
    private static final Color BOT_COLOR     = new Color(220, 235, 255);
    private static final Color USER_COLOR    = new Color(200, 240, 215);
    private static final Color HEADER_COLOR  = new Color(30, 60, 120);
 
    public ChatbotGUI() {
        chatEngine = new ChatEngine();
        buildUI();
        displayBotMessage("Hi there! I'm JavaBot 🤖 — your Java-powered assistant.\nType 'help' to see what I can do, or just start chatting!");
    }
 
    private void buildUI() {
        setTitle("JavaBot — AI Chatbot");
        setSize(600, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(0, 0));
 
        // Header
        JPanel header = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        header.setBackground(HEADER_COLOR);
        JLabel logo = new JLabel("🤖 JavaBot");
        logo.setFont(new Font("SansSerif", Font.BOLD, 18));
        logo.setForeground(Color.WHITE);
        JLabel sub = new JLabel("AI-powered chatbot");
        sub.setFont(new Font("SansSerif", Font.PLAIN, 12));
        sub.setForeground(new Color(180, 200, 255));
        header.add(logo);
        header.add(sub);
        add(header, BorderLayout.NORTH);
 
        // Chat area
        chatArea = new JTextPane();
        chatArea.setEditable(false);
        chatArea.setBackground(BG_COLOR);
        chatArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(scrollPane, BorderLayout.CENTER);
 
        // Input bar
        JPanel inputPanel = new JPanel(new BorderLayout(8, 0));
        inputPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(200, 210, 230)),
            BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));
        inputPanel.setBackground(Color.WHITE);
 
        inputField = new JTextField();
        inputField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        inputField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(180, 200, 230), 1, true),
            BorderFactory.createEmptyBorder(6, 10, 6, 10)
        ));
 
        sendButton = new JButton("Send ➤");
        sendButton.setBackground(HEADER_COLOR);
        sendButton.setForeground(Color.WHITE);
        sendButton.setFocusPainted(false);
        sendButton.setFont(new Font("SansSerif", Font.BOLD, 13));
        sendButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sendButton.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
 
        inputField.addActionListener(e -> sendMessage());
        sendButton.addActionListener(e -> sendMessage());
 
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);
 
        setVisible(true);
    }
 
    private void sendMessage() {
        String userText = inputField.getText().trim();
        if (userText.isEmpty()) return;
 
        displayUserMessage(userText);
        inputField.setText("");
 
        // Simulate a tiny delay to feel natural
        Timer delay = new Timer(400, e -> {
            ChatResponse response = chatEngine.processInput(userText);
            displayBotMessage(response.getResponseText());
        });
        delay.setRepeats(false);
        delay.start();
    }
 
    private void displayUserMessage(String text) {
        appendMessage("You", text, USER_COLOR, new Color(20, 100, 50));
    }
 
    private void displayBotMessage(String text) {
        appendMessage("JavaBot 🤖", text, BOT_COLOR, new Color(20, 50, 120));
    }
 
    private void appendMessage(String sender, String message, Color bgColor, Color nameColor) {
        // Build styled HTML bubble
        String html = buildMessageHTML(sender, message, bgColor, nameColor);
        try {
            javax.swing.text.EditorKit kit = chatArea.getEditorKit();
            javax.swing.text.Document doc  = chatArea.getDocument();
 
            if (!(kit instanceof javax.swing.text.html.HTMLEditorKit)) {
                chatArea.setContentType("text/html");
            }
 
            String existing = chatArea.getText();
            if (existing == null || existing.isEmpty() || existing.equals("<html><head></head><body></body></html>")) {
                chatArea.setText("<html><body style='font-family:SansSerif; padding:6px;'>" + html + "</body></html>");
            } else {
                // Append before </body></html>
                String updated = existing.replace("</body></html>", html + "</body></html>");
                chatArea.setText(updated);
            }
            // Scroll to bottom
            chatArea.setCaretPosition(chatArea.getDocument().getLength());
        } catch (Exception e) {
            // Fallback plain text
            chatArea.setText(chatArea.getText() + "\n" + sender + ": " + message + "\n");
        }
    }
 
    private String buildMessageHTML(String sender, String message, Color bg, Color nameColor) {
        String bgHex   = colorToHex(bg);
        String nameHex = colorToHex(nameColor);
        String msgEscaped = message.replace("\n", "<br>");
        return "<div style='background:" + bgHex + "; border-radius:8px; padding:8px 12px; "
             + "margin:6px 4px; max-width:90%;'>"
             + "<b style='color:" + nameHex + ";'>" + sender + "</b><br>"
             + "<span style='color:#222;'>" + msgEscaped + "</span>"
             + "</div>";
    }
 
    private String colorToHex(Color c) {
        return String.format("#%02X%02X%02X", c.getRed(), c.getGreen(), c.getBlue());
    }

}
