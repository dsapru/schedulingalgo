package processing;

import tasks.Task;

import java.util.ArrayList;

public class CPU {
    private boolean mActive;
    private Task mCurrentTask;
    private long mRunTimeRemaining;

    private static CPU mInstance;
    ArrayList<Long> mTaskIdOrder;

    public static CPU getInstance(long runTime){
        if(mInstance == null){
            mInstance = new CPU(runTime);
        }
        return mInstance;
    }

    private CPU(long runTime){
        mActive = true;
        mRunTimeRemaining = runTime;
    }

    public void execute(){
        if(!mActive){
            return;
        }
        if(mRunTimeRemaining <= 0){
            abort();
            return;
        }
        mCurrentTask.decrementCpuTimeRequired();
        mCurrentTask.incrementAllocatedCpuTime();
    }

    public boolean decrementRemainingTime(){
        mRunTimeRemaining--;
        return mRunTimeRemaining < 0;
    }

    public long getRunTimeRemaining(){
        return mRunTimeRemaining;
    }

    public void abort(){
        mActive =false;
    }

    public boolean isActive() {
        return mActive;
    }

    public void assignTask(Task task) {
        if(task ==null){
            mTaskIdOrder.add((long) -1);
            mCurrentTask = null;
            return;
        }
        mTaskIdOrder.add(task.getId());
        mCurrentTask = task;
    }

    public void start() {
        mTaskIdOrder = new ArrayList<>();
    }
}
