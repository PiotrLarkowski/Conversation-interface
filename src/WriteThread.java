public class WriteThread extends Thread implements Runnable{
    private MyJPanel panel;
    private boolean isRunning = true;
    private int numberOfPrintedLetter = 1;
    private String message;
    public WriteThread(MyJPanel panel, String message) {
        this.panel = panel;
        this.message = message;
    }
    public void stopThread(){
        isRunning = false;
    }
    @Override
    public void run() {
        try {
            while(isRunning) {
                if(numberOfPrintedLetter>message.length()){
                    isRunning = false;
                }else {
                    panel.drawMessage(message.substring(numberOfPrintedLetter));
                    Thread.sleep(500);
                    numberOfPrintedLetter++;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
