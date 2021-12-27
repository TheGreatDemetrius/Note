package ru.simple.note.components.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.simple.note.ui.theme.*

@Entity
data class Note(
    val title: String,
    val description: String,
    val date: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null//зачем? если можно использовать автоинкремент
//может потому что мы хотим контролировать идентификатор чтобы обновлять способом замены
)
{
    companion object{
        val noteColor = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}