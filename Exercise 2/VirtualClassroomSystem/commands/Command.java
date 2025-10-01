package VirtualClassroomSystem.commands;

import VirtualClassroomSystem.classroom.ClassroomManager;

/**
 * Command interface following Command Pattern
 * Similar to MarsRover Command structure
 */
public interface Command {
    /**
     * Execute the command on the classroom manager
     * @param manager The classroom manager to operate on
     */
    void execute(ClassroomManager manager);
    
    /**
     * Get command description for help/logging
     * @return String description of the command
     */
    String getDescription();
}