package assignment.thymeleafpracticetaskmanager.service;

import assignment.thymeleafpracticetaskmanager.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private List<Task> tasks = new ArrayList<>();
    private Long nextId = 1L;

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task getTaskById(Long id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void createTask(Task task) {
        task.setId(nextId);
        nextId++;
        tasks.add(task);
    }

    public void updateTask(Task updatedTask) {
        Task existingTask = getTaskById(updatedTask.getId());
        if (existingTask != null) {
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setCompleted(updatedTask.isCompleted());
        }
    }

    public void deleteTask(Long id) {
        Task taskToRemove = getTaskById(id);
        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
        }
    }
}

