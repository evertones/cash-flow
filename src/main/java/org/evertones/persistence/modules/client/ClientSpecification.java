package org.evertones.persistence.modules.client;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.evertones.model.modules.client.Client;
import org.evertones.model.modules.client.QClient;
import org.evertones.model.modules.client.QClientDetails;

class ClientSpecification {

    static BooleanExpression queryAll(Client client) {
        QClientDetails clientDetails  = QClient.client1.client;

        BooleanExpression query = clientDetails.id.gt(0);

        if (client.getClient().getName() != null && !client.getClient().getName().isEmpty()) {
            query = query.and(clientDetails.name.containsIgnoreCase(client.getClient().getName()));
        }

        if (client.getClient().getBirthday() != null) {
            query = query.and(clientDetails.birthday.eq(client.getClient().getBirthday()));
        }

        return query;
    }

}
