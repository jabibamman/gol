# Game of Life

## Qu'est-ce que le Game of Life ?

Le Game of Life, ou Jeu de la vie en français, est un automate cellulaire conçu par le mathématicien britannique John Horton Conway en 1970. Il s'agit d'un jeu à zéro joueur, ce qui signifie que son évolution est déterminée par son état initial, sans nécessiter d'interaction supplémentaire de la part des joueurs. Les cellules sur une grille vivent, meurent ou se reproduisent selon un ensemble de règles simples :

1. **Survie par sous-population :** Toute cellule vivante ayant moins de deux voisins vivants meurt, comme par sous-population.
2. **Survie par surpopulation :** Toute cellule vivante ayant plus de trois voisins vivants meurt, comme par surpopulation.
3. **Reproduction :** Toute cellule morte ayant exactement trois voisins vivants devient une cellule vivante, comme par reproduction.
4. **Stabilité :** Toute cellule vivante ayant deux ou trois voisins vivants reste vivante pour la génération suivante.

## Comment exécuter le projet

Ce projet est implémenté en Kotlin et utilise Cucumber pour les tests BDD (Behavior-Driven Development). Voici comment vous pouvez exécuter ce projet.

### Prérequis

- [JDK 1.8 ou plus récent](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- Un IDE supportant Kotlin (comme IntelliJ IDEA)

### Étapes pour exécuter le projet

1. **Cloner le dépôt**

   Clonez le dépôt dans votre répertoire local.

   ```sh
   git clone https://github.com/jabibamman/gol.git
   cd game-of-life
    ```

### Construire le projet

Utilisez Maven pour construire le projet. Ce command installera toutes les dépendances nécessaires.

```sh
mvn clean install
```

### Exécuter les tests

Exécutez les tests pour vous assurer que tout fonctionne correctement.

```sh
mvn test
```

### Exécuter l'application

Vous pouvez également exécuter l'application principale avec Maven.

```sh
mvn exec:java -Dexec.mainClass="com.gameoflife.MainKt"
```

### Structure du projet

Voici un aperçu des fichiers et répertoires principaux du projet :

- `src/main/kotlin/com/gameoflife`
  - Grid.kt : Contient la classe Grid qui représente la grille du jeu.
  - GameOfLife.kt : Contient la logique principale du jeu. 
- `src/test/kotlin/com/gameoflife`
  - GameOfLifeSteps.kt : Définit les étapes pour les tests BDD.
  - game_of_life.feature : Contient les scénarios de test écrits en Gherkin.


## Auteur

👤 **James ABIB**
👤 **Marc MALHA**
👤 **Charles CRETOIS**

Nos profils GitHub :

[@jabibamman](github.com/jabibamman)

[@marcmalha](github.com/marcmalha)

[@charlescretois](github.com/carlito0605)


## 🤝 Contribuer

Les contributions, les problèmes et les demandes de fonctionnalités sont les bienvenus !<br />

1. Forker le projet
2. Créer votre branche de fonctionnalité (`git checkout -b feat/BestFeature`)
3. Commiter vos modifications (`git commit -m 'Add some la Best Feature'`)
4. Pusher sur la branche (`git push origin feat/BestFeature`)