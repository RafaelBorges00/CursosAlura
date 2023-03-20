package med.voll.api.domain.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.consulta.ValidacaoException;
import med.voll.api.repository.ConsultaRepository;

@Component
public class ValidarMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta {
    
    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        var medicoPossuiOutraConsultaMesmoHorario = repository.existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(dados.idMedico(), dados.data());
        if(medicoPossuiOutraConsultaMesmoHorario) {
            throw new ValidacaoException("Médico já possui outra consulta agendada neste mesmo horário !");
        }
    }
}
