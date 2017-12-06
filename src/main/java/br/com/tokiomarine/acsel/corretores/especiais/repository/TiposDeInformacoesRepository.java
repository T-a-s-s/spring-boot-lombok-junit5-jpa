package br.com.tokiomarine.acsel.corretores.especiais.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.tokiomarine.acsel.corretores.especiais.entity.CorretorEspecialTipoInfo;

public abstract interface TiposDeInformacoesRepository 
	extends CrudRepository<CorretorEspecialTipoInfo, Integer>
{
  public abstract CorretorEspecialTipoInfo findContatoEspecialByCodTipoInfoAndGrupoTipoInfo(Integer paramInteger1, Integer paramInteger2);
  
  public abstract List<CorretorEspecialTipoInfo> findByGrupoTipoInfo(Integer paramInteger);
  
  public abstract List<CorretorEspecialTipoInfo> findAll();
}
