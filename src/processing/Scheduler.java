package processing;

import input.Input;
import tasks.Task;

import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 * This is the scheduler build from the input file
 * {@link TreeMap is an implementation of red black tree, its key is the cpu allocated time, so the left most leaf node
 * will always have the most unfair task, which will be selected in inorder travesal}
 */
public class Scheduler {
    private TreeMap<String, Task> mRedBlackTree;
    private long timer = 1;
    private Input mInput;
    private long mTaskRemaining;

    public Scheduler() {
        mRedBlackTree = new TreeMap<>();
    }

    public void schedule(Input input) {
        this.mInput = input;
        this.mTaskRemaining = input.getNumOfTasks();
        //input all the tasks in the tree with key as allocated cpu time
        input.getTasks().stream().filter(task -> task.getStartTime() == timer).
                forEach(task -> mRedBlackTree.put(makeTaskKey(task), task));
        mInput.getTasks().removeIf(task -> task.getStartTime() == timer);
    }

    private String makeTaskKey(Task task) {
        return task.getAllocatedCpuTime() + "T" + task.getId();
    }

    //TODO, remove later
    public TreeMap<String, Task> getmRedBlackTree() {
        return mRedBlackTree;
    }

    public void update(Task task) {
        // make updated entry // log n time
        mRedBlackTree.put(makeTaskKey(task), task);
    }

    public void decrementTaskRemaining() {
        mTaskRemaining--;
    }

    /**
     * returns the task which has the worst allocated cpu time, thus implementing the cfs algorithm
     * {@link TreeMap returns the first entry in-order traversal on the {@link TreeMap#firstEntry()}},
     * also this function adds more entities to the tree based on the cpu time
     *
     * @return current Task {@link Task}
     */
    public Task getCurrentTask() {
        System.out.println();
        System.out.print(" Timeline:"+timer+">> ");
        timer++;
        Task currentTask = null;
        if (!mRedBlackTree.isEmpty()) {
            currentTask = mRedBlackTree.remove(mRedBlackTree.firstKey());
        }
        //add more task entities to the tree for next timer
        mInput.getTasks().stream().filter(task -> task.getStartTime() == timer).
                forEach(task -> mRedBlackTree.put(makeTaskKey(task), task));
        mInput.getTasks().removeIf(task -> task.getStartTime() == timer);
        //find and remove the first entry(in order, left most leaf) // log n time
        mRedBlackTree.forEach((key, value) ->
                System.out.print(" Task " + value.getId() + " unfair value " + value.getAllocatedCpuTime()+" ||"));
        return currentTask;
    }

    public boolean isComplete() {
        return mTaskRemaining <= 0;
    }

    public long getTaskRemaining() {
        return mTaskRemaining;
    }

}
