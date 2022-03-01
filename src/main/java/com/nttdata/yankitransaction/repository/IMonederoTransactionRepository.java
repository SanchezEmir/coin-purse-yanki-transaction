package com.nttdata.yankitransaction.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.yankitransaction.entity.MonederoTransaction;

public interface IMonederoTransactionRepository extends ReactiveMongoRepository<MonederoTransaction, String> {
  
  

}
