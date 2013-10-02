/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliacao2.persistence.controller;

import avaliacao2.persistence.entity.Inscricao;
import avaliacao2.persistence.entity.InscricaoMinicurso;
import avaliacao2.persistence.entity.InscricaoMinicurso_;
import avaliacao2.persistence.entity.Inscricao_;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author João Paulo
 */
public class InscricaoJpaController extends JpaController {
    
    public List<Inscricao> findAll() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Inscricao> cq = cb.createQuery(Inscricao.class);
            cq.from(Inscricao.class);
            TypedQuery<Inscricao> q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public List<Inscricao> findByNumero(int codigo){
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Inscricao> cq = cb.createQuery(Inscricao.class);
            Root<Inscricao> rt = cq.from(Inscricao.class);
            cq.where(cb.equal(rt.get(Inscricao_.numero), codigo));
            TypedQuery<Inscricao> q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Inscricao> findByCpf(long cpf) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Inscricao> cq = cb.createQuery(Inscricao.class);
            Root<Inscricao> rt = cq.from(Inscricao.class);
            cq.where(cb.equal(rt.get(Inscricao_.cpf), cpf));
            TypedQuery<Inscricao> q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public List<InscricaoMinicurso> findByInscricao(Inscricao inscricao) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<InscricaoMinicurso> cq = cb.createQuery(InscricaoMinicurso.class);
            Root<InscricaoMinicurso> rt = cq.from(InscricaoMinicurso.class);
            cq.where(cb.equal(rt.get(InscricaoMinicurso_.inscricao), inscricao));
            TypedQuery<InscricaoMinicurso> q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void remove(Integer codigo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Inscricao inscricao = em.find(Inscricao.class, codigo);
            em.getTransaction().begin();
            em.remove(inscricao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void save(Inscricao inscricao) {

        EntityManager em = null;
        try {
            em = getEntityManager();   
            em.getTransaction().begin();
            em.persist(inscricao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
}
