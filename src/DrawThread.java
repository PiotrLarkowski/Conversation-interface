public class DrawThread extends Thread implements Runnable {
    private MyJPanel panel;
    private boolean isRunning = true;
    public DrawThread(MyJPanel panel) {
        this.panel = panel;
    }
    public void stopThread(){
        isRunning = false;
    }
    @Override
    public void run() {
        try {
            while(isRunning) {
                panel.drawString();
                Thread.sleep(1500);
                panel.drawBlank();
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
