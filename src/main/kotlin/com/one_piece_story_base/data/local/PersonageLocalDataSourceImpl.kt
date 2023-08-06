package com.one_piece_story_base.data.local

import com.one_piece_story_base.BaseUrl
import com.one_piece_story_base.data.model.*
import com.one_piece_story_base.data.model.PersonageDescriptionTable.fruit_id
import com.one_piece_story_base.data.model.PersonageDescriptionTable.image
import com.one_piece_story_base.domain.local.PersonageLocalDataSource
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction


class PersonageLocalDataSourceImpl : PersonageLocalDataSource {
    override fun fetchPersonage(): List<PersonageDTO> {
        return try {
            transaction {
                PersonageTable
                    .selectAll()
                    .toList()
                    .map { personage ->
                        PersonageDTO(
                            id = personage[PersonageTable.id],
                            mangaId = personage[PersonageTable.mangaId],
                            placeId = personage[PersonageTable.placeId],
                            name = personage[PersonageTable.name],
                            nameJp = personage[PersonageTable.nameJp],
                            transcriptionJp = personage[PersonageTable.transcriptionJp],
                            avatar = personage[PersonageTable.avatar],
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun fetchPersonageForPlace(): List<PersonageForPlaceDTO> {
        return try {
            transaction {
                PersonageTable
                    .selectAll()
                    .toList()
                    .map { personage ->
                        PersonageForPlaceDTO(
                            id = personage[PersonageTable.id],
                            mangaId = personage[PersonageTable.mangaId],
                            placeId = personage[PersonageTable.placeId],
                            name = personage[PersonageTable.name],
                            nameJp = personage[PersonageTable.nameJp],
                            transcriptionJp = personage[PersonageTable.transcriptionJp],
                            avatar = personage[PersonageTable.avatar],
                            image = if (personage[image] != null) BaseUrl + "static/personage/${personage[image]}" else null,
                            fruit = personage[fruit_id].toString()
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun fetchPersonageById(id: Int): PersonageDTO? {
        return try {
            transaction {
                val personage = PersonageTable
                    .select(PersonageTable.id.eq(id)).single()
                PersonageDTO(
                    id = personage[PersonageTable.id],
                    mangaId = personage[PersonageTable.mangaId],
                    placeId = personage[PersonageTable.placeId],
                    name = personage[PersonageTable.name],
                    nameJp = personage[PersonageTable.nameJp],
                    transcriptionJp = personage[PersonageTable.transcriptionJp],
                    avatar = personage[PersonageTable.avatar]
                )

            }
        } catch (e: Exception) {
            null
        }
    }

    override fun fetchPersonageByPlaceId(placeId: Int): List<PersonageForPlaceDTO> {
        return try {
            transaction {
                PersonageTable.innerJoin(PersonageDescriptionTable)
                    .slice(
                        PersonageTable.id,
                        PersonageTable.mangaId,
                        PersonageTable.placeId,
                        PersonageTable.name,
                        PersonageTable.nameJp,
                        PersonageTable.transcriptionJp,
                        PersonageTable.avatar,
                        image.groupConcat(", ", false),
                        fruit_id.castTo<String>(VarCharColumnType()).groupConcat(",", false)
                    )
                    .select(
                        where = PersonageTable.placeId.eq(placeId)
                                and PersonageTable.id.eq(PersonageDescriptionTable.personageId)
                    )
                    .groupBy(PersonageTable.id)
                    .toList()
                    .map { personage ->
                        PersonageForPlaceDTO(
                            id = personage[PersonageTable.id],
                            mangaId = personage[PersonageTable.mangaId],
                            placeId = personage[PersonageTable.placeId],
                            name = personage[PersonageTable.name],
                            nameJp = personage[PersonageTable.nameJp],
                            transcriptionJp = personage[PersonageTable.transcriptionJp],
                            avatar = personage[PersonageTable.avatar],
                            image = if (personage[image.groupConcat(", ", false)] != null)
                                BaseUrl + "static/personage/${personage[image.groupConcat(", ", false)]}" else null,
                            fruit = personage[fruit_id.castTo<String>(VarCharColumnType()).groupConcat(",", false)]
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun fetchPersonageListByPlaceId(placeId: Int): List<PersonageDTO> {
        return try {
            transaction {
                PersonageTable
                    .select(where = PersonageTable.placeId.eq(placeId))
                    .toList()
                    .map { personage ->
                        PersonageDTO(
                            id = personage[PersonageTable.id],
                            mangaId = personage[PersonageTable.mangaId],
                            placeId = personage[PersonageTable.placeId],
                            name = personage[PersonageTable.name],
                            nameJp = personage[PersonageTable.nameJp],
                            transcriptionJp = personage[PersonageTable.transcriptionJp],
                            avatar = personage[PersonageTable.avatar],
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun fetchDescriptionByPersonageId(personageId: Int): List<PersonageDescriptionDTO> {
        return try {
            transaction {
                PersonageDescriptionTable
                    .select(where = PersonageDescriptionTable.personageId.eq(personageId))
                    .toList()
                    .map { description ->
                        PersonageDescriptionDTO(
                            id = description[PersonageDescriptionTable.id],
                            personageId = description[PersonageDescriptionTable.personageId],
                            mangaId = description[PersonageDescriptionTable.mangaId],
                            description = description[PersonageDescriptionTable.description],
                            image = if (description[image] != null) BaseUrl + "static/personage/${description[image]}" else null,
                            personageType = description[PersonageDescriptionTable.personageType],
                            surname = description[PersonageDescriptionTable.surname],
                            fruitId = description[fruit_id],
                            career = description[PersonageDescriptionTable.career]
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun fetchDescriptionByPlaceId(placeId: Int): List<PersonageDescriptionDTO> {
        return try {
            transaction {
                PersonageDescriptionTable.innerJoin(MangaTable)
                    .select(
                        where = PersonageDescriptionTable.mangaId.eq(MangaTable.id)
                                and MangaTable.placeId.eq(placeId)
                    )
                    .toList()
                    .map { description ->
                        PersonageDescriptionDTO(
                            id = description[PersonageDescriptionTable.id],
                            personageId = description[PersonageDescriptionTable.personageId],
                            mangaId = description[PersonageDescriptionTable.mangaId],
                            description = description[PersonageDescriptionTable.description],
                            image = if (description[image] != null) BaseUrl + "static/personage/${description[image]}" else null,
                            personageType = description[PersonageDescriptionTable.personageType],
                            surname = description[PersonageDescriptionTable.surname],
                            fruitId = description[fruit_id],
                            career = description[PersonageDescriptionTable.career]
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun fetchDescription(): List<PersonageDescriptionDTO> {
        return try {
            transaction {
                PersonageDescriptionTable
                    .selectAll()
                    .toList()
                    .map { description ->
                        PersonageDescriptionDTO(
                            id = description[PersonageDescriptionTable.id],
                            personageId = description[PersonageDescriptionTable.personageId],
                            mangaId = description[PersonageDescriptionTable.mangaId],
                            description = description[PersonageDescriptionTable.description],
                            image = if (description[image] != null) BaseUrl + "static/personage/${description[image]}" else null,
                            personageType = description[PersonageDescriptionTable.personageType],
                            surname = description[PersonageDescriptionTable.surname],
                            fruitId = description[fruit_id],
                            career = description[PersonageDescriptionTable.career]
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun fetchSkillByPlaceId(placeId: Int): List<PersonageSkillDTO> {
        return try {
            transaction {
                PersonageSkillTable.innerJoin(MangaTable)
                    .select(
                        where = PersonageSkillTable.mangaId.eq(MangaTable.id)
                                and MangaTable.placeId.eq(placeId)
                    )
                    .toList()
                    .map { skill ->
                        PersonageSkillDTO(
                            id = skill[PersonageSkillTable.id],
                            personageId = skill[PersonageSkillTable.personageId],
                            mangaId = skill[PersonageSkillTable.mangaId],
                            nameSkill = skill[PersonageSkillTable.nameSkill],
                            description = skill[PersonageSkillTable.description],
                            nameJp = skill[PersonageSkillTable.nameJp],
                            transcriptionJp = skill[PersonageSkillTable.transcriptionJp]
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun fetchWeaponByPlaceId(placeId: Int): List<PersonageWeaponsDTO> {
        return try {
            transaction {
                PersonageWeaponsTable.innerJoin(MangaTable)
                    .select(
                        where = PersonageWeaponsTable.mangaId.eq(MangaTable.id)
                                and MangaTable.placeId.eq(placeId)
                    )
                    .toList()
                    .map { weapon ->
                        PersonageWeaponsDTO(
                            id = weapon[PersonageWeaponsTable.id],
                            personageId = weapon[PersonageWeaponsTable.personageId],
                            mangaId = weapon[PersonageWeaponsTable.mangaId],
                            nameWeapons = weapon[PersonageWeaponsTable.nameWeapons],
                            description = weapon[PersonageWeaponsTable.description],
                            oldWeapon = weapon[PersonageWeaponsTable.oldWeapon]
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}