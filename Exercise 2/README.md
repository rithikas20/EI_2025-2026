# Virtual Classroom System

A terminal-based Virtual Classroom Management System following clean architecture principles.

## Project Structure

```
VirtualClassroomSystem/
├── commands/
│   ├── Command.java                    ← Command interface
│   ├── AddClassroomCommand.java        ← Add classroom command
│   ├── AddStudentCommand.java          ← Add student command
│   ├── ScheduleAssignmentCommand.java  ← Schedule assignment command
│   └── SubmitAssignmentCommand.java    ← Submit assignment command
├── classroom/
│   ├── Classroom.java                  ← Classroom entity (like Grid)
│   ├── Assignment.java                 ← Assignment entity (like Obstacle)
│   └── ClassroomManager.java           ← Main manager (like Rover)
├── student/
│   └── Student.java                    ← Student entity (like Direction)
├── Main.java                           ← Application entry point
└── README.md                           ← This file
```

##  Running the Application

### Compile
```bash
javac VirtualClassroomSystem\Main.java VirtualClassroomSystem\commands\*.java VirtualClassroomSystem\classroom\*.java VirtualClassroomSystem\student\*.java
```

### Run
```bash
java VirtualClassroomSystem.Main
```

## Available Commands

- `add_classroom <class_name>`
- `add_student <student_id> <class_name>`
- `schedule_assignment <class_name> <assignment_details>`
- `submit_assignment <student_id> <class_name> <assignment_details>`
- `list_classrooms`
- `list_students <class_name>`
- `help`
- `exit`

##  Expected Output

```
Classroom Addition: "Classroom Mathematics101 has been created."
Student Addition: "Student STD001 has been enrolled in Mathematics101."
Assignment Scheduled: "Assignment for Mathematics101 has been scheduled."
Assignment Submission: "Assignment submitted by Student STD001 in Mathematics101."
```

## Architecture Patterns

- **Command Pattern**: All operations implemented as commands
- **Manager Pattern**: ClassroomManager handles all business logic
- **Entity Pattern**: Clean separation of entities (Classroom, Student, Assignment)
- **Clean Architecture**: Layered structure with clear dependencies

## Design Principles

- **SOLID Principles**: Applied throughout the design
- **Clean Code**: Readable, maintainable code structure
- **Error Handling**: Comprehensive validation and error recovery
- **Logging**: Built-in logging for all operations
