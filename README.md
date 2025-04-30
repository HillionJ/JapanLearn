# JapanLearn v1.0

**Développeur** : RedEstDeRetour

**Plateforme** : Android

**Version** : 1.0 (Itération 3)

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

## ✨ Fonctionnalités principales

- 📚 **Sélection des modes d'apprentissage** :
  - Hiragana simple (あ, い, う, え, お, etc.)
  - Hiragana combinés (きゃ, きゅ, きょ, etc.)
  - Katakanas simple (ア, イ, ウ, エ, オ, etc.)
  - Katakanas combinés (キャ, ショ, チョ, etc.)
  - Kanji (日, 月, 火, 水, 木, etc.)

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

- 🖐️ **Fermeture facile** :

    Un bouton `Fermer` permet de quitter rapidement l'entraînement.

## 📸 Aperçu de l'interface utilisateur

### Format portrait
![Video horizontale](Sources/horizontal.gif)

### Format paysage
![Video verticale](Sources/vertical.gif)

## ⚙️ Diagrammes

### Cas d'utilisation
![Cas d'utilisation](Sources/Cas%20d'utilisation.png)

### Diagramme de classes
![Cas d'utilisation](Sources/Diagrammes%20de%20classes.png)

## 🛠️ Installation et lancement

1. Cloner ou télécharger le projet.
2. Ouvrir avec Android Studio.
3. Construire et exécuter sur un appareil Android ou un émulateur.

**Minimum SDK recommandé** : Android 7.0 (Nougat)

## 🚧 Limitations connues
- Aucune gestion d'historique d'erreurs.
- Pas de personnalisation avancée de l'exercice.

## 📅 À venir dans les prochaines versions
- Mode "révision des erreurs" pour revoir les mauvaises réponses.

## 💬 Remarques

JapanLearn v1.0 est une version expérimentale, pensée avant tout pour aider à renforcer la mémoire visuelle et écrite du syllabaire japonais.

**Merci d'utiliser JapanLearn !**