import java.util.Arrays;
import java.util.Scanner;

public class courseProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of courses: ");
        int numCourses = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Course[] courses = new Course[numCourses];

        // Input courses from the user
        for (int i = 0; i < numCourses; i++) {
            System.out.println("Enter details for course " + (i + 1) + ":");

            System.out.print("Course ID: ");
            int courseId = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.print("Course Name: ");
            String courseName = scanner.nextLine();

            System.out.print("Course Admin: ");
            String courseAdmin = scanner.nextLine();

            System.out.print("Quiz: ");
            int quiz = scanner.nextInt();

            System.out.print("Handson: ");
            int handson = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            courses[i] = new Course(courseId, courseName, courseAdmin, quiz, handson);
        }

        // Find average quiz score by admin
        System.out.print("Enter admin name to find average quiz score: ");
        String admin = scanner.nextLine();
        int avgQuiz = findAvgOfQuizByAdmin(courses, admin);
        if (avgQuiz != 0) {
            System.out.println("Average Quiz Score: " + avgQuiz);
        } else {
            System.out.println("No Course found");
        }

        // Sort courses by hands-on
        System.out.print("Enter hands-on threshold: ");
        int handsonThreshold = scanner.nextInt();
        Course[] sortedCourses = sortCourseByHandsOn(courses, handsonThreshold);
        if (sortedCourses != null) {
            System.out.println("Courses with hands-on less than " + handsonThreshold + ":");
            for (Course course : sortedCourses) {
                System.out.println(course.getCourseName());
            }
        } else {
            System.out.println("No Course found with mentioned attribute.");
        }

        scanner.close();
    }

    public static int findAvgOfQuizByAdmin(Course[] courses, String admin) {
        int totalQuiz = 0;
        int count = 0;
        for (Course course : courses) {
            if (course.getCourseAdmin().equalsIgnoreCase(admin)) {
                totalQuiz += course.getQuiz();
                count++;
            }
        }
        return count > 0 ? totalQuiz / count : 0;
    }

    public static Course[] sortCourseByHandsOn(Course[] courses, int handsonThreshold) {
        Course[] filteredCourses = Arrays.stream(courses)
                                         .filter(course -> course.getHandson() < handsonThreshold)
                                         .toArray(Course[]::new);

        if (filteredCourses.length == 0) {
            return null;
        }

        Arrays.sort(filteredCourses, (c1, c2) -> Integer.compare(c1.getHandson(), c2.getHandson()));
        return filteredCourses;
    }
}



class Course{
    private int courseId;
    private String courseName;
    private String courseAdmin;
    private int quiz;
    private int handson;
    public Course(int courseId, String courseName, String courseAdmin, int quiz, int handson) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseAdmin = courseAdmin;
        this.quiz = quiz;
        this.handson = handson;
    }
    public int getCourseId(){
        return courseId;
    }
    public void setCourseId(int courseId){
        this.courseId = courseId;
    }
    public String getCourseName(){
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseAdmin() {
        return courseAdmin;
    }

    public void setCourseAdmin(String courseAdmin) {
        this.courseAdmin = courseAdmin;
    }

    public int getQuiz() {
        return quiz;
    }

    public void setQuiz(int quiz) {
        this.quiz = quiz;
    }

    public int getHandson() {
        return handson;
    }

    public void setHandson(int handson) {
        this.handson = handson;
    }

}