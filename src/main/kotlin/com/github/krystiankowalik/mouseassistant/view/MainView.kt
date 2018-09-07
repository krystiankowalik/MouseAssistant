package com.github.krystiankowalik.mouseassistant.view

import com.github.krystiankowalik.mouseassistant.MouseMover
import com.github.krystiankowalik.mouseassistant.app.Styles
import javafx.concurrent.Task
import javafx.geometry.Pos
import tornadofx.*

class MainView : View("Hamster") {

    lateinit var task: Task<Unit>

    override val root = hbox {
        alignment = Pos.CENTER

        label("The hamster is rolling...") {
            task = runAsyncWithProgress {
                println("Mouse started")
                MouseMover.run()
            }
        }

    }

   /* override fun onUndock() {
        println("Stopping Daemon...")
        task.cancel()
        super.onUndock()
    }*/
}