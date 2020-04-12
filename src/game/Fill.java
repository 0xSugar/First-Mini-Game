package game;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Fill {
    static final String[] WORDS_FOR_EXIT = {"/выйти", "выйти", "/выход", "выход", "exit", "/exit", "конец"};
    static final String[] WORDS_FOR_HELP = {"помощь", "/помощь", "help", "/help", "хелп", "хелп!"};
    static final String[] WORDS_TO_CREATE_CAR = {"создать машину", "новая машина", "старт", "создать"};
    static final String[] WORDS_TO_GET_ALL_INFO = {"вся инфа", "вся информация", "расскажи все"};
    static final String[] WORDS_TO_GET_CAR_INFO = {"машина", "все характеристики", "инфо", "инфа"};
    static final String[] WORDS_TO_START_THE_CAR = {"завести машину", "включить", "завести"};
    static final String[] WORDS_TO_END_THE_CAR = {"заглушить машину", "заглушить", "выключить"};
    static final String[] WORDS_TO_IS_WORKING = {"машина работает?", "состояние", "работает машина?", "работает машина", "машина работает", "что делает машина"};
    static final String[] WORDS_TO_WHICH_CITY = {"какой город", "в каком городе", "в каком я городе", "где я", "где я?", "город", "где машина"};
    static final String[] WORDS_TO_GET_BRAND = {"бренд", "фирма", "производитель", "страна создания"};
    static final String[] WORDS_TO_GET_MODEL = {"модель", "марка"};
    static final String[] WORDS_TO_GET_YEAR = {"год выпуска", "выпуск", "год", "когда выпустили"};
    static final String[] WORDS_TO_GET_VOLUME = {"объем двигателя", "обьем двигателя", "двигатель", "сс", "cc", "объем", "обьем"};
    static final String[] WORDS_TO_GET_SPEED = {"скорость", "макс скорость", "максимальная скорость"};
    static final String[] WORDS_TO_GET_POWER = {"лс", "мощность", "сколько лс", "сколько л.с", "сколько л.с."};
    static final String[] WORDS_TO_GET_FUEL = {"бензин", "сколько бензина", "сколько бензина осталось", "топливо", "сколько топлива", "фьюел", "fuel", "бак"};
    static final String[] WORDS_TO_REFUEL = {"заправить", "заправиться", "заправка", "заправить бак", "заправить машину"};
    static final String[] WORDS_TO_GET_PRICE = {"цена", "сколько стоит", "какая цена"};
    static final String[] WORDS_TO_GET_OLD_PRICE = {"изначальную", "изначально", "изначальная", "первая", "старую", "старая", "старая цена", "старую цену", "изначальная цена", "1"};
    static final String[] WORDS_TO_GET_NEW_PRICE = {"новую", "новая", "измененную", "измененная", "вторая", "новая цена", "новую цену", "измененная цена", "измененную цену", "2"};
    static final String[] WORDS_TO_GET_BOTH_PRICES = {"обе", "обе цены", "две цены", "и ту и ту", "3"};
    static final String[] WORDS_TO_SET_NEW_PRICE = {"новая цена", "изменить цену"};
    static final String[] WORDS_TO_GO = {"поехать", "отправиться", "в путь"};
    static final String[] WORDS_GO_TO_KIEV = {"в киев", "киев"};
    static final String[] WORDS_GO_TO_LVIV = {"львов", "во львов", "в львов"};
    static final String[] WORDS_GO_BACK = {"назад", "отменить"};
    static final String[] WORDS_AGAIN = {"again", "заново", "начать заново"};

    static final String UNKNOWN_COMMAND = "Неправильная команду";

    static final String[] ALL_WORDS = importAllWords();
    static final String YOU_NEED_CREATE_CAR = "Для начала тебе нужно создать машину. Используй команду \"Создать машину\" или \"/Помощь\" для вызова всех команд.";

    /**
     * Данный метод только для заполнения массива "ALL_WORDS". Он создает лист из указанных массивов и автоматически при
     * добавления туда слов (в указанные массивы) добавляет их так же в массив ALL_WORDS. Сделано, что бы ручками это не
     * делать... а то сложно как-то будет.
     *
     * @return массив со всеми словами
     */
    private static String[] importAllWords() {
        List<String[]> list = Arrays.asList(WORDS_FOR_EXIT, WORDS_FOR_HELP, WORDS_TO_CREATE_CAR, WORDS_TO_GET_CAR_INFO,
                WORDS_TO_START_THE_CAR, WORDS_TO_END_THE_CAR, WORDS_TO_IS_WORKING, WORDS_TO_GET_BRAND, WORDS_TO_GET_MODEL,
                WORDS_TO_GET_YEAR, WORDS_TO_GET_VOLUME, WORDS_TO_GET_SPEED, WORDS_TO_GET_POWER, WORDS_TO_GET_PRICE,
                WORDS_TO_SET_NEW_PRICE, WORDS_TO_GO, WORDS_TO_WHICH_CITY, WORDS_TO_GET_FUEL, WORDS_TO_REFUEL,
                WORDS_TO_GET_ALL_INFO);
        int numberOfWords = 0;                      // создаем лист массивов
        for (int i = 0; i < list.size(); i++) {     // заполняем numberOfWords всеми словами в этих массивах
            numberOfWords += list.get(i).length;
        }
        String[] allWords = new String[numberOfWords];  // создаем массив ВСЕХ_СЛОВ размером всех слов (numberOfWords)

        int index = 0;                              // заполянемы
        for (String[] array : list) {               // берем каждый массив из листа
            for (String word : array) {             // в нем берем каждое слово
                allWords[index] = word;             // добавляем
                index++;                            // увеличиаем "индекс" на 1
            }
        }
        return allWords;
    }

    /**
     * Колличество моделей должно быть равно с bmwModels, т.к. макс число генерируется по bmwModels.length
     *
     * @return
     */
    public static String[] bmwModels() {
        String[] array = {"M240i Купе", "M135i xDRIVE", "430i Кабриолет", "X7", "i8 Купе"};
        return array;
    }

    public static String[] mercModels() {
        String[] array = {"C 400 4MATIC Coupe", "G 500", "AMG SLC 43", "GLS 400 d 4MATIC", "SL 500"};
        return array;
    }

    public static HashMap<String, Integer> createMapForPrices() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("M240i Купе", 50000);
        map.put("M135i xDRIVE", 42300);
        map.put("430i Кабриолет", 54000);
        map.put("X7", 98000);
        map.put("i8 Купе", 128000);
        map.put("C 400 4MATIC Coupe", 58000);
        map.put("G 500", 140000);
        map.put("AMG SLC 43", 73000);
        map.put("GLS 400 d 4MATIC", 87000);
        map.put("SL 500", 154000);
        return map;
    }

    public static HashMap<String, Integer> createMapForHP() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("M240i Купе", 340);
        map.put("M135i xDRIVE", 306);
        map.put("430i Кабриолет", 252);
        map.put("X7", 530);
        map.put("i8 Купе", 231);
        map.put("C 400 4MATIC Coupe", 333);
        map.put("G 500", 585);
        map.put("AMG SLC 43", 367);
        map.put("GLS 400 d 4MATIC", 330);
        map.put("SL 500", 455);
        return map;
    }

    public static HashMap<String, Double> createMapForEngine() {
        HashMap<String, Double> map = new HashMap<>();
        map.put("M240i Купе", 2.998);
        map.put("M135i xDRIVE", 1.998);
        map.put("430i Кабриолет", 1.998);
        map.put("X7", 4.473);
        map.put("i8 Купе", 1.5);
        map.put("C 400 4MATIC Coupe", 3.0);
        map.put("G 500", 3.982);
        map.put("AMG SLC 43", 2.982);
        map.put("GLS 400 d 4MATIC", 2.925);
        map.put("SL 500", 4.663);
        return map;
    }

    public static HashMap<String, Integer> createMapForSpeed() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("M240i Купе", 250);
        map.put("M135i xDRIVE", 250);
        map.put("430i Кабриолет", 250);
        map.put("X7", 250);
        map.put("i8 Купе", 250);
        map.put("C 400 4MATIC Coupe", 250);
        map.put("G 500", 180);
        map.put("AMG SLC 43", 250);
        map.put("GLS 400 d 4MATIC", 238);
        map.put("SL 500", 250);
        return map;
    }
}
