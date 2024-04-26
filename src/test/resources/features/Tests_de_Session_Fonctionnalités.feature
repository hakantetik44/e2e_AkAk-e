Feature:

@kizconnect @hexaconnect @wisniowski @flexomV3 @APPSV2-1130
Scenario Outline: Tentative de connexion avec un mot de passe invalide
   Given lutilisateur souhaite se connecter à l'application
   When il accède à l'application Overkiz
   And l'utilisateur saisit son adresse e-mail valide
   Then si l'utilisateur saisit un mot de passe invalide
   And un message d'erreur saffiche correctement
Examples:
   | kizconnect  |
   | hexaconnect |
   | wisniowski  |
   | flexomV3    |

@kizconnect @hexaconnect @wisniowski @flexomV3  @APPSV2-1131
Scenario Outline: Tentative de connexion avec les champs vide
   Given lutilisateur souhaite se connecter à l'application
   When il accède à l'application Overkiz
   And l'utilisateur laisse le champ dadresse e-mail vide
   Then l'utilisateur laisse le champ du mot de passe vide
   And un message d'erreur saffiche correctement
  Examples:
    | kizconnect  |
    | hexaconnect |
    | wisniowski  |
    | flexomV3    |



  @kizconnect @flexomV3 @APPSV2-1128
Scenario Outline:Tentative de connexion avec succes
   Given lutilisateur souhaite se connecter à l'application
   When il accède à l'application Overkiz
   And utilisateur voit les champs "Adresse E-mail" And "Mot de passe" sur la page d'accueil
   Then  l'utilisateur saisit ses informations de connexion
   And l'utilisateur se connecte à son compte
 Examples:
   | tag        |
   | kizconnect |
   | flexomV3   |


@kizconnect @hexaconnect @wisniowski @flexomV3 @APPSV2-1129
Scenario Outline: Tentative de connexion avec une adresse e-mail invalide
  Given lutilisateur souhaite se connecter à l'application
  When il accède à l'application Overkiz
  And l'utilisateur saisit son adresse e-mail valide
  Then si l'utilisateur saisit une adresse e-mail invalide
  And un message d'erreur saffiche correctement
 Examples:
   | kizconnect  |
   | hexaconnect |
   | wisniowski  |
   | flexomV3    |