package br.com.tokiomarine.acsel.corretores.especiais.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.tokiomarine.acsel.corretores.especiais.entity.CorretorEspecialInfo;

public abstract interface InformacoesRepository 
	extends CrudRepository<CorretorEspecialInfo, Integer>
{
  @Query("select c from CorretorEspecialInfo c where c.codCorretor = ?1 and c.grupoTipoInfo = ?2 and c.dtInicioVigencia <= ?3 and (c.dtFimVigencia >= ?3 OR c.dtFimVigencia is null)")
  public abstract List<CorretorEspecialInfo> findCurrentContactsByCodCorretorAndGroupAndDate(Integer paramInteger1, Integer paramInteger2, Date paramDate);
  
  @Query("select c from CorretorEspecialInfo c where c.codCorretor = ?1 and c.codTipoInfo = ?2 and c.dtInicioVigencia <= ?3 and (c.dtFimVigencia >= ?3 OR c.dtFimVigencia is null)")
  public abstract List<CorretorEspecialInfo> findCurrentContactsByCodCorretorAndCodContatoEspecialAndDate(Integer paramInteger1, Integer paramInteger2, Date paramDate);
  
  @Query("select i from CorretorEspecialInfo i,  CorretorEspecialTipoInfo t where t.grupoTipoInfo = 1 and t.codTipoInfo = i.codTipoInfo")
  public abstract List<CorretorEspecialInfo> findContatosEspeciais();
  
  public abstract List<CorretorEspecialInfo> findByCodCorretor(Integer paramInteger);
}
