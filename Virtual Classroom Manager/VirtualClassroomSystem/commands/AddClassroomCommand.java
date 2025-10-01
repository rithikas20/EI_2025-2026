package VirtualClassroomSystem.commands;

import VirtualClassroomSystem.classroom.ClassroomManager;

/**
 * Command to add a new classroom
 * Follows Command Pattern like MarsRover MoveCommand
 */
public class AddClassroomCommand implements Command {
    private final String classroomName;

    public AddClassroomCommand(String classroomName) {
        this.classroomName = classroomName;
    }

    @Override
    public void execute(ClassroomManager manager) {
        manager.addClassroom(classroomName);
    }

    @Override
    public String getDescription() {
        return "Add classroom: " + classroomName;
    }
}