package fr.anthonyquere.teashop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class TeaCupTest {

    /*Add water unit tests:
    - should make temperature n
    - should make cup not empty
    - should do the same thing if the cup is not empty
     */

    @Test
    void should_make_temperature_n(){
        var temperature = 80;
        var teaCup = new TeaCup();
        teaCup.addWater(temperature);
        var teaCupTemperature = teaCup.getCurrentTemperatureCelsius();
        assertThat(teaCupTemperature).isEqualTo(temperature);
    }

    @Test void should_make_cup_not_empty(){
        var temperature = 80;
        var teaCup = new TeaCup();
        teaCup.addWater(temperature);
        var isEmpty = teaCup.isEmpty();
        assertThat(isEmpty).isFalse();
    }

    @Test void should_do_the_same_thing_if_the_cup_is_not_empty(){
        var temperature = 80;
        var teaCup = new TeaCup();
        teaCup.addWater(temperature);
        var isEmpty = teaCup.isEmpty();
        teaCup.addWater(temperature);
        var teaCupTemperature = teaCup.getCurrentTemperatureCelsius();
        assertThat(teaCupTemperature).isEqualTo(temperature);
        assertThat(isEmpty).isFalse();
    }

    /*Add tea unit tests:
    - should throw an exception if the cup is empty
    - should have same tea reference as the one added
     */

    //This test fails because when we create a new TeaCup, the cup's isEmpty attribute is not set to true'
    @Test
    void should_throw_an_illegal_state_exception_if_the_cup_is_empty(){
        var teaCup = new TeaCup();
        var tea = new Tea(
                "englishBreakfast",
                240,
                100,
                false
        );
        IllegalStateException exception = assertThrows(
                IllegalStateException.class, () -> {
                    teaCup.addTea(tea);
                }
        );
    }

    @Test
    void should_have_same_tea_reference_as_the_one_added(){
        var teaCup = new TeaCup();
        var tea = new Tea(
                "englishBreakfast",
                240,
                100,
                false
        );
        teaCup.addWater(100);
        teaCup.addTea(tea);
        assertThat(teaCup.getTea() == tea).isTrue();
    }

    /* isReadyToDrink Unit tests:
    - should return false if the cup is empty
    - should return false if the tea is null
    - should return false if the temperature is not ideal
     */

    @Test
    void should_return_false_if_the_cup_is_empty(){
        var teaCup = new TeaCup();
        var isReadyToDrink = teaCup.isReadyToDrink();
        assertThat(isReadyToDrink).isFalse();
    }

    @Test
    void should_return_false_if_the_tea_is_null(){
        var teaCup = new TeaCup();
        teaCup.addWater(100);
        var isReadyToDrink = teaCup.isReadyToDrink();
        assertThat(isReadyToDrink).isFalse();
    }

    @Test
    void should_return_false_if_the_temperature_is_not_ideal(){
        var teaCup = new TeaCup();
        var tea = new Tea(
                "englishBreakfast",
                240,
                100,
                false
        );
        teaCup.addWater(80);
        teaCup.addTea(tea);
        var isReadyToDrink = teaCup.isReadyToDrink();
        assertThat(isReadyToDrink).isFalse();
    }
}
