import java.awt.EventQueue;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var window = new TriangleWindow();
            window.show();
        });
    }
}