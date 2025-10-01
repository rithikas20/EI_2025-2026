package VirtualClassroomSystem.commands;

import VirtualClassroomSystem.classroom.ClassroomManager;

/**
 * Command to submit an assignment
 * Follows Command Pattern structure
 */
public class SubmitAssignmentCommand implements Command {
    private final String studentId;
    private final String classroomName;
    private final String assignmentDetails;

    public SubmitAssignmentCommand(String studentId, String classroomName, String assignmentDetails) {
        this.studentId = studentId;
        this.classroomName = classroomName;
        this.assignmentDetails = assignmentDetails;
    }

    @Override
    public void execute(ClassroomManager manager) {
        manager.submitAssignment(studentId, classroomName, assignmentDetails);
    }

    @Override
    public String getDescription() {
        return "Submit assignment by " + studentId + " in " + classroomName + ": " + assignmentDetails;
    }
}