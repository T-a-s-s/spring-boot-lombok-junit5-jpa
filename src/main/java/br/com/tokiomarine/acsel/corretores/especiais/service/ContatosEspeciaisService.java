package br.com.tokiomarine.acsel.corretores.especiais.service;

import java.util.List;

import br.com.tokiomarine.acsel.corretores.especiais.dto.ContatoCorretorDTO;
import br.com.tokiomarine.acsel.corretores.especiais.entity.CorretorEspecialInfo;

public abstract interface ContatosEspeciaisService
{
  public abstract CorretorEspecialInfo createContatoEspecialCorretor(ContatoCorretorDTO paramContatoCorretorDTO);
  
  public abstract CorretorEspecialInfo updateContatoEspecialCorretor(ContatoCorretorDTO paramContatoCorretorDTO);
  
  public abstract CorretorEspecialInfo getContatoEspecialCorretor(Integer paramInteger);
  
  public abstract void deleteContatoEspecialCorretor(Integer paramInteger);
  
  public abstract List<CorretorEspecialInfo> getContatoVigente(Integer paramInteger1, Integer paramInteger2, String paramString);
  
  public abstract List<CorretorEspecialInfo> listContatoEspecialCorretor();
}
