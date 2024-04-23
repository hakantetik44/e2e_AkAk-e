Feature:
 @kizconnectAndroid @hexaconnectAndroid @wisniowskiAndroid @flexomV3Android  @APPSV2-1129
  Scenario : Tentative de connexion avec une adresse e-mail invalide
    Given lutilisateur souhaite se connecter à l'application
    When il accède à l'application Overkiz
    And l'utilisateur saisit son adresse e-mail valide
    Then si l'utilisateur saisit une adresse e-mail invalide
    And un message d'erreur saffiche correctement



  @kizconnect @hexaconnect @wisniowski @flexomV3 @APPSV2-1130
  Scenario: Tentative de connexion avec un mot de passe invalide
    Given lutilisateur souhaite se connecter à l'application
    When il accède à l'application Overkiz
    And l'utilisateur saisit son adresse e-mail valide
    Then si l'utilisateur saisit un mot de passe invalide
    And un message d'erreur saffiche correctement


  @kizconnect @hexaconnect @wisniowski @flexomV3  @APPSV2-1131
   Scenario : Tentative de connexion avec les champs vide
    Given lutilisateur souhaite se connecter à l'application
    When il accède à l'application Overkiz
    And l'utilisateur laisse le champ dadresse e-mail vide
    Then l'utilisateur laisse le champ du mot de passe vide
    And un message d'erreur saffiche correctement
