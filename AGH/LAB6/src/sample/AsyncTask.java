package sample;

import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.GraphicsContext;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;


public class AsyncTask extends Task<Double> {
    private int amount;
    double result = 0.0;
    double counter = 0;
    private GraphicsContext gc;

    AsyncTask(int amount, GraphicsContext gc) {
        this.amount = amount;
        this.gc = gc;
    }

    @Override
    protected Double call() throws Exception{
        try {

            double MAX = 8.0;
            double MIN = -8.0;
            Random random = new Random();
            BufferedImage bi = new BufferedImage(600, 400, BufferedImage.TYPE_INT_RGB);

            for (int i = 0; i <amount; i++) {
                double x = MIN + (MAX - MIN) * random.nextDouble();
                double y = MIN + (MAX - MIN) * random.nextDouble();
                if (Equation.calc(x, y)) {
                    double xPrim, yPrim;
                    xPrim = ((380) * (x + 8) / (8 + 8) + 0);
                    yPrim = ((200) * (y + 8) / (8 + 8) + 0);
                    bi.setRGB((int) xPrim, (int) yPrim, Color.YELLOW.getRGB());
                    counter++;
                    if (i % 50 == 0) {
                        gc.drawImage(SwingFXUtils.toFXImage(bi, null), 0, 0);
                    }
                    updateProgress(i, amount);
                }
                if (isCancelled()) {
                    break;
                }
            }
        }
        catch(Exception e) {
            System.out.println("ERROR!");
        }
        result =256*(double)(counter/amount);
        return result;
    }
    public double returnResult(){
        result =256*(double)(counter/amount);
        return result;
    }


}
