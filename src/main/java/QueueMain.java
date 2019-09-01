import model.Task;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

public class QueueMain {
    private Deque<String> commits = new ArrayDeque<>();

    public void removeLastNCommits(int nCommits){
        for(int i = nCommits; i > 0; i--){
            // przerwanie gdy nCommits > commits.size()
            if(commits.isEmpty()){
                break;
            }
            System.out.println(commits.removeLast());
        }
    }

    public static void main(String[] args) {
        // Queue - kolejka jednokierunkowa
        // Deque - kolejka dwukierunkowa
        Deque<Task> tasks = new ArrayDeque<>();
        // -> T3 | T2 | T1 | START
        tasks.addLast(new Task("T.1.",
                LocalDateTime.of(2000,02,01,10,0,0)));
        tasks.addLast(new Task("T.2.",
                LocalDateTime.of(2000,03,01,10,0,0)));
        tasks.addLast(new Task("T.3.",
                LocalDateTime.of(2000,04,01,10,0,0)));
        System.out.println(tasks);

        for(int i = tasks.size() - 1; i >= 0; i --) {
//        while(!tasks.isEmpty()){
            System.out.println(tasks.removeFirst());
        }

        QueueMain main = new QueueMain();
        // dodawania na stos commitów
        main.commits.addLast("c1");
        main.commits.addLast("c2");
        main.commits.addLast("c3");
        main.commits.addLast("c4");
        main.commits.addLast("c5");
        main.commits.addLast("c6");
        main.commits.addLast("c7");
        main.commits.addLast("c8");

        // zaimplemntuj metodę usuwająca zadaną przez użytkownika liczbę commitów
        main.removeLastNCommits(15);


    }

}
