package br.com.tokiomarine.acsel.corretores.especiais.dto;

import java.util.Date;

import lombok.Getter;

@Getter
public class ContatoCorretorDTO
{
  private Integer codContEspCorr;
  private Integer codCorretor;
  private Integer codContatoEspecial;
  private String codProduto;
  private String conteudoContatoEspecial;
  private Date dtInicioVigencia;
  private String codUsuarioUltimaAlteracao;
  
}
