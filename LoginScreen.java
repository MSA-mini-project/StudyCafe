package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginScreen extends JFrame {

    public LoginScreen() {
        setTitle("로그인");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel loginLabel = new JLabel("로그인", SwingConstants.CENTER);
        loginLabel.setFont(new Font("", Font.BOLD, 24));
        loginLabel.setBounds(150, 100, 100, 30);
        panel.add(loginLabel);

        JTextField idField = new JTextField("Phone");
        idField.setBounds(100, 200, 200, 30);
        panel.add(idField);

        // idField FocusListener
        idField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (idField.getText().equals("Phone")) {
                    idField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (idField.getText().isEmpty()) {
                    idField.setText("Phone");
                }
            }
        });

        JPasswordField pwField = new JPasswordField("PW");
        pwField.setBounds(100, 250, 200, 30);
        panel.add(pwField);

        // PWField FocusListener
        pwField.setEchoChar((char) 0); // Initially display text
        pwField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                String password = new String(pwField.getPassword());
                if (password.equals("PW")) {
                    pwField.setText("");
                    pwField.setEchoChar('●'); // Change to a bullet character
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                String password = new String(pwField.getPassword());
                if (password.isEmpty()) {
                    pwField.setText("PW");
                    pwField.setEchoChar((char) 0); // Display text
                }
            }
        });

        JButton loginButton = new JButton("확인");
        loginButton.setBounds(150, 300, 100, 30);
        panel.add(loginButton);

        JButton signUpButton = new JButton("회원가입");
        signUpButton.setBounds(150, 350, 100, 30);
        panel.add(signUpButton);

        add(panel);

        // 확인 버튼 클릭 시 이벤트 처리
        loginButton.addActionListener(e -> {
            String idText = idField.getText();
            String pwText = new String(pwField.getPassword());

            if (idText.equals("") || idText.equals("Phone") || pwText.equals("") || pwText.equals("PW")) {
                JOptionPane.showMessageDialog(this, "제대로 입력해주세요.", "경고", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "로그인 성공", "알림", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // 회원가입 버튼 클릭 시 이벤트 처리
        signUpButton.addActionListener(e -> {
            new SignUpScreen();
            dispose();
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginScreen();
    }
}
