# Chat RMI Application

Cette application est un système de chat basé sur Java RMI (Remote Method Invocation) qui permet la communication entre plusieurs clients via un serveur centralisé.

## Structure du Projet

Le projet est organisé en trois composants principaux :
- `interfaces/` : Contient les interfaces RMI partagées
- `server/` : Contient l'implémentation du serveur
- `client/` : Contient l'implémentation du client

## Prérequis

- Java JDK 8 ou supérieur
- Apache Ant pour la compilation

## Construction du Projet

Le projet utilise Apache Ant pour la compilation et la création des fichiers JAR. Voici les principales commandes disponibles :

1. Pour tout compiler :
```bash
ant all
```

2. Pour nettoyer les fichiers compilés :
```bash
ant clean
```

## Exécution

1. Pour démarrer le serveur :
```bash
ant server
```

2. Pour lancer un client :
```bash
ant client
```

## Structure des Dossiers

- `interfaces/src/` : Code source des interfaces
- `server/src/` : Code source du serveur
- `client/src/` : Code source du client
- `lib/` : Bibliothèques partagées
- `server/lib/` : Bibliothèques spécifiques au serveur
- `client/lib/` : Bibliothèques spécifiques au client

## Fichiers Générés

Après la compilation, les fichiers suivants sont créés :
- `ChatInterfaces.jar` : Contient les interfaces RMI
- `ChatServer.jar` : Application serveur
- `ChatClient.jar` : Application client
