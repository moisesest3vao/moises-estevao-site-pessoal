package br.com.moisesestevao.api.mensagens.api;

import br.com.moisesestevao.api.mensagens.domain.dto.MensagemDto;
import br.com.moisesestevao.api.mensagens.domain.form.MensagemForm;
import br.com.moisesestevao.api.mensagens.domain.model.Mensagem;
import br.com.moisesestevao.api.mensagens.domain.model.enums.StatusLiberacao;
import br.com.moisesestevao.api.mensagens.application.repository.MensagemRepository;
import br.com.moisesestevao.api.mensagens.application.service.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {

    @Autowired
    MensagemRepository repository;
    @Autowired
    MensagemService service;
    StatusLiberacao status = StatusLiberacao.LIBERADO;

    @PostMapping
    public ResponseEntity<?> recebeMensagem(@RequestBody @Valid MensagemForm form,
                                            HttpServletRequest request){
        Mensagem mensagem = this.service.save(form, request);
        return mensagem != null ?
                ResponseEntity.ok(new MensagemDto(mensagem)) : ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<?> getAllMensagem(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "3") Integer size
    ){
        Page<Mensagem> all = this.repository.findAll(PageRequest.of(page, size));
        List<MensagemDto> allDto = new ArrayList<>();
        all.forEach(mensagem -> {
            allDto.add(new MensagemDto(mensagem));
        });
        return ResponseEntity.ok(allDto);
    }
}
