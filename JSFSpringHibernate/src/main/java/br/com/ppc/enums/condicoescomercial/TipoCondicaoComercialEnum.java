package br.com.ppc.enums.condicoescomercial;

/**
 * Tipo de condicao comercial
 * @author Christian Oscar Tejada Pacheco
 *
 */
public enum TipoCondicaoComercialEnum {

	PORCENTAGEM(1, "Porcentagem", "%"),
	VALOR(2, "Valor", "R$");


	private Integer id;

	private String label;

	private String simbolo;

	/**
	 * Retorna o label do TipoCondicaoComercial pelo id.
	 * @param id
	 * @return TipoUsuarioEnum
	 */
	static public TipoCondicaoComercialEnum getTipoCondComerEnumById(final Integer id) {
		for (TipoCondicaoComercialEnum tipoUsuarioEnum : TipoCondicaoComercialEnum.values()) {
			if (tipoUsuarioEnum.getId().intValue() == id.intValue()){
				return tipoUsuarioEnum;
			}
		}
		return null;
	}

	TipoCondicaoComercialEnum(final Integer id, final String label, final String simbolo) {
		this.id = id;
		this.label = label;
		this.simbolo = simbolo;
	}


	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(final String label) {
		this.label = label;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(final String simbolo) {
		this.simbolo = simbolo;
	}

}
