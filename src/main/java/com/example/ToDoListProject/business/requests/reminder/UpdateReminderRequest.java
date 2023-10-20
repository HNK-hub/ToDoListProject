package com.example.ToDoListProject.business.requests.reminder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReminderRequest {
    private int id;
    private String message;
    private LocalDateTime reminderDateTime;
    private int taskId;
}