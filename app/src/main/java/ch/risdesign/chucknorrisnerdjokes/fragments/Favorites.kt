package ch.risdesign.chucknorrisnerdjokes.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ch.risdesign.chucknorrisnerdjokes.R
import ch.risdesign.chucknorrisnerdjokes.helpers.FILE_NAME
import ch.risdesign.chucknorrisnerdjokes.helpers.KEY_FAVORITE
import kotlinx.android.synthetic.main.fragment_favorites.*

/**
 * A simple [Fragment] subclass.
 *
 */
class Favorites : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Read
        val isFav = view.context
            .getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
            .getString(KEY_FAVORITE, null)

        // Text abfüllen
        showPersistent.text = "⭐ " + isFav
    }
}
