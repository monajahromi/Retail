package io.bankmanagment.retail.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
@ConfigurationProperties("retail.account.current")
@Data
public class CurrentAccountProperties {

  private BigDecimal initialBalance = BigDecimal.valueOf(0);
  private BigDecimal initialBalanceFloor = BigDecimal.valueOf(0);
  private Boolean openWithChequeBook = false;
  private String accountNumber_Prefix = "CA" ;
  private String accountNumber_Separator= "-" ;



}
