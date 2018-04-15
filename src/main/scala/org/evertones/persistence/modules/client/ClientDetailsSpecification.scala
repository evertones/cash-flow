package org.evertones.persistence.modules.client

import java.time.Month

import com.querydsl.core.types.dsl.BooleanExpression
import org.evertones.model.modules.client.{ClientDetails, QClientDetails}
import org.evertones.model.types.ClientType

object ClientDetailsSpecification {

    def queryByClient(clientDetails: ClientDetails, clientType: ClientType): BooleanExpression = {
        val qClientDetails: QClientDetails = QClientDetails.clientDetails

        var query: BooleanExpression = qClientDetails.id.isNotNull

        if (clientDetails.getName != null && !clientDetails.getName.isEmpty) {
            query = query.and(qClientDetails.name.containsIgnoreCase(clientDetails.getName))
        }

        if (clientDetails.getBirthday != null) {
            query = query.and(qClientDetails.birthday.eq(clientDetails.getBirthday))
        }

        if (clientDetails.getSex != null) {
            query = query.and(qClientDetails.sex.eq(clientDetails.getSex))
        }

        if (clientType != null) {
            clientType match {
                case ClientType.CLIENT => query = query.and(qClientDetails.client.isNull)
                case ClientType.MODEL  => query = query.and(qClientDetails.client.isNotNull)
            }
        }

        query
    }

    def queryClientDetailsBirthday(month: Month): BooleanExpression = {
        QClientDetails.clientDetails.birthday.month().eq(month.getValue)
    }

}
