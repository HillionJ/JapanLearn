class SoftKeyboardInput
!!!139522.java!!!	handleSoftKeyboard(inout activity : Activity) : void
        View rootView = activity.findViewById(android.R.id.content);

        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            int imeHeight = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom;
            int navBarHeight = insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;

            // Ajuste la taille de la vue principale en fonction du clavier ouvert ou fermé
            v.setPadding(0, 0, 0, Math.max(imeHeight - navBarHeight, 0));
            return insets;
        });
