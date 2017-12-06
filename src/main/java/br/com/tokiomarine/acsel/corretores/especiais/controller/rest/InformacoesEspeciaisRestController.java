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

import br.com.tokiomarine.acsel.corretores.especiais.dto.InfoDTO;
import br.com.tokiomarine.acsel.corretores.especiais.dto.TipoInfoDTO;
import br.com.tokiomarine.acsel.corretores.especiais.entity.CorretorEspecialInfo;
import br.com.tokiomarine.acsel.corretores.especiais.entity.CorretorEspecialTipoInfo;
import br.com.tokiomarine.acsel.corretores.especiais.service.InformacoesEspeciaisService;
import br.com.tokiomarine.acsel.corretores.especiais.service.TiposDeInformacoesService;

@RestController
@RequestMapping({"/informacoesEspeciaisRest"})
public class InformacoesEspeciaisRestController
{
  @Autowired
  private TiposDeInformacoesService tiposDeInformacoesService;
  @Autowired
  private InformacoesEspeciaisService informacoesService;
  
  @RequestMapping({""})
  public String servicePing()
  {
    return "Serviço de informações especiais de corretores";
  }
  
  @RequestMapping(value={"/informacoes"}, method={RequestMethod.POST})
  @ResponseStatus(HttpStatus.CREATED)
  public CorretorEspecialTipoInfo createTipoDeInformacoes(@RequestBody TipoInfoDTO tipoInfoDTO)
  {
    return this.tiposDeInformacoesService.createTipoDeInformacaoEspecial(tipoInfoDTO);
  }
  
  @RequestMapping(value={"/informacoes"}, method={RequestMethod.GET})
  @ResponseStatus(HttpStatus.OK)
  public List<CorretorEspecialTipoInfo> listTiposDeInformacoes()
  {
    return this.tiposDeInformacoesService.listTiposDeInformacoes();
  }
  
  @RequestMapping(value={"/grupos/{grupoTipoInfo}"}, method={RequestMethod.GET})
  @ResponseStatus(HttpStatus.OK)
  public List<CorretorEspecialTipoInfo> listTiposDeInformacoesPorGrupo(@PathVariable Integer grupoTipoInfo)
  {
    return this.tiposDeInformacoesService.listTiposDeInformacoesPorGrupo(grupoTipoInfo);
  }
  
  @RequestMapping(value={"/informacoesCorretores"}, method={RequestMethod.POST})
  @ResponseStatus(HttpStatus.CREATED)
  public CorretorEspecialInfo createInformacaoCorretor(@RequestBody InfoDTO infoDTO)
  {
    return this.informacoesService.createInformacaoCorretor(infoDTO);
  }
  
  @RequestMapping(value={"/informacoesCorretores/corretores/{codCorretor}"}, method={RequestMethod.GET})
  @ResponseStatus(HttpStatus.OK)
  public List<CorretorEspecialInfo> listInformacoesCorretor(@PathVariable Integer codCorretor)
  {
    return this.informacoesService.listInformacoesCorretor(codCorretor);
  }
  
  @RequestMapping(value={"/corretores/{codCorretor}/grupos/{grupoTipoInfo}/dataReferencia/{dataReferencia}"}, method={RequestMethod.GET})
  @ResponseStatus(HttpStatus.OK)
  public List<CorretorEspecialInfo> listTiposDeInformacoesPorGrupo(@PathVariable Integer codCorretor, @PathVariable Integer grupoTipoInfo, @PathVariable String dataReferencia)
  {
    return this.informacoesService.listInformacoesVigentes(codCorretor, grupoTipoInfo, dataReferencia);
  }
}
