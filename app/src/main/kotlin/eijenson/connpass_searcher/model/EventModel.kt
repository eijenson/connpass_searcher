package eijenson.connpass_searcher.model

import eijenson.connpass_searcher.repository.api.response.EventJson
import eijenson.connpass_searcher.repository.api.response.SeriesJson
import eijenson.connpass_searcher.ui.view.data.ItemEvent
import eijenson.connpass_searcher.ui.view.data.ViewDate
import java.text.SimpleDateFormat
import java.util.*

class EventModel(val event: EventJson) {
    val df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX", Locale.JAPAN)

    val eventId: Long = event.eventId ?: -1
    val title: String = event.title ?: ""
    val catchPhrase: String = event.catchPhrase ?: ""
    val description: String = event.description ?: ""
    val eventUrl: String = event.eventUrl ?: ""
    val hashTag: String = event.hashTag ?: ""
    val startedAt: Date = df.parse(event.startedAt) ?: Date(0)
    val endedAt: Date = df.parse(event.endedAt) ?: Date(0)
    val limit: Int = event.limit ?: -1
    val eventType: String = event.eventType ?: ""
    val series: SeriesJson? = event.series
    val address: String = event.address ?: ""
    val place: String = event.place ?: ""
    val lat: Double = event.lat ?: -1.0
    val con: Double = event.con ?: -1.0
    val ownerId: Int = event.ownerId ?: -1
    val ownerNickname: String = event.ownerNickname ?: ""
    val ownerDisplayName: String = event.ownerDisplayName ?: ""
    val accepted: Int = event.accepted ?: -1
    val waiting: Int = event.waiting ?: -1
    val updatedAt: String = event.updatedAt ?: ""

    fun convertItemEvent(): ItemEvent {
        return ItemEvent(title, catchPhrase, description, eventUrl, hashTag, ViewDate(startedAt), ViewDate(endedAt), limit, eventType, address, place, accepted, waiting)
    }
}

