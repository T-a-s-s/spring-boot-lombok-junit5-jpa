package br.com.tokiomarine.acsel.corretores.especiais.service;

import java.util.List;

import br.com.tokiomarine.acsel.corretores.especiais.dto.CorretorEspecialDTO;
import br.com.tokiomarine.acsel.corretores.especiais.entity.CorretorEspecial;

public abstract interface CorretoresEspeciaisService
{
  public abstract CorretorEspecial createCorretorEspecial(CorretorEspecialDTO paramCorretorEspecialDTO);
  
  public abstract CorretorEspecial updateCorretorEspecial(CorretorEspecialDTO paramCorretorEspecialDTO);
  
  public abstract CorretorEspecial getCorretorEspecial(Integer paramInteger);
  
  public abstract void deleteCorretorEspecial(Integer paramInteger);
  
  public abstract List<CorretorEspecial> listCorretoresEspeciais();
}
