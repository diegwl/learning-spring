package br.ets.feedback.controllers;

import br.ets.feedback.model.feedback.dtos.DadosAgendamentoFeedback;
import br.ets.feedback.model.feedback.dtos.DadosDetalhamentoFeedback;
import br.ets.feedback.model.feedback.service.AgendaDeFeedback;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feedback")
@SecurityRequirement(name = "bearer-key")
public class FeedbackController {
    @Autowired
    private AgendaDeFeedback agendaDeFeedback;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoFeedback> agendar(DadosAgendamentoFeedback dadosAgendamentoFeedback) {
        agendaDeFeedback.agendar(dadosAgendamentoFeedback);
        return ResponseEntity.ok().build();
    }
}
