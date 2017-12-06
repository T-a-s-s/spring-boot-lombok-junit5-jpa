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

import br.com.tokiomarine.acsel.corretores.especiais.dto.ContatoCorretorDTO;
import br.com.tokiomarine.acsel.corretores.especiais.entity.CorretorEspecialInfo;
import br.com.tokiomarine.acsel.corretores.especiais.service.ContatosEspeciaisService;

@RestController
@RequestMapping({"/contatosEspeciaisCorretoresRest"})
public class ContatosEspeciaisRestContoller
{
  @Autowired
  private ContatosEspeciaisService informacoesService;
  
  @RequestMapping({""})
  public String servicePing()
  {
    return "Serviço de contatos especiais de corretores";
  }
  
  @RequestMapping(value={"/contatosCorretores"}, method={RequestMethod.POST})
  @ResponseStatus(HttpStatus.CREATED)
  public CorretorEspecialInfo createContatoEspecialCorretor(@RequestBody ContatoCorretorDTO contatoEspecialCorretorDTO)
  {
    return this.informacoesService.createContatoEspecialCorretor(contatoEspecialCorretorDTO);
  }
  
  @RequestMapping(value={"/contatosCorretores"}, method={RequestMethod.PUT})
  @ResponseStatus(HttpStatus.OK)
  public CorretorEspecialInfo updateContatoEspecialCorretor(@RequestBody ContatoCorretorDTO contatoEspecialCorretorDTO)
  {
    return this.informacoesService.updateContatoEspecialCorretor(contatoEspecialCorretorDTO);
  }
  
  @RequestMapping(value={"/contatosCorretores"}, method={RequestMethod.GET})
  @ResponseStatus(HttpStatus.OK)
  public List<CorretorEspecialInfo> listContatosEspeciaisCorretores()
  {
    return this.informacoesService.listContatoEspecialCorretor();
  }
  
  @RequestMapping(value={"/contatosCorretores/{codContatoEspecialCorretor}"}, method={RequestMethod.GET})
  @ResponseStatus(HttpStatus.OK)
  public CorretorEspecialInfo getContatoEspecial(@PathVariable Integer codContatoEspecialCorretor)
  {
    return this.informacoesService.getContatoEspecialCorretor(codContatoEspecialCorretor);
  }
  
  @RequestMapping(value={"/contatosCorretores/{codContatoEspecialCorretor}"}, method={RequestMethod.DELETE})
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteContatoEspecial(@PathVariable Integer codContatoEspecialCorretor)
  {
    this.informacoesService.deleteContatoEspecialCorretor(codContatoEspecialCorretor);
  }
  
  @RequestMapping(value={"/corretores/{codCorretor}/contatos/{codContato}/data/{date}"}, method={RequestMethod.GET})
  @ResponseStatus(HttpStatus.OK)
  public List<CorretorEspecialInfo> getContatoVigente(@PathVariable Integer codCorretor, @PathVariable Integer codContato, @PathVariable String date)
  {
    return this.informacoesService.getContatoVigente(codCorretor, codContato, date);
  }
  
  @RequestMapping(value={"/contatosCorretores/grupos/{codGrupo}/"}, method={RequestMethod.POST})
  @ResponseStatus(HttpStatus.CREATED)
  public CorretorEspecialInfo getContatosEspeciaisPorGrupo(@RequestBody ContatoCorretorDTO contatoEspecialCorretorDTO)
  {
    return this.informacoesService.createContatoEspecialCorretor(contatoEspecialCorretorDTO);
  }
}
