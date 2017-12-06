package br.com.tokiomarine.acsel.corretores.especiais.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.tokiomarine.acsel.corretores.especiais.entity.CorretorEspecial;

public abstract interface CorretoresEspeciaisRepository 
	extends CrudRepository<CorretorEspecial, Integer>
{
  public abstract List<CorretorEspecial> findAll();
}
