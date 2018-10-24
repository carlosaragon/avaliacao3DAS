package Cadastros;

import Cadastros.Viagem;

public class DuracaoMinutos {
	private final Viagem _viagem;
	private int duracaoMinutos;
	
	public DuracaoMinutos(Viagem source) {
		this._viagem = source;
	}
	
	public int compute() {
		if (_viagem.getMinutosTermino() > _viagem.getMinutoInicio()) 
			duracaoMinutos = _viagem.getMinutosTermino() - _viagem.getMinutoInicio();
		else {
			duracaoMinutos = 60 - _viagem.getMinutoInicio() + _viagem.getMinutosTermino();
			chegouA1Hora();
		}
		return duracaoMinutos;
	}

	private void chegouA1Hora() {
		if (duracaoMinutos == 60) //caso especial
			duracaoMinutos = 0;
	}
}
