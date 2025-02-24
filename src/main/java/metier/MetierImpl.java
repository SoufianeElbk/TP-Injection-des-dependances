package metier;

import dao.DaoImpl;
import dao.IDao;

public class MetierImpl implements IMetier {

    // Couplage faible
    private IDao dao;

    public MetierImpl() {
    }

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    /**
     * Pour injecter la variable dao un objet d'une classe qui implémente l'interface IDao
     */
    public void setDao(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double temp = dao.getData();
        double res = temp*23;
        return res;
    }
}
