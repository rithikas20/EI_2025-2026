package VirtualClassroomSystem;

import VirtualClassroomSystem.classroom.ClassroomManager;
import VirtualClassroomSystem.commands.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Main application class - similar to MarsRover Main.java
 * Handles user input and executes commands using Command Pattern
 */
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final Scanner scanner = new Scanner(System.in);
    private static final ClassroomManager manager = new ClassroomManager();

    public static void main(String[] args) {
        printWelcome();
        logger.info("Virtual Classroom Manager started");
        
        while (true) {
            try {
                manager.showStatus();
                System.out.print("Enter command: ");
                String input = scanner.nextLine().trim();
                
                if (input.isEmpty()) continue;
                if ("exit".equalsIgnoreCase(input) || "quit".equalsIgnoreCase(input)) {
                    break;
                }
                
                Command command = parseCommand(input);
                if (command != null) {
                    command.execute(manager);
                    logger.info("Command executed: " + command.getDescription());
                } else {
                    System.out.println("Unknown command. Type 'help' for available commands.");
                }
                
            } catch (Exception e) {
                System.out.println("System Error: " + e.getMessage());
                logger.severe("Command processing failed: " + e.getMessage());
            }
        }
        
        shutdown();
    }

    private static void printWelcome() {
        System.out.println("========================================================");
        System.out.println("          Virtual Classroom Manager v1.0               ");
        System.out.println("              Command-Line Interface                    ");
        System.out.println("========================================================");
        System.out.println();
        System.out.println("Available commands:");
        System.out.println("  add_classroom <class_name>");
        System.out.println("  add_student <student_id> <class_name>");
        System.out.println("  schedule_assignment <class_name> <assignment_details>");
        System.out.println("  submit_assignment <student_id> <class_name> <assignment_details>");
        System.out.println("  list_classrooms");
        System.out.println("  list_students <class_name>");
        System.out.println("  help");
        System.out.println("  exit");
        System.out.println();
    }

    private static Command parseCommand(String input) {
        String[] parts = parseCommandWithQuotes(input);
        if (parts.length == 0) return null;

        String command = parts[0].toLowerCase();
        
        switch (command) {
            case "add_classroom":
                if (parts.length != 2) {
                    System.out.println("Usage: add_classroom <class_name>");
                    return null;
                }
                return new AddClassroomCommand(parts[1]);
                
            case "add_student":
                if (parts.length != 3) {
                    System.out.println("Usage: add_student <student_id> <class_name>");
                    return null;
                }
                return new AddStudentCommand(parts[1], parts[2]);
                
            case "schedule_assignment":
                if (parts.length < 3) {
                    System.out.println("Usage: schedule_assignment <class_name> <assignment_details>");
                    return null;
                }
                String assignmentDetails = String.join(" ", Arrays.copyOfRange(parts, 2, parts.length));
                return new ScheduleAssignmentCommand(parts[1], assignmentDetails);
                
            case "submit_assignment":
                if (parts.length < 4) {
                    System.out.println("Usage: submit_assignment <student_id> <class_name> <assignment_details>");
                    return null;
                }
                String submitDetails = String.join(" ", Arrays.copyOfRange(parts, 3, parts.length));
                return new SubmitAssignmentCommand(parts[1], parts[2], submitDetails);
                
            case "list_classrooms":
                return new Command() {
                    @Override
                    public void execute(ClassroomManager manager) {
                        manager.listClassrooms();
                    }
                    
                    @Override
                    public String getDescription() {
                        return "List all classrooms";
                    }
                };
                
            case "list_students":
                if (parts.length != 2) {
                    System.out.println("Usage: list_students <class_name>");
                    return null;
                }
                return new Command() {
                    @Override
                    public void execute(ClassroomManager manager) {
                        manager.listStudents(parts[1]);
                    }
                    
                    @Override
                    public String getDescription() {
                        return "List students in " + parts[1];
                    }
                };
                
            case "help":
                printWelcome();
                return new Command() {
                    @Override
                    public void execute(ClassroomManager manager) {
                        // Help already printed
                    }
                    
                    @Override
                    public String getDescription() {
                        return "Show help";
                    }
                };
                
            default:
                return null;
        }
    }

    private static String[] parseCommandWithQuotes(String input) {
        List<String> tokens = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder currentToken = new StringBuilder();
        
        for (char c : input.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ' ' && !inQuotes) {
                if (currentToken.length() > 0) {
                    tokens.add(currentToken.toString());
                    currentToken = new StringBuilder();
                }
            } else {
                currentToken.append(c);
            }
        }
        
        if (currentToken.length() > 0) {
            tokens.add(currentToken.toString());
        }
        
        return tokens.toArray(new String[0]);
    }

    private static void shutdown() {
        System.out.println("\nThank you for using Virtual Classroom Manager!");
        System.out.println("Session Summary:");
        System.out.println("- Classrooms: " + manager.getClassrooms().size());
        System.out.println("- Students: " + manager.getStudents().size());
        
        logger.info("Virtual Classroom Manager shutdown completed");
        scanner.close();
    }
}