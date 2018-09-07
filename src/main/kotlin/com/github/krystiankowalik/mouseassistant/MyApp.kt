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

        val mainView: MainView by inject()

        override fun start(stage: Stage) {
            super.start(stage)
            FX.primaryStage.hide()

            stage.icons += Image("mouse_big.png")

            trayicon(resources.stream("/mouse_small.png")) {
                setOnMouseClicked(fxThread = true) {
                    FX.primaryStage.show()
                    FX.primaryStage.toFront()
                }

                menu("MyApp") {
                    item("Show status") {
                        setOnAction(fxThread = true) {
                            FX.primaryStage.show()
                            FX.primaryStage.toFront()
                        }
                    }
                    item("Start") {
                        setOnAction(fxThread = true) {
                            startDaemon()
                        }
                    }
                    item("Stop") {
                        setOnAction(fxThread = true) {
                            stopDaemon()
                        }
                    }
                    item("Exit") {
                        setOnAction(fxThread = true) {
                            stopDaemon()
                            Platform.exit()
                        }
                    }
                }


            }
        }

        private fun startDaemon() {
            mainView.task.run()
        }

        private fun stopDaemon() {
            mainView.task.cancel()
        }

        override fun stop() {
            stopDaemon()
            super.stop()
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        Application.launch(TornadoApp::class.java, *args)
    }
}