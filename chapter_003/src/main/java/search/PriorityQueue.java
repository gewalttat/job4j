package search;

import com.sun.jmx.snmp.tasks.TaskServer;

import java.util.*;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        int tasksSize = tasks.size();
        for (int i = 0; i < tasksSize; i++) {
            if (task.getPriority() < tasks.get(i).getPriority()) {
                tasksSize = i;
                break;
            }
        }
        tasks.add(tasksSize, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}