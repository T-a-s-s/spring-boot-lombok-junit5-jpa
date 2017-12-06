package br.com.tokiomarine.acsel.corretores.especiais.dto;

import java.util.Date;

import lombok.Getter;

@Getter
public class InfoDTO
{
  private Integer codInfo;
  private Integer codCorretor;
  private Integer codTipoInfo;
  private String conteudoInfo;
  private String codProduto;
  private Date dtInicioVigencia;
  private String codUsuarioUltimaAlteracao;
  private Integer grupoTipoInfo;
  
}
