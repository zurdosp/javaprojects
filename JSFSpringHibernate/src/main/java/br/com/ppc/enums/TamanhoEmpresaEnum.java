package br.com.ppc.enums;

/**
 *
 * @author Christian Oscar Tejada Pacheco
 *
 */
public enum TamanhoEmpresaEnum {

	PEQUENA(1, "pequena"),
	MEDIA(2, "media"),
	GRANDE(3, "grande");

	private Integer id;
	private String label;

	private TamanhoEmpresaEnum(final Integer id, final String label) {
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
