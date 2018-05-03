package tasks;
import com.google.gson.annotations.SerializedName;

public class Task {

    @SerializedName("cpu_time")
    private long mCpuTime;
    @SerializedName("id")
    private long mId;
    @SerializedName("start_time")
    private long mStartTime;
    private long mAllocatedCpuTime;
    private boolean mComplete;

    public Task(Task task){
        this.mComplete = task.mComplete;
        this.mId = task.mId;
        this.mStartTime = task.mStartTime;
        this.mAllocatedCpuTime = task.mAllocatedCpuTime;
        this.mComplete = task.mComplete;
    }

    public Long getCpuTime() {
        return mCpuTime;
    }

    public void setCpuTime(Long cpuTime) {
        mCpuTime = cpuTime;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Long getStartTime() {
        return mStartTime;
    }

    public void setStartTime(Long startTime) {
        mStartTime = startTime;
    }

    public void incrementAllocatedCpuTime(){
        mAllocatedCpuTime++;
    }

    public void decrementCpuTimeRequired(){
        mCpuTime--;
        if(mCpuTime <= 0){
            //System.out.println("Task "+mId+" finished");
            mComplete =true;
        }
    }

    public boolean isComplete() {
        return mComplete;
    }

    public long getAllocatedCpuTime(){
        return mAllocatedCpuTime;
    }
}

