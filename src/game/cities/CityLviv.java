package game.cities;

public class CityLviv extends Cities {
    private boolean isIn;

    public CityLviv() {
        isIn = false;
    }

    public boolean getIsIn() {
        return isIn;
    }
    public void setIsIn(boolean isIn) {
        this.isIn = isIn;
    }

    @Override
    public void getInfo() {
        System.out.println("Это город Львов. Что бы добраться сюда - нужно " + FUEL_NEEDS_TO_GO_IN + " ед. топлива.");
    }
}
