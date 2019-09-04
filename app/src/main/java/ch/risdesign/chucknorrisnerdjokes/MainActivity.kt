package ch.risdesign.chucknorrisnerdjokes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import ch.risdesign.chucknorrisnerdjokes.model.networking.MyRetrofitClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_nav.setupWithNavController(findNavController(R.id.nav_host_fragment))
    }
}
