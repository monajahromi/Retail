package io.bankmanagment.retail.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties("retail.account.current")
@Data
public class CurrentAccountProperties {

  private BigDecimal initialBalance = BigDecimal.valueOf(0);
  private Boolean openWithChequeBook = false;



}
