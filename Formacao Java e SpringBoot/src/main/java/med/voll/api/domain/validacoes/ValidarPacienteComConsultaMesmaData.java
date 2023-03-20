package med.voll.api.domain.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.consulta.ValidacaoException;
import med.voll.api.repository.ConsultaRepository;

@Component
public class ValidarPacienteComConsultaMesmaData implements ValidadorAgendamentoDeConsulta {
    
    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHoraro = dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHoraro);
        if(pacientePossuiOutraConsultaNoDia) {
            throw new ValidacaoException("Paciente possui outra consulta agendada no mesmo dia !");
        }
    }
}
