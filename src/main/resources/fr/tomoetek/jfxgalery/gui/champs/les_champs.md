## Les Champs texte

Quand on a besoin de faire des formulaires, on a besoin de champs textuels pour entrer des données. Les `TextField` sont là pour ça.
Il en existe plusieurs:
- Le `TextField`

```xml
<TextField fx:id="nomField" />
```

Il a d'autres attributs accessibles par SceneBuilder ou directement dans le FXML. Comme par exemple le prompt ( équivalent du placeholder en html)

```xml
<TextField fx:id="prenomField" promptText="prénom" />
```

Ajoutons un envoie vers un label et une vérification avec un bouton et une méthode `sendHandle()` (vue précédemment).

```java
public void sendHandle() {

        Boolean flagChampNom,flagChampPrenom,flagChampTel;

        if (Verification.verifTexte(nomField.getText()) ) {
            nomField.setStyle("");
            flagChampNom = true;
        } else {
          // si le test ne passe pas on change la couleur de bordure
            nomField.setStyle("-fx-border-color: darkred");
            flagChampNom = false;
        }if (Verification.verifTexte(prenomField.getText()) ) {
            prenomField.setStyle("");
            flagChampPrenom = true;
        } else {
            nomField.setStyle("-fx-border-color: darkred");
            flagChampPrenom = false;
        }if (Verification.verifNum(telField.getText()) ) {
            telField.setStyle("");
            flagChampTel = true;
        } else {
          // si le test ne passe pas on change la couleur de bordure
            telField.setStyle("-fx-border-color: darkred");
            flagChampTel = false;
        }

        if (flagChampNom && flagChampPrenom && flagChampTel) sendField();
    }

    private void sendField() {
        nomLab.setText(nomField.getText());
        prenomLab.setText(prenomField.getText());
        telLab.setText(telField.getText());
        passLab.setText(passField.getText());
    }
```

Comme vous pouvez le remarquer, il n'y a pas de méthode `verifTexte()` ou `verifNum()`. J'ai préféré organiser le projet en rangeant cette méthode dans un package séparé `fr.tomoetek.jfxgalery.Verification` (soit org/gerblog/tools/Verification.java)

```java
public class Verification {
    final static Pattern texte = Pattern.compile("\\p{IsAlphabetic}*$");
    final static Pattern num = Pattern.compile("\\p{Digit}*$");

    public static boolean verifTexte(String champ){
        return texte.matcher(champ).matches();
    }

    public static boolean verifNum(String champ){
        return num.matcher(champ).matches();
    }
}
```