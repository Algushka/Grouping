import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//Дан список Programmer(String name, String city, List<Task>  tasks).
//        Каждый программист  имеет список задач    Task (int Number,
//
//        String description, String status, int daysInProcessing) .
//        Сформировать Map<String, Integer> где ключ, это имя программиста
//        (в данной задаче оно уникально), а значение количество задач в списке
//        у данного программиста (в рамках этой задачи, считаем что список
//        не пустой и в нем нет null значений)

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    List <Task> t1 = List.of(new Task(4, "task1", "done", 8),
            new Task(6, "task1", "done", 8),
            new Task(5, "task1", "done", 8),
            new Task(8, "task1", "done", 8),
            new Task(1, "task1", "done", 8),
            new Task(2, "task1", "done", 8),
            new Task(3, "task1", "done", 8),
            new Task(7, "task1", "done", 8)
            );
        List <Task> t2 = List.of(new Task(4, "task1", "done", 8),
                new Task(6, "task1", "done", 8),
                new Task(5, "task1", "done", 8),
                new Task(8, "task1", "in process", 8),
                new Task(9, "task1", "done", 8),
                new Task(2, "task1", "finished", 8),
                new Task(11, "task1", "done", 8),
                new Task(7, "task1", "done", 8)
        );
        List <Task> t3 = List.of(new Task(4, "task1", "done", 8),
                new Task(6, "task1", "in process", 8),
                new Task(5, "task1", "done", 8),
                new Task(8, "task1", "finished", 8),
                new Task(9, "task1", "done", 8)
        );


    List<Programmer> list = new ArrayList<>(List.of(new Programmer("John", "Ulyanovsk", t1),
        new Programmer("Olga", "Berlin", t2), new Programmer ("Andrew", "Paris", t3)));

        // 1 задача
        Map<String, Integer> map = list.stream().collect(Collectors
                                .toMap(s -> s.getName(), s -> s.getTasks().size()-1));

        //конец первой задачи

        //Map<String, List<Task>> map1 = list.stream().collect(Collectors.toMap(s -> s.getName(), s -> s.getTasks()));
        //Map<List<Task>, List<Programmer>> mapTasks = list.stream().collect(Collectors.groupingBy(s -> s.getTasks()));
        //System.out.println(mapTasks);

        //вторая задача :
//        Дан список Programmer(String name, String city, List<Task>  tasks). Каждый программист
//        имеет список задач    Task (int Number, String description, String status, int daysInProcessing) .
//        Сформировать Map<Integer, Task> где ключ, это номер задачи, а значение сама задача

        List <List<Task>> listOfTasks = new ArrayList(List.of(t1,t2,t3));
        Map<Integer, List<Task>> allTasksGroupingByNumbers = listOfTasks.stream()
                .flatMap(s -> s.stream()).collect(Collectors.groupingBy(s -> s.getNumber()));
        System.out.println(allTasksGroupingByNumbers);//map из ключика TaskNumber и самой задачи
        //конец второй задачи

        //третья задача
//        Дан список Programmer(String name, String city, List<Task>  tasks).
//                Каждый программист  имеет список задач
//        Task (int Number, String description, String status, int daysInProcessing) .
//        Сформировать Map<String, List<Task>> где ключ, это статус задачи, а значение список задач в этом статусе
        Map<String, List<Task>> allTasksGroupingByStatus = listOfTasks.stream().flatMap(s -> s.stream()).collect(Collectors.groupingBy(s -> s.getStatus()));
        System.out.println(allTasksGroupingByStatus );

    }
}