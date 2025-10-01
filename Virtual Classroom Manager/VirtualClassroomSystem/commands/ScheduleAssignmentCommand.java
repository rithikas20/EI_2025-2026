package VirtualClassroomSystem.commands;

import VirtualClassroomSystem.classroom.ClassroomManager;

/**
 * Command to schedule an assignment for a classroom
 * Follows Command Pattern structure
 */
public class ScheduleAssignmentCommand implements Command {
    private final String classroomName;
    private final String assignmentDetails;

    public ScheduleAssignmentCommand(String classroomName, String assignmentDetails) {
        this.classroomName = classroomName;
        this.assignmentDetails = assignmentDetails;
    }

    @Override
    public void execute(ClassroomManager manager) {
        manager.scheduleAssignment(classroomName, assignmentDetails);
    }

    @Override
    public String getDescription() {
        return "Schedule assignment for " + classroomName + ": " + assignmentDetails;
    }
}