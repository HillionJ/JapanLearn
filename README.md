# JapanLearn v0.2

**Développeur** : RedEstDeRetour
**Plateforme** : Android
**Version** : 0.2 (Deuxième version)
**Nom de l'application** : JapanLearn

## 📖 Présentation

JapanLearn est une application Android d'entraînement simple et rapide pour apprendre et pratiquer les hiraganas, les katakanas et les kanji. Elle permet de s'exercer à les reconnaître et à écrire leur transcription en romaji.

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

## ✨ Fonctionnalités principales

- 📚 **Sélection des modes d'apprentissage** :
  - Hiragana simple (あ, い, う, え, お, etc.)
  - Hiragana combinés (きゃ, きゅ, きょ, etc.)
  - Katakanas simple (ア, イ, ウ, エ, オ, etc.)
  - Katakanas combinés (キャ, ショ, チョ, etc.)
  - Kanji (日, 月, 火, 水, 木, etc.)

- 🔄 **Questions aléatoires** :

  À chaque lancement d'exercice, un caractère est tiré aléatoirement.

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

### Diagramme de classes

## 🛠️ Installation et lancement

1. Cloner ou télécharger le projet.
2. Ouvrir avec Android Studio.
3. Construire et exécuter sur un appareil Android ou un émulateur.

**Minimum SDK recommandé** : Android 7.0 (Nougat)

## 🚧 Limitations connues
- Seuls les hiraganas sont implémentés pour l'instant.
- Katakana et Kanji sont cochables mais non encore pris en charge.
- Pas encore de suivi de score ou de progression.
- Aucune gestion d'historique d'erreurs.
- Pas de personnalisation avancée de l'exercice.

## 📅 À venir dans les prochaines versions
- Support du katakana.
- Ajout de kanji de base avec leur lecture.
- Mode "révision des erreurs" pour revoir les mauvaises réponses.
- Mode "niveau" avec difficulté progressive.
- Enregistrement de la progression de l'utilisateur.

## 💬 Remarques

JapanLearn v0.1 est une version expérimentale, pensée avant tout pour aider à renforcer la mémoire visuelle et écrite du syllabaire japonais.

**Merci d'utiliser JapanLearn !**