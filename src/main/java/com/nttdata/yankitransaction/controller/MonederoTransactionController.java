package com.nttdata.yankitransaction.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.yankitransaction.entity.MonederoTransaction;
import com.nttdata.yankitransaction.service.IMonederoTransactionService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@EnableBinding(Source.class)
@RestController
@RequestMapping("/publish")
public class MonederoTransactionController {
  @Autowired
  private MessageChannel output;

  @Autowired
  private IMonederoTransactionService service;

  @GetMapping("/list")
  public Flux<MonederoTransaction> findAll() {
    return service.findAll();
  }

  @PostMapping("/create")
  public Mono<ResponseEntity<MonederoTransaction>> create(
      @RequestBody MonederoTransaction monederoTransaction) {
    monederoTransaction.setCreateAt(LocalDateTime.now());
    output.send(MessageBuilder.withPayload(monederoTransaction).build());
    return service.create(monederoTransaction)
        .map(ct -> new ResponseEntity<>(ct, HttpStatus.CREATED))
        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
  }
}
