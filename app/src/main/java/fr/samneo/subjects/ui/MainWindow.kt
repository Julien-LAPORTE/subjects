package fr.samneo.subjects.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import fr.samneo.subjects.R
import fr.samneo.subjects.data.DataSource
import fr.samneo.subjects.model.Topic
import fr.samneo.subjects.ui.theme.SubjectsTheme

@Composable
fun MainWindow(modifier: Modifier = Modifier) {
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier) {
        items(DataSource.topics) { topic ->
            TopicCard(
                topic = topic,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Row(verticalAlignment = Alignment.Bottom) {
            Image(
                painter = painterResource(id = topic.picture),
                contentDescription = null,
                modifier = Modifier.weight(1f),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.weight(1.7f)) {
                Text(
                    text = stringResource(id = topic.category),
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(
                        start = dimensionResource(id = R.dimen.padding_medium),
                        bottom = dimensionResource(id = R.dimen.padding_small)
                    )
                )
                Row (verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = dimensionResource(id = R.dimen.padding_medium))
                            .size(dimensionResource(id = R.dimen.topic_icon_size))

                    )
                    Text(
                        text = topic.numberOfcourses.toString(),
                        modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_small)),
                        style = MaterialTheme.typography.displayMedium
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun MainWindowPreview() {
    SubjectsTheme {
        MainWindow()
    }
}

@Preview
@Composable
fun TopicCardPreview() {
    SubjectsTheme {
        TopicCard(DataSource.topics[12])
    }
}