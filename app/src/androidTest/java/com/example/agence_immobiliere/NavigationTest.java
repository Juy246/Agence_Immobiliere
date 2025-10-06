package com.example.agence_immobiliere;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.agence_immobiliere.ui.main.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class NavigationTest {

        @Test
        public void testNavigation_fromListToAddScreen() {
            // 1. Lancer l'activité principale de l'application (MainActivity)
            // ActivityScenario est la manière moderne et recommandée de lancer des activités en test.
            ActivityScenario.launch(MainActivity.class);

            // 2. Attendre que la liste des biens s'affiche et trouver le bouton "+"
            // On suppose que votre bouton "Ajouter"
            Espresso.onView(ViewMatchers.withId(R.id.btnAddBiens))
                    .check(ViewAssertions.matches(ViewMatchers.isDisplayed())); // Vérifie que le bouton est bien visible

            // 3. Simuler un clic sur le bouton "+"
            Espresso.onView(ViewMatchers.withId(R.id.btnAddBiens))
                    .perform(ViewActions.click());

            // 4. Vérifier que l'écran de création/modification est bien affiché.
            // Pour cela, on cherche un élément qui n'existe que sur cet écran.
            // Par exemple, un champ de texte (EditText) pour le titre du bien avec l'ID `edit_text_title`
            // ou un bouton "Sauvegarder" avec l'ID `button_save`.
            // Assurez-vous d'utiliser un ID qui existe dans votre layout `fragment_bien_create.xml`.
            Espresso.onView(ViewMatchers.withId(R.id.etVille))
                    .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

            // On peut aussi vérifier la présence d'un texte spécifique, comme un titre
            Espresso.onView(ViewMatchers.withText("Créer un bien"))
                    .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        }
    }

