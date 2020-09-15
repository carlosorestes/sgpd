package com.sgpd.br.enums;

public enum TipoVeiculo {
	CICLOMOTOR(2),
	MOTONETA(3),
	MOTOCICLETA(4),
	TRICICLO(5),
	AUTOMOVEL(6),
	MICROONIBUS(7),
	ONIBUS(8),
	REBOQUE(10),
	SEMIRREBOQUE(11),
	CAMIONETA(13),
	CAMINHAO(14),
	CAMINHAOTRATOR(17),
	TRRODAS(18),
	TRESTEIRAS(19),
	TRMISTO(20),
	QUADRICICLO(21),
	CHASSIPLATAFORMA(22),
	CAMINHONETE(23),
	UTILITARIO(25),
	MOTORCASA(26);
	
	public final Integer value;
	
	TipoVeiculo(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}
	
	public static TipoVeiculo tipoVeiculoOfByValue(Integer value) {
		if(value != null) {
			for(TipoVeiculo tipoVeiculo: TipoVeiculo.values()) {
				if (tipoVeiculo.getValue() == value) {
					return tipoVeiculo;
				}
			}
		}
		
		throw new IllegalArgumentException("Tipo de veiculo invalido");
	}
	
	
}
