# e2e_overkiz


## Premiers pas avec le projet

### 1. Présentation du projet:

Ce projet est un projet de test mobile qui vise à développer des tests pour les plateformes Android/iOS et ce projet est une configuration pour les tests d'automatisation end-to-end (E2E) utilisant Appium, Cucumber et Selenium.

### 2. Technologies utilisées:

* Langage de programmation: Java
* Outil de build: Maven
* Cadre de test mobile: Appium
* Langage BDD: Gherkin (Cucumber)
* Kit de développement Java (JDK): 8
* Page Object Modèle
* Outil de reporting: Masterthought

  
### 3. Avantages du projet:

* Code compréhensible: L'utilisation du modèle Page Object rend le code plus organisé et plus compréhensible.
* Prise en charge de différentes plates-formes: Des tests peuvent être développés pour les plates-formes Android et iOS.
* Maintenance facile: Les scénarios de test écrits en langage Gherkin peuvent être facilement mis à jour.
* Rapports détaillés: Des rapports détaillés des résultats des tests peuvent être générés à l'aide de l'outil de reporting Masterthought.

**DRIVER CLASS** est une classe utilitaire qui initialise et gère les pilotes Appium pour les plates-formes Android et iOS.

**HOOKS CLASS** est une classe Cucumber qui définit les actions à effectuer avant et après chaque scénario de test, telles que la sélection d'une application (APK) pour les tests Android.

**BASEPAGE CLASS** contient des méthodes utilitaires pour effectuer des actions de base sur les éléments de la page, telles que le défilement et le clic, ainsi que la génération de données aléatoires pour les tests.

