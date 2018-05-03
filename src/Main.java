import input.InputHelper;
import processing.CPU;
import processing.Executor;
import processing.Scheduler;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        InputHelper helper = InputHelper.getInstance();
        Scheduler scheduler = new Scheduler();
        scheduler.schedule(helper.getInput());
        //System.out.println(scheduler.getmRedBlackTree().entrySet());
        CPU cpu = CPU.getInstance(helper.getInput().getTimeToRun());
        Executor executor = new Executor(cpu,scheduler);
        executor.execute();
    }


}
