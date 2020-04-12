package game.car;

import game.cities.Cities;
import game.cities.CityKiev;
import game.cities.CityLviv;

public class Car {
    // П О Л Я    К Л А С С А
    private String brand;                   // бренд
    private String model;                   // модель
    private int yearOfIssue;                // год выпуска
    private double engineVolume;            // объем двигателя
    private int horsePower;                 // сколько ЛС
    private int maxSpeed;                   // макс скорость
    private int price;                      // цена
    private boolean isTurnedOn = false;     // заведена ли машина
    private int fuel = 100;                 // бензин
    private CityKiev kiev;
    private CityLviv lviv;

    private int newPrice = 0;
    private static final int WHEELS = 4;    // колеса, все машины имеют 4 колеса

    // К О Н С Т Р У К Т О Р Ы    К Л А С С А
    public Car(String brand, String model, int yearOfIssue, double engineVolume, int horsePower, int price, String city) {
        // Не используется, не нужен. Если понадобится - доработать, т.к. тут много ошибок во время исполнения будет.
        this.brand = brand;
        this.model = model;
        this.yearOfIssue = yearOfIssue;
        this.engineVolume = engineVolume;
        this.horsePower = horsePower;
        this.price = price;

        kiev = new CityKiev();
        lviv = new CityLviv();

        if (city.toLowerCase().equals("львов")) {
            this.lviv.setIsIn(true);
            this.kiev.setIsIn(false);
        }
    }

    /**
     * При создании машины без характеристик вызывается метод generateNewCar, что генерирует параметры
     * для машины
     */
    public Car() {
        System.out.println("Твоя новая машина, поздравляю!");
        generateNewCar();
        System.out.print(this);
    }

    private void generateNewCar() {
        brand = Car_Create.generateBrand();
        model = Car_Create.generateModel(brand);
        yearOfIssue = Car_Create.generateYearOfIssue(model);
        engineVolume = Car_Create.ENGINE.get(model);
        maxSpeed = Car_Create.SPEED.get(model);
        horsePower = Car_Create.HP.get(model);
        price = Car_Create.generatePrice(model, yearOfIssue);
        kiev = new CityKiev();
        lviv = new CityLviv();
    }

    // Г Е Т Т Е Р Ы   И   С Е Т Т Е Р Ы
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getPrice() {
        return price;
    }

    public int getWHEELS() {
        return WHEELS;
    }

    public boolean getIsTurnedOn() {
        return isTurnedOn;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        if (fuel > 100) {
            this.fuel = 100;
        } else {
            this.fuel = fuel;
        }
    }

    public int getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(int newPrice) {
        this.newPrice = newPrice;
    }

    public CityKiev getKiev() {
        return kiev;
    }

    public CityLviv getLviv() {
        return lviv;
    }

    // М Е Т О Д Ы

    /**
     * Выводит на экран "Завели машину" и изменяет isTurnedOn на True (что значит машина заведена)
     */
    public void start() {
        System.out.println("Бж-бж, завели машину");
        isTurnedOn = true;
    }

    /**
     * Выводит на экран "Завели машину" и изменяет isTurnedOn на False (что значит машина выключена)
     */
    public void end() {
        System.out.println("Гкх-гкх, выключили машину");
        isTurnedOn = false;
    }

    public boolean where() {
        if (kiev.getIsIn()) {
            return true;
        } else {
            return false;
        }
    }

    public void goTo(Cities toWhichCity) {
        if (toWhichCity.equals(lviv)) {
            if (lviv.getIsIn()) {
                System.out.println("Ты уже и так во Львове.");
            } else if (!isTurnedOn) {
                System.out.println("Ты пешком что ли собрался? Сперва заведи машину!");
            } else if (fuel < lviv.FUEL_NEEDS_TO_GO_IN) {
                System.out.println("Не хватает топлипа, нужно еще " + (lviv.FUEL_NEEDS_TO_GO_IN - fuel) + " единиц. Заправся сперва.");
            } else {
                lviv.setIsIn(true);
                kiev.setIsIn(false);
                fuel -= lviv.FUEL_NEEDS_TO_GO_IN;
                System.out.println("Воу воу, с ветерком добрались до Львова! Что прикажешь делать дальше?");
            }
        } else if (toWhichCity.equals(kiev)) {
            if (kiev.getIsIn()) {
                System.out.println("Ты уже и так в Киеве.");
            } else if (!isTurnedOn) {
                System.out.println("Ты пешком что ли собрался? Сперва заведи машину!");
            } else if (fuel < kiev.FUEL_NEEDS_TO_GO_IN) {
                System.out.println("Не хватает топлипа, нужно еще " + (kiev.FUEL_NEEDS_TO_GO_IN - fuel) + " единиц. Заправся сперва.");
            } else {
                kiev.setIsIn(true);
                lviv.setIsIn(false);
                fuel -= kiev.FUEL_NEEDS_TO_GO_IN;
                System.out.println("Вот она, столица Украины - Киев! Что прикажешь делать дальше?");
            }
        } else {
            System.out.println("Ошибочка произошла.");
        }
    }

    /**
     * Проверяет установлена ли новая цена на машину
     *
     * @return true - если новая цена установлена, false - если нет
     */
    public final boolean isNewPrice() {
        if (this.getNewPrice() == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() { // вывод: BMW M240i Купе (год), двигатель 3.0см²(340 л.с., макс 250 км/час), цена = $50000
        // Если новая цена установлена - выведет новую цену. Если нет - покажет старую цену
        if (this.isNewPrice()) {
            return String.format("%s %s (%d), двигатель %.3fсм\u00B2 (%d л.с., макс %d км/час), изначальная цена = $%,d" +
                    " (объявлена: $%,d)%n", brand, model, yearOfIssue, engineVolume, horsePower, maxSpeed, price, newPrice);
        } else {
            return String.format("%s %s (%d), двигатель %.3fсм\u00B2 (%d л.с., макс %d км/час), цена = $%,d %n",
                    brand, model, yearOfIssue, engineVolume, horsePower, maxSpeed, price);
//            return this.brand + " " + this.model + " (" + this.yearOfIssue + "), двигатель " + this.engineVolume + "см" +
//                    '\u00B2' + "(" + this.horsePower + " л.с., макс " + this.maxSpeed + " км/час), реальная цена = $" +
//                    this.price + " (объявлена: $" + this.newPrice + ")";
//            return this.brand + " " + this.model + " (" + this.yearOfIssue + "), двигатель " + this.engineVolume + "см" +
//                    '\u00B2' + "(" + this.horsePower + " л.с., макс " + this.maxSpeed + " км/час), цена = $" + this.price;
        }
    }
}