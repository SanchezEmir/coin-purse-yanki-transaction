package com.nttdata.yankitransaction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.yankitransaction.entity.MonederoTransaction;
import com.nttdata.yankitransaction.repository.IMonederoTransactionRepository;
import com.nttdata.yankitransaction.service.IMonederoTransactionService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class MonederoTransactionServiceImpl implements IMonederoTransactionService {

  @Autowired
  IMonederoTransactionRepository dao;

  @Override
  public Flux<MonederoTransaction> findAll() {
    log.info("Listar");
    return dao.findAll();
  }

  @Override
  public Mono<MonederoTransaction> findById(String id) {
    log.info("Busacar por id");
    return dao.findById(id);
  }

  @Override
  public Mono<MonederoTransaction> create(
      MonederoTransaction monederoTransaction) {
    log.info("Guardar transaccion");
    return dao.save(monederoTransaction);
  }

}
