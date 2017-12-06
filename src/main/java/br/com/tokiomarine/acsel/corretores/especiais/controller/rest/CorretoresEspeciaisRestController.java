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

import br.com.tokiomarine.acsel.corretores.especiais.dto.CorretorEspecialDTO;
import br.com.tokiomarine.acsel.corretores.especiais.entity.CorretorEspecial;
import br.com.tokiomarine.acsel.corretores.especiais.service.CorretoresEspeciaisService;

@RestController
@RequestMapping({"/corretoresEspeciaisRest"})
public class CorretoresEspeciaisRestController
{
  @Autowired
  private CorretoresEspeciaisService corretoresEspeciaisService;
  
  @RequestMapping(value={""}, method={RequestMethod.GET})
  public String servicePing()
  {
    return "Serviço de corretores especiais";
  }
  
  @RequestMapping(value={"/corretores"}, method={RequestMethod.POST})
  @ResponseStatus(HttpStatus.CREATED)
  public CorretorEspecial createCorretorEspecial(@RequestBody CorretorEspecialDTO corretorEspecialDTO)
  {
    return this.corretoresEspeciaisService.createCorretorEspecial(corretorEspecialDTO);
  }
  
  @RequestMapping(value={"/corretores"}, method={RequestMethod.PUT})
  @ResponseStatus(HttpStatus.OK)
  public CorretorEspecial updateCorretorEspecial(@RequestBody CorretorEspecialDTO corretorEspecialDTO)
  {
    return this.corretoresEspeciaisService.updateCorretorEspecial(corretorEspecialDTO);
  }
  
  @RequestMapping(value={"/corretores"}, method={RequestMethod.GET})
  @ResponseStatus(HttpStatus.OK)
  public List<CorretorEspecial> listCorretoresEspeciais()
  {
    return this.corretoresEspeciaisService.listCorretoresEspeciais();
  }
  
  @RequestMapping(value={"/corretores/{codCorretor}"}, method={RequestMethod.GET})
  @ResponseStatus(HttpStatus.OK)
  public CorretorEspecial getCorretorEspecial(@PathVariable Integer codCorretor)
  {
    return this.corretoresEspeciaisService.getCorretorEspecial(codCorretor);
  }
  
  @RequestMapping(value={"/corretores/{codCorretor}"}, method={RequestMethod.DELETE})
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteCorretorEspecial(@PathVariable Integer codCorretor)
  {
    this.corretoresEspeciaisService.deleteCorretorEspecial(codCorretor);
  }
}
