package org.evertones.persistence.modules.client;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.evertones.model.modules.client.ClientDetails;
import org.evertones.model.modules.client.QClient;
import org.evertones.model.modules.client.QClientDetails;
import org.evertones.model.types.ClientType;

import java.time.Month;

class ClientDetailsSpecification {

    static BooleanExpression queryByClient(ClientDetails clientDetails, ClientType clientType) {
        QClientDetails qClientDetails = QClientDetails.clientDetails;

        BooleanExpression query = qClientDetails.id.gt(0);

        if (clientDetails.getName() != null && !clientDetails.getName().isEmpty()) {
            query = query.and(qClientDetails.name.containsIgnoreCase(clientDetails.getName()));
        }

        if (clientDetails.getBirthday() != null) {
            query = query.and(qClientDetails.birthday.eq(clientDetails.getBirthday()));
        }

        if (clientDetails.getSex() != null) {
            query = query.and(qClientDetails.sex.eq(clientDetails.getSex()));
        }

        if (clientType != null) {
            switch (clientType) {
                case CLIENT:
                    query = query.and(qClientDetails.client.isNull());
                    break;
                case MODEL:
                    query = query.and(qClientDetails.client.isNotNull());
                    break;
            }
        }

        return query;
    }

    static BooleanExpression queryClientDetailsBirthday(Month month) {
        return QClientDetails.clientDetails.birthday.month().eq(month.getValue());
    }

}
