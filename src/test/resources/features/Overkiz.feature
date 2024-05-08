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


  Scenario Outline: Gestion des scénarios - Ajout d'équipements
    Given Je lance mon app "<tag>"
    When l'utilisateur sélectionne le "Scénarios"
    And l'utilisateur clique sur "Ajoutez un équipement"
    And l'utilisateur sélectionne léquipement à ajouter
    Then l'utilisateur clique sur Terminer
    And l'utilisateur resélectionne léquipement à ajouter
    And l'utilisateur choisit une action à réaliser lors de lexécution du scénario
    Then l'utilisateur clique sur Valider
    And le message de mis à jour avec succès devrait s'afficher

    Examples:
      | tag         |
      | kizconnect  |
      | hexaconnect |
      | flexomV3    |



  Scenario Outline: Création, suppression et lancement de scénario avec ajout d'équipements
    Given Je lance mon app "<tag>"
    When l'utilisateur sélectionne le Scénarios
    And l'utilisateur clique sur Créer un scénario
    And l'utilisateur nomme le scénario dans le champ "Nom du scénario"
    And l'utilisateur choisit licône du scénario
    And l'utilisateur clique sur Suivant
    And l'utilisateur choisit léquipement à ajouter au scénario
    And l'utilisateur ne choisit pas la position de léquipement
    And l'utilisateur clique sur Valider
    And l'utilisateur verifie léquipement à ajouter au scénario
    And l'utilisateur clique sur Terminer
    And le message de créé devrait s'afficher
    And l'utilisateur choisit une action à réaliser lors de lexécution du scénario
    Then l'utilisateur clique sur Valider
    And le message de mis à jour avec succès devrait s'afficher
    And  l'utilisateur clique sur le bouton retour
    Then  l'utilisateur cliquesur le logo Play
    And l'utilisateur cliquesur le bouton Stop
    And A la fin de l'exécution de la commande, le bouton "Play" réapparait.
    Then l'utilisateur sélectionne un scénario à supprimer
    And l'utilisateur le fait glisser vers la gauche
    Then le pop-up "Êtes-vous sûr de vouloir supprimer ce scénario ?" s'affiche
    And l'utilisateur clique sur Supprimer
    And le message de suppression avec succès devrait s'afficher
    And l'utilisateur contrôler les données sur ladmin

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


