package game;

import game.car.Car;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Game_Activity {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Передается введенное слово и другие слова. Если переданное слово совпадает хоть с 1м
     * из переданных слов - возвращает true, если не совпадает - false.
     *
     * @param line
     * @param words
     * @return Совпадает слово или нет
     */
    static boolean isThatWord(String line, String... words) {
        for (String word : words) {
            if (line.equals(word)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Выполняет действия в зависимости, что написали. Если создать - создает машину, другие команды - говорит,
     * что сначала нужно создать машину, неопознаные слова - неправильный ввод
     *
     * @param line
     * @param car
     * @return newCar
     * @throws InterruptedException
     */
    static Car noCar(String line, Car car) throws InterruptedException {
        if (isThatWord(line, Fill.WORDS_FOR_HELP)) {
            help();
        } else if (isThatWord(line, Fill.WORDS_TO_CREATE_CAR)) {
            car = new Car();
            System.out.println("(команды: завести, заглушить, состояние, поехать, новая цена)");
        } else if (isThatWord(line, Fill.WORDS_TO_GET_ALL_INFO)) {
            System.out.println("У тебя еще Нет машины и тебе нужно её создать. Для этого напиши - \"Создать\" (да, так просто).");
        }  else if (isThatWord(line, Fill.ALL_WORDS)) {
            System.out.println(Fill.YOU_NEED_CREATE_CAR);
        } else {
            System.out.println(Fill.UNKNOWN_COMMAND);
        }
        return car;
    }

    static void withCar(String line, Car car) throws InterruptedException, IOException {
        if (isThatWord(line, Fill.WORDS_FOR_HELP)) {
            help();
        } else if (isThatWord(line, Fill.WORDS_TO_CREATE_CAR)) {
            System.out.println("Пирожок, у тебя уже есть машина... это тебе не перчатки, что бы их менять каждые 20 секунд!");
        } else if (isThatWord(line, Fill.WORDS_TO_GET_CAR_INFO)) {
            System.out.println(car);
        } else if (isThatWord(line, Fill.WORDS_TO_START_THE_CAR)) {
            if (car.getIsTurnedOn()) {          // Если она уже заведена (true)
                System.out.println("Машина уже заведена");
            } else {
                car.start();
            }
        } else if (isThatWord(line, Fill.WORDS_TO_END_THE_CAR)) {
            if (car.getIsTurnedOn()) {          // Если она уже заведена (true)
                car.end();
            } else {
                System.out.println("Машина уже заведена");
            }
        } else if (isThatWord(line, Fill.WORDS_TO_IS_WORKING)) {
            String ans = car.getIsTurnedOn() ? "Машина работает" : "Машина выключена";
            System.out.println(ans);
        } else if (isThatWord(line, Fill.WORDS_TO_GET_BRAND)) {
            System.out.println(car.getBrand());
        } else if (isThatWord(line, Fill.WORDS_TO_GET_MODEL)) {
            System.out.println(car.getModel());
        } else if (isThatWord(line, Fill.WORDS_TO_GET_YEAR)) {
            System.out.println(car.getYearOfIssue() + "г");
        } else if (isThatWord(line, Fill.WORDS_TO_GET_VOLUME)) {
            System.out.println(car.getEngineVolume() + "см\u00B2");
        } else if (isThatWord(line, Fill.WORDS_TO_GET_SPEED)) {
            System.out.println("Макс скорость: " + car.getMaxSpeed() + " км/час.");
        } else if (isThatWord(line, Fill.WORDS_TO_GET_POWER)) {
            System.out.println(car.getHorsePower() + "л.с.");
        } else if (isThatWord(line, Fill.WORDS_TO_GET_PRICE)) {
            getPrice(car);
        } else if (isThatWord(line, Fill.WORDS_TO_GET_FUEL)) {
            if (car.getFuel() == 100) {
                System.out.println("У тебя полный бак, дружище!");
            } else if (car.getFuel() >= 70) {
                System.out.println("У тебя почти полный бак! Целых " + car.getFuel() + " единци топлива!");
            } else if (car.getFuel() < 50 && car.getFuel() >= 30) {
                System.out.println("Ну.. на еще одну поездку хватит.. у тебя осталось " + car.getFuel() + " едениц топлива.");
            } else {
                System.out.println("Совсем все плохо с баком, там так все высохло, что аж крысы завелись...");
                System.out.println("Ост: " + car.getFuel() + " едицин.");
            }
        } else if (isThatWord(line, Fill.WORDS_TO_REFUEL)) {
            if (car.getFuel() == 100) {
                System.out.println("Брось, у тебя и так полный бак! Или ты в карманы собрали доливать?");
            } else {
                System.out.println("Бак залит до отвала!");
                System.out.println("Долито: " + (100 - car.getFuel()) + " ед.");
                car.setFuel(100);
            }
        } else if (isThatWord(line, Fill.WORDS_TO_SET_NEW_PRICE)) {
            car.setNewPrice(newPrice());
        } else if (isThatWord(line, Fill.WORDS_TO_WHICH_CITY)) {
            System.out.println("Ты сейчас в" + ((car.where()) ? " Киеве" : "о Львове"));
        } else if (isThatWord(line, Fill.WORDS_TO_GO)) {
            goTo(car);
        } else if (isThatWord(line, Fill.WORDS_TO_GET_ALL_INFO)) {
            String where = (car.where()) ? " Киеве" : "о Львове";
            String fuel = (car.getFuel() == 100) ? "полный бак" : car.getFuel() + " ед. топлива";
            String condition = (car.getIsTurnedOn()) ? "работает." : "не работает";
            System.out.printf("Ты сейчас в%s, у тебя %s, машина %s%n", where, fuel, condition);
            System.out.print("Машина: ");
            System.out.println(car);
        } else {
            System.out.println(Fill.UNKNOWN_COMMAND);
        }
    }

    private static int newPrice() throws IOException {
        int newPrice;
        while (true) {
            System.out.print("Введите новую цену: $");
            try {
                newPrice = Integer.parseInt(reader.readLine());
                System.out.printf("Новая цена = $%,d%n", newPrice);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число");
            } catch (Exception e) {
                System.out.println("Что-то пошло не так");
            }
        }
        return newPrice;
    }

    private static void getPrice(Car car) throws IOException {
        String line;
        if (car.isNewPrice()) {
            System.out.println("Ты хочешь получить старую цену (изначальную), новую (измененную) или обе?");
            line = reader.readLine();
            if (isThatWord(line, Fill.WORDS_TO_GET_NEW_PRICE)) {

                System.out.printf("Ты выставил цену на машину: $%,d %n", car.getNewPrice());

            } else if (isThatWord(line, Fill.WORDS_TO_GET_OLD_PRICE)) {

                System.out.printf("Изначальная цена: $%,d %n", car.getPrice());

            } else if (isThatWord(line, Fill.WORDS_TO_GET_BOTH_PRICES)) {

                System.out.printf("Изначальная цена: $%,d %nНовая цена: $%,d %n", car.getPrice(), car.getNewPrice());

            } else System.out.println(Fill.UNKNOWN_COMMAND);
        } else {
            System.out.printf("Машина на данный момент стоит: $%,d %n", car.getPrice());
        }
    }

    private static void goTo(Car car) throws IOException {
        System.out.println("Ты сейчас в" + ((car.where()) ? " Киеве" : "о Львове") + ". Куда ты хочешь поехать?");
        while (true) {
            String line = reader.readLine();
            if (isThatWord(line, Fill.WORDS_GO_BACK)) break;
            if (isThatWord(line, Fill.WORDS_GO_TO_LVIV)) {
                car.goTo(car.getLviv());
                break;
            } else if (isThatWord(line, Fill.WORDS_GO_TO_KIEV)) {
                car.goTo(car.getKiev());
                break;
            } else {
                System.out.println(Fill.UNKNOWN_COMMAND);
            }
        }
    }

    static void help() throws InterruptedException {
        System.out.println("\nЧто бы выполнить какое-то действие, тебе нужно написать команду:");
        Thread.sleep(1000);
        System.out.println("\"Создать\" - создает новую машину" +
                "\n\"Завести\" - заводит машину" +
                "\n\"Заглушить\" - глушит машину" +
                "\n\"Состояние\" - проверяет работает ли машина" +
                "\n\"Где я\" - в каком ты городе" +
                "\n\"Поехать\" - поехать в другой город" +
                "\n\"Новая цена\" - изменить цену" +
                "\n\"Вся инфа\" - дает всю информацию по тебе и машине" +
                "\n\"Заново\" - начать игру заново" +
                "\n\"Выйти\" - для выхода");
        Thread.sleep(2000);
        System.out.println("\n\nЧто бы узнать всю информацию по машине напиши \"Машина\", или использую одну из след. команд:");
        System.out.printf("%-20s%-20s%-20s", "Бренд", "Модель", "Год выпуска");
        System.out.printf("%n%-20s%-20s%-20s", "Объем двигателя", "Мощость (в л.с.)", "Скорость");
        System.out.printf("%n%-20s%-20s", "Цена", "Бензин");
        System.out.println("\nТеперь ты можешь начать играть! Создай свою первую машину!");
    }
}
