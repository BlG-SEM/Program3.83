package ru.vsu.cs;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Picture picture = new Picture(
                new Parabola(0.125, 0.5, -4.5),
                new Circle(-1, -6, 2),
                new Line(-4, 4),
                new Line(0.25, 2.75),
                new LineY(-3)
        );

        boolean test = test(picture);
        if (test) {
            System.out.println("Test was successful\n");
            start(picture);
        } else {
            System.out.println("Test failed");
        }
    }

    private static void start(Picture picture) {
        String restartCalculate;
        do {
            double x = readDouble("x = ");
            double y = readDouble("y = ");

            Point point = new Point(x, y);
            SimpleColor color = picture.getColor(point);
            printColorForPoint(color, point);

            restartCalculate = continueTyping();
        } while (!restartCalculate.equals("stop"));
    }

    private static boolean test(Picture picture) {
        TestCase[] testCases = {new TestCase(-1, 3, SimpleColor.ORANGE), new TestCase(-1, -6,  SimpleColor.YELLOW),
                new TestCase(0, 0, SimpleColor.GREEN), new TestCase(2, 0, SimpleColor.WHITE), new TestCase(1, 4, SimpleColor.GREY),
                new TestCase(-9, 0, SimpleColor.BLUE)};

        boolean check = true;
        for (int i = 0; i < testCases.length; i++) {
            TestCase testCase = testCases[i];
            Point point = new Point(testCase.getX(), testCase.getY());

            SimpleColor color = picture.getColor(point);
            SimpleColor correctColor = testCase.getCorrectColor();

            printColorForPoint(color, point);
            System.out.printf("Expected area is %s\n", correctColor);
            if (color != correctColor) {
                check = false;
            }
        }
        return check;
    }

    private static double readDouble(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter coordinate %s ", name);
        return scanner.nextDouble();
    }

    private static String continueTyping() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Continue or stop? \nYour choice: " );
        return scanner.next();
    }

    private static void printColorForPoint(SimpleColor color, Point point) {
        System.out.printf("(%1$.1f; %2$.1f) is point in " + color + "\n", point.x, point.y);
    }
}