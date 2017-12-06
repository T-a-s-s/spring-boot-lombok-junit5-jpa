package br.com.tokiomarine.acsel.corretores.especiais.service;

import java.util.List;

import br.com.tokiomarine.acsel.corretores.especiais.dto.InfoDTO;
import br.com.tokiomarine.acsel.corretores.especiais.entity.CorretorEspecialInfo;

public abstract interface InformacoesEspeciaisService
{
  public abstract List<CorretorEspecialInfo> listInformacoesVigentes(Integer paramInteger1, Integer paramInteger2, String paramString);
  
  public abstract CorretorEspecialInfo createInformacaoCorretor(InfoDTO paramInfoDTO);
  
  public abstract List<CorretorEspecialInfo> listInformacoesCorretor(Integer paramInteger);
}
