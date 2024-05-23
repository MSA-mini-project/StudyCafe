
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeatReservation extends JFrame {
    private JButton[] seats;
    private JPanel[] seatPrice;
    private JLabel[] seatPriceLabel;
    
    public SeatReservation() {
    	JFrame frame = new JFrame("Seat Reservation System");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        
        // 상호명 
        JLabel TM = new JLabel("푸름 스터디카페");
        TM.setBounds(240, 20, 350, 80);
        TM.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        add(TM);
    
        
        JPanel seatPanel = new JPanel();
        seatPanel.setLayout(null); // 자유로운 위치 배치를 위해 null 레이아웃 사용

        seats = new JButton[35];
        int[] seatNumbers = {
            1, 2, 3, 4, 5, 
            6, 7, 8, 9, 10, 
            11, 12, 13, 14, 15, 
            16, 17, 18, 19, 20, 
            21, 22, 23, 24, 25, 
            26, 27, 28, 29, 30,
            31, 32, 33, 34, 35
        };
        
        // 좌석 위치 좌표 (x, y, width, height)
        int [] x = {30, 150, 210, 330, 390, 510};
        int [] y = {110, 170, 230, 290, 350, 450};
        int width = 50;
        int gold_width = 60;
        int[][] seatPositions = {
            {x[0], y[0], width, width}, {x[0], y[1], width, width}, {x[0], y[2], width, width}, 
            {x[0], y[3], width, width}, {x[0], y[4], width, width}, 
            
            {x[1], y[0], width, width}, {x[1], y[1], width, width}, {x[1], y[2], width, width}, 
            {x[1], y[3], width, width}, {x[1], y[4], width, width}, 
            
            {x[2], y[0], width, width}, {x[2], y[1], width, width}, {x[2], y[2], width, width}, 
            {x[2], y[3], width, width}, {x[2], y[4], width, width}, 
            
            {x[3], y[0], width, width}, {x[3], y[1], width, width}, {x[3], y[2],width, width}, 
            {x[3], y[3], width, width}, {x[3], y[4], width, width}, 
            
            {x[4], y[0], width, width}, {x[4], y[1], width, width}, {x[4], y[2], width, width}, 
            {x[4], y[3], width, width}, {x[4], y[4], width, width}, 
            
            {x[5], y[0], width, width}, {x[5], y[1], width, width}, {x[5], y[2], width, width}, 
            {x[5], y[3], width, width}, {x[5], y[4], width, width}, 
            
            {50, y[5], gold_width, gold_width}, {160, y[5], gold_width, gold_width}, {270, y[5], gold_width, gold_width},
            {380, y[5], gold_width, gold_width}, {490, y[5], gold_width, gold_width},
            
        };
        seatPrice = new JPanel[5];
        seatPriceLabel = new JLabel[5];
        Object[][] rec = {
        		{590, 150, 30, 30, new Color(0, 153, 0), "2000원"},
				{590, 200, 30, 30, new Color(57, 107, 249), "4000원"},
				{590, 250, 30, 30, new Color(253, 93, 93), "5000원"},
				{590, 300, 30, 30, new Color(255, 192, 0), "7000원"},
				{590, 350, 30, 30, Color.GRAY, "선택불가"}
        };
        
        for (int i = 0; i < seats.length; i++) {
            seats[i] = new JButton(String.valueOf(seatNumbers[i]));
            seats[i].setBounds(seatPositions[i][0], seatPositions[i][1], seatPositions[i][2], seatPositions[i][3]);
            // A존 좌석 색상
            if (i < 10)
            	seats[i].setBackground(new Color(81, 211, 81));
            else if (i < 20)
            	seats[i].setBackground(new Color(51, 204, 255));
            else if (i < 30)
            	seats[i].setBackground(new Color(254, 130, 163));
            else
            	seats[i].setBackground(new Color(255, 192, 0));
 
            seats[i].setForeground(Color.WHITE);
            seats[i].addActionListener(new SeatButtonListener());
            seatPanel.add(seats[i]);
        }
        for (int i = 0; i < seatPrice.length; i++) {
        	seatPrice[i] = new JPanel();
        	seatPrice[i].setBounds((int)rec[i][0], (int)rec[i][1], (int)rec[i][2], (int)rec[i][3]);
        	seatPrice[i].setBackground((Color)rec[i][4]);
        	seatPriceLabel[i] = new JLabel((String)rec[i][5]);
        	seatPriceLabel[i].setBounds((int)rec[i][0]+35, (int)rec[i][1]-10, 50, 50);
        	seatPanel.add(seatPrice[i]);
        	seatPanel.add(seatPriceLabel[i]);
        }
        // A존
        JPanel zoneA = new JPanel();
        zoneA.setBounds(25, 100, 180, 310);
        zoneA.setBorder(BorderFactory.createLineBorder(new Color(0, 153, 0), 2));
        zoneA.setLayout(null);  // Layout Manager를 null로 설정하여 수동으로 위치 조정 
        zoneA.setOpaque(false); // 내부를 투명하게 설정
        JLabel zoneALabel = new JLabel("A구역");
        zoneALabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        zoneALabel.setHorizontalAlignment(SwingConstants.CENTER);
        int label_x = (zoneA.getWidth() - 50) / 2; // 테두리의 가로 중앙 
        int label_y = (zoneA.getHeight() - 50)/ 2; // 테두리의 세로 중앙
        zoneALabel.setBounds(label_x, label_y, 50, 50);
        zoneA.add(zoneALabel);
        
        
        // B존
        JPanel zoneB = new JPanel();
        zoneB.setBounds(205, 100, 180, 310);
        zoneB.setBorder(BorderFactory.createLineBorder(new Color(57, 107, 249), 2));
        zoneB.setLayout(null);  // Layout Manager를 null로 설정하여 수동으로 위치 조정 
        zoneB.setOpaque(false); // 내부를 투명하게 설정
        JLabel zoneBLabel = new JLabel("B구역");
        zoneBLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        zoneBLabel.setHorizontalAlignment(SwingConstants.CENTER);
        label_x = (zoneB.getWidth() - 50) / 2; // 테두리의 가로 중앙 
        label_y = (zoneB.getHeight() - 50)/ 2; // 테두리의 세로 중앙
        zoneBLabel.setBounds(label_x, label_y, 50, 50);
        zoneB.add(zoneBLabel);

        
        // C존
        JPanel zoneC = new JPanel();
        zoneC.setBounds(385, 100, 180, 310);
        zoneC.setBorder(BorderFactory.createLineBorder(new Color(253, 93, 93), 2));
        zoneC.setLayout(null);  // Layout Manager를 null로 설정하여 수동으로 위치 조정 
        zoneC.setOpaque(false); // 내부를 투명하게 설정
        JLabel zoneCLabel = new JLabel("C구역");
        zoneCLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        zoneCLabel.setHorizontalAlignment(SwingConstants.CENTER);
        label_x = (zoneC.getWidth() - 50) / 2; // 테두리의 가로 중앙 
        label_y = (zoneC.getHeight() - 50)/ 2; // 테두리의 세로 중앙
        zoneCLabel.setBounds(label_x, label_y, 50, 50);
        zoneC.add(zoneCLabel);

        
        // Gold존 테두리
        JPanel zoneS = new JPanel();
        zoneS.setBounds(40, 440, 520, 110);
        zoneS.setBorder(BorderFactory.createLineBorder(new Color(255, 204, 0), 2));
        zoneS.setLayout(null);  // Layout Manager를 null로 설정하여 수동으로 위치 조정 
        zoneS.setOpaque(false); // 내부를 투명하게 설정
        JLabel zoneSLabel = new JLabel("S구역");
        zoneSLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        zoneSLabel.setLayout(null);
        label_x = (zoneS.getWidth() - 50) / 2; // 테두리의 가로 중앙 
        label_y = (zoneS.getHeight() - 50)/ 2; // 테두리의 세로 중앙
        zoneSLabel.setBounds(label_x, label_y, 100, 100);  
        zoneS.add(zoneSLabel);
        
        
        add(zoneA);
        add(zoneB);
        add(zoneC);
        add(zoneS);
    
        //add(seatMenu);
        add(seatPanel);

        //setLayout(null); // 레이아웃 설정 추가
        setVisible(true); // 프레임을 보이게 설정
        
    }

    private class SeatButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            int seatNumber = Integer.parseInt(clickedButton.getText());
            // API 호출하여 예약 처리
            reserveSeat(seatNumber);
            clickedButton.setBackground(Color.GRAY); // 예약된 좌석은 빨간색으로 표시
            // 알림창 표시
            JOptionPane.showMessageDialog(SeatReservation.this, "좌석 " + seatNumber +"번이 선택되었습니다.");
        }
    }

    private void reserveSeat(int seatNumber) {
        // 좌석 예약 API 호출
        // 실제 구현에서는 HttpURLConnection을 사용하여 서버와 통신
        System.out.println("Seat " + seatNumber + " reserved.");
    }
    

    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SeatReservation().setVisible(true);
            }
        });
    }
}

