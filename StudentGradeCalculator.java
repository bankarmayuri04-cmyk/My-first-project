import java.util.Scanner;

class Student {
    private String name;
    private String studentID;
    private double[] grades;

    // Constructor
    public Student(String name, String studentID, double[] grades) {
        this.name = name;
        this.studentID = studentID;
        this.grades = grades;
    }

    // Calculate average grade
    public double calculateAverage() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

    // Determine pass/fail
    public boolean hasPassed() {
        return calculateAverage() >= 40; // Pass mark is 40%
    }

    // Determine letter grade
    public String getLetterGrade() {
        double avg = calculateAverage();
        if (avg >= 90)
            return "A";
        else if (avg >= 80)
            return "B";
        else if (avg >= 70)
            return "C";
        else if (avg >= 60)
            return "D";
        else if (avg >= 40)
            return "E";
        else
            return "F";
    }

    // Display student details
    public void displayDetails() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + studentID);
        System.out.print("Grades: ");
        for (double grade : grades) {
            System.out.print(grade + " ");
        }
        double avg = calculateAverage();
        System.out.println("\nAverage Grade: " + avg);
        System.out.println("Letter Grade: " + getLetterGrade());
        System.out.println("Status: " + (hasPassed() ? "Passed ✅" : "Failed ❌"));
    }

    // Getter for average (used to calculate class average)
    public double getAverage() {
        return calculateAverage();
    }
}

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numStudents = scan.nextInt();
        scan.nextLine();  // consume newline

        Student[] students = new Student[numStudents];

        // Input student details
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Enter name: ");
            String name = scan.nextLine();

            System.out.print("Enter student ID: ");
            String id = scan.nextLine();

            System.out.print("Enter number of subjects: ");
            int numSubjects = scan.nextInt();

            double[] grades = new double[numSubjects];
            for (int j = 0; j < numSubjects; j++) {
                System.out.print("Enter grade for subject " + (j + 1) + ": ");
                grades[j] = scan.nextDouble();
            }
            scan.nextLine(); // consume newline

            students[i] = new Student(name, id, grades);
        }

        // Display details for all students
        double totalAverage = 0;
        for (Student s : students) {
            s.displayDetails();
            totalAverage += s.getAverage();
        }

        // Calculate and display class average
        double classAverage = totalAverage / numStudents;
        System.out.println("\n==========================");
        System.out.println("Class Average: " + classAverage);
        System.out.println("Class Letter Grade: " + getClassLetterGrade(classAverage));
        System.out.println("==========================");

        scan.close();
    }

    // Method to get class letter grade based on average
    public static String getClassLetterGrade(double avg) {
        if (avg >= 90)
            return "A";
        else if (avg >= 80)
            return "B";
        else if (avg >= 70)
            return "C";
        else if (avg >= 60)
            return "D";
        else if (avg >= 40)
            return "E";
        else
            return "F";
    }
}


