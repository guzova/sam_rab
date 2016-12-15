package com.guzova;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        LinkedList<Task> test = parseFile("test.txt");
        System.out.print("Введите фамилию, имя, курс и группу через пробел: ");
        Scanner sc = new Scanner(System.in);
        User user = new User(sc.next(), sc.next(), sc.nextInt(), sc.nextInt());
        int percent = doTest(test);
        System.out.println("Статистика: " + percent + "%");
        FileWriter logfile = new FileWriter("logfile.txt", true);
        logfile.write(user.toString() + " " + ((percent > 75) ? ("1") : ("0")) + System.lineSeparator());
        logfile.close();
        if (percent > 75) {
            FileWriter output = new FileWriter("output2.txt", true);
            output.write(user.toString() + System.lineSeparator());
            output.close();
        } else {
            FileWriter output = new FileWriter("output1.txt", true);
            output.write(user.toString() + System.lineSeparator());
            output.close();
        }
    }

    private static int doTest(LinkedList<Task> test) {
        int size = test.size();
        int correct = 0;
        Scanner sc = new Scanner(System.in);
        while (!test.isEmpty()) {
            Task task = test.getFirst();
            System.out.println(task.getQuestion());
            for (int i = 0; i < task.getAnswers().size(); i++) {
                System.out.print("" + (i + 1) + ": ");
                System.out.println(task.getAnswers().get(i));
            }
            System.out.print("Ответ: ");
            int answer = sc.nextInt();
            if (answer == task.getRightAnswer())
                correct++;
            System.out.println();
            test.removeFirst();
        }
        return (int) (correct / (double) size * 100);
    }

    private static LinkedList<Task> parseFile(String file) throws FileNotFoundException {
        LinkedList<Task> test = new LinkedList<>();
        Scanner sc = new Scanner(new File(file));
        while (sc.hasNext()) {
            String question = sc.nextLine();
            int count = Integer.parseInt(sc.nextLine());//строку приводим к int
            List<String> answers = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                answers.add(sc.nextLine());
            }
            int rightAnswer = Integer.parseInt(sc.nextLine());//строку приводим к int
            Task task = new Task(question, answers, rightAnswer);
            test.addLast(task);
        }
        return test;
    }
}
