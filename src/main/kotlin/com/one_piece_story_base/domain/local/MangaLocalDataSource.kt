package com.one_piece_story_base.domain.local

import com.one_piece_story_base.data.model.MangaDTO

interface MangaLocalDataSource {
    fun fetchManga(): List<MangaDTO>
    fun fetchMangaByPlaceId(placeId: Int): List<MangaDTO>
    fun fetchMangaById(id: Int): MangaDTO?
    fun insert(mangaDTO: MangaDTO)
}