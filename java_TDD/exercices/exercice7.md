## Exercice 7 TDD ***Bowling***

Le but de l'exercice est de :
Poursuivre l’apprentissage du mocking via la réalisation d’une série de tests d’une application de bowling virtuel jouant sur l’aléatoire.

On souhaite développer une classe Frame, qui représente une Frame dans le jeu du bowling, en utilisant les TDD.

1. Créez la structure de classe Frame.
2. Réalisez les tests pour les méthodes de la classe Frame.
3. Implémentez les méthodes de la classe Frame.

Les tests pour réaliser la classe Frame du jeu de bowling doivent couvrir les scénarios suivants:
- S’il s’agit d’une série standard (round 1 par exemple)
    - Le premier lancer d’une série doit augmenter le score de la série
    - Le second lancer d’une série doit augmenter le score de cette série
    - En cas de strike, il ne doit pas être possible de lancer de nouveau au cours de cette même série.
    - En cas de lancers standards, il ne doit pas être possible de lancer plus de 2 fois
- S’il s’agit d’une série finale (dernier round)
    - En cas de strike, il doit être possible de lancer une nouvelle fois au cours d’une série
    - En cas de strike puis de lancer, le score est censé augmenter en accord avec le résultat du lancer.
    - En cas de strike puis d’un lancer, il doit être possible de lancer une nouvelle fois
    - En cas de strike puis de lancer, le score est censé augmenter en accord avec le résultat
    - En cas de spare, il doit être possible de lancer une nouvelle fois au cours d’une série
    - En cas de spare puis de lancer, le score est censé augmenter en accord avec le résultat du lancer.
    - En cas de lancers standards, il ne doit pas être possible de lancer plus de 4 fois