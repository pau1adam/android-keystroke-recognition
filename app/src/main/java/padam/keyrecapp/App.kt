package padam.keyrecapp

import android.app.Application
import timber.log.Timber

/**
 * Created by Pavlos Adam on 09-Aug-17.
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

    companion object {
        lateinit var instance: App
            private set
    }
}
