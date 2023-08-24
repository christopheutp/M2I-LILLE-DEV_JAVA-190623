## Exercice 2

- Le but de l'exercice est de réaliser des tests unitaire en utilisant junit pour la classe fournie

```
public class Fib {

    private int range;

    public Fib(int r){
        range = r;
    }

    public List<Integer> getFibSeries() {
        List<Integer> result = new ArrayList<Integer>();
        int a = 0,b=1, c=0;
        if(range == 1) {
            result.add(0);
            return result;
        }
        result.add(0);
        result.add(1);
        for(int i=2; i < range; i++) {
            c = a + b;
            result.add(c);
            a = b;
            b = c;
        }
        return result;
    }

}
```

- Lors du déclanchement de la fonction getFibSeries() avec un Range de 1
    - Le résultat n’est pas vide
    - Le résultat correspond à une liste qui contient {0}
- Lors du déclanchement de la fonction getFibSeries() avec un Range de 6
    - Le résultat contient le chiffre 3
    - Le résultat contient 6 éléments
    - Le résultat n’a pas le chiffre 4 en son sein
    - Le résultat correspond à une liste qui contient {0, 1, 1, 2, 3, 5}
    - Le résultat est trié de façon ascendance 