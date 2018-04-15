package org.evertones.persistence.modules.client

import com.querydsl.core.types.dsl.BooleanExpression
import org.evertones.model.modules.client.{Client, QClient, QClientDetails}

object ClientSpecification {

    def queryAll(client: Client): BooleanExpression = {
        val clientDetails: QClientDetails  = QClient.client1.client

        var query: BooleanExpression = clientDetails.id.isNotNull

        if (client.getClient.getName != null && !client.getClient.getName.isEmpty) {
            query = query.and(clientDetails.name.containsIgnoreCase(client.getClient.getName))
        }

        if (client.getClient.getBirthday != null) {
            query = query.and(clientDetails.birthday.eq(client.getClient.getBirthday))
        }

        query
    }

}
