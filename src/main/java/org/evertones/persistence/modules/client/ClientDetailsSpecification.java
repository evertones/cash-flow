package org.evertones.persistence.modules.client;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.evertones.model.modules.client.Client;
import org.evertones.model.modules.client.QClientDetails;

class ClientDetailsSpecification {

    static BooleanExpression queryByClient(Client client) {
        return QClientDetails.clientDetails.client.eq(client);
    }


}
