package br.com.tokiomarine.acsel.corretores.especiais.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tokiomarine.acsel.corretores.especiais.dto.ContatoEspecialDTO;
import br.com.tokiomarine.acsel.corretores.especiais.dto.TipoInfoDTO;
import br.com.tokiomarine.acsel.corretores.especiais.entity.CorretorEspecialTipoInfo;
import br.com.tokiomarine.acsel.corretores.especiais.exception.ForbiddenException;
import br.com.tokiomarine.acsel.corretores.especiais.repository.TiposDeInformacoesRepository;
import br.com.tokiomarine.acsel.corretores.especiais.service.TiposDeInformacoesService;

@Service
public class TiposDeInformacoesServiceImpl
  implements TiposDeInformacoesService
{
  @Autowired
  private TiposDeInformacoesRepository tiposDeInformacoesRepository;
  
  public CorretorEspecialTipoInfo createContatoEspecial(ContatoEspecialDTO contatoEspecialDTO)
  {
    CorretorEspecialTipoInfo tipoInfo = CorretorEspecialTipoInfo.builder().codTipoInfo(contatoEspecialDTO.getCodContatoEspecial()).nomeTipoInfo(contatoEspecialDTO.getNomeContatoEspecial()).descTipoInfo(contatoEspecialDTO.getDescContatoEspecial()).codUsuarioUltimaAlteracao(contatoEspecialDTO.getCodUsuarioUltimaAlteracao()).grupoTipoInfo(Integer.valueOf(1)).dtUltimaAlteracao(new Date()).build();
    return this.tiposDeInformacoesRepository.save(tipoInfo);
  }
  
  public CorretorEspecialTipoInfo updateContatoEspecial(ContatoEspecialDTO contatoEspecialDTO)
  {
    CorretorEspecialTipoInfo tipoInfo = this.tiposDeInformacoesRepository.findContatoEspecialByCodTipoInfoAndGrupoTipoInfo(contatoEspecialDTO.getCodContatoEspecial(), Integer.valueOf(1));
    if (tipoInfo == null) {
      throw new ForbiddenException("Contato Especial with codContato = " + contatoEspecialDTO.getCodContatoEspecial() + " NOT FOUND");
    }
    tipoInfo.setNomeTipoInfo(contatoEspecialDTO.getNomeContatoEspecial());
    tipoInfo.setDescTipoInfo(contatoEspecialDTO.getDescContatoEspecial());
    tipoInfo.setCodUsuarioUltimaAlteracao(contatoEspecialDTO.getCodUsuarioUltimaAlteracao());
    return this.tiposDeInformacoesRepository.save(tipoInfo);
  }
  
  public CorretorEspecialTipoInfo getContatoEspecial(Integer codTipoInfo)
  {
    return this.tiposDeInformacoesRepository.findContatoEspecialByCodTipoInfoAndGrupoTipoInfo(codTipoInfo, Integer.valueOf(1));
  }
  
  public void deleteContatoEspecial(Integer codTipoInfo)
  {
    this.tiposDeInformacoesRepository.delete(codTipoInfo);
  }
  
  public List<CorretorEspecialTipoInfo> listContatosEspecias()
  {
    return this.tiposDeInformacoesRepository.findByGrupoTipoInfo(Integer.valueOf(1));
  }
  
  public CorretorEspecialTipoInfo createTipoDeInformacaoEspecial(TipoInfoDTO tipoInfoDTO)
  {
    CorretorEspecialTipoInfo tipoInfo = CorretorEspecialTipoInfo.builder().codTipoInfo(tipoInfoDTO.getCodTipoInfo()).nomeTipoInfo(tipoInfoDTO.getNomeTipoInfo()).descTipoInfo(tipoInfoDTO.getDescTipoInfo()).codUsuarioUltimaAlteracao(tipoInfoDTO.getCodUsuarioUltimaAlteracao()).grupoTipoInfo(tipoInfoDTO.getGrupoTipoInfo()).dtUltimaAlteracao(new Date()).build();
    return this.tiposDeInformacoesRepository.save(tipoInfo);
  }
  
  public List<CorretorEspecialTipoInfo> listTiposDeInformacoes()
  {
    return this.tiposDeInformacoesRepository.findAll();
  }
  
  public List<CorretorEspecialTipoInfo> listTiposDeInformacoesPorGrupo(Integer grupoTipoInfo)
  {
    return this.tiposDeInformacoesRepository.findByGrupoTipoInfo(grupoTipoInfo);
  }
}
