package FP03;

import java.util.List;
import java.util.function.Supplier;

public class FP03MethodReferences {

    private final int course_code;

    public FP03MethodReferences(int course_code) {
        this.course_code = course_code;
    }

    public void printCourseCode() {
        System.out.println(course_code);
    }

    private static void print(String string) {
        System.out.println(string);
    }

    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "API",
                "Microservices", "AWS", "PCF",
                "Azure", "Docker", "Kubernetes", "AWS");

        courses.stream()
                .map(String::toUpperCase)
                .forEach(FP03MethodReferences::print);

        Supplier<String> stringSupplier = String::new; //use a constructor reference to create new object

        //you can call on constructors too i.e. for new object creation
        Supplier<FP03MethodReferences> supplier = () -> new FP03MethodReferences(25);

        supplier.get().printCourseCode();
    }
}
