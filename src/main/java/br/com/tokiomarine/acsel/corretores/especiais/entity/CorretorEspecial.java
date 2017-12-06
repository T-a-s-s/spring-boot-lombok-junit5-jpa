package br.com.tokiomarine.acsel.corretores.especiais.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="corretores_especiais")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CorretorEspecial implements Serializable {
  
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="cod_corretor")
	private Integer codCorretor;
	@Column(name="nome_corretor")
	@Setter
	private String nomeCorretor;
	@Column(name="cod_usu_ult_alter")
	@Setter
	private String codUsuarioUltimaAlteracao;
	@Column(name="dt_ultima_alter")
	@Temporal(TemporalType.DATE)
	@Setter
	private Date dtUltimaAlteracao;
  
}
