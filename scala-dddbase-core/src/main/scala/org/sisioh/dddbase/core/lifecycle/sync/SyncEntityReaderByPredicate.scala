/*
 * Copyright 2010 TRICREO, Inc. (http://tricreo.jp/)
 * Copyright 2011 Sisioh Project and others. (http://www.sisioh.org/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.sisioh.dddbase.core.lifecycle.sync

import org.sisioh.dddbase.core.lifecycle.{EntitiesChunk, EntityReaderByPredicate}
import org.sisioh.dddbase.core.model.{Entity, Identity}
import scala.util.Try

/**
 * [[org.sisioh.dddbase.core.lifecycle.EntityReaderByPredicate]]のTry版。
 *
 * @tparam ID 識別子の型
 * @tparam E エンティティの型
 */
trait SyncEntityReaderByPredicate[ID <: Identity[_], E <: Entity[ID]]
  extends EntityReaderByPredicate[ID, E, Try] {
  this: SyncEntityReader[ID, E] =>

  /**
   * @return Success: [[org.sisioh.dddbase.core.lifecycle.EntitiesChunk]]
   *         Faliure: [[org.sisioh.dddbase.core.lifecycle.RepositoryException]]
   */
  def filterByPredicate
  (predicate: E => Boolean,
   index: Option[Int] = None,
   maxEntities: Option[Int] = None): Try[EntitiesChunk[ID, E]]

}
