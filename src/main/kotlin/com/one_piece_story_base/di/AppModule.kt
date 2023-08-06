package com.one_piece_story_base.di

import com.one_piece_story_base.data.local.*
import com.one_piece_story_base.database.DatabaseFactory
import com.one_piece_story_base.database.DatabaseFactoryImpl
import com.one_piece_story_base.domain.controller.*
import com.one_piece_story_base.domain.local.*
import com.one_piece_story_base.routing.repository.*
import org.koin.core.scope.get
import org.koin.dsl.module

val appModule = module {
    single<DatabaseFactory> { DatabaseFactoryImpl() }
    single<MangaLocalDataSource> { MangaLocalDataSourceImpl() }
    single<MangaController> { MangaControllerImpl(get()) }
    single<PersonageLocalDataSource> { PersonageLocalDataSourceImpl() }
    single<PersonageController> { PersonageControllerImpl(get(), get()) }
    single<InventoryLocalDataSource> { InventoryLocalDataSourceImpl() }
    single<InventoryController> { InventoryControllerImpl(get()) }
    single<RewardLocalDataSource> { RewardLocalDataSourceImpl() }
    single<RewardController> { RewardControllerImpl(get()) }
    single<BandLocalDataSource> { BandLocalDataSourceImpl() }
    single<BandController> { BandControllerImpl(get()) }
    single<BondLocalDataSource> { BondLocalDataSourceImpl() }
    single<BondController> { BondControllerImpl(get()) }
    single<FruitLocalDataSource> { FruitLocalDataSourceImpl() }
    single<FruitController> { FruitControllerImpl(get()) }
    single<ShipLocalDataSource> { ShipLocalDataSourceImpl() }
    single<ShipController> { ShipControllerImpl(get()) }
    single<PlaceLocalDataSource> { PlaceLocalDataSourceImpl() }
    single<PlaceController> {
        PlaceControllerImpl(
            get(), get(), get(), get(), get(), get(), get(), get(), get()
        )
    }

}