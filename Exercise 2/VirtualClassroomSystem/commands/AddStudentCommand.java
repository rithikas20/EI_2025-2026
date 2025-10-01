package VirtualClassroomSystem.commands;

import VirtualClassroomSystem.classroom.ClassroomManager;

/**
 * Command to add a student to a classroom
 * Follows Command Pattern structure
 */
public class AddStudentCommand implements Command {
    private final String studentId;
    private final String classroomName;

    public AddStudentCommand(String studentId, String classroomName) {
        this.studentId = studentId;
        this.classroomName = classroomName;
    }

    @Override
    public void execute(ClassroomManager manager) {
        manager.addStudent(studentId, classroomName);
    }

    @Override
    public String getDescription() {
        return "Add student " + studentId + " to " + classroomName;
    }
}