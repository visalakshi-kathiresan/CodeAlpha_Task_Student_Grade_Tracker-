import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();

        if (numStudents <= 0) {
            System.out.println("Invalid number of students.");
            return;
        }

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter grade for student " + (i + 1) + ": ");
            int grade = scanner.nextInt();

            
            if (grade < 0 || grade > 100) {
                System.out.println("Grade must be between 0 and 100.");
                i--; 
                continue;
            }

            grades.add(grade);
        }

        int highest = Collections.max(grades);
        int lowest = Collections.min(grades);
        double average = grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);

        System.out.println("\n--- Grade Summary ---");
        for (int i = 0; i < grades.size(); i++) {
            int grade = grades.get(i);
            String letter = convertToLetterGrade(grade);
            System.out.println("Student " + (i + 1) + ": " + grade + " -> " + letter);
        }

        System.out.println("\nHighest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
        System.out.printf("Average Grade: %.2f\n", average);

        scanner.close();
    }

    public static String convertToLetterGrade(int grade) {
        if (grade >= 90) return "A+";
        else if (grade >= 80) return "A";
        else if (grade >= 70) return "B";
        else if (grade >= 60) return "C";
        else if (grade >= 50) return "D";
        else return "F";
    }
}
