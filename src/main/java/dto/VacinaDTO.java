package dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.orangetalents.desafio.entitys.Vacina;

import javax.validation.constraints.Email;

public class VacinaDTO {

	@NotNull
	private Long id;

	@Email
	@NotBlank
	@NotNull
	private String emailUser;

	@NotBlank
	@NotNull
	private String nomeVacina;

	@NotNull
	private LocalDate dataAplicacao;

	public VacinaDTO() {
	}

	public VacinaDTO(Vacina vacina) {
		this.id = vacina.getId();
		this.emailUser = vacina.getEmailUser();
		this.nomeVacina = vacina.getNomeVacina();
		this.dataAplicacao = vacina.getDataAplicacao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public String getNomeVacina() {
		return nomeVacina;
	}

	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}

	public LocalDate getDataAplicacao() {
		return dataAplicacao;
	}

	public void setDataAplicacao(LocalDate dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}

}
