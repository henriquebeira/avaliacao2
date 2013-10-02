/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliacao2.faces.mngbeans;

import avaliacao2.persistence.controller.InscricaoJpaController;
import avaliacao2.persistence.entity.Inscricao;
import avaliacao2.persistence.entity.InscricaoMinicurso;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import utfpr.faces.support.PageBean;

@ManagedBean
@RequestScoped
public class Inscricao_Bean extends PageBean {

    private Inscricao inscricao;

    public Inscricao_Bean() {
        inscricao = new Inscricao();
    }

    public Inscricao getInscricao() {
        return inscricao;
    }

    public void setInscricao(Inscricao inscricao) {
        this.inscricao = inscricao;
    }

    public String abrirNovaInscricaoAction() {
        this.inscricao = new Inscricao();
        return "cadastroInscricao";
    }

    public String salvarInscricaoAction() {
        InscricaoJpaController ctl = new InscricaoJpaController();
        ctl.save(inscricao);
        return "inicio";
    }

    public List<InscricaoMinicurso> getMinicursos() {
        List<InscricaoMinicurso> minicursos;
        InscricaoJpaController ctl = new InscricaoJpaController();
        minicursos = ctl.findByInscricao(inscricao);
        return minicursos;
    }
}
