package com.github.krystiankowalik.mouseassistant.view

import com.github.krystiankowalik.mouseassistant.MouseMover
import com.github.krystiankowalik.mouseassistant.app.Styles
import javafx.concurrent.Task
import tornadofx.*

class MainView : View("Mouse Assistant") {

    lateinit var task : Task<Unit>
    override val root = hbox {
        label("Mickey") {
            addClass(Styles.heading)
            task = runAsyncWithOverlay {
                MouseMover.run()
            }
        }
    }

    override fun onUndock() {
        println("Stopping Daemon...")
        task.cancel()
        super.onUndock()
    }
}