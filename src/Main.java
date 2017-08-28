import Array.TaskScheduler;

/**
 * Created by Lin on 2017/2/12.
 */
public class Main {
    public static void main(String[] args){

        TaskScheduler ts = new TaskScheduler();
        char[] tasks = {'A','A','B','B','B','A'};

        ts.leastInterval(tasks, 2);
    }
}
