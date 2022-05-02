package me.golovata.currencies.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "baseCurrency")
    private Integer baseCurrency;

    @Column(name = "targetCurrency")
    private Integer targetCurrency;

    @Column(name = "rateBuy")
    private Double rateBuy;

    @Column(name = "rateSell")
    private Double rateSell;

    @Column(name = "rateCross")
    private Double rateCross;
}
