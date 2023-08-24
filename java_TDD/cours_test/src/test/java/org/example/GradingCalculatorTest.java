package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GradingCalculatorTest {

    @Test
    public void testGetGradeScore95Attendance90GradeShouldBeA() {
        // Arrange
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(95);
        gradingCalculator.setAttendancePercentage(90);

        //Act
        char result  = gradingCalculator.getGrade();

        //Assert
        Assertions.assertEquals('A', result);
    }
    @Test
    public void testGetGradeScore85Attendance90GradeShouldBeB() {
        // Arrange
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(85);
        gradingCalculator.setAttendancePercentage(90);

        //Act
        char result  = gradingCalculator.getGrade();

        //Assert
        Assertions.assertEquals('B', result);
    }
    @Test
    public void testGetGradeScore65Attendance90GradeShouldBeC() {
        // Arrange
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(65);
        gradingCalculator.setAttendancePercentage(90);

        //Act
        char result  = gradingCalculator.getGrade();

        //Assert
        Assertions.assertEquals('C', result);
    }
    @Test
    public void testGetGradeScore95Attendance65GradeShouldBeB() {
        // Arrange
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(95);
        gradingCalculator.setAttendancePercentage(65);

        //Act
        char result  = gradingCalculator.getGrade();

        //Assert
        Assertions.assertEquals('B', result);
    }

    @Test
    public void testGetGradeScore95Attendance55GradeShouldBeF() {
        // Arrange
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(95);
        gradingCalculator.setAttendancePercentage(55);

        //Act
        char result  = gradingCalculator.getGrade();

        //Assert
        Assertions.assertEquals('F', result);
    }

    @Test
    public void testGetGradeScore65Attendance55GradeShouldBeF() {
        // Arrange
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(65);
        gradingCalculator.setAttendancePercentage(55);

        //Act
        char result  = gradingCalculator.getGrade();

        //Assert
        Assertions.assertEquals('F', result);
    }

    @Test
    public void testGetGradeScore50Attendance90GradeShouldBeF() {
        // Arrange
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(50);
        gradingCalculator.setAttendancePercentage(90);

        //Act
        char result  = gradingCalculator.getGrade();

        //Assert
        Assertions.assertEquals('F', result);
    }
}
