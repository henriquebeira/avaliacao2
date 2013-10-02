package avaliacao2.faces.mngbeans;

import avaliacao2.persistence.entity.Inscricao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;
import utfpr.faces.support.PageBean;
import avaliacao2.persistence.controller.InscricaoJpaController;

@ManagedBean
@RequestScoped
public class ListaInscricoesBean extends PageBean {
        
   private ListDataModel<Inscricao> listaInscricoes;

    public ListaInscricoesBean() {
       InscricaoJpaController ctl = new InscricaoJpaController();
       listaInscricoes = new ListDataModel<>(ctl.findAll());
    }      
    
   public ListDataModel<Inscricao> getInscricoesDataModel() {
       return listaInscricoes;
   }
   
   public String editarInscricaoAction(){
       return "cadastroInscricoes";
   }
   
   public String excluirInscricaoAction(){
       Inscricao inscricao = listaInscricoes.getRowData();
       InscricaoJpaController ctl = new InscricaoJpaController();
       ctl.remove(inscricao.getNumero());
       listaInscricoes = new ListDataModel<>(ctl.findAll());
       return "lista_inscricao";
   }
}