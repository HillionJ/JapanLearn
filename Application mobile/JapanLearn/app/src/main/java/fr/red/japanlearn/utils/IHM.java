package fr.red.japanlearn.utils;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import fr.red.japanlearn.activity.MainActivity;

@SuppressWarnings("unused")
public class IHM {

    private static IHM ihm;
    private final List<Object> ihmActives = new ArrayList<>();
    private AppCompatActivity activiteActive;

    public static IHM init(MainActivity mainActivity) {
        if (ihm == null)
            ihm = new IHM(mainActivity);
        return ihm;
    }

    // Récupérer une Activité, un Fragment ou autre élément actif ou en sommeil
    @Nullable
    public Object getIHMActive(Class<?> typeObjet) {
        for (Object ihmActive : ihmActives) {
            if (typeObjet.isInstance(ihmActive)) {
                return ihmActive;
            }
        }
        return null;
    }

    public static IHM getIHM() {
        return IHM.ihm;
    }

    public IHM(AppCompatActivity activiteActive) {
        IHM.ihm = this;
        this.activiteActive = activiteActive;
    }

    // Ajouter une activité lors de son lancement
    public void ajouterIHM(Object pageIHM) {
        if (pageIHM instanceof AppCompatActivity) {
            activiteActive = (AppCompatActivity) pageIHM;
        }
        for (Object ihmActive : ihmActives) {
            if (pageIHM.getClass() == ihmActive.getClass()) {
                ihmActives.remove(ihmActive);
                break;
            }
        }
        ihmActives.add(pageIHM);
    }

    // Récupérer l'activitée actuelle
    public AppCompatActivity getActiviteActive() {
        if (activiteActive.isDestroyed()) {
            // En cas d'activité inactive, chercher une potentiellement active
            for (Object ihmActive : ihmActives) {
                if (ihmActive instanceof AppCompatActivity && !((AppCompatActivity) ihmActive).isDestroyed()) {
                    activiteActive = (AppCompatActivity) ihmActive;
                    break;
                }
            }
        }
        return activiteActive;
    }

    // Récupérer une activité active
    public AppCompatActivity getActivite(Class<?> typeActivite) {
        return (AppCompatActivity) getIHMActive(typeActivite);
    }

    // Quitter une activité
    public void fermerActivite(Class<?> typeActivite) {
        Object activite = getIHMActive(typeActivite);
        if (activite instanceof AppCompatActivity) {
            ((AppCompatActivity)activite).finish();
        }
    }

    // Fermer les DialogFragment si existants
    public void fermerPopups() {
        for (Object ihmActive : ihmActives) {
            if (ihmActive instanceof DialogFragment) {
                try {
                    ((DialogFragment)ihmActive).dismiss();
                } catch (Exception ignored) {
                }
            }
        }
    }

    // Lancer une nouvelle activité (sans extra)
    public void demarrerActivite(Object lanceur, Context contexte, Class<?> typeActivite) {
        Intent intent = new Intent(contexte, typeActivite);
        if (lanceur instanceof Fragment) {
            ((Fragment) lanceur).startActivity(intent);
        } else {
            ((AppCompatActivity) lanceur).startActivity(intent);
        }
    }
}
