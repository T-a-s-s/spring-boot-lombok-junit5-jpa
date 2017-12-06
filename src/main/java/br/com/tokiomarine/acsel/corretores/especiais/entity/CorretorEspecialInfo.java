package br.com.tokiomarine.acsel.corretores.especiais.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="corretores_espec_info")
@SequenceGenerator(name="cod_corr_esp_info_seq", sequenceName="cod_corr_esp_info_seq")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CorretorEspecialInfo implements Serializable {
	
	  private static final long serialVersionUID = 1L;
	  @Id
	  @GeneratedValue(generator="cod_corr_esp_info_seq")
	  @Column(name="cod_info")
	  private Integer codInfo;
	  @Column(name="cod_corretor")
	  @Setter
	  private Integer codCorretor;
	  @Column(name="cod_tipo_info")
	  @Setter
	  private Integer codTipoInfo;
	  @Column(name="conteudo_info")
	  @Setter
	  private String conteudoInfo;
	  @Column(name="grupo_tipo_info")
	  @Setter
	  private Integer grupoTipoInfo;
	  @Column(name="cod_prod")
	  @Setter
	  private String codProduto;
	  @Column(name="dt_inicio_vigencia")
	  @Temporal(TemporalType.DATE)
	  @Setter
	  private Date dtInicioVigencia;
	  @Column(name="dt_fim_vigencia")
	  @Temporal(TemporalType.DATE)
	  private Date dtFimVigencia;
	  @Column(name="cod_usu_ult_alter")
	  @Setter
	  private String codUsuarioUltimaAlteracao;
	  @Column(name="dt_ultima_alter")
	  @Temporal(TemporalType.DATE)
	  @Setter
	  private Date dtUltimaAlteracao;
}