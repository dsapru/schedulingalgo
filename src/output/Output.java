package output;

import com.google.gson.Gson;
import tasks.Task;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Packer class to help plot the output x-axis is tasks, y-axis is time
 */
public class Output {
    private long mNumberOfTasks;
    private long mTotalTime;
    private long mRemainingTasks;
    private long mRemainingCpuTime;
    private List<Long> mCompletionOrder;
    private String mMessage;
    //execution order of the task with unit time separation
    private List<Long> mTasksExecutionOrder;

    public Output(long numberOfTasks, long totalTime) {
        this.mNumberOfTasks = numberOfTasks;
        this.mTotalTime = totalTime;
        this.mTasksExecutionOrder = new ArrayList<>();
        this.mCompletionOrder = new ArrayList<>();
    }

    /**
     * add new task to the execution order
     *
     * @param id
     */
    public void addExectingTask(long id) {
        mTasksExecutionOrder.add(id);
    }

    public void addToComplete(long id) {
        mCompletionOrder.add(id);
    }

    public void setRemainingTasks(long remainingTasks){
        this.mRemainingTasks = remainingTasks;
    }

    public void setRemainingCpuTime(long remainingCpuTime){
        this.mRemainingCpuTime = remainingCpuTime;
    }

    public long getNumberOfTasks() {
        return mNumberOfTasks;
    }

    public void setNumberOfTasks(long numberOfTasks) {
        this.mNumberOfTasks = numberOfTasks;
    }

    public long getTotalTime() {
        return mTotalTime;
    }

    public void setTotalTime(long totalTime) {
        this.mTotalTime = totalTime;
    }

    public long getRemainingTasks() {
        return mRemainingTasks;
    }


    public long getRemainingCpuTime() {
        return mRemainingCpuTime;
    }

    public List<Long> getCompletionOrder() {
        return mCompletionOrder;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        this.mMessage = message;
    }

    public List<Long> getTasksExecutionOrder() {
        return mTasksExecutionOrder;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    /**
     * writes the output to the file
     */
    public void writeToOutputFile(){
        System.out.println(toString());
    }

    /**
     * sets the output file
     * @param pathToSave
     */
    public void setOutputFile(String pathToSave){
        PrintStream out = null;
        try {
            out = new PrintStream(new FileOutputStream(pathToSave));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(out);
    }
}
