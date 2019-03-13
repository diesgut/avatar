package com.avatar.diesgut.dao.hibernate;

import com.avatar.diesgut.dao.UsuarioDAO;
import com.avatar.diesgut.model.Usuario;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAOH implements UsuarioDAO {

    @PersistenceContext
    private EntityManager entityManger;

    @Override
    public void saveUsuario(Usuario usuario) {
        entityManger.persist(usuario);
    }

    @Override
    public Usuario findUsuarioByUsernameAndPassword(String userName, String password) {
        StringBuilder sQuery = new StringBuilder();
        sQuery.append(" Select u from Usuario u ");
        sQuery.append(" where 1=1 ");
        sQuery.append(" AND u.userName=:PRM_USERNAME ");
        sQuery.append(" AND u.password=:PRM_PASSWORD ");

        Query query = entityManger.createQuery(sQuery.toString());
        query.setParameter("PRM_USERNAME", userName);
        query.setParameter("PRM_PASSWORD", password);
        query.setMaxResults(BigDecimal.ONE.intValue());
        Usuario result = null;
        try {
            result = (Usuario) query.getSingleResult();
        } catch (NoResultException e) {
            result = null;
        }
        return result;
    }

}
