package VirtualClassroomSystem.classroom;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Classroom class - similar to Grid in MarsRover
 * Represents a virtual classroom with students and assignments
 */
public class Classroom {
    private final String name;
    private final Set<String> enrolledStudents;
    private final List<Assignment> assignments;
    private final LocalDateTime createdAt;

    public Classroom(String name) {
        this.name = name;
        this.enrolledStudents = new HashSet<>();
        this.assignments = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
    }

    public void enrollStudent(String studentId) {
        enrolledStudents.add(studentId);
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    public boolean isStudentEnrolled(String studentId) {
        return enrolledStudents.contains(studentId);
    }

    public String getName() {
        return name;
    }

    public Set<String> getEnrolledStudents() {
        return new HashSet<>(enrolledStudents);
    }

    public List<Assignment> getAssignments() {
        return new ArrayList<>(assignments);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return String.format("Classroom{name='%s', students=%d, assignments=%d}", 
                           name, enrolledStudents.size(), assignments.size());
    }
}