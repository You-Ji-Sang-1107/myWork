package breakoutStyleGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class setupGame extends JPanel implements KeyListener {
    private static final int WIDTH = 800;  // ȭ�� �ʺ�
    private static final int HEIGHT = 600;  // ȭ�� ����

    // �� �Ӽ�
    private int ballX = WIDTH / 2;
    private int ballY = HEIGHT / 2;
    private int ballRadius = 15;
    private int ballSpeedX = 3;
    private int ballSpeedY = 3;

    // �е� �Ӽ�
    private int paddleWidth = 100;
    private int paddleHeight = 15;
    private int paddleX = WIDTH / 2 - paddleWidth / 2;
    private int paddleY = HEIGHT - 50;  // �е��� y ��ġ
    private int paddleSpeed = 15;

    // ���� �Ӽ�
    private final int brickRows = 5;
    private final int brickColumns = 10;
    private final int brickWidth = 60;
    private final int brickHeight = 20;
    private ArrayList<Rectangle> bricks;  // ���� ����Ʈ

    public setupGame() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.addKeyListener(this);
        this.setFocusable(true);  // Ű���� �Է� Ȱ��ȭ

        // ���� �ʱ�ȭ
        bricks = new ArrayList<>();
        for (int row = 0; row < brickRows; row++) {
            for (int col = 0; col < brickColumns; col++) {
                int x = col * (brickWidth + 10) + 50;
                int y = row * (brickHeight + 10) + 50;
                bricks.add(new Rectangle(x, y, brickWidth, brickHeight));
            }
        }
    }

    // �е� �׸���
    public void drawPaddle(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(paddleX, paddleY, paddleWidth, paddleHeight);
    }

    // ���� �׸���
    public void drawBricks(Graphics g) {
        g.setColor(Color.ORANGE);
        for (Rectangle brick : bricks) {
            g.fillRect(brick.x, brick.y, brick.width, brick.height);
        }
    }

    // �� ������ �� �浹 ó��
    public void moveBall() {
        ballX += ballSpeedX;
        ballY += ballSpeedY;

        // �� �浹
        if (ballX - ballRadius <= 0 || ballX + ballRadius >= WIDTH) {
            ballSpeedX = -ballSpeedX;  // x�� �ݻ�
        }
        if (ballY - ballRadius <= 0) {
            ballSpeedY = -ballSpeedY;  // y�� �ݻ�
        }

        // �е� �浹
        if (ballY + ballRadius >= paddleY && ballX >= paddleX && ballX <= paddleX + paddleWidth) {
            ballSpeedY = -ballSpeedY;
            // ���� �ӵ��� ���� ������
            ballSpeedX += (ballSpeedX > 0) ? 1 : -1;
            ballSpeedY += (ballSpeedY > 0) ? 1 : -1;
        }

        // ���� �浹
        for (int i = 0; i < bricks.size(); i++) {
            Rectangle brick = bricks.get(i);
            if (brick.contains(ballX, ballY)) {
                bricks.remove(i);  // ���� ����
                ballSpeedY = -ballSpeedY;  // y�� �ݻ�
                break;
            }
        }

        // �ٴڿ� �������� �� ���� ���� ó��
        if (ballY - ballRadius >= HEIGHT) {
            System.out.println("���� ����!");
            System.exit(0);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // �� �׸���
        g.setColor(Color.WHITE);
        g.fillOval(ballX - ballRadius, ballY - ballRadius, ballRadius * 2, ballRadius * 2);

        // �е� �׸���
        drawPaddle(g);

        // ���� �׸���
        drawBricks(g);
    }

    // Ű���� �Է� ó��
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT && paddleX > 0) {
            paddleX -= paddleSpeed;  // �е� ���� �̵�
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && paddleX + paddleWidth < WIDTH) {
            paddleX += paddleSpeed;  // �е� ������ �̵�
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Breakout Style Game");
        setupGame gamePanel = new setupGame();
        frame.add(gamePanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // ȭ�� ���� �� ���� ����
        Timer timer = new Timer(16, e -> {
            gamePanel.moveBall();
            gamePanel.repaint();
        });
        timer.start();
    }
}
