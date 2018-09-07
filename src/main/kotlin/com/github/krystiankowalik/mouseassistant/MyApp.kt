package com.github.krystiankowalik.mouseassistant

import com.github.krystiankowalik.mouseassistant.app.Styles
import com.github.krystiankowalik.mouseassistant.view.MainView
import javafx.application.Application
import javafx.application.Platform
import javafx.scene.image.Image
import javafx.stage.Stage
import tornadofx.*

object MyApp {

    class TornadoApp : App(MainView::class) {
        override fun start(stage: Stage) {
            super.start(stage)
            stage.icons += Image("Hamster.png")

            trayicon(resources.stream("/Hamster.png")) {
                setOnMouseClicked(fxThread = true) {
                    FX.primaryStage.show()
                    FX.primaryStage.toFront()
                }

                menu("MyApp") {
                    item("Show...") {
                        setOnAction(fxThread = true) {
                            FX.primaryStage.show()
                            FX.primaryStage.toFront()
                        }
                    }
                    item("Exit") {
                        setOnAction(fxThread = true) {
                            Platform.exit()
                        }
                    }
                }


            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        Application.launch(TornadoApp::class.java, *args)
    }
}