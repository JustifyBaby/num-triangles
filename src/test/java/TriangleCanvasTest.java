import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.jupiter.api.Test;

class TriangleCanvasTest {
    @Test
    void numberRangeIsZeroThroughNineteen() {
        assertEquals(0, NumTriangleBody.FIRST_NUMBER);
        assertEquals(19, NumTriangleBody.LAST_NUMBER);
    }

    @Test
    void canvasHasExpectedSizeAndWhiteBackground() {
        TriangleCanvas canvas = new TriangleCanvas();

        assertEquals(800, canvas.getWIDTH());
        assertEquals(680, canvas.getHEIGHT());
        assertEquals(Color.WHITE, canvas.getBackground());
    }

    @Test
    void paintDrawsNumbersFromRowStartThroughNineteen() {
        TriangleCanvas canvas = new TriangleCanvas();
        BufferedImage image = new BufferedImage(
                canvas.getWIDTH(), canvas.getHEIGHT(), BufferedImage.TYPE_INT_RGB);

        Graphics2D graphics = image.createGraphics();
        try {
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
            canvas.paint(graphics);
        } finally {
            graphics.dispose();
        }

        assertTrue(hasInk(image, 70, 45), "row 0 should contain 0");
        assertTrue(hasInk(image, 100, 45), "row 0 should contain 1");
        assertTrue(hasInk(image, 100, 75), "row 1 should contain 1");
        assertTrue(hasInk(image, 640, 615), "row 19 should contain 19");
        assertTrue(!hasInk(image, 70, 75), "row 1 should not contain 0");
    }

    private static boolean hasInk(BufferedImage image, int cellX, int baselineY) {
        for (int y = baselineY - 20; y <= baselineY; y++) {
            for (int x = cellX; x < cellX + 28; x++) {
                if ((image.getRGB(x, y) & 0x00ffffff) != 0x00ffffff) {
                    return true;
                }
            }
        }
        return false;
    }
}
