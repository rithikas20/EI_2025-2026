package VirtualClassroomSystem.classroom;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Assignment class - similar to Obstacle in MarsRover
 * Represents an assignment that can be submitted by students
 */
public class Assignment {
    private final String details;
    private final String classroomName;
    private final LocalDateTime scheduledAt;
    private final Set<String> submissions;

    public Assignment(String classroomName, String details) {
        this.classroomName = classroomName;
        this.details = details;
        this.scheduledAt = LocalDateTime.now();
        this.submissions = new HashSet<>();
    }

    public void addSubmission(String studentId) {
        submissions.add(studentId);
    }

    public boolean hasSubmission(String studentId) {
        return submissions.contains(studentId);
    }

    public String getDetails() {
        return details;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public LocalDateTime getScheduledAt() {
        return scheduledAt;
    }

    public Set<String> getSubmissions() {
        return new HashSet<>(submissions);
    }

    public boolean matchesDetails(String searchDetails) {
        return details.toLowerCase().contains(searchDetails.toLowerCase());
    }

    @Override
    public String toString() {
        return String.format("Assignment{details='%s', submissions=%d}", 
                           details, submissions.size());
    }
}