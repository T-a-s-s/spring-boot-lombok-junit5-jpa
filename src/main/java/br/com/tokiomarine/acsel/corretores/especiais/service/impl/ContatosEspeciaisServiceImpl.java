package br.com.tokiomarine.acsel.corretores.especiais.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tokiomarine.acsel.corretores.especiais.dto.ContatoCorretorDTO;
import br.com.tokiomarine.acsel.corretores.especiais.entity.CorretorEspecialInfo;
import br.com.tokiomarine.acsel.corretores.especiais.exception.ForbiddenException;
import br.com.tokiomarine.acsel.corretores.especiais.repository.InformacoesRepository;
import br.com.tokiomarine.acsel.corretores.especiais.service.ContatosEspeciaisService;

@Service
public class ContatosEspeciaisServiceImpl
  implements ContatosEspeciaisService
{
  @Autowired
  private InformacoesRepository contatosEspeciaisCorretoresRepository;
  private SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
  
  public CorretorEspecialInfo createContatoEspecialCorretor(ContatoCorretorDTO contatoCorretorDTO)
  {
    CorretorEspecialInfo contatoEspecialCorretor = CorretorEspecialInfo.builder().codTipoInfo(contatoCorretorDTO.getCodContatoEspecial()).codCorretor(contatoCorretorDTO.getCodCorretor()).codProduto(contatoCorretorDTO.getCodProduto()).conteudoInfo(contatoCorretorDTO.getConteudoContatoEspecial()).codUsuarioUltimaAlteracao(contatoCorretorDTO.getCodUsuarioUltimaAlteracao()).dtInicioVigencia(contatoCorretorDTO.getDtInicioVigencia()).dtUltimaAlteracao(new Date()).build();
    return this.contatosEspeciaisCorretoresRepository.save(contatoEspecialCorretor);
  }
  
  public CorretorEspecialInfo updateContatoEspecialCorretor(ContatoCorretorDTO contatoCorretorDTO)
  {
    CorretorEspecialInfo contatoEspecialCorretor = this.contatosEspeciaisCorretoresRepository.findOne(contatoCorretorDTO.getCodContEspCorr());
    if (contatoEspecialCorretor == null) {
      throw new ForbiddenException("Contato Especial Corretor with codContEspCorr = " + contatoCorretorDTO.getCodContEspCorr() + " NOT FOUND");
    }
    contatoEspecialCorretor.setCodTipoInfo(contatoCorretorDTO.getCodContatoEspecial());
    contatoEspecialCorretor.setCodCorretor(contatoCorretorDTO.getCodCorretor());
    contatoEspecialCorretor.setCodProduto(contatoCorretorDTO.getCodProduto());
    contatoEspecialCorretor.setConteudoInfo(contatoCorretorDTO.getConteudoContatoEspecial());
    contatoEspecialCorretor.setCodUsuarioUltimaAlteracao(contatoCorretorDTO.getCodUsuarioUltimaAlteracao());
    contatoEspecialCorretor.setDtInicioVigencia(contatoCorretorDTO.getDtInicioVigencia());
    contatoEspecialCorretor.setDtUltimaAlteracao(new Date());
    return (CorretorEspecialInfo)this.contatosEspeciaisCorretoresRepository.save(contatoEspecialCorretor);
  }
  
  public CorretorEspecialInfo getContatoEspecialCorretor(Integer codInfo)
  {
    return this.contatosEspeciaisCorretoresRepository.findOne(codInfo);
  }
  
  public void deleteContatoEspecialCorretor(Integer codInfo)
  {
    this.contatosEspeciaisCorretoresRepository.delete(codInfo);
  }
  
  public List<CorretorEspecialInfo> getContatoVigente(Integer codCorretor, Integer codContato, String date)
  {
    try
    {
      return this.contatosEspeciaisCorretoresRepository.findCurrentContactsByCodCorretorAndCodContatoEspecialAndDate(codCorretor, codContato, this.sdf.parse(date));
    }
    catch (ParseException e)
    {
      throw new ForbiddenException("Data recebida com formato incorreto, favor enviar a data no formato ddMMyyyy");
    }
  }
  
  public List<CorretorEspecialInfo> listContatoEspecialCorretor()
  {
    return this.contatosEspeciaisCorretoresRepository.findContatosEspeciais();
  }
}
