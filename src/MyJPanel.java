import javax.swing.*;
import java.awt.*;

public class MyJPanel extends JPanel {
    private boolean drawString = false;
    private boolean drawMessage = false;
    private String currentMessage;
    WriteThread writeThread;
    DrawThread drawThread;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public MyJPanel(){
        setBackground(new Color(255, 255, 255));
        setPreferredSize(screenSize);
//        startDrawingThread();
        writeThread = new WriteThread(this, "Witam jestem Piotr");
        writeThread.run();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(0, 0, 0));
        g.fillRoundRect((int)calculateGivenPercentageFromGivenNumber(5, screenSize.width),
                (int)calculateGivenPercentageFromGivenNumber(10, screenSize.height),
                screenSize.width-(2*(int)calculateGivenPercentageFromGivenNumber(5, screenSize.width)),
                screenSize.height-(2*((int)calculateGivenPercentageFromGivenNumber(15, screenSize.height))),30,30);
        g.setColor(new Color(255, 255, 255));
        g.fillRoundRect((int)calculateGivenPercentageFromGivenNumber(5, screenSize.width)+1,
                (int)calculateGivenPercentageFromGivenNumber(10, screenSize.height)+1,
                screenSize.width-(2*(int)calculateGivenPercentageFromGivenNumber(5, screenSize.width))-2,
                screenSize.height-(2*((int)calculateGivenPercentageFromGivenNumber(15, screenSize.height)))-2,30,30);
        g.setColor(new Color(0, 0, 0));
        g.fillRoundRect((int)calculateGivenPercentageFromGivenNumber(5, screenSize.width),
                screenSize.height-(2*((int)calculateGivenPercentageFromGivenNumber(9, screenSize.height))),
                screenSize.width-(2*(int)calculateGivenPercentageFromGivenNumber(5, screenSize.width)),
                (int)calculateGivenPercentageFromGivenNumber(15, screenSize.height),30,30);
        g.setColor(new Color(255, 255, 255));
        g.fillRoundRect((int)calculateGivenPercentageFromGivenNumber(5, screenSize.width)+1,
                screenSize.height-(2*((int)calculateGivenPercentageFromGivenNumber(9, screenSize.height)))+1,
                screenSize.width-(2*(int)calculateGivenPercentageFromGivenNumber(5, screenSize.width))-2,
                (int)calculateGivenPercentageFromGivenNumber(15, screenSize.height)-2,30,30);
        if (drawString) {
            g.setColor(new Color(0, 0, 0));
            g.fillRoundRect((int)calculateGivenPercentageFromGivenNumber(5, screenSize.width),
                    (int)calculateGivenPercentageFromGivenNumber(5, screenSize.height),
                    100,50,30,30);
            g.setColor(Color.WHITE);
            g.fillRoundRect((int)calculateGivenPercentageFromGivenNumber(5, screenSize.width)+3,
                    (int)calculateGivenPercentageFromGivenNumber(5, screenSize.height)+3,
                    100-6,50-6,30,30);
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font("Tahoma",Font.ITALIC,24));
            g.drawString("Pisze",(int)calculateGivenPercentageFromGivenNumber(5, screenSize.width)+15,
                    (int)calculateGivenPercentageFromGivenNumber(5, screenSize.height)+35);
        }
        if(drawMessage){
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font("Tahoma",Font.PLAIN,24));
            g.drawString(currentMessage,(int)calculateGivenPercentageFromGivenNumber(5, screenSize.width)+50,
                    (int)calculateGivenPercentageFromGivenNumber(5, screenSize.height)+100);
        }
    }
    public void startDrawingThread() {
        drawThread = new DrawThread(this);
        drawThread.start();
    }
    public void stopDrawingThread() {
        drawThread.stopThread();
    }
    private double calculateGivenPercentageFromGivenNumber(int percentage, int givenValue){
        return (double) (percentage * givenValue) /100;
    }
    public void drawString() {
        this.drawString = true;
        repaint();
    }
    public void drawBlank() {
        this.drawString = false;
        repaint();
    }
    public void drawMessage(String message){
        startDrawingThread();
        drawMessage = true;
        currentMessage = message;
        repaint();
    }
}
