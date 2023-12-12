package com.one_piece_story_base.domain.controller

import com.one_piece_story_base.data.model.toResponse
import com.one_piece_story_base.domain.local.MangaLocalDataSource
import com.one_piece_story_base.domain.model.manga.MangaApiResponse
import com.one_piece_story_base.routing.repository.MangaController


class MangaControllerImpl(
    private val dao: MangaLocalDataSource,
) : MangaController {

    override suspend fun getMangaAll(): MangaApiResponse {
        val daoManga = dao.fetchManga()
        val respond = daoManga.map { it.toResponse() }
        return MangaApiResponse(manges = respond)
    }

    override suspend fun getMangaByPlace(placeId: Int): MangaApiResponse {
        val daoManga = dao.fetchMangaByPlaceId(placeId).map { it.toResponse() }
        return MangaApiResponse(manges = daoManga)
    }
}