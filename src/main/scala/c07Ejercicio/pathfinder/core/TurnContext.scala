package c07Ejercicio.pathfinder.core

import c07Ejercicio.pathfinder.entity.Entity

class TurnContext(entities: List[Entity]):
  private val entitiesWithInitiative: List[(Entity, Int)] =
    entities.map(e => (e, e.getInitiative()))
  private val sortedEntities =
    entitiesWithInitiative.sortBy((e, i) => i).map((e, i) => e)

  private var currentTurnIndex: Int = 0
  def getOrder() = sortedEntities
  def currentEntity(): Entity = sortedEntities(currentTurnIndex)
  def nextTurn(): Unit =
    currentTurnIndex = (currentTurnIndex + 1) % sortedEntities.length
