/*
 * FXGL - JavaFX Game Library. The MIT License (MIT).
 * Copyright (c) AlmasB (almaslvl@gmail.com).
 * See LICENSE for details.
 */

package com.almasb.fxgl.ai.btree

import com.almasb.fxgl.ai.btree.AIControl
import com.almasb.fxgl.ai.btree.LeafTask
import com.almasb.fxgl.ai.btree.Task
import com.almasb.fxgl.dsl.FXGL
import com.almasb.fxgl.entity.Entity

/**
 * A single action that always succeeds.
 *
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
abstract class SingleAction
@JvmOverloads constructor(val name: String = "") : LeafTask<Entity>() {

    /**
     * Executed every frame when action is active.
     */
    abstract fun onUpdate(tpf: Double)
    
    override final fun execute(): Status {
        entity.getComponent(AIControl::class.java).setBubbleMessage(if (name.isNotEmpty()) name else javaClass.simpleName)
        // TODO:
        onUpdate(FXGL.tpf())

        return Status.SUCCEEDED
    }

    override fun copyTo(task: Task<Entity>): Task<Entity> {
        return task
    }
}