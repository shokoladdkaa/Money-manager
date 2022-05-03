package me.golovata.currencies.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.golovata.currencies.CurrencyCode;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "currencies")
@AllArgsConstructor
@NoArgsConstructor
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "currencyNumber")
    private Integer currencyNumber;

    @Column(name = "currencyFullName")
    private String currencyFullName;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "currencyCode")
    private String currencyCode;
}
