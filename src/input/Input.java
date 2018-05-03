
package input;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import tasks.Task;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Input {

    @SerializedName("num_of_tasks")
    private Long mNumOfTasks;
    @SerializedName("tasks")
    private List<Task> mTasks;
    @SerializedName("time_to_run")
    private Long mTimeToRun;

    public Long getNumOfTasks() {
        return mNumOfTasks;
    }

    public void setNumOfTasks(Long numOfTasks) {
        mNumOfTasks = numOfTasks;
    }

    public List<Task> getTasks() {
        return mTasks;
    }

    public void setTasks(List<Task> tasks) {
        mTasks = tasks;
    }

    public Long getTimeToRun() {
        return mTimeToRun;
    }

    public void setTimeToRun(Long timeToRun) {
        mTimeToRun = timeToRun;
    }

}
