package org.evertones.persistence.client;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.evertones.model.client.QClient;
import org.evertones.model.client.QClientDetails;

import java.time.Month;

class ClientSpecification {

    static BooleanExpression queryClientBirthday(Month month) {
        QClientDetails client  = QClient.client1.client;
        return client.birthday.month().eq(month.getValue());
    }

}
