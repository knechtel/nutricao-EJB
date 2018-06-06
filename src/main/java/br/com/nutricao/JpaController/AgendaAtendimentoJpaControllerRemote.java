package br.com.nutricao.JpaController;

import java.util.List;

import br.com.nutricao.bean.AgendaAtendimento;

public interface AgendaAtendimentoJpaControllerRemote {

	void create(AgendaAtendimento agendaAtendimento);

	List<AgendaAtendimento> findAll();

}