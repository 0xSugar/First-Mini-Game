package game.cities;

public class CityKiev extends Cities {
    private boolean isIn;

    public CityKiev() {
        isIn = true;
    }

    public boolean getIsIn() {
        return isIn;
    }
    public void setIsIn(boolean isIn) {
        this.isIn = isIn;
    }

    @Override
    public void getInfo() {
        System.out.println("Это город Киев. Что бы добраться сюда - нужно " + FUEL_NEEDS_TO_GO_IN + " ед. топлива.");
    }
}