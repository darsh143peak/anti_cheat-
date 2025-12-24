public class CheatingScoreEngine{
    private int cheatingScore=0;
    public synchronized void addScore(int val,String msg){
        cheatingScore+=val;
        ExamLogger.log(msg+" | "+val+" | Total = "+cheatingScore);
    }
    public synchronized int getScore(){
        return cheatingScore;
    }
}
