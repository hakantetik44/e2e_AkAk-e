# language: fr
@Smoke
Fonctionnalité: Se connecter à Overkiz

  @SUP-3
  Scénario:Tentative de connexion avec succes
    Étant donné que lutilisateur souhaite se connecter à l'application
    Quand il accède à l'application Overkiz
    Et utilisateur voit les champs "Adresse E-mail" et "Mot de passe" sur la page d'accueil
    Alors  l'utilisateur saisit ses informations de connexion
    Et l'utilisateur se connecte à son compte

  @SUP-4
  Scénario: Tentative de connexion avec une adresse e-mail invalide
    Étant donné que lutilisateur souhaite se connecter à l'application
    Quand il accède à l'application Overkiz
    Et l'utilisateur saisit son adresse e-mail valide
    Alors si l'utilisateur saisit une adresse e-mail invalide
    Et un message d'erreur saffiche correctement

  @SUP-5
  Scénario: Tentative de connexion avec un mot de passe invalide
    Étant donné que lutilisateur souhaite se connecter à l'application
    Quand il accède à l'application Overkiz
    Et l'utilisateur saisit son adresse e-mail valide
    Alors si l'utilisateur saisit un mot de passe invalide
    Et un message d'erreur saffiche correctement

  @SUP-6
  Scénario: Tentative de connexion avec les champs vide
    Étant donné que lutilisateur souhaite se connecter à l'application
    Quand il accède à l'application Overkiz
    Et l'utilisateur laisse le champ dadresse e-mail vide
    Alors l'utilisateur laisse le champ du mot de passe vide
    Et un message d'erreur saffiche correctement

  @SUP-7
  Scénario: Vérification des éléments sur la page d'accueil
    Étant donné que lutilisateur souhaite vérifier les éléments sur la page d'accueil
    Quand il accède à l'application Overkiz
    Alors  l'utilisateur saisit ses informations de connexion
    Et les éléments de la page d'accueil sont vérifiés conformément aux spécifications

  @APPSV2-656
  Scénario: Vérification des informations personnelles pour Android
    Étant donné que l'utilisateur souhaite vérifier ses informations personnelles
    Quand il accède à l'application Overkiz avec ses informations de connexion
    Alors l'utilisateur peut vérifier ses informations personnelles

  @APPSV2-655
  Scénario:  Modifications des informations personnelles pour Android
    Étant donné que l'utilisateur souhaite modifier ses informations personnelles
    Quand il accède à l'application Overkiz avec ses informations de connexion
    Alors l'utilisateur peut modifier ses informations personnelles
    Et l'utilisateur ne peut pas modifier certaines informations.

