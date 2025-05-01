package fr.red.japanlearn.utils;

import android.app.Activity;
import android.view.View;

import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SoftKeyboardInput {

    public SoftKeyboardInput(Activity activity) {
        View rootView = activity.findViewById(android.R.id.content);

        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            int imeHeight = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom;
            int navBarHeight = insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;

            // Ajuste la taille de la vue principale en fonction du clavier ouvert ou fermé
            v.setPadding(0, 0, 0, Math.max(imeHeight - navBarHeight, 0));
            return insets;
        });
    }
}
