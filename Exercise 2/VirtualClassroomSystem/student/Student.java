package VirtualClassroomSystem.student;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Student class - similar to Direction/Status classes in MarsRover
 * Represents a student in the virtual classroom system
 */
public class Student {
    private final String studentId;
    private final Set<String> enrolledClassrooms;
    private final LocalDateTime registeredAt;

    public Student(String studentId) {
        this.studentId = studentId;
        this.enrolledClassrooms = new HashSet<>();
        this.registeredAt = LocalDateTime.now();
    }

    public void enrollInClassroom(String classroomName) {
        enrolledClassrooms.add(classroomName);
    }

    public void unenrollFromClassroom(String classroomName) {
        enrolledClassrooms.remove(classroomName);
    }

    public boolean isEnrolledIn(String classroomName) {
        return enrolledClassrooms.contains(classroomName);
    }

    public String getStudentId() {
        return studentId;
    }

    public Set<String> getEnrolledClassrooms() {
        return new HashSet<>(enrolledClassrooms);
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    @Override
    public String toString() {
        return String.format("Student{id='%s', classrooms=%d, registered=%s}", 
                           studentId, enrolledClassrooms.size(), 
                           registeredAt.toLocalDate());
    }
}