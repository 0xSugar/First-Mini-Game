package game;

import game.car.Car;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс для запуска игры
 */

public class Start_Of_The_Game {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Приветствую! Ты хочешь начать новую игру?");
        boolean start = startGame();
        if (start) {
            play();
            System.out.println("\n\nХорошо поиграли! До новых встреч!");
        }
    }

    private static boolean startGame() throws IOException, InterruptedException {
        String isNewGame = reader.readLine().toLowerCase();
        if (Game_Activity.isThatWord(isNewGame, "да", "хочу", "yes", "lf")) {
            System.out.println("Отлично, вот то, что ты можешь сейчас сделать:");
            Thread.sleep(1000);
            Game_Activity.help();
            return true;
        } else if (Game_Activity.isThatWord(isNewGame, "нет", "не хочу", "нехочу", "no")) {
            System.out.println("Очень жаль, мы будем ждать тебя снова!");
            return false;
        } else {
            System.out.println(Fill.UNKNOWN_COMMAND);
            return startGame();
        }
    }

    /**
     * Главный метод для "игры", вводится строка, если это "выйти" - забота завершается. Если нет он проверяет
     * равна ли ссылка null и если true - бросает на метод с созданием машины и ответов "сначала нужна машина"
     * @throws IOException
     * @throws InterruptedException
     */
    private static void play() throws IOException, InterruptedException {
        Car car = null;
        while (true) {
            String line = reader.readLine().toLowerCase();

            // проверка на выход
            if (Game_Activity.isThatWord(line, Fill.WORDS_FOR_EXIT)) break;

            // проверка на начать заново
            if (Game_Activity.isThatWord(line, Fill.WORDS_AGAIN)) {
                if (car == null) {
                    System.out.println("Нельзя начать заново то, что еще не начал. Для начала хотя бы начни эту игру, " +
                            "а потом уж начинай заново, раз ты уж так хочешь.");
                } else {
                    car = null;
                    System.out.println("\nИтак, ты хочешь начать заново.. Хорошо!");
                    Game_Activity.help();
                }
            } else {
                // Проверяет есть ли машина
                if (car == null) {  // Если еще нет машины
                    car = Game_Activity.noCar(line, car);
                } else {            // Если есть машина
                    Game_Activity.withCar(line, car);
                }
            }
        }
    }
}
