package fr.anthonyquere.teashop;

public class TeaCup {
    private int currentTemperatureCelsius;
    private Tea tea;
    private boolean isEmpty;
    private int steepingStartTime; // in seconds

    public void addWater(int temperatureCelsius) {
        this.currentTemperatureCelsius = temperatureCelsius;
        this.isEmpty = false;
    }

    public void addTea(Tea tea) {
        if (isEmpty) {
            throw new IllegalStateException("Cannot add tea to an empty cup!");
        }
        this.tea = tea;
        this.steepingStartTime = getCurrentTimeInSeconds();
    }

    public boolean isReadyToDrink() {
        if (tea == null || isEmpty) return false;

        int steepingTime = getCurrentTimeInSeconds() - steepingStartTime;
        return steepingTime >= tea.getSteepingTimeSeconds() &&
                isTemperatureIdeal();
    }

    private boolean isTemperatureIdeal() {
        return Math.abs(currentTemperatureCelsius - tea.getIdealTemperatureCelsius()) <= 5;
    }

    private int getCurrentTimeInSeconds() {
        return (int) (System.currentTimeMillis() / 1000);
    }


    // Ajout de getters pour les unit tests
    public boolean isEmpty() {
        return isEmpty;
    }

    public int getCurrentTemperatureCelsius() {
        return currentTemperatureCelsius;
    }

    public Tea getTea(){
        return tea;
    }
}
