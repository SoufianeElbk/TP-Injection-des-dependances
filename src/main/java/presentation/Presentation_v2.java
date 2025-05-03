package presentation;

import dao.DaoImpl;
import dao.IDao;
import metier.IMetier;
import metier.MetierImpl;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Presentation_v2 {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("config.txt"));
//            DaoImpl dao = new DaoImpl();
            String daoClassName = scanner.nextLine();
            Class cDao = Class.forName(daoClassName);
            IDao dao = (IDao) cDao.getConstructor().newInstance();
//            System.out.println(dao.getData());

//            MetierImpl metier = new MetierImpl(dao);
            String metierClassName = scanner.nextLine();
            Class cMetier = Class.forName(metierClassName);
            IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);

            // metier.setDao(dao);
            Method setDao = metier.getClass().getMethod("setDao", IDao.class);
            setDao.invoke(metier, dao);

            System.out.println("Res = " + metier.calcul());

        } catch (Exception e ) {
            System.out.println(e.getMessage());
        }
    }
}


