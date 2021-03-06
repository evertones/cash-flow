package org.evertones.model.modules.cashflow;

import javax.persistence.*;

@Entity
public class Flow {

    private Integer     id;
    private String      inputOutput;
    private String      expectedExecuted;
    private Item        item;
    private String      itemName;
    private Double      value;
    private Period      period;
    private ClientOld clientOld;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInputOutput() {
        return inputOutput;
    }

    public void setInputOutput(String inputOutput) {
        this.inputOutput = inputOutput;
    }

    public String getExpectedExecuted() {
        return expectedExecuted;
    }

    public void setExpectedExecuted(String expectedExecuted) {
        this.expectedExecuted = expectedExecuted;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public ClientOld getClientOld() {
        return clientOld;
    }

    public void setClientOld(ClientOld clientOld) {
        this.clientOld = clientOld;
    }
}
