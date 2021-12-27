package ru.simple.note.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.simple.note.components.data.source.NoteDatabase
import ru.simple.note.components.data.storage.NoteRepositoryImpl
import ru.simple.note.components.domain.repository.NoteRepository
import ru.simple.note.components.domain.usecase.ComponentsNote
import ru.simple.note.components.domain.usecase.DeleteNote
import ru.simple.note.components.domain.usecase.GetNotes
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase =
        Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository =
        NoteRepositoryImpl(db.noteDao)

    @Provides
    @Singleton
    fun provideNote(repository: NoteRepository): ComponentsNote =
        ComponentsNote(GetNotes(repository), DeleteNote(repository))
}