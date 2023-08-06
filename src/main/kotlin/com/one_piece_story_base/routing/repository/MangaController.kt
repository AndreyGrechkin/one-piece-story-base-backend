package com.one_piece_story_base.routing.repository

import com.one_piece_story_base.domain.model.manga.MangaApiResponse

interface MangaController {
    suspend fun getMangaAll(): MangaApiResponse
    suspend fun getMangaByPlace(placeId: Int): MangaApiResponse
}