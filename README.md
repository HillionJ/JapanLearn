![Android Badge](https://img.shields.io/badge/Android-3DDC84?logo=android&logoColor=fff&style=plastic)

![android-build](https://github.com/HillionJ/JapanLearn/actions/workflows/android.yml/badge.svg)

![GitHub commit activity](https://img.shields.io/github/commit-activity/m/HillionJ/JapanLearn)
![GitHub last commit](https://img.shields.io/github/last-commit/HillionJ/JapanLearn)
![GitHub contributors](https://img.shields.io/github/contributors/HillionJ/JapanLearn)

![GitHub pull requests](https://img.shields.io/github/issues-pr/HillionJ/JapanLearn)
![GitHub closed pull requests](https://img.shields.io/github/issues-pr-closed/HillionJ/JapanLearn)

# JapanLearn v2.0

**Développeur** : RedEstDeRetour

**Plateforme** : Android

**Version** : 2.0 (Itération 4)

**Nom de l'application** : JapanLearn

## 📖 Présentation

JapanLearn est une application Android d'entraînement simple et rapide pour apprendre et pratiquer les hiraganas, les katakanas et les kanji. Elle permet de s'exercer à les reconnaître et à écrire leur transcription en romaji.

## 📚 Glossaire
- **Question**: Caractère où ensemble de caractères à déterminer
- **Questionnaire**: Suite de questions composé de *n* questions
- **Statistiques**: Données récoltée en fonctions des réponses du questionnaire
- **Session**: Constitue l'emsemble d'un questionnaire et de ses statistiques de manière unique.
- **Statut d'une réponse**: Défini si la réponse entrée est valide ou invalide. Peut ou non contenir des informations sur la réponse entrée


## 🕒 Historique des versions
**Version 0.1** : 
- Paramétrer la session (Hiraganas et Combinaisons Hiraganas)
- Lancer une session
- Visualiser le caractère
- Ecrire la réponse
- Visualiser le statut de la réponse via un "Toast" (Bonne réponse / Mauvaise réponse)


**Version 0.2** : 
- Paramétrer la session (Hiraganas ± Kataganas ± Kanji ± Combinaisons Hiraganas ± Combinaisions Katakanas)
- Lancer une session
- Visualiser le caractère
- Ecrire la réponse
- Visualiser le statut de la réponse:
  - **Bonne réponse**: Afficher la signification (si disponible)
  - **Mauvaise réponse**: Afficher la solution
- Passer à la question suivante avec `Continuer` en cas de _visualisation du statut d'une réponse_


**Version 1.0** : 
- Paramétrer la session (Hiraganas ± Kataganas ± Kanji ± Combinaisons Hiraganas ± Combinaisions Katakanas + Nombre de quesitons)
- Lancer une session
- Visualiser le caractère
- Ecrire la réponse
- Visualiser le statut de la réponse:
  - **Bonne réponse**: Afficher la signification (si disponible)
  - **Mauvaise réponse**: Afficher la solution
- Passer à la question suivante avec `Continuer` en cas de _visualisation du statut d'une réponse_
- Visualiser les statisques à la fin de la partie
- Visualiser la progression du questionnaire
- Sauvegarder et appliquer les paramètres
- Faire sortir le clavier automatiquement en fonction de l'orientation:
  - **Portait**: Afficher automatiquement à chaque question
  - **Paysage**: Laisser le clavier masqué le temps que l'utilisateur visualise la question

**Version 2.0** : 
- Paramétrer la session (Hiraganas ± Kataganas ± Kanji ± Combinaisons Hiraganas ± Combinaisions Katakanas + Nombre de quesitons)
- Lancer une session
- Visualiser le caractère
- Ecrire la réponse
- Visualiser le statut de la réponse:
  - **Bonne réponse**: Afficher la signification (si disponible)
  - **Mauvaise réponse**: Afficher la solution
- Passer à la question suivante avec `Continuer` en cas de _visualisation du statut d'une réponse_
- Visualiser les statisques à la fin de la partie
- Visualiser la progression du questionnaire
- Sauvegarder et appliquer les paramètres
- Faire sortir le clavier automatiquement en fonction de l'orientation:
  - **Portait**: Afficher automatiquement à chaque question
  - **Paysage**: Laisser le clavier masqué le temps que l'utilisateur visualise la question
- Visualiser ses erreurs fréquentes
- Corriger ses erreurs fréquentes
- Données enregistrées dans une base de données SQLite:
  - **Caractères**: Enregistrer les caractères Hiragana, Katakana et Kanji
  - **Questions**: Enregistrer les questions constituées de caractères et de leur transcription en romaji
  - **Erreurs fréquentes**: Enregistrer les erreurs fréquentes de l'utilisateur

## ✨ Fonctionnalités principales

- 📚 **Sélection des modes d'apprentissage** :
  - **Hiragana**
    - Hiragana simple (あ, い, う, え, お, etc.)
    - Hiragana combinés (きゃ, きゅ, きょ, etc.)
  - **Katakanas**
    - Katakanas simple (ア, イ, ウ, エ, オ, etc.)
    - Katakanas combinés (キャ, ショ, チョ, etc.)
  - **Kanji**
    - Kanji simple (日, 月, 火, 水, 木, etc.)

- 🔄 **Questions aléatoires** :

  Au lancement de la session, un questionnaire est créer aléatoirement

- 🔁 **Inversion des questions** :

    Il est possible que l'application demande soit :
  - "Quel est le romaji de ce hiragana ?"
  - soit "Quel est le hiragana pour ce romaji ?"

- ✅ **Correction instantanée** :

    L'utilisateur est informé immédiatement si sa réponse est correcte ou non.
    
    - **En cas de mauvaise réponse**: Un texte apparait en **rouge** avec la bonne réponse d'afficher
    - **En cas de bonne réponse**:
      - AVEC SIGNIFICATION: Un texte apparait en **vert** avec la signification (Kanji uniquement)
      - SANS SIGNIFICATION: Passage automatique vers la question suivante.

- 🎯 **Relance rapide** :

    Après chaque réponse ou continuation, l'application enchaîne directement sur un nouveau caractère.

- ❌ **Révision des erreur** :
  
  L'application mémorise les erreurs fréquentes de l'utilisateur et lui propose de les corriger à la fin de la session.

  Elle lui permet de revoir les caractères qu'il a le plus souvent mal identifiés dans une activité dédiée.


- 🖐️ **Fermeture facile** :

    Un bouton `Fermer` permet de quitter rapidement l'entraînement.

## 📸 Aperçu de l'interface utilisateur

### Format portrait
![Video portrait](Sources/portrait.gif)

## ⚙️ Diagrammes

### Cas d'utilisation
![Cas d'utilisation](Sources/Cas%20d'utilisation.png)

### Diagramme de classes
![Cas d'utilisation](Sources/Diagrammes%20de%20classes.png)

### Diagramme de base de données relationnelle
![Cas d'utilisation](Sources/Diagramme%20de%20base%20de%20données%20relationnelle.png)

## 🛠️ Installation et lancement

1. Cloner ou télécharger le projet.
2. Ouvrir avec Android Studio.
3. Construire et exécuter sur un appareil Android ou un émulateur.

**Minimum SDK recommandé** : Android 7.0 (Nougat)

## 🚧 Limitations connues
- Pas de personnalisation avancée de l'exercice.

## 💬 Remarques

JapanLearn v2.0 est une version expérimentale, pensée avant tout pour aider à renforcer la mémoire visuelle et écrite du syllabaire japonais.

**Merci d'utiliser JapanLearn !**