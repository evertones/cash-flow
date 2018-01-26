package org.evertones.model.cashflow;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Period {

    private Integer id;
    private Integer month;
    private Integer year;
    private Double  balancePeriod;
    private Double  balanceFinal;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull
    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    @NotNull
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getBalancePeriod() {
        return balancePeriod;
    }

    public void setBalancePeriod(Double balancePeriod) {
        this.balancePeriod = balancePeriod;
    }

    public Double getBalanceFinal() {
        return balanceFinal;
    }

    public void setBalanceFinal(Double balanceFinal) {
        this.balanceFinal = balanceFinal;
    }

}
