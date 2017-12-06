package br.com.tokiomarine.acsel.corretores.especiais.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tokiomarine.acsel.corretores.especiais.dto.InfoDTO;
import br.com.tokiomarine.acsel.corretores.especiais.entity.CorretorEspecialInfo;
import br.com.tokiomarine.acsel.corretores.especiais.exception.ForbiddenException;
import br.com.tokiomarine.acsel.corretores.especiais.repository.InformacoesRepository;
import br.com.tokiomarine.acsel.corretores.especiais.service.InformacoesEspeciaisService;

@Service
public class InformacoesEspeciaisServiceImpl
  implements InformacoesEspeciaisService
{
  @Autowired
  private InformacoesRepository informacoesRepository;
  private SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
  
  public List<CorretorEspecialInfo> listInformacoesVigentes(Integer codCorretor, Integer grupoTipoInfo, String dataReferencia)
  {
    try
    {
      return this.informacoesRepository.findCurrentContactsByCodCorretorAndGroupAndDate(codCorretor, grupoTipoInfo, this.sdf.parse(dataReferencia));
    }
    catch (ParseException e)
    {
      throw new ForbiddenException("O formato da data enviada est� incorreto, favor utilizar o formato: ddMMyyyy");
    }
  }
  
  public CorretorEspecialInfo createInformacaoCorretor(InfoDTO infoDTO)
  {
    CorretorEspecialInfo informacaoEspecial = CorretorEspecialInfo.builder().codTipoInfo(infoDTO.getCodTipoInfo()).codCorretor(infoDTO.getCodCorretor()).codProduto(infoDTO.getCodProduto()).conteudoInfo(infoDTO.getConteudoInfo()).grupoTipoInfo(infoDTO.getGrupoTipoInfo()).codUsuarioUltimaAlteracao(infoDTO.getCodUsuarioUltimaAlteracao()).dtInicioVigencia(infoDTO.getDtInicioVigencia()).dtUltimaAlteracao(new Date()).build();
    return this.informacoesRepository.save(informacaoEspecial);
  }
  
  public List<CorretorEspecialInfo> listInformacoesCorretor(Integer codCorretor)
  {
    return this.informacoesRepository.findByCodCorretor(codCorretor);
  }
}
