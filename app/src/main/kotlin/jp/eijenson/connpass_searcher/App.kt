package jp.eijenson.connpass_searcher

import android.app.Application
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.kotlin.boxFor
import jp.eijenson.connpass_searcher.repository.column.FavoriteColumn
import jp.eijenson.connpass_searcher.repository.column.MyObjectBox
import jp.eijenson.connpass_searcher.repository.column.SeriesColumn
import timber.log.Timber

class App : Application() {

    lateinit var boxStore: BoxStore
        private set

    lateinit var favoriteTable: Box<FavoriteColumn>
        private set

    lateinit var seriesTable: Box<SeriesColumn>

    override fun onCreate() {
        super.onCreate()

        boxStore = MyObjectBox.builder().androidContext(this).build()
        favoriteTable = boxStore.boxFor()
        seriesTable = boxStore.boxFor()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}