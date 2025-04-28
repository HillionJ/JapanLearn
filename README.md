# JapanLearn v0.1

**Développeur** : RedEstDeRetour
**Plateforme** : Android
**Version** : 0.1 (Première version)
**Nom de l'application** : JapanLearn

## 📖 Présentation

JapanLearn est une application Android d'entraînement simple et rapide pour apprendre et pratiquer les hiraganas japonais. Elle permet de s'exercer à reconnaître les hiraganas et à écrire leur transcription en romaji.

**Version 0.1** : uniquement les hiraganas de base et combinés sont disponibles.

## ✨ Fonctionnalités principales

- 📚 **Sélection des modes d'apprentissage** :
  - Hiragana simple (あ, い, う, え, お, etc.)
  - Hiragana combinés (きゃ, きゅ, きょ, etc.)

- 🔄 **Questions aléatoires** :

    À chaque lancement d'exercice, un caractère est tiré aléatoirement.

- 🔁 **Inversion des questions** :

    Il est possible que l'application demande soit :
  - "Quel est le romaji de ce hiragana ?"
  - soit "Quel est le hiragana pour ce romaji ?"

- ✅ **Correction instantanée** :

    L'utilisateur est informé immédiatement si sa réponse est correcte ou non.

- 🎯 **Relance rapide** :

    Après chaque réponse, l'application enchaîne directement sur un nouveau caractère.

- 🖐️ **Fermeture facile** :

    Un bouton `Fermer` permet de quitter rapidement l'entraînement.

## 📸 Aperçu rapide de l'utilisation

1. Lancer l'application

2. Sélectionner les caractères à étudier (Hiragana simples et/ou combinés)

3. Cliquer sur `Démarrer`

4. Écrire la bonne transcription et valider

5. Corriger immédiatement en cas d'erreur

6. Continuer l'apprentissage sur de nouveaux caractères

## ⚙️ Structure technique

- **MainActivity** :
  - Permet de configurer la session (choix des types de caractères).
  - Démarre l'activité d'entraînement.
  - Gère la sélection aléatoire des caractères et la possibilité d'inversion question/réponse.

- **TrainActivity** :
  - Présente un caractère à deviner.
  - Compare la réponse de l'utilisateur à la réponse attendue.
  - Fournit un feedback immédiat.
  - Relance une nouvelle tentative automatiquement.

- **Hiraganas** (utilitaire) :
  - Contient deux maps statiques :
  - `hiraganaMap` : hiragana simples
  - `hiraganaCombinedMap` : hiragana combinés (`きゃ`, `ぎゅ`, etc.)

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