package org.evertones.persistence.client;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.evertones.model.client.Client;
import org.evertones.model.client.QClient;
import org.evertones.model.client.QClientDetails;

import java.time.Month;

class ClientSpecification {

    static BooleanExpression queryClientBirthday(Month month) {
        QClientDetails clientDetails  = QClient.client1.client;
        return clientDetails.birthday.month().eq(month.getValue());
    }

    static BooleanExpression queryAll(Client client) {
        QClientDetails clientDetails  = QClient.client1.client;
        QClientDetails motherDetails  = QClient.client1.mother;
        QClientDetails fatherDetails  = QClient.client1.father;

        BooleanExpression query = clientDetails.id.gt(0);

        if (client.getClient().getName() != null && !client.getClient().getName().isEmpty()) {
            query = query.and(clientDetails.name.containsIgnoreCase(client.getClient().getName()));
        }

        if (client.getClient().getBirthday() != null) {
            System.out.println("BIRTHDAY: " + client.getClient().getBirthday());
            query = query.and(clientDetails.birthday.eq(client.getClient().getBirthday()));
        }

        if (client.getMother().getName() != null && !client.getMother().getName().isEmpty()) {
            query = query.and(motherDetails.name.containsIgnoreCase(client.getMother().getName()));
        }

        if (client.getFather().getName() != null && !client.getFather().getName().isEmpty()) {
            query = query.and(fatherDetails.name.containsIgnoreCase(client.getFather().getName()));
        }

        return query;
    }

}
