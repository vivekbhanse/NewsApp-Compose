package com.loc.newsapp.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.magnifier
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.loc.newsapp.R
import com.loc.newsapp.domain.models.Article
import com.loc.newsapp.presentation.onboarding.Dimens.ArticleCardSize
import com.loc.newsapp.presentation.onboarding.Dimens.ExtraSmallPadding
import com.loc.newsapp.presentation.onboarding.Dimens.ExtraSmallPadding2
import com.loc.newsapp.presentation.onboarding.Dimens.SmallIconSize
import com.loc.newsapp.ui.theme.NewsAppTheme

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier, article: Article, onClick: () -> Unit,
) {
    val context = LocalContext.current
    Row(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .padding(ExtraSmallPadding)
            .fillMaxWidth() // Let the row take full width
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context).data(article.urlToImage).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(96.dp) // Ensure the image has enough space
        )

        Column(
            modifier = Modifier
                .padding(start = ExtraSmallPadding)
                .fillMaxWidth()
                .height(ArticleCardSize)
        ) {
            Text(
                text = article.title,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.text_title),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = ExtraSmallPadding)
    ) {
        Text(
            text = article.source.name,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.body),
        )
        Spacer(modifier = Modifier.width(ExtraSmallPadding2))
        Icon(
            painter = painterResource(id = R.drawable.ic_time),
            contentDescription = null,
            modifier = Modifier.size(SmallIconSize),
            tint = colorResource(id = R.color.body)
        )
        Spacer(modifier = Modifier.width(ExtraSmallPadding2))
        Text(
            text = article.publishedAt,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.body),
        )
    }
}
