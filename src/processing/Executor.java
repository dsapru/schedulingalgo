package processing;

import output.Output;
import tasks.Task;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Executor {

    private static final long UNIT_OF_TIME = 1000;
    private CPU mCpu;
    private Scheduler mScheduler;

    public Executor(CPU cpu, Scheduler scheduler) {
        this.mCpu = cpu;
        this.mScheduler = scheduler;
    }

    /**
     * executes the input tasks on the cpu {@link CPU} using the {@link Scheduler}
     */
    public void execute() {
        Output output = new Output(mScheduler.getTaskRemaining(), mCpu.getRunTimeRemaining());
        output.setOutputFile("output.txt");
        mCpu.start();
        Task task;
        //keep running until either there are no more tasks or the cpu run time is over
        while ((!mScheduler.isComplete() &&
                mCpu.isActive())) {
            task = mScheduler.getCurrentTask();
            mCpu.assignTask(task);
            //if there exist some task to be execute then only execute
            if (task != null)
                mCpu.execute();
            //mock one second (unit of time), before the next execution
            try {
                Thread.sleep(UNIT_OF_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //update the task, if its not complete yet
            if (task != null) {
                //a task was executed, add it to execution order
                output.addExectingTask(task.getId());
                if (task.isComplete()) {
                    //finished with this task, mark as complete in output file
                    output.addToComplete(task.getId());
                    mScheduler.decrementTaskRemaining();
                } else
                    mScheduler.update(task);

            }else{
                //no task at this time, -1
                output.addExectingTask(-1);
            }
        }
        //after getting out of the schedule, set output params
        output.setRemainingCpuTime(mCpu.getRunTimeRemaining());
        output.setRemainingTasks(mScheduler.getTaskRemaining());
        if(mCpu.getRunTimeRemaining()>0){
            output.setMessage("Finished all tasks");
        }else{
            output.setMessage("Ran out of the CPU time "+mScheduler.getTaskRemaining()+" tasks remaining");
        }
        output.writeToOutputFile();
    }
}
