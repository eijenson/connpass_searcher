package jp.eijenson.connpass_searcher.presenter

import android.content.Context
import android.os.Build
import jp.eijenson.connpass_searcher.ui.notification.MyNotification

/**
 * Created by makoto.kobayashi on 2018/04/17.
 */
class NotificationPresenter(private val context: Context) {
    private val myNotification = MyNotification()

    fun notifyTest() {
        notify("新しいタイトル", "テキスト")
    }

    fun notifyNewArrival(keyword: String, count: Int) {
        notify("イベント検索結果", keyword + "で検索しました。" + count + "件のイベントがあります")
    }

    private fun notify(title: String, text: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            myNotification.sendNotification(context, title, text)
        } else {
            myNotification.sendNotificationOld(context, title, text)
        }
    }
}