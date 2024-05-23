package Kiosk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class BeverageKiosk extends JFrame implements ActionListener {
	private JButton orderButton;
    private JButton paymentButton;
    private JLabel orderListLabel;  // 주문 내역을 표시할 레이블
    private List<String> selectedBeverages;  // 선택한 음료 정보를 저장할 리스트

    public BeverageKiosk() {
        setTitle("음료 선택");
        setSize(700, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        selectedBeverages = new ArrayList<>();
        
        // 음료 메뉴 생성
        MenuButton coffeePanel = new MenuButton(new ImageIcon("Image/Water.png"), "생수", this);
        MenuButton teaPanel = new MenuButton(new ImageIcon("Image/Coffee.png"), "아메리카노", this);
        MenuButton juicePanel = new MenuButton(new ImageIcon("Image/OrangeJuice.png"), "오렌지 쥬스", this);
        MenuButton smoothiePanel = new MenuButton(new ImageIcon("Image/LemonAde.png"), "레몬에이드", this);

        // 주문 버튼 생성
        orderButton = new JButton("주문");
        orderButton.addActionListener(this);

        // 결제하기 버튼 생성
        paymentButton = new JButton("결제하기");
        paymentButton.addActionListener(this);

        // 주문 내역 레이블 생성
        orderListLabel = new JLabel("주문 내역");
        
        // 레이아웃 설정
        JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10)); // 가운데 정렬, 수평, 수직 간격은 각각 10
        menuPanel.add(coffeePanel);
        menuPanel.add(teaPanel);
        menuPanel.add(juicePanel);
        menuPanel.add(smoothiePanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(orderButton);
        buttonPanel.add(paymentButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(menuPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(orderListLabel, BorderLayout.NORTH); //주문 내역 레이블 추가 
        add(mainPanel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == orderButton) {
            // 주문 버튼 클릭 시 동작
            //JOptionPane.showMessageDialog(this, "주문이 완료되었습니다.");
        	// 주문 버튼 클릭 시 주문 내역 업데이트
        	StringBuilder orderText = new StringBuilder("주문 내역");
        	for (String beverage : selectedBeverages) {
        		orderText.append(beverage).append("\n");
        	}
        	if (!selectedBeverages.isEmpty()) {
        		orderText.delete(orderText.length() - 2, orderText.length());  // 마지막 쉼표 제거
        	}
        	else {
        		orderText.append("없음");
        	}
        } else if (e.getSource() == paymentButton) {
            // 결제하기 버튼 클릭 시 동작
            JOptionPane.showMessageDialog(this, "결제가 완료되었습니다.");
        }
    }
    
    public void addSelectedBeverage(String beverage) {
    	selectedBeverages.add(beverage);
    }
    public void removeSelectedBeverage(String menuName) {
    	
    }
    
    public void updateOrderList() {
        // 선택한 음료들을 문자열로 변환하여 주문 내역 레이블에 표시
        StringBuilder orderText = new StringBuilder("주문 내역: ");
        for (String beverage : selectedBeverages) {
            orderText.append(beverage).append(", ");
        }
        if (!selectedBeverages.isEmpty()) {
            orderText.delete(orderText.length() - 2, orderText.length()); // 마지막 쉼표 제거
        } else {
            orderText.append("없음");
        }
        orderListLabel.setText(orderText.toString());
    }


    public static void main(String[] args) {
        new BeverageKiosk();
    }
}
