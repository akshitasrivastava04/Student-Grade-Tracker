import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize ArrayList to store student grades
        ArrayList<Integer> grades = new ArrayList<>();

        // Prompt user to enter grades, limit to 5 subjects
        System.out.println("Enter grades for up to 5 subjects (terminate input with -1):");
        int count = 0;
        try {
            while (count < 5) {
                int grade = sc.nextInt();
                if (grade == -1) {
                    break;
                } else if (grade < 0 || grade > 100) {
                    System.out.println("Invalid grade. Grades should be between 0 and 100.");
                    continue;
                }
                grades.add(grade);
                count++;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
            return; // Exit program on error
        }

        // Display entered grades
        if (!grades.isEmpty()) {
            System.out.println("Entered grades: " + grades);
        } else {
            System.out.println("No grades entered.");
            return;
        }

        // Calculate average grade
        double average = calculateAverage(grades);
        System.out.println("Average grade: " + average);

        // Find highest and lowest grades
        int highestGrade = findHighestGrade(grades);
        int lowestGrade = findLowestGrade(grades);
        System.out.println("Highest grade: " + highestGrade);
        System.out.println("Lowest grade: " + lowestGrade);
    }

    // Method to calculate average grade
    private static double calculateAverage(ArrayList<Integer> grades) {
        if (grades.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }

        return (double) sum / grades.size();
    }

    // Method to find highest grade
    private static int findHighestGrade(ArrayList<Integer> grades) {
        if (grades.isEmpty()) {
            throw new IllegalArgumentException("Empty list of grades");
        }

        int highest = grades.get(0);
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }

        return highest;
    }

    // Method to find lowest grade
    private static int findLowestGrade(ArrayList<Integer> grades) {
        if (grades.isEmpty()) {
            throw new IllegalArgumentException("Empty list of grades");
        }

        int lowest = grades.get(0);
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }

        return lowest;
    }
}
