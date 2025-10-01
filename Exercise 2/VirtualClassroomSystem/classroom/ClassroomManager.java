package VirtualClassroomSystem.classroom;

import VirtualClassroomSystem.student.Student;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * ClassroomManager - similar to the main management class in MarsRover
 * Manages all classrooms, students, and assignments
 */
public class ClassroomManager {
    private static final Logger logger = Logger.getLogger(ClassroomManager.class.getName());
    
    private final Map<String, Classroom> classrooms;
    private final Map<String, Student> students;

    public ClassroomManager() {
        this.classrooms = new HashMap<>();
        this.students = new HashMap<>();
    }

    public void addClassroom(String classroomName) {
        if (classrooms.containsKey(classroomName)) {
            System.out.println("Error: Classroom '" + classroomName + "' already exists");
            logger.warning("Attempted to create duplicate classroom: " + classroomName);
            return;
        }

        Classroom classroom = new Classroom(classroomName);
        classrooms.put(classroomName, classroom);
        System.out.println("Classroom " + classroomName + " has been created.");
        logger.info("Classroom created: " + classroomName);
    }

    public void addStudent(String studentId, String classroomName) {
        Classroom classroom = classrooms.get(classroomName);
        if (classroom == null) {
            System.out.println("Error: Classroom '" + classroomName + "' does not exist");
            logger.warning("Attempted to add student to non-existent classroom: " + classroomName);
            return;
        }

        // Create student if doesn't exist
        students.computeIfAbsent(studentId, Student::new);

        if (classroom.isStudentEnrolled(studentId)) {
            System.out.println("Error: Student " + studentId + " is already enrolled in " + classroomName);
            return;
        }

        classroom.enrollStudent(studentId);
        students.get(studentId).enrollInClassroom(classroomName);
        System.out.println("Student " + studentId + " has been enrolled in " + classroomName + ".");
        logger.info("Student enrolled: " + studentId + " in " + classroomName);
    }

    public void scheduleAssignment(String classroomName, String assignmentDetails) {
        Classroom classroom = classrooms.get(classroomName);
        if (classroom == null) {
            System.out.println("Error: Classroom '" + classroomName + "' does not exist");
            logger.warning("Attempted to schedule assignment for non-existent classroom: " + classroomName);
            return;
        }

        Assignment assignment = new Assignment(classroomName, assignmentDetails);
        classroom.addAssignment(assignment);
        System.out.println("Assignment for " + classroomName + " has been scheduled.");
        logger.info("Assignment scheduled for " + classroomName + ": " + assignmentDetails);
    }

    public void submitAssignment(String studentId, String classroomName, String assignmentDetails) {
        Classroom classroom = classrooms.get(classroomName);
        if (classroom == null) {
            System.out.println("Error: Classroom '" + classroomName + "' does not exist");
            return;
        }

        if (!classroom.isStudentEnrolled(studentId)) {
            System.out.println("Error: Student " + studentId + " is not enrolled in " + classroomName);
            return;
        }

        // Find matching assignment
        Assignment assignment = findAssignmentByDetails(classroom, assignmentDetails);
        if (assignment == null) {
            System.out.println("Error: No matching assignment found for the given details");
            return;
        }

        if (assignment.hasSubmission(studentId)) {
            System.out.println("Error: Assignment already submitted by this student");
            return;
        }

        assignment.addSubmission(studentId);
        System.out.println("Assignment submitted by Student " + studentId + " in " + classroomName + ".");
        logger.info("Assignment submitted by " + studentId + " in " + classroomName);
    }

    public void listClassrooms() {
        if (classrooms.isEmpty()) {
            System.out.println("No classrooms available.");
            return;
        }

        System.out.println("\n=== Classrooms ===");
        classrooms.values().forEach(System.out::println);
    }

    public void listStudents(String classroomName) {
        Classroom classroom = classrooms.get(classroomName);
        if (classroom == null) {
            System.out.println("Error: Classroom '" + classroomName + "' does not exist");
            return;
        }

        if (classroom.getEnrolledStudents().isEmpty()) {
            System.out.println("No students enrolled in " + classroomName + ".");
            return;
        }

        System.out.println("\n=== Students in " + classroomName + " ===");
        classroom.getEnrolledStudents().forEach(studentId -> {
            Student student = students.get(studentId);
            if (student != null) {
                System.out.println(student);
            }
        });
    }

    public void showStatus() {
        System.out.println("\n=== Current Status ===");
        System.out.println("Number of Classrooms: " + classrooms.size());
        System.out.println("Number of Students: " + students.size());
        
        int totalAssignments = classrooms.values().stream()
                                        .mapToInt(c -> c.getAssignments().size())
                                        .sum();
        System.out.println("Number of Assignments: " + totalAssignments);
        System.out.println("======================");
    }

    private Assignment findAssignmentByDetails(Classroom classroom, String details) {
        return classroom.getAssignments().stream()
                       .filter(assignment -> assignment.matchesDetails(details))
                       .findFirst()
                       .orElse(null);
    }

    public Map<String, Classroom> getClassrooms() {
        return new HashMap<>(classrooms);
    }

    public Map<String, Student> getStudents() {
        return new HashMap<>(students);
    }
}