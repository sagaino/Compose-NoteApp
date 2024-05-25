package com.example.jetnote.di

import android.content.Context
import androidx.room.Room
import com.example.jetnote.data.NoteDataBase
import com.example.jetnote.data.NoteDataBaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
  @Singleton
  @Provides
  fun provideNotesDao(noteDatabase: NoteDataBase): NoteDataBaseDao = noteDatabase.noteDao()

  @Singleton
  @Provides
  fun provideAppDatabase(@ApplicationContext context: Context): NoteDataBase = Room.databaseBuilder(
    context, NoteDataBase::class.java, name = "notes_db"
  ).fallbackToDestructiveMigration().build()
}