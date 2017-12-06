package br.com.tokiomarine.acsel.corretores.especiais.service;

import java.util.List;

import br.com.tokiomarine.acsel.corretores.especiais.dto.ContatoEspecialDTO;
import br.com.tokiomarine.acsel.corretores.especiais.dto.TipoInfoDTO;
import br.com.tokiomarine.acsel.corretores.especiais.entity.CorretorEspecialTipoInfo;

public abstract interface TiposDeInformacoesService
{
  public abstract CorretorEspecialTipoInfo createContatoEspecial(ContatoEspecialDTO paramContatoEspecialDTO);
  
  public abstract CorretorEspecialTipoInfo updateContatoEspecial(ContatoEspecialDTO paramContatoEspecialDTO);
  
  public abstract CorretorEspecialTipoInfo getContatoEspecial(Integer paramInteger);
  
  public abstract void deleteContatoEspecial(Integer paramInteger);
  
  public abstract List<CorretorEspecialTipoInfo> listContatosEspecias();
  
  public abstract CorretorEspecialTipoInfo createTipoDeInformacaoEspecial(TipoInfoDTO paramTipoInfoDTO);
  
  public abstract List<CorretorEspecialTipoInfo> listTiposDeInformacoes();
  
  public abstract List<CorretorEspecialTipoInfo> listTiposDeInformacoesPorGrupo(Integer paramInteger);
}
