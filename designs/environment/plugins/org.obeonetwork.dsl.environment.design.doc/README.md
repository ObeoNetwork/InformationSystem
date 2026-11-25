# Contribuer à la documentation d’IS Designer

Ce guide rassemble les conventions communes aux documentations utilisateur d’IS Designer : modeleurs, vues, outils d’import, transformations et autres fonctionnalités. Son emplacement dans le module Environment ne limite pas son application à ce module.

Il est rédigé en français pour une raison pratique : la documentation utilisateur est majoritairement en français. Les principes de structure, de nommage et de vérification s’appliquent aussi aux pages en anglais, en adaptant les règles rédactionnelles à leur langue. Conserver la langue d’une page sauf décision de traduction.

## Sources et publications

Les fichiers `.textile` sont les sources. Après une modification, régénérer le HTML et le sommaire XML avec l’outil dédié dans Eclipse. Corriger les sources, puis régénérer les sorties plutôt que modifier directement le HTML ou le sommaire.

Les mêmes sources alimentent l’aide Eclipse et le [wiki GitHub ISD](https://github.com/ObeoNetwork/InformationSystem/wiki). Vérifier la lisibilité et la navigation sur les deux supports. Eclipse est la référence pour les réglages d’affichage. Des différences de rendu avec GitHub sont acceptées.

## Rédaction et typographie

| Sujet | Convention |
| --- | --- |
| Consignes | Pour les pages en français, employer l’infinitif, sans « vous » ni « nous » : « Sélectionner l’élément ». |
| Descriptions | Employer le présent. Les titres et descriptions d’outils peuvent rester nominaux : « Création d’un élément ». |
| Noms et sigles | Écrire uniformément IS Designer et OpenAPI. Les sigles restent invariables au pluriel : « les DTO », « les API », « les URL ». |
| Libellés de l’interface | Reprendre exactement les libellés et les mettre en italique dans la prose : `_Model Explorer_`. Vérifier une graphie incertaine dans les ressources ou le code qui définit l’interface, puis dans le produit si nécessaire. Conserver le pluriel, la casse et la langue d’un libellé exact. |
| Concepts du modèle | Employer le nom exact du type en italique, sans suffixe de pluriel ajouté : `_Namespace_`, `_ViewContainer_`. Employer le français pour les explications générales, par exemple « package » ou « conteneur de vue ». Distinguer un nom de type d’un libellé de l’interface. |
| Interactions | Utiliser « calque », « libellé », « glisser-déposer », « double-clic » et « vue de propriétés » dans les explications. Conserver les noms exacts des actions et attributs. |
| Valeurs techniques | Employer la chasse fixe Textile `@...@` pour les noms d’attributs, extensions, chemins, expressions et valeurs techniques, sans changer leur contenu : `@label@`, `@*.aird@`, `@ASC@`. Présenter les commandes ou exemples sur plusieurs lignes dans un bloc `bc.`. |
| Listes et ponctuation | Harmoniser chaque liste selon sa construction. Une phrase complète commence par une majuscule et se termine par un point. Les fragments poursuivant une phrase gardent une ponctuation cohérente. Écrire « etc. » et préférer « et » ou « ou » à une barre oblique selon le sens. Séparer les listes des paragraphes par une ligne vide. |

Le nom IS Designer reste en texte courant. Lorsqu’il appartient à un libellé d’interface ou à un chemin de menu, il suit la mise en italique de ce libellé. Réserver le gras aux points importants et aux avertissements.

Préserver les notions métier et leur sens, notamment le binding. Swagger et OpenAPI peuvent désigner des choses différentes : vérifier le contexte avant de remplacer l’un par l’autre. Décrire les usages du point de vue de l’utilisateur final et réserver les détails techniques aux informations qui lui sont utiles.

## Plans, titres et navigation

Adapter le plan à la fonction de chaque documentation. Un modeleur peut distinguer présentation, création du modèle, utilisation, représentations et fonctionnalités complémentaires. Un outil d’import peut suivre les étapes d’une opération. Une vue dédiée peut distinguer son ouverture, son contenu et ses actions. Utiliser ces repères lorsqu’ils servent le contenu, sans créer de section vide ou artificielle.

Pour une représentation, employer son nom exact dans l’interface comme titre. Présenter son rôle et son contexte de création dans le texte, puis les éléments affichés, les outils et les interactions utiles. Introduire les concepts avant leurs propriétés ou contraintes.

Utiliser un titre principal par page et une hiérarchie sans saut de niveau. Donner des sous-titres aux procédures ou explications qui méritent d’être accessibles dans le sommaire.

Chaque titre porte une ancre explicite, lisible, sans accent, en minuscules avec des mots séparés par `_`. L’ancre est unique dans sa page et correspond au contenu de la section :

```textile
h2(#model_creation). Création d’un modèle
```

Conserver les ancres déjà lisibles et adaptées. Lors d’un changement d’ancre, rechercher les références dans les autres pages, mettre à jour les liens concernés et vérifier les cibles du sommaire régénéré. Vérifier aussi les renvois textuels lorsqu’un titre change.

## Images

La publication wiki fusionne les dossiers `pics` des différentes documentations. Chaque page dispose donc d’un premier sous-dossier propre, y compris lorsque plusieurs pages sont dans le même module. Une vue consolidée a un sous-dossier distinct de celui du modeleur associé. Conserver les sous-classements thématiques utiles.

Pour nommer les fichiers :

- Employer des noms anglais descriptifs, fondés sur le contenu visible et son contexte.
- Utiliser CamelCase avec initiale majuscule, sans espaces ni underscores. Conserver les sigles reconnaissables.
- Employer le tiret pour exprimer une relation conteneur/contenu : `ModelExplorer-ProjectStructure.png`, `ModelCreationWizard-NameAndLocation.png`.
- Examiner les captures avant de remplacer les noms vagues ou numérotés. Un nom doit permettre de comprendre ce que montre l’image.
- Conserver le format du fichier et écrire l’extension en minuscules.

Lors d’un renommage ou d’un déplacement, préserver le contenu du fichier image, mettre à jour toutes les références et vérifier l’absence de collisions après fusion des chemins pour le wiki. Rechercher les usages dans les autres pages avant de supprimer une image non référencée dans sa page d’origine.

Les grandes captures utilisent une largeur maximale qui permet de les réduire à la largeur disponible sans les agrandir :

```textile
!{max-width:100%}pics/exemple/DiagramOverview.png!
```

Les icônes et petites captures restent à taille native, sans style ajouté. Choisir l’affichage selon la lisibilité et les proportions, sans facteur d’échelle ni seuil de largeur universel. Ne pas ajouter de hauteur ni `height:auto` lorsque seule la largeur maximale est définie.

Préserver la fidélité des captures à l’interface du produit. Vérifier le résultat dans le HTML et l’aperçu Textile Eclipse. GitHub peut ignorer les styles Textile et appliquer ses propres règles d’affichage.

## Vérifications avant commit

- Relire le diff des sources et vérifier que le vocabulaire technique, les exemples et les règles fonctionnelles conservent leur sens.
- Régénérer le HTML et le sommaire dans Eclipse, puis contrôler les titres, les ancres, les liens et les références d’images.
- Contrôler l’unicité des ancres dans chaque page et l’existence des cibles des liens entre documentations.
- Vérifier les références aux images, les collisions de chemins entre pages et la conservation du contenu des fichiers renommés.
- Vérifier des cas représentatifs de rendu sur Eclipse et le wiki. Distinguer un contrôle statique des sources, une vérification visuelle et un contrôle des pages réellement publiées.
- Consigner les lacunes ou incohérences de fond qui appellent un traitement distinct.

Pour un commit de documentation lié à un ticket, utiliser le préfixe `[IDENTIFIANT-TICKET] Documentation - `, suivi du module ou du sujet et d’un résumé du changement.
