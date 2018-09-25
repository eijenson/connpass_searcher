package jp.eijenson.connpass_searcher.infra.repository.file

import android.content.Context
import com.google.gson.Gson
import io.reactivex.Single
import jp.eijenson.connpass_searcher.domain.repository.EventRemoteRepository
import jp.eijenson.connpass_searcher.infra.repository.api.entity.RequestEvent
import jp.eijenson.connpass_searcher.infra.repository.api.entity.response.ResultEventJson
import jp.eijenson.connpass_searcher.infra.repository.api.entity.response.mapping.toResultEvent
import jp.eijenson.model.ResultEvent

class EventFileRepository(private val context: Context) : EventRemoteRepository {
    override fun getAll(request: RequestEvent): Single<ResultEvent> {
        val inputStream = context.assets.open("result.json")
        return Single.create<ResultEvent> {
            it.onSuccess(inputStream.reader()
                    .use { Gson().fromJson(it, ResultEventJson::class.java).toResultEvent() }
            )
        }
    }
}