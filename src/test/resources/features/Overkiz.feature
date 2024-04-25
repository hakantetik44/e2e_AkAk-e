
Feature: Se connecter à overkiz

  @kizconnect @flexomV3 @hexaconnect  @APPSV2-1133
  Scenario Outline: Vérification des informations personnelles
    Given l'utilisateur souhaite vérifier ses informations personnelles
    When il accède à l'application Overkiz pour accéder à son profil
    Then l'utilisateur peut vérifier ses informations personnelles

    Examples:
      | tag         |
      | kizconnect  |
      | flexomV3    |
      | hexaconnect |

  @kizconnect @flexomV3 @hexaconnect @APPSV2-1134
  Scenario Outline:  Modifications des informations personnelles
    Given l'utilisateur souhaite modifier ses informations personnelles
    When il accède à l'application Overkiz pour accéder à son profil
    And l'utilisateur peut modifier ses informations personnelles
    Then l'utilisateur ne peut pas modifier certaines informations
    Examples:
      | tag         |
      | kizconnect  |
      | flexomV3    |
      | hexaconnect |

  @kizconnect @hexaconnect @wisniowski @flexomV3 @APPSV2-1135
  Scenario Outline: Planification via la géolocalisation
    Given l'utilisateur est sur lécran daccueil
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
      | kizconnect  |
      | hexaconnect |
      | wisniowski  |
      | flexomV3    |




  @kizconnect @hexaconnect @wisniowski @flexomV3 @APPSV2-1136
  Scenario Outline: Gestion des scénarios - Modifications
    Given  l'utilisateur est sur lécran daccueil
    When  l'utilisateur clique sur "Gérer mes accès secondaires" dans longlet "En plus"
    And  il saisi l'adresse e-mail et le mot de passe du compte secondaire
    And  il clique sur le bouton "Créer" en bas
    Then l'accès secondaire est créé
    And  un écran récapitulatif des comptes secondaires existants apparaît
    Examples:
      | kizconnect  |
      | hexaconnect |
      | wisniowski  |
      | flexomV3    |

  @kizconnect @hexaconnect @wisniowski  @flexomV3 @APPSV2-445
  Scenario Outline: Piloter un équipement depuis l'écran d'exploitation
    Given  l'utilisateur est sur lécran daccueil
    When l'utilisateur navigue dans les pièces pour choisir léquipement à piloter
    And l'utilisateur devrait être redirigé vers lécran dexploitation
    And l'utilisateur devrait voir le nom de léquipement
    And l'utilisateur devrait voir les boutons
    And l'utilisateur devrait voir licône de léquipement
    And l'utilisateur devrait voir létoile permettant de placer léquipement en favori
    When l'utilisateur clique sur "Ouvrir"
    Then l'équipement devrait être ouvert
    When l'utilisateur clique sur "Fermer"
    Then l'équipement devrait être fermé
    When l'utilisateur clique sur "Stop"
    Then l'équipement devrait sarrêter
    When l'utilisateur clique sur "On"
    Then l'équipement devrait être allumé
    When l'utilisateur clique sur "Off"
    Then l'équipement devrait être éteint
    When l'utilisateur lit les informations du capteur
    Then l'utilisateur devrait voir les informations du capteur
    Examples:
      | kizconnect  |
      | hexaconnect |
      | wisniowski  |
      | flexomV3    |

  @kizconnect @hexaconnect @wisniowski @flexomV3
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
      | @kizconnect  |
      | @hexaconnect |
      | @wisniowski  |
      | @flexomV3    |



