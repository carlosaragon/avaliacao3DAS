package Cadastros;

import Cadastros.Viagem;

public class DuracaoHoras {
	private final Viagem _viagem;
	private int duracaoHoras;

	public DuracaoHoras(Viagem source) {
		this._viagem = source;
	}
	
	public int compute() {
		if (_viagem.getHoraTermino() == _viagem.getHoraInicio())
			duracaoHoras = 0;
		Ultrapassou2Horas();
		if (_viagem.getHoraTermino() < _viagem.getHoraInicio()) 
			duracaoHoras = -1; //para casos em que a hora de termino nao foi registrada
		return duracaoHoras;
	}

	private void Ultrapassou2Horas() {
		if (_viagem.getHoraTermino() > _viagem.getHoraInicio()) //varias possibilidades... 
			if (_viagem.getHoraTermino() == _viagem.getHoraInicio() + 1) {  
				chegouA1Hora();
			} else { //possivelmente ultrapassou duas horas
				entre1E2Horas();
					
			}
	}

	private void entre1E2Horas() {
		if (_viagem.getHoraTermino() - _viagem.getHoraInicio() > 2) //
			duracaoHoras = _viagem.getHoraTermino() - _viagem.getHoraInicio();
		else if (_viagem.getHoraTermino() - _viagem.getHoraInicio() == 2 &&   //certamente menos de duas horas  
				 _viagem.getMinutosTermino() < _viagem.getMinutoInicio())    //e mais de uma hora
			duracaoHoras = 1;
		else //duracao de duas horas, certamente
			duracaoHoras = 2;
	}

	private void chegouA1Hora() {
		if (_viagem.getMinutosTermino() < _viagem.getMinutoInicio())  //nao chegou a uma hora
			duracaoHoras= 0;
		else //durou pelo menos uma hora
			duracaoHoras = 1;
	}
}
