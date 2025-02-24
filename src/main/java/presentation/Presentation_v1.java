package presentation;

import dao.DaoImpl;
import dao.IDao;
import metier.IMetier;
import metier.MetierImpl;

public class Presentation_v1 {
    public static void main(String[] args) {
        /*
        Injection des dépendences par instanciation statique
         */
        DaoImpl dao = new DaoImpl();
        MetierImpl metier = new MetierImpl(dao); // Injection des dépendances via le constructeur
        // metier.setDao(dao); // Injection via le setter
        System.out.println("Resultat = "+metier.calcul());
    }
}
