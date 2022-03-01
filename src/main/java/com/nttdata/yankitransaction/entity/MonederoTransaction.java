package com.nttdata.yankitransaction.entity;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.nttdata.yankitransaction.entity.enums.EStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "moneyTransaction")
public class MonederoTransaction {

  @Id
  private String id;

  @NotNull
  private String originNumber;

  @NotNull
  private String destinationNumber;

  @NotNull
  private Double amount;

  private EStatus status;

  private int condition;

  private LocalDateTime createAt;

}
