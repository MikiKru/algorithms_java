package sorting;

import exercise.model.Course;
import exercise.model.CourseCategory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingComparator {
        List<Course> courses = new ArrayList<>(Arrays.asList(
                new Course(
                        "javabyd1",
                        CourseCategory.developer,
                        new ArrayList<>(),
                        LocalDate.of(2018,2,2),
                        "MK"),
                new Course(
                        "javabyd2",
                        CourseCategory.analyst,
                        new ArrayList<>(),
                        LocalDate.of(2018,5,2),
                        "KK"),
                new Course(
                        "javabyd3",
                        CourseCategory.developer,
                        new ArrayList<>(),
                        LocalDate.of(2018,7, 2),
                        "TT"),
                new Course(
                        "javator1",
                        CourseCategory.analyst,
                        new ArrayList<>(),
                        LocalDate.of(2018,2,2),
                        "MK"),
                new Course(
                        "javator2",
                        CourseCategory.dev_ops,
                        new ArrayList<>(),
                        LocalDate.of(2018,8,2),
                        "LL")
        ));

    public List<Course> sortCoursesByTrainer(){
        return courses.stream()
                .sorted(Comparator.comparing(Course::getTrainer).reversed())
                .collect(Collectors.toList());
    }
//    public List<Course> sortCoursesByCategory(){
//
//    }

    public static void main(String[] args) {
        SortingComparator sortingComparator = new SortingComparator();
        sortingComparator.sortCoursesByTrainer().forEach(System.out::println);
    }

}
