package com.github.krystiankowalik.mouseassistant.app

import com.github.krystiankowalik.mouseassistant.view.MainView
import javafx.scene.image.Image
import javafx.stage.Stage
import tornadofx.App

class MyApp : App(MainView::class, Styles::class) {
    override fun start(stage: Stage) {
        super.start(stage)
        stage.icons += Image ("Hamster.png")
    }
}