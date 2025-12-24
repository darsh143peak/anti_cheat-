public class AlertSystem extends Thread{
    private CheatingScoreEngine engine;
    public AlertSystem(CheatingScoreEngine engine){
        this.engine=engine;
    }
    public void run(){
        try{
            while(true){
                int score=engine.getScore();
                if(score>=50){
                    System.out.println("Exam Terminated Due to Cheating!");
                    System.exit(0);
                }
                else if(score>=30){
                    System.out.println("⚠ WARNING: Do not switch windows!");
                }
                Thread.sleep(2000);
            }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}