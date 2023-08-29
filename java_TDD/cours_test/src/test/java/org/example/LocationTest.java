package org.example;

import org.example.exception.ConditionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LocationTest {

    private Voiture voiture ;
    private Location location;

    @BeforeEach
    void setUp(){
        location = new Location();
    }

    @Test
    void rentDueInDecreaseEveryDailyRoutine (){
        voiture = Voiture.builder().rentDueIn(5).condition(5).type("classic").build();

        location.dailyRoutine(voiture);
        Assertions.assertEquals(4,voiture.getRentDueIn());
    }

    @Test
    void conditionDecreaseEveryDailyRoutine (){
        voiture = Voiture.builder().rentDueIn(5).condition(5).type("classic").build();

        location.dailyRoutine(voiture);
        Assertions.assertEquals(4,voiture.getCondition());
    }

    @Test
    void afterDueDateConditionDecrease2Time (){
        voiture = Voiture.builder().rentDueIn(0).condition(5).type("classic").build();

        location.dailyRoutine(voiture);
        Assertions.assertEquals(3,voiture.getCondition());
    }

    @Test
    void conditionNeverBeNegative (){
        voiture = Voiture.builder().rentDueIn(5).condition(0).type("classic").build();

        Assertions.assertThrowsExactly(ConditionException.class,()->{
            location.dailyRoutine(voiture);
        });
    }

    @Test
    void conditionVoitureLuxeIncrease (){
        voiture = Voiture.builder().rentDueIn(5).condition(5).type("luxe").build();

        location.dailyRoutine(voiture);
        Assertions.assertEquals(6,voiture.getCondition());
    }

    @Test
    void ConditionNeverBeMoreThan100 (){
        voiture = Voiture.builder().rentDueIn(5).condition(100).type("luxe").build();

        Assertions.assertThrowsExactly(ConditionException.class,()->{
            location.dailyRoutine(voiture);
        });
    }

    @Test
    void conditionDecrease2TimeFasterForOldVoiture (){
        voiture = Voiture.builder().rentDueIn(5).condition(50).type("old").build();
        location.dailyRoutine(voiture);
        Assertions.assertEquals(48,voiture.getCondition());
    }

    @Test
    void conditionDecrease2TimeFasterForOldVoitureForDueDate0 (){
        voiture = Voiture.builder().rentDueIn(0).condition(50).type("old").build();
        location.dailyRoutine(voiture);
        Assertions.assertEquals(46,voiture.getCondition());
    }







}
