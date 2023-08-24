## Exercice 1
- Le but de l'exerice est de réaliser les tests de la méthode ***getGrade*** de la classe ***GradingCalculator***

```
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
```
**Les scénarios de tests** :

- Score : 95%, Présence : 90 => Note: A
- Score : 85%, Présence : 90 => Note: B
- Score : 65%, Présence : 90 => Note: C
- Score : 95%, Présence : 65 => Note: B
- Score : 95%, Présence : 55 => Note: F
- Score : 65%, Présence : 55 => Note: F
- Score : 50%, Présence : 90 => Note: F