package org.sisioh.dddbase.core.lifecycle.forwarding.async

import org.sisioh.dddbase.core.lifecycle.EntitiesChunk
import org.sisioh.dddbase.core.model.{Entity, Identity}
import scala.concurrent.{Future, ExecutionContext}
import org.sisioh.dddbase.core.lifecycle.async.{AsyncEntityReaderByPredicate, AsyncEntityReader}

trait ForwardingAsyncEntityReaderByPredicate[ID <: Identity[_], E <: Entity[ID]]
  extends AsyncEntityReaderByPredicate[ID, E] {
  this: AsyncEntityReader[ID, E] =>

  protected val delegateAsyncEntityReaderByPredicate: AsyncEntityReaderByPredicate[ID, E]

  def filterByPredicate(predicate: (E) => Boolean, index: Option[Int], maxEntities: Option[Int]): Future[EntitiesChunk[ID, E]] =
    delegateAsyncEntityReaderByPredicate.filterByPredicate(predicate, index, maxEntities)

}
