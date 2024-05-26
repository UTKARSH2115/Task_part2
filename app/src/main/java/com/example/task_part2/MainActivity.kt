package com.example.task_part2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.text.font.FontStyle
import com.example.task_part2.ui.theme.Task_part2Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Task_part2Theme {
                Quiz()
            }


        }
    }
}


@Composable
fun QuestionFormat(question: QuestionBank, AnsSelected: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = question.ques,)
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { AnsSelected(question.option[0]) },
            modifier = Modifier
                .fillMaxWidth(0.75f)
                .padding(vertical = 4.dp)
        ) {
            Text(text = question.option[0])
        }
        Button(
            onClick = { AnsSelected(question.option[1]) },
            modifier = Modifier
                .fillMaxWidth(0.75f)
                .padding(vertical = 4.dp)
        ) {
            Text(text = question.option[1])
        }
        Button(
            onClick = { AnsSelected(question.option[2]) },
            modifier = Modifier
                .fillMaxWidth(0.75f)
                .padding(vertical = 4.dp)
        ) {
            Text(text = question.option[2])
        }
        Button(
            onClick = { AnsSelected(question.option[3]) },
            modifier = Modifier
                .fillMaxWidth(0.75f)
                .padding(vertical = 4.dp)
        ) {
            Text(text = question.option[3])
        }


    }
}

@Composable
fun Quiz() {
    var QuestionNumber by remember { mutableStateOf(0) }
    var selectedAnswer by remember { mutableStateOf<String?>(null) }
    val question = questions[QuestionNumber]

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        QuestionFormat(question = question) { answer ->
            selectedAnswer = answer
            if (answer == question.ans) {
                if (QuestionNumber <= questions.size) {
                    QuestionNumber++
                }
            }

        }

    }
}



data class QuestionBank(
    var ques : String,
    val option: List<String>,
    val ans: String
)

val questions = listOf(
    QuestionBank(
        ques = "When is Indian Independence day celebrated?",
        option = listOf("A. 15th August", "B. 26th January", "C. 2nd October", "D. 15th February"),
        ans= "A. 15th August"
    ),
    QuestionBank(
        ques = "Which planet is known as the Red Planet?",
        option = listOf("A. Earth", "B. Mars", "C. Jupiter", "D. Venus"),
        ans = "B. Mars"
    ),
    QuestionBank(
        ques = "What is known as the powerhouse of the cell?",
        option = listOf("A. Ribosomes", "B. Mitochondria", "C. Cytoplasm", "D. Nucleus"),
        ans = "B. Mitochondria"
    ),
    QuestionBank(
        ques = "what is the capital of Canada?",
        option = listOf("A. Delhi", "B. Paris", "C. Buenos Aires", "D. Ottawa"),
        ans = "D. Ottawa"
    )

)

