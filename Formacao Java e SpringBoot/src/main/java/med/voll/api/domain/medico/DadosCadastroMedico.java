package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;

/* Record é um recurso que permite representar uma classe imutável, contendo apenas atributos, construtor e métodos de leitura, 
de uma maneira muito simples e enxuta. Seu objetivo é apenas representar dados que serão recebidos ou devolvidos pela API, sem nenhum tipo de comportamento*/
/* Bean Validation serve para não ficar verificando campos obrigatórios com IF  */
public record DadosCadastroMedico(
                @NotBlank(message = "{nome.obrigatorio}") String nome,

                @NotBlank(message = "{email.obrigatorio}") @Email(message = "{email.invalido}") String email,

                @NotBlank(message = "{telefone.obrigatorio}") String telefone,

                @NotBlank(message = "{crm.obrigatorio}") @Pattern(regexp = "\\d{4,6}", message = "{crm.invalido}") String crm,

                @NotNull(message = "{especialidade.obrigatoria}") Especialidade especialidade,

                @NotNull(message = "{endereco.obrigatorio}") @Valid DadosEndereco endereco) {
}
