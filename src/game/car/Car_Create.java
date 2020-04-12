package game.car;

import java.util.HashMap;
import java.util.Random;
import game.Fill;

class Car_Create {
    /**
     * Тут "хранится" информация просто существующие модели и их характеристики (с них создается рандомная машина)
     * Все хранится в классе game.Fill
     */
    private static final String[] BMW_MODELS = Fill.bmwModels();
    private static final String[] MERC_MODELS = Fill.mercModels();
    private static final HashMap<String, Integer> PRICES = Fill.createMapForPrices();
    static final HashMap<String, Integer> HP = Fill.createMapForHP();
    static final HashMap<String, Double> ENGINE = Fill.createMapForEngine();
    static final HashMap<String, Integer> SPEED = Fill.createMapForSpeed();

    /**
     * Генерирует бренд, BMW или Merc
     *
     * @return BMW или Merc
     */
    static String generateBrand() {
        Random random = new Random();
        int numb = random.nextInt(2);
        if (numb == 0) {
            return "BMW";
        } else if (numb == 1) {
            return "Mercedes-Benz";
        } else {
            return "Ошибка при генерации бренда";
        }
    }

    /**
     * Принимает Бренд и генерирует одну из 5ти моделей этого бренда
     *
     * @param model
     * @return модель машины
     */
    static String generateModel(String model) {
        Random random = new Random();
        String line;
        int randomNumber;

        if (model.equals("BMW")) {
            randomNumber = random.nextInt(BMW_MODELS.length);
            line = BMW_MODELS[randomNumber];
        } else if (model.equals("Mercedes-Benz")) {
            randomNumber = random.nextInt(MERC_MODELS.length);
            line = MERC_MODELS[randomNumber];
        } else {
            line = "Ошибка при генерации модели";
        }
        return line;
    }

    /**
     * Генерирует год "выпуска" с 2010 по 2020 год
     *
     * @param model
     * @return год машины
     */
    static int generateYearOfIssue(String model) {
        Random random = new Random();
        return (2010 + random.nextInt(11));
    }

    /**
     * Генерирует цену машины. Берет полную стоимость машины и отнимает по
     * 5% от стоимости за каждый "существующий" год. Если машина стоит 10_000 и ей 4 года, то
     * 10_000 - (5% * 4) = 8_000 стоиость машины
     *
     * @param model
     * @param year
     * @return
     */
    static int generatePrice(String model, int year) {
        int dif = 2020 - year;
        return (int) (PRICES.get(model) - (PRICES.get(model) * ((dif * 5.0) * 0.01)));
    }
}
