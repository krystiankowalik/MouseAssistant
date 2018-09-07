package com.github.krystiankowalik.mouseassistant

import com.github.krystiankowalik.mouseassistant.app.Styles
import com.github.krystiankowalik.mouseassistant.view.MainView
import javafx.application.Application
import javafx.scene.image.Image
import javafx.stage.Stage
import tornadofx.App

object MyApp {

    class TornadoApp : App(MainView::class) {
        override fun start(stage: Stage) {
            super.start(stage)
            stage.icons += Image("Hamster.png")
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        Application.launch(TornadoApp::class.java, *args)
    }
}