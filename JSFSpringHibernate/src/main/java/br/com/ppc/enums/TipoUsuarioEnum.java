package br.com.ppc.enums;

/**
 *
 * @author Christian Oscar Tejada Pacheco
 *
 */
public enum TipoUsuarioEnum {

	VISITANTE(1, "Visitante"),
	OBESERVADOR(2, "Observador"),
	MASTER(3, "Master"),
	VENDEDOR(4, "Vendedor"),
	APROVADOR(5, "Aprovador");

	private Integer id;

	private String label;

	/**
	 * Retorna o label do tipousuarioEnum pelo id.
	 * @param id
	 * @return TipoUsuarioEnum
	 */
	static public TipoUsuarioEnum getTipoUsuarioEnumById(final Integer id) {
		for (TipoUsuarioEnum tipoUsuarioEnum : TipoUsuarioEnum.values()) {
			if (tipoUsuarioEnum.getId().intValue() == id){
				return tipoUsuarioEnum;
			}
		}
		return null;
	}

	TipoUsuarioEnum(final Integer id, final String label) {
		this.id = id;
		this.label = label;
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

}
