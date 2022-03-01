package com.nttdata.yankitransaction.service;

import com.nttdata.yankitransaction.entity.MonederoTransaction;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMonederoTransactionService {

  Flux<MonederoTransaction> findAll();

  Mono<MonederoTransaction> findById(String id);

  Mono<MonederoTransaction> create(MonederoTransaction monederoTransaction);

}
