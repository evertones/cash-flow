package org.evertones.dataset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap {

    private BootstrapCashFlow bootstrapCashFlow;
    private BootstrapSecurity bootstrapSecurity;
    private BootstrapClient   bootstrapClient;

    @Autowired
    public void setBootstrapCashFlow(BootstrapCashFlow bootstrapCashFlow) {
        this.bootstrapCashFlow = bootstrapCashFlow;
    }

    @Autowired
    public void setBootstrapSecurity(BootstrapSecurity bootstrapSecurity) {
        this.bootstrapSecurity = bootstrapSecurity;
    }

    @Autowired
    public void setBootstrapClient(BootstrapClient bootstrapClient) {
        this.bootstrapClient = bootstrapClient;
    }

    public void run() {
        bootstrapSecurity.create();
        bootstrapCashFlow.create();
        bootstrapClient.create();
    }

}
