import java.time.LocalTime;
    public class ExamLogger {
    public static void log(String msg){
        System.out.println(LocalTime.now()+" | "+msg);
    }
}
