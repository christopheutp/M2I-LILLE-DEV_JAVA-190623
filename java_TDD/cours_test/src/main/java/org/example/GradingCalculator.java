package org.example;

public class GradingCalculator {
    private int score;
    private int attendancePercentage;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAttendancePercentage() {
        return attendancePercentage;
    }

    public void setAttendancePercentage(int attendancePercentage) {
        this.attendancePercentage = attendancePercentage;
    }

    public char getGrade() {
        if(score > 90 && attendancePercentage > 70) return 'A';
        else if(score > 80 && attendancePercentage > 60) return  'B';
        else if (score > 60 && attendancePercentage > 60) return  'C';
        else return 'F';
    }
}