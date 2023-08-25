## Exercice 5 Bis TDD

Une agence de location de voitures utilise un système informatisé pour suivre le nombre de jours restant avant l'échéance du contrat de location et l'état de chaque voiture.

Dans le système, chaque voiture possède :

- Un attribut "RentDueIn" qui indique le nombre de jours restants avant que le contrat de location n'expire.
- Un attribut "Condition" qui représente l'état de chaque voiture sur une échelle de 0 à 100.

Chaque jour, le système déclenche une routine appelée "dailyRoutine" qui réduit la valeur de RentDueIn et Condition pour chaque voiture selon ces règles :

- Après l'expiration du contrat de location, la valeur de Condition se dégrade deux fois plus vite.
- L'état d'une voiture n'est jamais négatif.
- L'état d'une voiture n'est jamais supérieur à 100.
- L'état des voitures de luxe augmente avec le temps, car elles sont régulièrement entretenues.
- Les voitures plus anciennes se dégradent en condition deux fois plus vite que les voitures normales.

Votre mission est de réaliser la méthode "dailyRoutine" en utilisant les TDD (Test-Driven Development)