import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

public class TriangleCanvas extends Canvas {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 680;
    private static final int LEFT_MARGIN = 70;
    private static final int TOP_MARGIN = 45;
    private static final int COLUMN_WIDTH = 30;
    private static final int ROW_HEIGHT = 30;
    private static final Font NUMBER_FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 18);

    TriangleCanvas() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        super.setBackground(Color.WHITE);
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(NUMBER_FONT);

        for (int row = NumTriangleBody.FIRST_NUMBER;
             row <= NumTriangleBody.LAST_NUMBER;
             row++) {
            int y = TOP_MARGIN + row * ROW_HEIGHT;

            for (int number = row; number <= NumTriangleBody.LAST_NUMBER; number++) {
                int x = LEFT_MARGIN + number * COLUMN_WIDTH;
                g.drawString(Integer.toString(number), x, y);
            }
        }
    }
}
