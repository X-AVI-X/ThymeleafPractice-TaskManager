package assignment.thymeleafpracticetaskmanager.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Task {
    private Long id;
    private String title;
    private boolean completed;

}
