package br.com.pratofeito.customer.domain.api

import br.com.pratofeito.customer.domain.api.AuditableAbstractEvent
import br.com.pratofeito.customer.domain.api.model.AuditEntry
import br.com.pratofeito.customer.domain.api.model.Money
import br.com.pratofeito.customer.domain.api.model.PersonName
import br.com.pratofeito.customer.domain.api.model.CustomerId
import br.com.pratofeito.customer.domain.api.model.CustomerOrderId

abstract class CustomerEvent(open val aggregateIdentifier: CustomerId, override val auditEntry: AuditEntry)
    : AuditableAbstractEvent(auditEntry)

abstract class CustomerOrderEvent(open val aggregateIdentifier: CustomerOrderId, open val auditEntry: AuditEntry)
    : AuditableAbstractEvent(auditEntry)

data class CustomerCreateEvent(
    val name: PersonName, 
    val orderLimit: Money, 
    override val aggregateIdentifier: CustomerId, 
    override val auditEntry: AuditEntry)
    : CustomerEvent(aggregateIdentifier, auditEntry
)

data class CustomerOrderCreateEvent(
    val orderTotal: Money, 
    override val aggregateIdentifier: CustomerId,
    override val CustomerOrderId: CustomerOrderId,
    override val auditEntry: AuditEntry)
    : CustomerEvent(aggregateIdentifier, auditEntry
)

data class CustomerOrderDeliveredEvent(
    override val aggregateIdentifier: CustomerOrderId, 
    override val auditEntry: AuditEntry)
    : CustomerOrderEvent(aggregateIdentifier, auditEntry
)

data class CustomerOrderRejectedEvent(
    override val aggregateIdentifier: CustomerOrderId, 
    override val auditEntry: AuditEntry)
    : CustomerOrderEvent(aggregateIdentifier, auditEntry
)