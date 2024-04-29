Feature: Se connecter à overkiz

  @APPSV2-1133
  Scenario Outline: Vérification des informations personnelles
    Given Je lance mon app "<tag>"
    Given l'utilisateur souhaite vérifier ses informations personnelles
    When il accède à l'application Overkiz pour accéder à son profil
    Then l'utilisateur peut vérifier ses informations personnelles
    Examples:
      | tag         |
      | kizconnect  |
      | hexaconnect |
      | flexomV3    |



  @APPSV2-1134
  Scenario Outline: Modifications des informations personnelles
    Given Je lance mon app "<tag>"
    Given l'utilisateur souhaite modifier ses informations personnelles
    When il accède à l'application Overkiz pour accéder à son profil
    And l'utilisateur peut modifier ses informations personnelles
    Then l'utilisateur ne peut pas modifier certaines informations
    Examples:
      | tag         |
      | kizconnect  |
      | flexomV3    |
      | hexaconnect |
      | wisniowski  |


   @APPSV2-1135
  Scenario Outline: Planification via la géolocalisation
    Given Je lance mon app "<tag>"
    When l'utilisateur sélectionne le "Scénarios" pour la géolocalisation
    And l'utilisateur clique sur Géolocaliser
    Then trois actions sont possibles : Désactiver, Toujours activer, Activer une fois
    And l'utilisateur clique sur Toujours activer après avoir ajusté la distance
    When  l'utilisateur peut choisir une distance entre 100m And 1km à laide dun curseur nommé "Distance du domicile"
    Then l'utilisateur vérifie dans linterface dadministration que la planification est prise en compte dans le menu
    And l'utilisateur clique de nouveau sur "Géolocaliser"
    When l'utilisateur clique sur Désactiver
    Then l'utilisateur vérifie dans linterface dadministration que la planification est prise en compte dans le menu
    And l'utilisateur clique de nouveau sur "Géolocaliser"
    When l'utilisateur clique sur Activer une fois après avoir ajusté la distance
    And l'utilisateur clique sur Enregistrer
    Then l'utilisateur vérifie dans linterface dadministration que la planification est prise en compte dans le menu
    Examples:
      | tag         |
      | kizconnect  |
      | hexaconnect |
      | flexomV3    |



  Scenario: Gestion des scénarios - Ajout d'équipements
    Given Je lance mon app "<tag>"
    When l'utilisateur sélectionne le "Scénarios" pour la géolocalisation
    And l'utilisateur clique sur "Ajoutez un équipement"
    And l'utilisateur sélectionne l'équipement à ajouter
    And l'utilisateur ne choisit pas d'action à réaliser lors de l'exécution du scénario
    Then l'utilisateur clique sur "Valider"
    And l'utilisateur ne choisit pas d'action à réaliser lors de l'exécution du scénario
    Then l'utilisateur clique sur "Valider"
    And l'utilisateur clique sur "Terminer"
    And l'utilisateur choisit une action à réaliser lors de l'exécution du scénario
    Then l'utilisateur clique sur "Valider"
    And l'utilisateur clique sur "Terminer"




  @APPSV2-1136
  Scenario Outline: Gestion des scénarios - Modifications
    Given Je lance mon app "<tag>"
    When  l'utilisateur clique sur "Gérer mes accès secondaires" dans longlet "En plus"
    And  il saisi l'adresse e-mail et le mot de passe du compte secondaire
    And  il clique sur le bouton "Créer" en bas
    Then l'accès secondaire est créé
    And  un écran récapitulatif des comptes secondaires existants apparaît
    Examples:
      | tag         |
      | kizconnect  |
      | hexaconnect |
      | wisniowski  |
      | flexomV3    |



  Scenario Outline: Gérer la connexion et accéder au menu caché
    Given l'utilisateur est sur lécran daccueil
    When Je sélectionne "En plus" puis "Déconnexion"
    Then On est sur la page de connexion de l’application
    When On est sur la page de connexion de l’application
    And Je choisis un serveur parmi:
    And Je renseigne le numéro du serveur dans le champ dédié
    And Je clique sur "OK"
    Then L’application pointe sur le serveur sélectionné
    And L'écran de connexion est de nouveau visible
    Examples:
      | tag         |
      | kizconnect  |
      | hexaconnect |
      | wisniowski  |
      | flexomV3    |


