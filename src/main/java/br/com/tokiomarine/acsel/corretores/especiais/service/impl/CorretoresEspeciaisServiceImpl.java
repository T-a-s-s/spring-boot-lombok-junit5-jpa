package br.com.tokiomarine.acsel.corretores.especiais.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tokiomarine.acsel.corretores.especiais.dto.CorretorEspecialDTO;
import br.com.tokiomarine.acsel.corretores.especiais.entity.CorretorEspecial;
import br.com.tokiomarine.acsel.corretores.especiais.exception.ForbiddenException;
import br.com.tokiomarine.acsel.corretores.especiais.repository.CorretoresEspeciaisRepository;
import br.com.tokiomarine.acsel.corretores.especiais.service.CorretoresEspeciaisService;

@Service
public class CorretoresEspeciaisServiceImpl
  implements CorretoresEspeciaisService
{
  @Autowired
  CorretoresEspeciaisRepository corretoresEspeciaisRepository;
  
  public CorretorEspecial createCorretorEspecial(CorretorEspecialDTO corretorEspecialDTO)
  {
    CorretorEspecial corretor = CorretorEspecial.builder().codCorretor(corretorEspecialDTO.getCodCorretor()).nomeCorretor(corretorEspecialDTO.getNomeCorretor()).codUsuarioUltimaAlteracao(corretorEspecialDTO.getCodUsuarioUltimaAlteracao()).dtUltimaAlteracao(new Date()).build();
    return this.corretoresEspeciaisRepository.save(corretor);
  }
  
  public CorretorEspecial updateCorretorEspecial(CorretorEspecialDTO corretorEspecialDTO)
  {
    CorretorEspecial corretorEspecial = (CorretorEspecial)this.corretoresEspeciaisRepository.findOne(corretorEspecialDTO.getCodCorretor());
    if (corretorEspecial == null) {
      throw new ForbiddenException("Corretor Especial with codCorretor = " + corretorEspecialDTO.getCodCorretor() + " NOT FOUND");
    }
    corretorEspecial.setNomeCorretor(corretorEspecialDTO.getNomeCorretor());
    corretorEspecial.setCodUsuarioUltimaAlteracao(corretorEspecial.getCodUsuarioUltimaAlteracao());
    corretorEspecial.setDtUltimaAlteracao(new Date());
    return this.corretoresEspeciaisRepository.save(corretorEspecial);
  }
  
  public CorretorEspecial getCorretorEspecial(Integer codCorretor)
  {
    return this.corretoresEspeciaisRepository.findOne(codCorretor);
  }
  
  public void deleteCorretorEspecial(Integer codCorretor)
  {
    this.corretoresEspeciaisRepository.delete(codCorretor);
  }
  
  public List<CorretorEspecial> listCorretoresEspeciais()
  {
    return this.corretoresEspeciaisRepository.findAll();
  }
}
