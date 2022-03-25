package com.jetpack.circularposition

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.MotionLayout
import com.jetpack.circularposition.ui.theme.CircularPositionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CircularPositionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "Circular Position",
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            )
                        }
                    ) {
                        CircularPosition()
                    }
                }
            }
        }
    }
}

@Composable
fun CircularPosition() {
    var animateToEnd by remember { mutableStateOf(false) }
    val progress by animateFloatAsState(
        targetValue = if (animateToEnd) 1f else 0f,
        animationSpec = tween(4000)
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                animateToEnd = !animateToEnd
            },
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text(text = "Run")
        }

        MotionLayout(
            ConstraintSet(
                content = """
                    {
                      h1: { circular: ['parent', 0, 100] },
                      h2: { circular: ['parent', 40, 100], rotationZ: 40 },
                      h3: { circular: ['parent', 80, 100], rotationZ: 80 },
                      h4: { circular: ['parent', 120, 100], rotationZ: 120 },
                      h5: { circular: ['parent', 160, 100], rotationZ: 160 },
                      h6: { circular: ['parent', 200, 100], rotationZ: 200 },
                      h7: { circular: ['parent', 240, 100], rotationZ: 240 },
                      h8: { circular: ['parent', 280, 100], rotationZ: 280 },
                      h9: { circular: ['parent', 320, 100], rotationZ: 320 }
                    }
                """
            ),
            ConstraintSet(
                """
                    {
                      h1: { circular: ['parent', 0, 100], rotationZ: 360 },
                      h2: { circular: ['parent', 40, 100], rotationZ: 400 },
                      h3: { circular: ['parent', 80, 100], rotationZ: 440 },
                      h4: { circular: ['parent', 120, 100], rotationZ: 480 },
                      h5: { circular: ['parent', 160, 100], rotationZ: 520 },
                      h6: { circular: ['parent', 200, 100], rotationZ: 560 },
                      h7: { circular: ['parent', 240, 100], rotationZ: 600 },
                      h8: { circular: ['parent', 280, 100], rotationZ: 640 },
                      h9: { circular: ['parent', 320, 100], rotationZ: 680 },
                    }
                """.trimIndent()
            ),
            progress = progress,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Box(
                modifier = Modifier
                    .layoutId("h1")
                    .width(100.dp)
                    .height(60.dp)
                    .background(Color.Red)
            )
            Box(
                modifier = Modifier
                    .layoutId("h2")
                    .width(100.dp)
                    .height(60.dp)
                    .background(Color.Green)
            )
            Box(
                modifier = Modifier
                    .layoutId("h3")
                    .width(100.dp)
                    .height(60.dp)
                    .background(Color.Blue)
            )
            Box(
                modifier = Modifier
                    .layoutId("h4")
                    .width(100.dp)
                    .height(60.dp)
                    .background(Color.Gray)
            )
            Box(
                modifier = Modifier
                    .layoutId("h5")
                    .width(100.dp)
                    .height(60.dp)
                    .background(Color.Yellow)
            )
            Box(
                modifier = Modifier
                    .layoutId("h6")
                    .width(100.dp)
                    .height(60.dp)
                    .background(Color.Cyan)
            )
            Box(
                modifier = Modifier
                    .layoutId("h7")
                    .width(100.dp)
                    .height(60.dp)
                    .background(Color.Magenta)
            )
            Box(
                modifier = Modifier
                    .layoutId("h8")
                    .width(100.dp)
                    .height(60.dp)
                    .background(Color.Red)
            )
            Box(
                modifier = Modifier
                    .layoutId("h9")
                    .width(100.dp)
                    .height(60.dp)
                    .background(Color.DarkGray)
            )
        }
    }
}


















