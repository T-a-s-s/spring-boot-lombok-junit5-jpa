package br.com.tokiomarine.acsel.corretores.especiais.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tokiomarine.acsel.corretores.especiais.dto.ContatoEspecialDTO;
import br.com.tokiomarine.acsel.corretores.especiais.entity.CorretorEspecialTipoInfo;
import br.com.tokiomarine.acsel.corretores.especiais.service.TiposDeInformacoesService;

@RestController
@RequestMapping({"/contatosEspeciaisRest"})
public class TiposDeInformacoesRestController
{
  @Autowired
  private TiposDeInformacoesService contatosEspeciaisService;
  
  @RequestMapping(value={""}, method={RequestMethod.GET})
  public String servicePing()
  {
    return "Serviço de tipos de informações especiais de corretores";
  }
  
  @RequestMapping(value={"/contatos"}, method={RequestMethod.POST})
  @ResponseStatus(HttpStatus.CREATED)
  public CorretorEspecialTipoInfo createContatoEspecial(@RequestBody ContatoEspecialDTO contatoEspecialDTO)
  {
    return this.contatosEspeciaisService.createContatoEspecial(contatoEspecialDTO);
  }
  
  @RequestMapping(value={"/contatos"}, method={RequestMethod.GET})
  @ResponseStatus(HttpStatus.OK)
  public List<CorretorEspecialTipoInfo> listContatoEspecial()
  {
    return this.contatosEspeciaisService.listContatosEspecias();
  }
  
  @RequestMapping(value={"/contatos"}, method={RequestMethod.PUT})
  @ResponseStatus(HttpStatus.OK)
  public CorretorEspecialTipoInfo updateContatoEspecial(@RequestBody ContatoEspecialDTO contatoEspecialDTO)
  {
    return this.contatosEspeciaisService.updateContatoEspecial(contatoEspecialDTO);
  }
  
  @RequestMapping(value={"/contatos/{codContato}"}, method={RequestMethod.GET})
  @ResponseStatus(HttpStatus.OK)
  public CorretorEspecialTipoInfo getContatoEspecial(@PathVariable Integer codContato)
  {
    return this.contatosEspeciaisService.getContatoEspecial(codContato);
  }
  
  @RequestMapping(value={"/contatos/{codContato}"}, method={RequestMethod.DELETE})
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteContatoEspecial(@PathVariable Integer codContato)
  {
    this.contatosEspeciaisService.deleteContatoEspecial(codContato);
  }
}
